import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ballot {

	private int size = 0;
	private String directory;
	private File f;
	private String[] candidates = {"--","--","--","--","--"};

	public Ballot(String directory) {
		this.f = new File(directory);
		this.directory = directory;
		try {
			BufferedReader b = new BufferedReader(new FileReader(this.f));
			String readLine = "";
			int i=0;
			int countApproved = 0;
			boolean approve =true;
			while (((readLine = b.readLine()) != null)) {
				readLine=readLine.trim();
				if(readLine.equals("Akiko")||readLine.equals("Bob")||readLine.equals("Carlos")||readLine.equals("Danielle")||readLine.equals("--")){
					candidates[i]=readLine;
					i++;
				}
			}
			for (String c: candidates){
				StdOut.println(c);
			}
			StdOut.println("XXXXXXXXXXXXXXXXXXXX");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int size() {
		int lineCount = 0;
		for (int i = 0; i < 5; i++) {
			if (!this.candidates.equals(null)) {
				lineCount++;
			}
		}
		return (lineCount);
	}
	

	public String get(int rank) {
		if (this.candidates[rank] == null) {
			return "Nobody";
		}
		String candidate = this.candidates[rank];
		return candidate;
	}

	public static void main(String[] args) {
		Ballot b = new Ballot("elections/election3/ballot0");
	}

}
