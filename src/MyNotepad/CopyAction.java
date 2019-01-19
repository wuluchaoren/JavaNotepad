package MyNotepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//¡°¸´ÖÆ¡±²Ëµ¥
public class CopyAction implements ActionListener {
	private NotepadFrame frame;
	
	public CopyAction(NotepadFrame frame){
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		TextService.copy(frame);
	}

}
