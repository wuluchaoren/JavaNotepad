package MyNotepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// �滻�Ի����滻����ť
public class ReplaceButtonAction implements ActionListener {
    private MyDialog dialog;
    
    public ReplaceButtonAction(MyDialog dialog){
        this.dialog = dialog;
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
        TextService.replace(dialog);
    }

}
