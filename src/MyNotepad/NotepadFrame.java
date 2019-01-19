package MyNotepad;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;



public class NotepadFrame extends JFrame {
	public static final String PROGRAM_NAME = ".Mytxt"; // ���ڱ���ĺ�벿�� 
	private String tmpText = ""; //��ʱ�浵
	private static Map<File, NotepadFrame> openedFiles = new HashMap<File, NotepadFrame>();//�������Ѿ��򿪵��ļ�
	private JTextArea textArea = new JTextArea();	
	private JPanel statePanel = new JPanel();
	private File file; //��������textArea���ļ�
	private Font menuFont = new Font("΢���ź�", Font.PLAIN, 13); //�˵�Ĭ������
	private Font defaultTextAreaFont = new Font("΢���ź�", Font.PLAIN, 14); //�ı���Ĭ������
	private boolean hasChangedNOSave = false; //�ı��Ƿ���δ����ĸ���
	private JLabel stateLabel = new JLabel();
	private JCheckBoxMenuItem stateMenuItem; //��״̬�����˵���
	private JMenuItem repealMenuItem; //���������˵���
	private JMenuItem gotoMenuItem;//��ת�����˵���
	private LinkedList<String> repealList = new LinkedList<String>(); // ����ÿ�β������ı������ڳ���
	
	public NotepadFrame(){
		super("�ޱ���" + PROGRAM_NAME);
		try{
//			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel"); //Ĭ��LAF
//			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel"); //����ʽWindows����
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); //��Windowsһ��
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");//��ʽWindows
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); //��ǰϵͳ���
		}
		catch (Exception e){
			e.printStackTrace();
		}
		this.setJMenuBar(this.createMenuBar());
		this.add(this.createTextArea());
		this.add(this.createStatePanel(), BorderLayout.SOUTH);
		this.setPreferredSize(new Dimension(600, 600));
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //������д��WindowListener
		this.addWindowListener(WindowFactory.getWindowListener(this, "Closing"));
		this.pack();
		//���ô��ھ���
		int screenSizeX = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int screenSizeY = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int frameSizeX = (int)this.getSize().getWidth();
		int frameSizeY = (int)this.getSize().getHeight();
		this.setBounds((screenSizeX-frameSizeX)/2, (screenSizeY-frameSizeY)/2, frameSizeX, frameSizeY);
		this.setVisible(true);
	}

	//�����˵������ŵ�JPanel�ﷵ��
	private JMenuBar createMenuBar(){
		//�˵���
		String[] menuArr = {"�ļ�(F)", "�༭(E)", "��ʽ(O)", "�鿴(V)", "����(H)"};
		//�˵���
		String[][] menuItemArr = {
				{"�½�(N)", "��(O)...", "����(S)", "���Ϊ(A)...", "-", "�˳�(X)"},
				{"����(U)", "-", "����(T)", "����(C)", "ճ��(P)", "ɾ��(L)", "-",
					"����(F)...", "�滻(R)...", "ת��(G)...", "-", "ȫѡ(A)", "ʱ��/����(D)"},
				{"�Զ�����(W)", "����(F)..."},
				{"״̬��(S)"},
				{"�鿴����(H)", "-", "���ڼ��±�(A)"}};
		//��ϲ˵���
		JMenuBar menuBar = new JMenuBar();
		for(int i = 0; i < menuArr.length; i++){
			JMenu menu = new JMenu(menuArr[i]);
			menu.setFont(menuFont);
			for(int j = 0; j < menuItemArr[i].length; j++){
				//�����-����ӷָ���
				if (menuItemArr[i][j].equals("-")){
					menu.addSeparator();
				}
				else if (menuItemArr[i][j].equals("�Զ�����(W)") || menuItemArr[i][j].equals("״̬��(S)") ){ //�Զ�����Ҫ��JCheckBoxMenuItem
				    //JCheckBoxMenuItemĬ��δѡ��
					JCheckBoxMenuItem checkboxMenuItem = new JCheckBoxMenuItem(menuItemArr[i][j]);
					if (menuItemArr[i][j].equals("״̬��(S)")) stateMenuItem = checkboxMenuItem;
					checkboxMenuItem.addActionListener(ActionListenerFactory.getActionListener(this, menuItemArr[i][j]));
					checkboxMenuItem.setFont(menuFont);
					menu.add(checkboxMenuItem);
				}
				else{
					JMenuItem menuItem = new JMenuItem(menuItemArr[i][j]);
					menuItem.addActionListener(ActionListenerFactory.getActionListener(this, menuItemArr[i][j]));
					//���������˵���ʼΪ���ɵ��
					if(menuItem.getText().equals("����(U)")){
					    this.repealMenuItem = menuItem;
					    menuItem.setEnabled(false);
					}else if (menuItemArr[i][j].equals("�鿴����(H)")){
					    menuItem.setEnabled(false);
					}else if(menuItemArr[i][j].equals("ת��(G)...")){
                        this.gotoMenuItem = menuItem;
                    }
					menuItem.setFont(menuFont);
					menu.add(menuItem);
					//ҳ�����úʹ�ӡ����ȡ�����˵����Ϊ��ɫ
				}
			}
			if (!menu.getText().equals("�Զ�����(W)")){
				menuBar.add(menu);				
			}
		}
		return menuBar;
	}
	
	//�����ײ���״̬��	
	private JPanel createStatePanel(){
	    this.statePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
	    this.statePanel.add(this.stateLabel);
	    this.stateLabel.setFont(this.defaultTextAreaFont);
	    this.setStateLabel(1,1);
		//Ĭ�ϲ��ɼ�
		statePanel.setVisible(false);
		return statePanel;
	}
	
	//�������˹�������JTextArea
	private JScrollPane createTextArea(){
	    //��Ӽ�����
	    textArea.getDocument().addDocumentListener(
	            DocumentListenerFactory.getDocumentListener(this, "NotepadFrameTextArea"));
	    textArea.addCaretListener(CaretListenerFactory.getCaretListener(this));
		//Ĭ�ϲ��Զ�����
		textArea.setLineWrap(false);
		//���Ҫ���У����ʱ߽紦����
		textArea.setWrapStyleWord(true);
		//����,Ĭ��ʹ��menuFont
		textArea.setFont(this.defaultTextAreaFont);
		JScrollPane scrollPane = new JScrollPane(textArea);
		return scrollPane;
	}	
	
	// ѡ���ı�
	public void select(int start, int end){
	    textArea.select(start, end);
	}
	
	// �����ı����й���λ��
	public void setCaretPosition(int index){
	    textArea.setCaretPosition(index);
	}
	
	// ��ȡ�ı����������
	public int getLineCount(){
	    return textArea.getLineCount();
	}
	
	// �����ı�������� 
	public void setTextAreaFont(Font font){
	    textArea.setFont(font);
	}
	
	// ��ȡ�ı��������
	public Font getTextAreaFont(){
	    return textArea.getFont();
	}
	
	// �ı��ı����Զ����е�״̬
	public void setLineWrap(boolean b){
	    textArea.setLineWrap(b);
	}
	
	// ��ȡ�ı����Զ����е�״̬
	public boolean getLineWrap(){
	    return textArea.getLineWrap();
	}
	
	//��ȡ��꿪ʼ��λ��
	public int getSelectionStart(){
	    return textArea.getSelectionStart();
	}
	
	// ��ȡ�ı����������λ��
	public int getSelectionEnd(){
	    return textArea.getSelectionEnd();
	}
	
	//���ı�����׷���ı�
	public void append(String text){
	    textArea.append(text);
	}
	
	// ��ȡ�ı����ڵ�ȫ���ı�
	public String getWholeText(){
	    return textArea.getText();
	}
	
	// �����ı�����ı�
	public void setText(String text){
	    textArea.setText(text);
	}
	
	// ��ȡѡ���ı�
	public String getSelectedText(){
	    return textArea.getSelectedText();
	}
	
	// ȫѡ
	public void selectAll(){
	    textArea.selectAll();
	    //Selects all the text in the TextComponent. Does nothing on a null or empty document.
	}
	
	// �滻ѡ���ı�
	public void replaceSelection(String text){
	    textArea.replaceSelection(text);
	    //Replaces the currently selected content with new content represented by the given string.
	    //If there is no selection this amounts to an insert of the given text.
	    //If there is no replacement text this amounts to a removal of the current selection. 

	}
	
	//���õײ�״̬��������
	public void setStateLabel(int row, int column){
	    this.stateLabel.setText("��" + row + "�У���" + column + "��         ");
	}
	
	// ����״̬���Ŀɼ���
	public void setStatePanelVisible(boolean b){
	    statePanel.setVisible(b);
	}
	
	// ��ȡ״̬���Ŀɼ���״̬
	public boolean getStatePanelVisible(){
	    return statePanel.isVisible();
	}
	
	//���ñ�����ļ�
	//�ı䴰����
	//�����Ѵ��ļ�Map
	public void setFile(File file){
		this.file = file;
		this.setTitle(file.getName() + PROGRAM_NAME);
		openedFiles.put(file, this);
	}
	
	//��ȡtextArea������ļ�
	public File getFile(){
		return this.file;
	}
	
	//��ȡtmpText
	public void setTmpText(String txt){
	    this.tmpText = txt;
	}
	public String getTmpText(){
	    return this.tmpText;
	}
	
	//����JTextArea��δ������ı��
	public void setHasChangedNoSave(boolean b){
	    this.hasChangedNOSave = b;
	}
	
	//��ȡJTextArea��δ������ı��
	public boolean getHasChangedNoSave(){
	    return this.hasChangedNOSave;
	}
	
	//���á�״̬��������ת�����˵��Ŀ�����
	public void setStateMenuItemEnabled(boolean b){
	    this.stateMenuItem.setEnabled(b);
	    this.gotoMenuItem.setEnabled(b);
	}
	
	//��ȡ��״̬�����˵���ѡ�����
	public boolean getStatePanelMenuItem(){
	    return this.stateMenuItem.getState();
	}
	
	//���á��������˵��Ŀɼ���
	public void setRepealMenuItemEnabled(boolean b){
	    this.repealMenuItem.setEnabled(b);
	}
	
	// ��ȡ������ı���ջ�Ĵ�С
	public int getStackSize(){
	    return repealList.size();
	}
	
	// �����ݴ�ջ��ȡ��
	public String popFromStack(){
	    if (repealList.size() > 1){
	        return repealList.pop();
	    }
	    return null;
	}
	
	// ���������뱣���ļ���ջ
	public void pushToStack(String text){
	    repealList.push(text);
	}

	//����File��ȡNotepadFrame�������ǲ�������ص����ԣ��þ�̬����
	public static NotepadFrame getNotepadFrame(File file){
		return openedFiles.get(file);
	}
	
	//ɾ��openedFiles��ָ����File��������������ص����ԣ����þ�̬����
	public static void deleteOpenedFile(File file){
		openedFiles.remove(file);
	}
	
	
	//�ж�ĳFile�Ƿ��Ѿ��򿪣���������ԣ��þ�̬����
	public static boolean isFileOpened(File file){
		return openedFiles.containsKey(file);
	}
	
}
