	package MyNotepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//�����塱�Ի���ȡ����ť
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
