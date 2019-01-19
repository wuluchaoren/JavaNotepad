package MyNotepad;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

//�����С�б��
public class FontSizeListSelectionListener implements ListSelectionListener {
    private FontDialog dialog;
    
    public FontSizeListSelectionListener(FontDialog dialog) {
        this.dialog = dialog;
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        TextService.setFontSizeListSelected(dialog);
    }

}
