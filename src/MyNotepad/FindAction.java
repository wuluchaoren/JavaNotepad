package MyNotepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//NotepadFrame菜单中的“查找”，打开查找对话框
public class FindAction implements ActionListener {
    private NotepadFrame frame;
    
    public FindAction(NotepadFrame frame){
        this.frame = frame;
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
        new FindDialog(frame);
    }

}
