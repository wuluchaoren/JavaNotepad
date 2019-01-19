package MyNotepad;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;



//�����ڼ��±���
public class AboutNotepadDialog extends JDialog {
    
    public AboutNotepadDialog(NotepadFrame frame){
        super(frame, "���� \"�ҵļ��±�\"");
        add(createTitle(), BorderLayout.NORTH);
        add(createMainBody());
        add(createEnterButton(), BorderLayout.SOUTH);
        //���öԻ�����Frame����
        int frameX = (int)frame.getBounds().getX();
        int frameY = (int)frame.getBounds().getY();
        setBounds(frameX+80, frameY+150, 0, 0);
        pack();
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
    }
   

    
    //ȷ����ť
    private JPanel createEnterButton(){
        JButton button = new JButton("ȷ��");
        button.addActionListener(ActionListenerFactory.getActionListener(this, "ȷ��"));
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel.add(button);
        return panel;
    }
    
    //����
    private JPanel createMainBody(){
        String text = "<html><body>" 
                + "���ߣ�������" + "<br>"
                + "���ߣ�24320162202901" + "<br>" 
                + "ʱ�䣺2018/5/19 "+"<br>" 
                + "<body></html>"; 
        JLabel label = new JLabel(text);
        label.setFont(new Font("΢���ź�", Font.PLAIN, 13));
        label.setBorder(BorderFactory.createEmptyBorder(10, 10, 40, 10));
        JPanel panel = new JPanel();
        panel.add(label);
        panel.setBorder(BorderFactory.createEtchedBorder());
        return panel;
    }
   
    // ������
    private JPanel createTitle(){
        JLabel label = new JLabel("�ҵļ��±�");
        label.setFont(new Font("΢���ź�", Font.BOLD, 30));
        JPanel panel = new JPanel();
        panel.add(label);
        panel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        return panel;
    }
}
