package MyNotepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//¡°É¾³ý¡±²Ëµ¥
public class DeleteAction implements ActionListener {
	private NotepadFrame frame;
	
	public DeleteAction(NotepadFrame frame){
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		TextService.delete(frame);
	}

}
