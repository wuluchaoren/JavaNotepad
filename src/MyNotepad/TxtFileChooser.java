package MyNotepad;

//��ɸѡTXT�ļ�
public class TxtFileChooser extends MyFileChooser {
	public TxtFileChooser(){
		super();
		this.setFileFilter(new TxtFileFilter());
	}
	
	public TxtFileChooser(String path){
		super(path);
		this.setFileFilter(new TxtFileFilter());
	}
}
