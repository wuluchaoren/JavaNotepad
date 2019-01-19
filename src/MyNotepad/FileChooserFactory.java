package MyNotepad;

import javax.swing.JFileChooser;

public class FileChooserFactory {
	
	//����Ĭ��ʹ�õ�ǰ·����JFileChooser
	public static JFileChooser getFileChooser(String type){
		switch (type) {
		case "txt":
		case ".txt":
			return new TxtFileChooser(".");
		}
		return null;
	}
}
