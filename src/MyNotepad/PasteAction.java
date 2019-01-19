package MyNotepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//¡°Õ³Ìù¡±²Ëµ¥
public class PasteAction implements ActionListener {
	private NotepadFrame frame;
	
	public PasteAction(NotepadFrame frame){
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		TextService.paste(frame);
	}

}
