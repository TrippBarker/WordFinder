import java.util.ArrayList;

public class Main {
	
	//public static WordGrabber wGrab = new WordGrabber();
	public static WordGetter wg = new WordGetter();
	public static WordFinder wf;
	public static ArrayList<String> allWordsAL = new ArrayList<String>();
	public static String letters = "";
	
	public static void main(String[] args) {
		allWordsAL = wg.getWords();
		letters = wg.getLetters();
		wf = new WordFinder(allWordsAL, letters);
		wf.FindWords();
	}

}
