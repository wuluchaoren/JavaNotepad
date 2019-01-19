package MyNotepad;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.util.Calendar;

import javax.swing.JOptionPane;

//�ı�������ص�ҵ�����
public class TextService {
	private static Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	
	//�������ں�ʱ��
	public static void addTime(NotepadFrame frame){
		Calendar c = Calendar.getInstance();
		String time = "" + c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE)
				+ " " + c.get(Calendar.YEAR) + "/" + c.get(Calendar.MONTH)
				+ "/" + c.get(Calendar.DATE);
		frame.replaceSelection(time);
	}
	
	//ȫѡ
	public static void allSelect(NotepadFrame frame){
		frame.selectAll();
	}
	
	//����
	public static void copy(NotepadFrame frame){
		//���Ƶ�ϵͳ���а�
		String selectText = frame.getSelectedText();
		// ��װ��Ž�������
		StringSelection select = new StringSelection(selectText);
		clipboard.setContents(select, null);
	}
	
	//����
	public static void cut(NotepadFrame frame){
		//�ȸ�����ɾ��ѡ������
		copy(frame);
		delete(frame);
	}
	
	//ɾ��ѡ������
	public static void delete(NotepadFrame frame){
		frame.replaceSelection("");
	}

	//ճ��
	public static void paste(NotepadFrame frame){
		//�����ѡ�����ݣ����滻֮�������������λ��
		frame.replaceSelection(getClipboardText());
	}
	
	//��ȡ�������е��ı�
	//������ı����򷵻ؿ��ַ���
	private static String getClipboardText(){
	    // ������а������ı����򷵻ظ��ı�
	    if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)){
	        try{
	            return (String)clipboard.getData(DataFlavor.stringFlavor);
	        }
	        catch(Exception e){
	            e.printStackTrace();
	        }
	    }
	    return "";
	}
	
	/**
	 * ����
	 * @param dialog ���һ�����滻�Ի���
	 */
	public static void find(MyDialog dialog){
	    String findText = dialog.getFindText(); //�����ҵ��ַ���
	    String text = dialog.getWholeText(); //�����ı�
	    int start = 0; //�������ı����Ŀ�ʼ����
	    int end = text.length(); //�������ı�����β������
	    // ��������ִ�Сд����ȫתΪСд
	    if (!dialog.isMatchCase()){
	        text = text.toLowerCase();
	        findText = findText.toLowerCase();
	    }
	    if (dialog.isDownward()) { // �����²��ң���ֻȡ������ı���������
	        start = dialog.getSelectionEnd();
	        start = text.indexOf(findText, start);
	        if(start == -1){ //�Ҳ����ı��򵯳���ʾ
	            JOptionPane.showMessageDialog(dialog.getNotepadFrame(), "�Ҳ��� \"" + findText + "\""
	                    , NotepadFrame.PROGRAM_NAME.substring(1), JOptionPane.INFORMATION_MESSAGE);
	        }else{ //���ҵ���ѡ���ı�
	            dialog.select(start, start + findText.length());
	        }
	    }else{ //�����ϲ��ң���ȡ���ǰ���ı�
	        end = dialog.getSelectionStart();
	        end = text.lastIndexOf(findText, end-1);
	        if(end == -1){
	            JOptionPane.showMessageDialog(dialog.getNotepadFrame(), "�Ҳ��� \"" + findText + "\""
	                    , NotepadFrame.PROGRAM_NAME.substring(1), JOptionPane.INFORMATION_MESSAGE);
	        }else{
	            dialog.select(end, end +findText.length());
	        }
	    }
	}
	
	//�滻
	public static void replace(MyDialog dialog){
	    String selectedText = dialog.getSelectedText(); //Ŀǰѡ�е��ı�
	    String findText = dialog.getFindText(); //��Ҫ���ҵ��ı�
	    // ��������ִ�Сд����ȫתΪСд
	    if (!dialog.isMatchCase()){
	        findText = findText.toLowerCase();
	        if (selectedText != null) selectedText = selectedText.toLowerCase();
	    }
        //����Ѿ�ѡ����ı��Ǵ������ַ��������滻
        if(findText.equals(selectedText)){
            dialog.replaceSelection(dialog.getReplaceText()); //��ת��֮ǰ���ַ��������滻
        }
        // ������һ����û���滻����Ҫ����һ��
        find(dialog); //�滻ֻ�����¡�
	}
	
	//ȫ���滻
	public static void replaceAll(MyDialog dialog){
	    String text = dialog.getWholeText(); //�����ı�
	    String findText = dialog.getFindText(); //�������ı�
	    //�Ƿ����ִ�Сд
	    if (!dialog.isMatchCase()){
	        text = text.toLowerCase();
	        findText = findText.toLowerCase();
	    }
	    //��������滻
	    text = text.replace(findText, dialog.getReplaceText());
	    dialog.setText(text);
	}
	
	//��ȡ������ڵ�����
	public static int getRow(NotepadFrame frame){
	    int count = 0; //��¼ǰ���м����س�
	    int index = frame.getSelectionStart(); //������ڵ�λ�ã�
	    String text = frame.getWholeText(); // �ı����е��������ݣ����ڲ���
	    //�������λ��֮ǰ�м������з�
	    while((index = text.lastIndexOf("\n", index)) != -1){
	        count++;
	        index--; //����1����ظ����ش�λ��
	    }
	    count++; //ǰ����һ���س�˵��������
	    //������滹������һ���س������1�����Ǵ�ʵ������еó��Ľ���
	    if (text.length() > frame.getSelectionStart() && text.charAt(frame.getSelectionStart()) == '\n') count--;
	    return count;
	}
	
	//��ȡ������ڵ�����
	public static int getColumn(NotepadFrame frame){
	    int index = frame.getSelectionStart(); //������ڵ�λ��
	    String text = frame.getWholeText(); //�ı����е���������
	    text = text.substring(0, index);
	    int start = text.lastIndexOf("\n", index);
	    if (start == -1) start = 0;
	    int count = text.substring(start, index).length();
	    if(start == 0) count++; //������㷨�������ڵ�һ�У�������Ϊ0�����1
	    return count;
	}
	
	//����ʱ�洢����ջ�����ı������ݴ�����ʱ�洢��ͬʱ���á��������˵��ɼ�
	public static void pushTextArea(NotepadFrame frame){
	    String text = frame.getWholeText();
	    if (text.length() > 0 || text == ""){
	        frame.pushToStack(frame.getTmpText());
	        frame.setTmpText(text);
	        frame.setRepealMenuItemEnabled(true);
	    }
	}
	
	// ��ջ�е����ı������ݣ���������������
	public static void popTextArea(NotepadFrame frame){
	    // ջ�����ݲ�Ϊ0���򵯳�
	    if(frame.getStackSize() > 1){
	        String text = frame.popFromStack();
	        frame.setText(text); //��ʱ�ִ����������Ѵ��ı�����ջ
	        frame.popFromStack();//�շ�����ظ��ĵ�ǰ�ı���ջ
	    }
	    else { //ջ�������ݣ������ó����˵�Ϊ���ɼ���ͬʱ���ı���Ϊ��ֵ
	        frame.setRepealMenuItemEnabled(false);
	        frame.setText("");
	    }
	}
	
	// ���Զ����С��˵��������Զ����к�״̬��
	public static void setAutoWrap(NotepadFrame frame){
	    frame.setLineWrap(!frame.getLineWrap()); //�ı��Զ�����״̬
        //����Զ�����Ϊtrue������ʾ״̬������״̬���˵���ťʧЧ
        if (frame.getLineWrap()){
            frame.setStatePanelVisible(false);
            frame.setStateMenuItemEnabled(false);
        }else{
            frame.setStatePanelVisible((frame.getStatePanelMenuItem()));
            frame.setStateMenuItemEnabled(true);
        }
	}
	
	//��ת�����˵��������Ի���
	public static void gotoLine(GotoDialog dialog){
	    int lineNum = dialog.getLineNum(); //��ת������
	    NotepadFrame frame = dialog.getNotepadFrame();
	    String text = dialog.getWholeText(); //�����ı�
	    int index = 0; //�к�
	    //����������ж࣬�򵯳���ʾ
	    if (lineNum > dialog.getLineCount()){
	        JOptionPane.showMessageDialog(frame, "����������������", frame.PROGRAM_NAME.substring(1) +
	                "-����", JOptionPane.ERROR_MESSAGE);
	        dialog.setLineNum(getRow(frame));
	    }else{
	        while(lineNum > 1){ //����lineNum-1���س�
	            index = text.indexOf("\n", index);
	            index++; //��һλ������
	            lineNum--; //�ҵ�һ���س��ͼ�1��
	        }
	        dialog.setCaretPosition(index);
	        dialog.dispose();
	    }
	}
	
	//��ȡ����Ի�����ѡ�������
	private static Font getSelectedFont(FontDialog dialog){
	    return new Font(dialog.getFontListValue()
                , dialog.getFontStyleListValue(), dialog.getFontSizeListValue());
	}
	
	// ����ʾ��Label����
	private static void setExampleFont(FontDialog dialog){
	    //�ı�ʾ��Label������   
	    dialog.setExampleFont(getSelectedFont(dialog));
	}
	
	// �����ı�������岢�رնԻ���
	public static void setTextAreaFont(FontDialog dialog){
	    dialog.setTextAreaFont(getSelectedFont(dialog));
	    dialog.dispose();
	}
	
	// ����ʾ��Label������
	public static void setTextExample(FontDialog dialog){
	    dialog.setExampleText(dialog.getScenarioListValue());
	}
	
	// ѡ�������б�ʱ�Ķ���
	//�������б��ѡ������ʾ���Ϸ����ı����У��ı�ʾ���е�����
	public static void setFontListSelected(FontDialog dialog){
	    //������JList��ѡ������ʾ���Ϸ����ı�����
	    dialog.setFontTextField(dialog.getFontListValue());
	    setExampleFont(dialog);
	}
	
	//ѡ�������б�ʱ�Ķ���
	//�������б��ѡ������ʾ���Ϸ����ı����У��ı�ʾ���е�����
	public static void setFontStyleListSelected(FontDialog dialog){
	    // ������List��ѡ������ʾ���Ϸ��ı�����
	    dialog.setFontStyleTextField(FontDialog.fontStyle[dialog.getFontStyleListValue()]);
	    setExampleFont(dialog);
	}
	
	//ѡ�������С�б�ʱ�Ķ���
	//�������С�б��ѡ������ʾ���Ϸ����ı����У��ı�ʾ���е�����
	public static void setFontSizeListSelected(FontDialog dialog){
	    // �������СList��ѡ������ʾ���Ϸ��ı�����
	    dialog.setFontSizeTextField(dialog.getFontSizeListValue());
	    setExampleFont(dialog);
	}
}
