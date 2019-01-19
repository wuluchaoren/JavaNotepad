package MyNotepad;

import java.awt.event.ActionListener;


public class ActionListenerFactory {
	
    // NotepadFrame�е�ActionListener
	public static ActionListener getActionListener(NotepadFrame frame, String menuItemName){
		switch (menuItemName){
		case "�Զ�����(W)":
			return new AutoWrapAction(frame);
		case "����(F)...":
		    return new FontAction(frame);
		case "�½�(N)":
			return new NewNotepadAction();
		case "�˳�(X)":
			return new ExitNotepadAction(frame);
		case "״̬��(S)":
			return new ShowHideStateAction(frame);
		case "��(O)...":
			return new OpenAction(frame);
		case "����(S)":
			return new SaveAction(frame);
		case "���Ϊ(A)...":
			return new SaveAsAction(frame);
		case "����(U)":
		    return new RepealAction(frame);
		case "����(T)":
			return new CutAction(frame);
		case "����(C)":
			return new CopyAction(frame);
		case "ճ��(P)":
			return new PasteAction(frame);
		case "ɾ��(L)":
		    return new DeleteAction(frame);
		case "����(F)...":
		    return new FindAction(frame);
		case "�滻(R)...":
		    return new ReplaceAction(frame);
		case "ת��(G)...":
		    return new GotoAction(frame);
		case "ȫѡ(A)":
			return new AllSelectAction(frame);
		case "ʱ��/����(D)":
			return new AddTimeAction(frame);
		case "���ڼ��±�(A)":
		    return new AboutNotepadAction(frame);
		}
		return null;
	}
	
	// FindDialog�е�ActionListener
	public static ActionListener getActionListener(MyDialog dialog, String buttonName){
	    switch (buttonName) {
        case "������һ��(F)":
            return new FindNextAction(dialog);
        case "�滻(R)":
            return new ReplaceButtonAction(dialog);
        case "ȫ���滻(A)":
            return new ReplaceAllAction(dialog);
        case "ȡ��":
            return new CancelAction(dialog);
        }
	    return null;
	}
	
	//��ת�����е�ActionListener
	public static ActionListener getActionListener(GotoDialog dialog, String buttonName){
	    switch (buttonName){
	    case "ת��":
	        return new GotoDialogGotoAction(dialog);
	    case "ȡ��":
	        return new GotoDialogCancelAction(dialog);
	    }
	    return null;
	}
	
	//�����ڡ��Ի����ActionListener
	public static ActionListener getActionListener(AboutNotepadDialog dialog, String buttonName){
	    switch (buttonName){
	    case "ȷ��":
	        return new CancelAboutAction(dialog);
	    }
	    return null;
	}
	
	//�����塱�Ի����ActionListener
	public static ActionListener getActionListener(FontDialog dialog, String type){
	    switch (type){
	    case "ȷ��":
	        return new EnsureFontDialogActionListener(dialog);
	    case "ȡ��":
	        return new CancelFontDialogActionListener(dialog);
	    }
	    return null;
	}
}
