package MyNotepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//“查找”对话框，“查找下一个”
public class FindNextAction implements ActionListener {
    private MyDialog dialog;
    
    public FindNextAction(MyDialog dialog){
        this.dialog = dialog;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //保存此次搜索的字符串
        TextService.find(dialog);
    }

}
