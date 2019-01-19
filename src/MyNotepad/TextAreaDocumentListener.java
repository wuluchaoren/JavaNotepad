package MyNotepad;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * 自定义实现Document监听器
 * 文档内容改变时触发此监听器，将有未保存的更改标记设为true，并更新行数
 */
public class TextAreaDocumentListener implements DocumentListener {
    private NotepadFrame frame;
    
    public TextAreaDocumentListener(NotepadFrame frame){
        this.frame = frame;
    }
    
    //设置未保存标记为真，并将内容存入撤消栈
    private void whenTextAreaChange(){
        frame.setHasChangedNoSave(true);
        TextService.pushTextArea(frame);
    }
    
    @Override
    public void changedUpdate(DocumentEvent e) {
        whenTextAreaChange();
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        whenTextAreaChange();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        whenTextAreaChange();
    }

}
