package MyNotepad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

//IO��ص�ҵ�����
public class FileService {
    public static final int SAVE = 1; //saveFileMenu()�����Ĳ���
    public static final int SAVE_AS = 0; //saveFileMenu()�����Ĳ���

    /**
     * ִ�С����桱�����Ϊ���˵�
     * @param frame ��ǰ���±�ʵ��
     * @param model SAVEΪ���棬SAVE_ASΪ���Ϊ
     */
    public static void saveFileMenu(NotepadFrame frame, int model){
        File saveFile = null;
        if (model == SAVE){
            // ����ļ��Ƿ��Ѿ�����
            saveFile = frame.getFile();
        }
        if(saveFile == null){//SAVE_AS
            saveFile = FileService.getSaveFile(frame);
        }
        //������ص���null�����û�ȡ�����ļ�ѡ��Ի�����ʲô������
        //�������null���ͱ���
        if (saveFile != null){
            FileService.saveToFile(frame, saveFile);
        }
    }
    
    /**
     * ִ�С��򿪡��Ի���
     * @param frame ��Ҫ���ļ��ļ��±�ʵ��
     */
    public static void openFileMenu(NotepadFrame frame){
        //�������ļ��Ի��򲢻�ȡ�����ļ�
        File openFile = FileService.getOpenFile(frame);
        //�����null��˵���û�ȡ���˴򿪶Ի��򣬷�����в���
        if(openFile != null){
            //����ļ��Ƿ��Ѿ��򿪣�����򿪣������û�ȷ��
            if (FileService.confirmOpenFile(openFile)){
                //������ļ��Ѿ��򿪣���
                FileService.openFile(frame, openFile);
            }
        }
    }
    
	/**
	 * �������ļ��Ի��򲢻�ȡ���򿪵�file
	 * @param frame ���ļ��Ի�������ļ��±�ʵ��
	 * @return
	 */
	private static File getOpenFile(NotepadFrame frame){
		File openFile = null;
		JFileChooser chooser = FileChooserFactory.getFileChooser("txt");
//		chooser.addChoosableFileFilter(filter); //�����ַ�����Ĭ����ʾ�����ļ�
		int result = chooser.showOpenDialog(frame);
		if (result == MyFileChooser.APPROVE_OPTION){ //������µ��Ǵ򿪰�ť
			openFile = chooser.getSelectedFile();
		}
		return openFile;
	}
	
	/**
	 * ��������Ի��򲢻�ȡ�������File
	 * @param frame �����ļ��Ի�������ļ��±�ʵ��
	 * @return
	 */
	private static File getSaveFile(NotepadFrame frame){
		File saveFile = null;
		JFileChooser chooser = FileChooserFactory.getFileChooser("txt");
		int isFileCover = 100; //�����������е��κγ����ֶ�ֵ
		do{
			int result = chooser.showSaveDialog(frame);
			if(result == JFileChooser.APPROVE_OPTION){
				saveFile = chooser.getSelectedFile();
				if (!saveFile.getName().toLowerCase().endsWith(".txt")){
					saveFile = new File(saveFile.getName() + ".txt");
				}
				if (saveFile.exists()){
					isFileCover = JOptionPane.showConfirmDialog(frame, saveFile.getName()
							+ "�Ѵ��ڡ�\nҪ�滻����", "ȷ�����Ϊ"
							, JOptionPane.YES_NO_OPTION);
				}
			}
			else if(result == JFileChooser.CANCEL_OPTION){ 
				isFileCover = 100; //���������һ������isFileCover��ֵΪNO_OPTIONʱ��������˱����ļ���ȡ����ť����Ȼ�޷��˳�ѭ��
			}
		}while(isFileCover == JOptionPane.NO_OPTION); 
		return saveFile;
	}
	
	/**
	 * ��ָ��File
	 * @param frame �������ļ��ļ��±�ʵ��
	 * @param openFile ��Ҫ�򿪵��ļ�
	 */
	private static void openFile(NotepadFrame frame, File openFile){
		//�������ļ���NotepadFrame
		NotepadFrame openFileFrame = frame;
		//�����ǰ�ı������Ѿ������ݣ����½����±�ʵ��
		if (!openFileFrame.getWholeText().equals("")){
			openFileFrame = new NotepadFrame();
		}
		//��ǰ�������ı���TextArea
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(openFile)));
			String lineText = null;
			while( (lineText = br.readLine()) != null){
				frame.append(lineText + "\n");
			}
			br.close();
		}
		catch (IOException ioe){
			ioe.printStackTrace();
		}
		openFileFrame.setFile(openFile);
	}
	
	/**
	 * ���浽ָ���ļ�
	 * @param frame �豣��ļ��±�ʵ��
	 * @param saveFile ���浽���ļ�
	 */
	private static void saveToFile(NotepadFrame frame, File saveFile){
		try{
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(saveFile)));
			String text = frame.getWholeText();
			bw.write(text);
			bw.flush();
			bw.close();
		}
		catch (IOException ioe){
			ioe.printStackTrace();
		}
		//�ѱ����File����NotepadFrame
		frame.setFile(saveFile);
		frame.setHasChangedNoSave(false); //δ��������Ϊ��
	}
	
	/**
	 * �ر�ָ������
	 * @param frame ���رյĴ���
	 */
	public static void closeWindow(NotepadFrame frame){
	    //����ļ���δ����ĸ��ģ�����ʾ�Ƿ񱣴�
	    if (frame.getHasChangedNoSave()){
	        int wantSave = JOptionPane.showConfirmDialog(frame, "�ļ� " 
                    + (frame.getFile()==null?"�ޱ���":frame.getFile().getName()) 
	                + " �������Ѿ��ı䡣\n�뱣���ļ���", NotepadFrame.PROGRAM_NAME.substring(1)
	                , JOptionPane.YES_NO_CANCEL_OPTION);
	        if (wantSave == JOptionPane.CANCEL_OPTION) return; //ȡ���ر�
	        if (wantSave == JOptionPane.YES_OPTION) saveFileMenu(frame, SAVE); //���棬��͵�������桱�˵�һ��Ч��
	    }
		//��ɾ��NotepadFrame �е�openedFiles
		NotepadFrame.deleteOpenedFile(frame.getFile());
		//�ٹرյ�ǰ����
		frame.dispose();
	}
	
	/**
	 * ����ļ��Ĵ�״̬������Ѵ򿪣������û�ȷ���Ƿ����
	 * @param file �����ļ��Ƿ��Ѿ��򿪡��Ѿ��򿪵��ļ������NotepadFrame��openedFiles������
	 * @return
	 */
	private static boolean confirmOpenFile(File file){
		//����ļ���û�д򿪣�����True
		if(!NotepadFrame.isFileOpened(file)){
			return true;
		}
		else{
			//����ļ��Ѿ��򿪣������Ի������û�ȷ���Ƿ�����TextArea
			int isTextAreaCover = JOptionPane.showConfirmDialog(NotepadFrame.getNotepadFrame(file), file.getName()
					+ "�Ѿ��򿪣�������������δ������޸ġ�\nҪ��������", "ȷ�ϴ�"
					, JOptionPane.YES_NO_OPTION);
			if (isTextAreaCover == JOptionPane.YES_OPTION){ //�û�ѡ�˼���
				return true;
			}
		}
		return false;
	}
	
}
