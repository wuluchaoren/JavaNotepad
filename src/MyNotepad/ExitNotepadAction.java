package MyNotepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//���˳����˵�
public class ExitNotepadAction implements ActionListener {
	private NotepadFrame frame;
	
	public ExitNotepadAction(NotepadFrame frame){
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		FileService.closeWindow(frame);
	}

}
