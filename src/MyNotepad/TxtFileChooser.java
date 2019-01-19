package MyNotepad;

//仅筛选TXT文件
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
