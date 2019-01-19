package MyNotepad;

import java.awt.Frame;

import javax.swing.JDialog;
 
public abstract class MyDialog extends JDialog {
    protected static String lastFindText = "";
    protected static String lastReplaceText = "";
    public MyDialog(){
        super();
    }
    
    public MyDialog(Frame owner, String title){
        super(owner, title);
        //���öԻ�����Frame����
        int frameX = (int)owner.getBounds().getX();
        int frameY = (int)owner.getBounds().getY();
        setBounds(frameX+80, frameY+150, 0, 0);
    }   
    
    public abstract void setButtonEnable(boolean b); //���ò����滻�Ի���������ť��״̬
    public abstract boolean isMatchCase(); //�Ƿ����ִ�Сд
    public abstract boolean isDownward(); //�Ƿ����²���
    public abstract String getFindText(); //��Ҫ���ҵ�Ŀ���ַ���
    public abstract String getReplaceText(); //��Ҫ�滻��Ŀ���ַ���
    public abstract String getWholeText(); //��ȡ�ı����ȫ���ı�
    public abstract String getSelectedText(); //Ŀǰѡ�е��ı�
    public abstract NotepadFrame getNotepadFrame(); //��������NotepadFrame
    public abstract int getSelectionStart(); //��ȡ�ı���Ŀ�ʼλ��
    public abstract int getSelectionEnd(); //��ȡ�ı���ѡ���β��λ��
    public abstract void select(int start, int end); //ѡ���Ӧ���ı���
    public abstract void replaceSelection(String text); //�滻ѡ���ı�
    public abstract void setText(String text); //�����ı�����ı�

}
