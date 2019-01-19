	package MyNotepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//“字体”对话框，取消按钮
public class CancelFontDialogActionListener implements ActionListener {
    private FontDialog dialog;
    
    public CancelFontDialogActionListener(FontDialog dialog) {
        this.dialog = dialog;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        dialog.dispose();
    }

}
