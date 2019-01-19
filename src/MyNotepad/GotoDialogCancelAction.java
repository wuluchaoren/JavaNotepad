package MyNotepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GotoDialogCancelAction implements ActionListener {
    private GotoDialog dialog;
    
    public GotoDialogCancelAction(GotoDialog dialog){
        this.dialog = dialog;
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
        dialog.dispose();
    }

}
