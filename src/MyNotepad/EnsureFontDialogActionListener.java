package MyNotepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//“字体”对话框，确定按钮
public class EnsureFontDialogActionListener implements ActionListener {
    private FontDialog dialog;
    
    public EnsureFontDialogActionListener(FontDialog dialog) {
        this.dialog = dialog;
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
        TextService.setTextAreaFont(dialog);
    }

}
