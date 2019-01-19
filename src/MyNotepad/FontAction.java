package MyNotepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//¡°×ÖÌå¡±²Ëµ¥
public class FontAction implements ActionListener {
    private NotepadFrame frame;
    
    public FontAction(NotepadFrame frame){
        this.frame = frame;
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
        new FontDialog(frame);
    }

}
