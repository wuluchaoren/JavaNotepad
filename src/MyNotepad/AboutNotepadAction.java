package MyNotepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//“关于记事本”菜单
public class AboutNotepadAction implements ActionListener {
    private NotepadFrame frame;
    
    public AboutNotepadAction(NotepadFrame frame){
        this.frame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        new AboutNotepadDialog(frame);
    }

}
