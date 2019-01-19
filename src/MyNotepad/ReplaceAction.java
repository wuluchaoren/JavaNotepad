package MyNotepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// ¡°Ìæ»»¡±²Ëµ¥Ïî
public class ReplaceAction implements ActionListener {
    private NotepadFrame frame;
    
    public ReplaceAction(NotepadFrame frame){
        this.frame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        new FindReplaceDialog(frame);
    }

}
