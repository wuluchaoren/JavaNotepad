package MyNotepad;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

//字体大小列表框
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
