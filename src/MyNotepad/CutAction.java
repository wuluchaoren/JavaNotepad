package MyNotepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CutAction implements ActionListener {
	private NotepadFrame frame;
	
	public CutAction(NotepadFrame frame){
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//�����ı�����صķ������м���
		TextService.cut(frame);
	}

}
