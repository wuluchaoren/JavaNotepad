package MyNotepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Ìæ»»¶Ô»°¿ò¡°Ìæ»»¡±°´Å¥
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
