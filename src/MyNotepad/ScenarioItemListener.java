package MyNotepad;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

//“字体”对话框的脚本列表
public class ScenarioItemListener implements ItemListener {
    private FontDialog dialog;
    
    public ScenarioItemListener(FontDialog dialog) {
        this.dialog = dialog;
    }
    
    @Override
    public void itemStateChanged(ItemEvent e) {
        TextService.setTextExample(dialog);
    }

}
