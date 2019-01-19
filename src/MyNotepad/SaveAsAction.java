package MyNotepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//¡°Áí´æÎª¡±²Ëµ¥
public class SaveAsAction implements ActionListener {
	private NotepadFrame frame;
	
	public SaveAsAction(NotepadFrame frame){
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		FileService.saveFileMenu(frame, FileService.SAVE_AS);
	}

}
