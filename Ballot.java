import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ballot {

	private int size = 0;
	private String directory;
	private File f;
	private String[] candidates = new String[4];

	public Ballot(String directory) {
		this.f = new File(directory);
		this.directory = directory;
		try {
			BufferedReader b = new BufferedReader(new FileReader(this.f));
			String readLine = "";
			int i=0;
			while (((readLine = b.readLine()) != null)) {
				this.candidates[i] = readLine;
				readLine = b.readLine();
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
	

	public int size() {
		int lineCount=0;
		for (int i=0;i<4;i++){
			if(!this.candidates.equals(null)){
				lineCount++;
			}
		}
		return (lineCount);
	}
	
	public String get(int rank){
		String candidate=this.candidates[rank];
		return candidate;
	}

	public static void main(String[] args) {

	}

}
