package MyNotepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//��ת�����˵�
public class GotoAction implements ActionListener {
    private NotepadFrame frame;
    
    public GotoAction(NotepadFrame frame){
        this.frame = frame;
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
        new GotoDialog(frame);
    }

}
