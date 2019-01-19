package MyNotepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 查找替换对话框“替换全部”按钮
public class ReplaceAllAction implements ActionListener {
    private MyDialog dialog;
    
    public ReplaceAllAction(MyDialog dialog){
        this.dialog = dialog;
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
        TextService.replaceAll(dialog);
    }

}
