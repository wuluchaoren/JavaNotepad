package MyNotepad;

import java.awt.event.WindowListener;

public class WindowFactory {
	public static WindowListener getWindowListener(NotepadFrame frame, String type){
		switch (type) {
		case "Closing":
			return new ClosingWindow(frame);
		}
		return null;
	}
}
