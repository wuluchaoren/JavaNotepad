package MyNotepad;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


//��ת���������ֻ��һ�����ʲ�ʹ�ù���ģʽ
public class GotoDialog extends JDialog {
    private JTextField input = new JTextField(30); 
    private NotepadFrame frame;
    
    public GotoDialog(NotepadFrame frame){
        super(frame, "ת��ָ����");
        this.frame = frame;
        JPanel all = new JPanel(new BorderLayout());
        JLabel label = new JLabel("�кţ�");
        JPanel up = new JPanel(new FlowLayout(FlowLayout.LEFT));
        up.add(label);
        all.add(up, BorderLayout.NORTH);
        all.add(input);
        input.addKeyListener(KeyListenerFactory.getKeyListener("����������"));
        JButton gotoButton = new JButton("ת��");
        gotoButton.addActionListener(ActionListenerFactory.getActionListener(this, "ת��"));
        JButton cancelButton = new JButton("ȡ��");
        cancelButton.addActionListener(ActionListenerFactory.getActionListener(this, "ȡ��"));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(gotoButton);
        buttonPanel.add(cancelButton);
        all.add(buttonPanel, BorderLayout.SOUTH);
        all.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(all);
        //���öԻ�����Frame����
        int frameX = (int)frame.getBounds().getX();
        int frameY = (int)frame.getBounds().getY();
        setBounds(frameX+80, frameY+150, 0, 0);
        pack();
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
    }
    
    //��ȡ��Ӧ�ļ��±�ʵ��
    public NotepadFrame getNotepadFrame(){
        return frame;
    }
    
    //��������
    public void setLineNum(int n){
        this.input.setText(String.valueOf(n));
        this.input.selectAll();
    }
    
    //��ȡ������ǰ���Ѿ�ͨ��KeyListenerָ��ֻ���������֣���ֱ��ת������
    public int getLineNum(){
        return Integer.valueOf(input.getText());
    }
    
    //��ȡ�ı����ȫ���ı�
    public String getWholeText() {
        return frame.getWholeText();
    }
    
    // ��ȡ�ı����������
    public int getLineCount(){
        return frame.getLineCount();
    }
    
    // �����ı����й���λ��
    public void setCaretPosition(int index){
        frame.setCaretPosition(index);
    }
    
}



