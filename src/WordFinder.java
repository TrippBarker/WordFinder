import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WordFinder {
	
	private Scanner sc;
	private FileReader fr;
	
	public WordFinder(){
		
	}
	
	public ArrayList<String> getWords() {
		ArrayList<String> engWordsAL = new ArrayList<String>();
		try {
			fr = new FileReader("res/EngWords.txt");
			sc = new Scanner(fr);
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe);
		}
		
		while (sc.hasNextLine()) {
			engWordsAL.add(sc.nextLine());
		}
		sc.close();
		return engWordsAL;
	}
	

}
