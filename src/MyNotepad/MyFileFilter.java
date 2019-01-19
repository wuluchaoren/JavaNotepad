package MyNotepad;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.filechooser.FileFilter;

//ʵ��FileFilter�����࣬�����Զ���FileFilter��Ϊ��������
public class MyFileFilter extends FileFilter {
	private String description;
	private List<String> extensions = new ArrayList<String>();
	
	//�����Ҫ���˵ĺ�׺��
	public void addExtension(String extension){
		if(!extension.startsWith(".")){
			extension = "." + extension;
		}
		this.extensions.add(extension.toLowerCase());
	}
	
	//��ӶԻ�������
	public void addDescription(String description){
		this.description = description;
	}

	@Override
	public boolean accept(File f) {
		if(f.isDirectory()) return true;
		String name = f.getName().toLowerCase();
		for(String s : extensions){
			if (name.endsWith(s)) return true;
		}
		return false;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

}
