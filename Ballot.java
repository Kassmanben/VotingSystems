import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ballot {

	private int size = 0;
	private File f;

	public Ballot(String directory) {
		this.f = new File(directory);
	}

	public int size(String directory) {
		int lineCount = 0;
		try {
			File f = new File(directory);
			BufferedReader b = new BufferedReader(new FileReader(f));
			String readLine = "";
			while ((readLine = b.readLine()) != null) {
				System.out.println(readLine);
				lineCount++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (lineCount);
	}

	public static void main(String[] args) {

	}

}
