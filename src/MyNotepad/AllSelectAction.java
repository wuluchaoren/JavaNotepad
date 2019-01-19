package MyNotepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AllSelectAction implements ActionListener {
	private NotepadFrame frame;
	
	public AllSelectAction(NotepadFrame frame){
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		TextService.allSelect(frame);
	}

}
