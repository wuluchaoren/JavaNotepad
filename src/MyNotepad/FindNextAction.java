package MyNotepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//�����ҡ��Ի��򣬡�������һ����
public class FindNextAction implements ActionListener {
    private MyDialog dialog;
    
    public FindNextAction(MyDialog dialog){
        this.dialog = dialog;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //����˴��������ַ���
        TextService.find(dialog);
    }

}
