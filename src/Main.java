import java.util.ArrayList;

public class Main {
	
	public static WordGetter wg = new WordGetter();
	public static ArrayList<String> allWordsAL = new ArrayList<String>();
	public static String letters = "";
	
	public static void main(String[] args) {
		allWordsAL = wg.getWords();
		letters = wg.getLetters();
		System.out.println(letters);
	}

}
