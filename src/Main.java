import java.util.ArrayList;

public class Main {
	
	public static WordFinder wf = new WordFinder();
	public static ArrayList<String> allWordsAL = new ArrayList<String>();
	
	public static void main(String[] args) {
		allWordsAL = wf.getWords();
		for (String word: allWordsAL) {
			System.out.println(word);
		}
	}

}
