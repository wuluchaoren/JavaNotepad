package MyNotepad;

import javax.swing.event.CaretListener;

// ������¼�������
public class CaretListenerFactory {
    public static CaretListener getCaretListener(NotepadFrame frame){
        return new MyCaretListener(frame);
    }
}
