package MyNotepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//�����塱�˵�
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
