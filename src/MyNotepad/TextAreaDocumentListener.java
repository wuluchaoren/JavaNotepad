package MyNotepad;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * �Զ���ʵ��Document������
 * �ĵ����ݸı�ʱ�����˼�����������δ����ĸ��ı����Ϊtrue������������
 */
public class TextAreaDocumentListener implements DocumentListener {
    private NotepadFrame frame;
    
    public TextAreaDocumentListener(NotepadFrame frame){
        this.frame = frame;
    }
    
    //����δ������Ϊ�棬�������ݴ��볷��ջ
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
