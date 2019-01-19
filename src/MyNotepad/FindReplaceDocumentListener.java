package MyNotepad;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

//�����滻�Ի����в����ı�����¼�������
public class FindReplaceDocumentListener implements DocumentListener {
    private MyDialog dialog;
    
    public FindReplaceDocumentListener(MyDialog dialog){
        this.dialog = dialog;
    }
    
    private void whenTextNotNull(){
        if (dialog.getFindText() != null && dialog.getFindText().length() > 0){
            dialog.setButtonEnable(true);
        }else{
            dialog.setButtonEnable(false);
        }
    }
    @Override
    public void changedUpdate(DocumentEvent e) {
        whenTextNotNull();
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        whenTextNotNull();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        whenTextNotNull();
    }

}
