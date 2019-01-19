package MyNotepad;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//¹Ø±Õ´°¿Ú
public class ClosingWindow extends WindowAdapter {
	private NotepadFrame frame;
	public ClosingWindow(NotepadFrame frame){
		this.frame = frame;
	}
	@Override
	public void windowClosing(WindowEvent e){
		FileService.closeWindow(this.frame);
	}
}
