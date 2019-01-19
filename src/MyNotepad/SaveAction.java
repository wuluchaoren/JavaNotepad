package MyNotepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveAction implements ActionListener {
	private NotepadFrame frame;
	
	public SaveAction(NotepadFrame frame){
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		FileService.saveFileMenu(frame, FileService.SAVE);
	}

}
