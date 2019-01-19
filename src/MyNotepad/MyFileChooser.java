package MyNotepad;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JFileChooser;

//�Զ���JFileChooser���ʵ���һЩ�����������Զ���JFileChooser������������
public class MyFileChooser extends JFileChooser {
	private Font defaultFileChooserFont = new Font("΢���ź�", Font.PLAIN, 12);
	
	public MyFileChooser(){
		super();
		this.modifyFont(this, defaultFileChooserFont);
	}
	
	public MyFileChooser(String s){
		super(s);
 		this.modifyFont(this, defaultFileChooserFont);
	}
	
	//�Ի�����N������ļ��ϣ���Ҫͨ���ݹ齫ÿһ������������������
	private void modifyFont(Component comp, Font font){
		comp.setFont(font);
		if(comp instanceof Container){
			Container c = (Container) comp;
			int n = c.getComponentCount();
			for(int i = 0; i < n; i++){
				modifyFont(c.getComponent(i), font);
			}
		}
	}
	
}
