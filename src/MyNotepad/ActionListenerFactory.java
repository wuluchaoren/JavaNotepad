package MyNotepad;

import java.awt.event.ActionListener;


public class ActionListenerFactory {
	
    // NotepadFrame中的ActionListener
	public static ActionListener getActionListener(NotepadFrame frame, String menuItemName){
		switch (menuItemName){
		case "自动换行(W)":
			return new AutoWrapAction(frame);
		case "字体(F)...":
		    return new FontAction(frame);
		case "新建(N)":
			return new NewNotepadAction();
		case "退出(X)":
			return new ExitNotepadAction(frame);
		case "状态栏(S)":
			return new ShowHideStateAction(frame);
		case "打开(O)...":
			return new OpenAction(frame);
		case "保存(S)":
			return new SaveAction(frame);
		case "另存为(A)...":
			return new SaveAsAction(frame);
		case "撤消(U)":
		    return new RepealAction(frame);
		case "剪切(T)":
			return new CutAction(frame);
		case "复制(C)":
			return new CopyAction(frame);
		case "粘贴(P)":
			return new PasteAction(frame);
		case "删除(L)":
		    return new DeleteAction(frame);
		case "查找(F)...":
		    return new FindAction(frame);
		case "替换(R)...":
		    return new ReplaceAction(frame);
		case "转到(G)...":
		    return new GotoAction(frame);
		case "全选(A)":
			return new AllSelectAction(frame);
		case "时间/日期(D)":
			return new AddTimeAction(frame);
		case "关于记事本(A)":
		    return new AboutNotepadAction(frame);
		}
		return null;
	}
	
	// FindDialog中的ActionListener
	public static ActionListener getActionListener(MyDialog dialog, String buttonName){
	    switch (buttonName) {
        case "查找下一个(F)":
            return new FindNextAction(dialog);
        case "替换(R)":
            return new ReplaceButtonAction(dialog);
        case "全部替换(A)":
            return new ReplaceAllAction(dialog);
        case "取消":
            return new CancelAction(dialog);
        }
	    return null;
	}
	
	//“转到”中的ActionListener
	public static ActionListener getActionListener(GotoDialog dialog, String buttonName){
	    switch (buttonName){
	    case "转到":
	        return new GotoDialogGotoAction(dialog);
	    case "取消":
	        return new GotoDialogCancelAction(dialog);
	    }
	    return null;
	}
	
	//“关于”对话框的ActionListener
	public static ActionListener getActionListener(AboutNotepadDialog dialog, String buttonName){
	    switch (buttonName){
	    case "确定":
	        return new CancelAboutAction(dialog);
	    }
	    return null;
	}
	
	//“字体”对话框的ActionListener
	public static ActionListener getActionListener(FontDialog dialog, String type){
	    switch (type){
	    case "确定":
	        return new EnsureFontDialogActionListener(dialog);
	    case "取消":
	        return new CancelFontDialogActionListener(dialog);
	    }
	    return null;
	}
}
