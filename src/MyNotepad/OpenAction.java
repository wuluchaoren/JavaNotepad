package MyNotepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//���򿪡��˵�
public class OpenAction implements ActionListener {
	private NotepadFrame frame;
	
	public OpenAction(NotepadFrame frame){
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		FileService.openFileMenu(frame);
	}

}


