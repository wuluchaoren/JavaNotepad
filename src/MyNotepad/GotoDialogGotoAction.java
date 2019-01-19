package MyNotepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//转到指定行对话框，“转到”按钮
public class GotoDialogGotoAction implements ActionListener {
    private GotoDialog dialog;
    
    public GotoDialogGotoAction(GotoDialog dialog){
        this.dialog = dialog;
    }
        
    @Override
    public void actionPerformed(ActionEvent arg0) {
        TextService.gotoLine(dialog);
    }

}
