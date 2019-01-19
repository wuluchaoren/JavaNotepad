package MyNotepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//�����塱�Ի���ȷ����ť
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
