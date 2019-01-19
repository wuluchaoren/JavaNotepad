package MyNotepad;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * �����ҡ��Ի���
 * ��Ϊ��������JPanel�����JPanel��Ϊ����������
 */
public class FindDialog extends MyDialog{
    private JTextField text = new JTextField(10); // �������õ�����С���
    private JCheckBox caseCheckBox = new JCheckBox("���ִ�Сд(C)");
    private JRadioButton up = new JRadioButton("����(U)");
    private JRadioButton down = new JRadioButton("����(D)", true);
    private NotepadFrame frame;
    private JButton findNext;
    
    public FindDialog(NotepadFrame frame){
        super(frame, "����");
        this.frame = frame;
        add(createLeftPanel(), BorderLayout.WEST);
        add(createRightPanel());
        pack();
        if (text.getText() != null 
                && text.getText().length() > 0) setButtonEnable(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
    }
    

    private Box createLeftPanel(){
        //�ϰ벿��
        JLabel label = new JLabel("��������(N):");
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
        Box upBox = new Box(BoxLayout.X_AXIS);
        upBox.add(label);
        text.setText(lastFindText); //�ϴβ��ҵ��ַ���
        text.getDocument().addDocumentListener(
                DocumentListenerFactory.getDocumentListener(this, "FindReplaceTextField"));
        text.selectAll();
        upBox.add(text);
        //�°벿��
        //����
        caseCheckBox.setBorder(BorderFactory.createEmptyBorder(35, 0, 0, 20));
        //���߿�Ķ�����ѡ��ť
        //����
        ButtonGroup directionButtonGroup = new ButtonGroup();
        directionButtonGroup.add(up);
        directionButtonGroup.add(down);
        JPanel direction = new JPanel();
        direction.add(up); //ButtonGroupֻ��������ã���������
        direction.add(down);
        direction.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "����", TitledBorder.LEFT
                , TitledBorder.TOP));
        Box downBox = new Box(BoxLayout.X_AXIS);
        downBox.add(caseCheckBox);
        downBox.add(direction);
        downBox.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        //�������������
        Box left = new Box(BoxLayout.Y_AXIS);
        left.add(upBox);
        left.add(downBox);
        left.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return left;
    }
    
    
    private JPanel createRightPanel(){
        JPanel right = new JPanel(new GridLayout(2, 1, 0, 10));
        findNext = new JButton("������һ��(F)");
        setButtonEnable(false);
        findNext.addActionListener(ActionListenerFactory.getActionListener(this, "������һ��(F)"));
        JButton cancel = new JButton("ȡ��");
        cancel.addActionListener(ActionListenerFactory.getActionListener(this, "ȡ��"));
        right.add(findNext);
        right.add(cancel);
        right.setBorder(BorderFactory.createEmptyBorder(10, 0, 30, 20));
        return right;
    }
    

    //�Ƿ����ִ�Сд
    @Override
    public boolean isMatchCase() {
        return caseCheckBox.isSelected();
    }

    //���ش����ҵ�Ŀ���ַ�����ͬʱ���������lastFindText
    @Override
    public String getFindText() {
        lastFindText = text.getText();
        return lastFindText;
    }

    //�Ƿ����²���
    @Override
    public boolean isDownward() {
        return down.isSelected()?true:false;
    }

    //��ȡ������NotepadFrame
    @Override
    public NotepadFrame getNotepadFrame() {
        return frame;
    }
    
    //��ȡ�������ַ������˴�Ϊ���ҶԻ����ò����˷������������ⷵ�ء�
    @Override
    public String getReplaceText() {
        return "";
    }
    
    //�ı䡰������һ������ť�Ŀ�����
    @Override
    public void setButtonEnable(boolean b) {
        findNext.setEnabled(b);
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
    
    // �滻ѡ���ı������ҶԻ��򲻶��ı�����в���
    @Override
    public void replaceSelection(String text) {}
    
    //�����ı�����ı������ҶԻ��򲻶��ı�����в���
    @Override
    public void setText(String text) {}
}
