package MyNotepad;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


//�滻�Ի���
public class FindReplaceDialog extends MyDialog {
    private JTextField textFind = new JTextField(20); // �������õ�����С���
    private JTextField textReplace = new JTextField(20);
    private JCheckBox caseCheckBox = new JCheckBox("���ִ�Сд(C)");
    private JRadioButton up = new JRadioButton("����(U)");
    private JRadioButton down = new JRadioButton("����(D)", true);
    private NotepadFrame frame;
    private JButton[] buttonArr = new JButton[4]; //�Ի����е��ĸ���ť
    
    public FindReplaceDialog(NotepadFrame frame){
        super(frame, "�滻");
        this.frame = frame;
        add(createLeftPanel(), BorderLayout.WEST);
        add(createRightPanel());
        if (textFind.getText() != null && textFind.getText().length() > 0) setButtonEnable(true);
        pack();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
    }
    
    
    /**
     * ��벿�ֶԻ���
     * @return
     */
    private Box createLeftPanel(){
        //�ϰ벿��
        //������ǩ
        JLabel findLabel = new JLabel("��������(N):");
        findLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 10));
        JLabel replaceLabel = new JLabel("�滻Ϊ(P):");
        Box upLeftBox = new Box(BoxLayout.Y_AXIS);
        upLeftBox.add(findLabel);
        upLeftBox.add(replaceLabel);
        //�����ı���
//        textFind.setText(TextService.getClipboardText());  //��ʼ�����ı�Ϊ������
        textFind.setText(lastFindText); //�ϴβ��ҵ��ַ���
        textFind.getDocument().addDocumentListener(
                DocumentListenerFactory.getDocumentListener(this, "FindReplaceTextField"));
        Box upRightBox = new Box(BoxLayout.Y_AXIS);
        upRightBox.add(textFind);
        upRightBox.add(Box.createVerticalStrut(10));
        upRightBox.add(textReplace);
        //�ϰ벿����װһ��
        Box upBox = new Box(BoxLayout.X_AXIS);
        upBox.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        upBox.add(upLeftBox);
        upBox.add(upRightBox);
        //�°벿��
        //����
        caseCheckBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        JPanel downPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        downPanel.add(caseCheckBox);
        //�������������
        Box left = new Box(BoxLayout.Y_AXIS);
        left.add(upBox);
        left.add(downPanel);
        left.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return left;
    }
    
    /**
     * �����Ұ벿�ֶԻ���
     * @return
     */
    private JPanel createRightPanel(){
        JPanel right = new JPanel(new GridLayout(2, 2, 15, 15));
        //��JButton����JPanel�����Լ�СButton�Ĵ�С
        String[] buttonNameArr = {"������һ��(F)", "�滻(R)", "ȫ���滻(A)", "ȡ��"};
        for(int i = 0; i < buttonArr.length; i++){
            buttonArr[i] = new JButton(buttonNameArr[i]);
            buttonArr[i].addActionListener(ActionListenerFactory.getActionListener(this, buttonNameArr[i]));
            right.add(buttonArr[i]);
        }
        setButtonEnable(false);
        right.setBorder(BorderFactory.createEmptyBorder(15, 0, 30, 20));
        return right;
    }
    
    // ����ǰ������ť�Ŀ�����
    public void setButtonEnable(boolean b){
        for(int i = 0; i < 3; i++){
            buttonArr[i].setEnabled(b);
        }
    }

    //�Ƿ����ִ�Сд
    @Override
    public boolean isMatchCase() {
        return caseCheckBox.isSelected();
    }

    //���ش����ҵ�Ŀ���ַ���
    @Override
    public String getFindText() {
        lastFindText = textFind.getText();
        return lastFindText;
    }

    //�Ƿ����²��ң��滻�Ի����޴�ѡ�һ��Ϊtrue
    @Override
    public boolean isDownward() {
        return true;
    }

    //��ȡ������NotepadFrame
    @Override
    public NotepadFrame getNotepadFrame() {
        return frame;
    }
    
    //��ȡ���滻���ַ���
    @Override
    public String getReplaceText() {
        lastReplaceText = textReplace.getText();
        return lastReplaceText;
    }
    
    //��ȡ�ı����ȫ���ı�
    @Override
    public String getWholeText() {
        return frame.getWholeText();
    }
    
    //��ȡ��ѡ���ı���β��
    @Override
    public int getSelectionEnd() {
        return frame.getSelectionEnd();
    }

    //ѡ���Ӧ���ı���
    @Override
    public void select(int start, int end) {
        frame.select(start, end);
    }
    
    //��ȡ�ı���Ŀ�ʼλ��
    @Override
    public int getSelectionStart() {
        return frame.getSelectionStart();
    }

    // Ŀǰѡ�е��ı�
    @Override
    public String getSelectedText() {
        return frame.getSelectedText();
    }
    
    // �滻ѡ���ı�
    @Override
    public void replaceSelection(String text) {
        frame.replaceSelection(text);
    }

    //�����ı�����ı�
    @Override
    public void setText(String text) {
        frame.setText(text);
    }

}
