package MyNotepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// ���������˵�
public class RepealAction implements ActionListener {
    private NotepadFrame frame;
    
    public RepealAction(NotepadFrame frame){
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        TextService.popTextArea(frame);
    }

}
