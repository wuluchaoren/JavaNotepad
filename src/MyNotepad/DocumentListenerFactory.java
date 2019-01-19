package MyNotepad;

import javax.swing.event.DocumentListener;

public class DocumentListenerFactory {
    public static DocumentListener getDocumentListener(NotepadFrame frame, String type){
        switch (type) {
        case "NotepadFrameTextArea":
            return new TextAreaDocumentListener(frame);
        }
        return null;
    }
    
    public static DocumentListener getDocumentListener(MyDialog dialog, String type){
        switch (type){
        case "FindReplaceTextField":
            return new FindReplaceDocumentListener(dialog);
        }
        return null;
    }
}
