package MyNotepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



//“关于记事本”对话框中的“确定”按钮
public class CancelAboutAction implements ActionListener {
    private AboutNotepadDialog dialog;
    
    public CancelAboutAction(AboutNotepadDialog dialog){
        this.dialog = dialog;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        dialog.dispose();
    }

}
