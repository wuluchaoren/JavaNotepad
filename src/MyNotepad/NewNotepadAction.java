package MyNotepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//���½����˵�
public class NewNotepadAction implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		new NotepadFrame();
	}

}
