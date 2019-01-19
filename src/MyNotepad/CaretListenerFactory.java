package MyNotepad;

import javax.swing.event.CaretListener;

// ²åÈë·ûÊÂ¼ş¼àÌıÆ÷
public class CaretListenerFactory {
    public static CaretListener getCaretListener(NotepadFrame frame){
        return new MyCaretListener(frame);
    }
}
