package MyNotepad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ���Զ����С��˵�
 * ���ڲ��Զ����е�ʱ�����ʾ״̬��
 */
public class AutoWrapAction implements ActionListener {
    private NotepadFrame frame;
	
	public AutoWrapAction(NotepadFrame frame){
	    this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {		
		TextService.setAutoWrap(frame);
	}

}
