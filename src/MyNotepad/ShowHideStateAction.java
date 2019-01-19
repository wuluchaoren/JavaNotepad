package MyNotepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//¡°²é¿´-×´Ì¬À¸¡±²Ëµ¥
public class ShowHideStateAction implements ActionListener {
	private NotepadFrame frame;
	
	public ShowHideStateAction(NotepadFrame frame){
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		frame.setStatePanelVisible(!frame.getStatePanelVisible());
	}
}
