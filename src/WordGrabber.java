import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class WordGrabber {
	private FileReader fr;
	private Scanner sc;
	private PrintWriter pw;
	private String word;
	
	public WordGrabber() {
		try {
			fr = new FileReader("res/english3.txt");
			sc = new Scanner(fr);
			pw = new PrintWriter("res/EngWords.txt");
		} catch(FileNotFoundException fnfe) {
			System.out.println(fnfe);
		}
		
		while(sc.hasNextLine()) {
			word = sc.nextLine().toUpperCase();
			if (word.length() > 3) {
				pw.println(word);
			}
		}
		pw.close();
		sc.close();
	}
}
