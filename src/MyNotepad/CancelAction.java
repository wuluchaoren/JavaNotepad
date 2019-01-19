package MyNotepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//“查找”对话框中的“取消”按钮
public class CancelAction implements ActionListener {
    private MyDialog dialog;
    
    public CancelAction(MyDialog dialog){
        this.dialog = dialog;
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
        dialog.dispose();
    }

}
