package MyNotepad;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

//�Զ���JListʹ�õĵ�Ԫ��Ⱦ��
public class MyCellRenderer extends JLabel implements ListCellRenderer<String> {

    @Override
    public Component getListCellRendererComponent(JList list,
            String item, int index, boolean isSelected, boolean cellHasFocus) {
        setText(item);
        if(isSelected){
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        }else{
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        setEnabled(list.isEnabled());
        Font font = list.getFont();
        setFont(new Font(item, font.getStyle(), font.getSize()));
        setOpaque(true); //�������͸��
        return this;
    }

}
