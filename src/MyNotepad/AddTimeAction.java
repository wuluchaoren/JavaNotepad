package MyNotepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddTimeAction implements ActionListener {
	private NotepadFrame frame;
	
	public AddTimeAction(NotepadFrame frame){
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		TextService.addTime(frame);
	}
}
