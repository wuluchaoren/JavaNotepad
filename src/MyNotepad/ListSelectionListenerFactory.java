package MyNotepad;

import java.awt.event.ItemListener;

import javax.swing.event.ListSelectionListener;

//��ȡJListѡ�������
public class ListSelectionListenerFactory {
    public static ListSelectionListener getListener(FontDialog dialog, String type){
        switch (type){
        case "����":
            return new FontListSelectionListener(dialog);
        case "����":
            return new FontStyleListSelectionListener(dialog);
        case "��С":
            return new FontSizeListSelectionListener(dialog);
        }
        return null;
    }

}
