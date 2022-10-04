import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordFinder {
	
	private ArrayList<String> validWords;
	private String foundWords;
	private String letters;
	private char mustHaveLetter;
	private PrintWriter pw;
	private boolean containsAll = true;
	private boolean validWord = true;
	private Pattern pattern;
	private Matcher matcher;
	
	public WordFinder(ArrayList<String> validWords, String letters) {
		this.validWords = validWords;
		this.letters = letters;
	}
	
	public void FindWords() {
		try {
			pw = new PrintWriter("res/Words.txt");
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe);
		}
		mustHaveLetter = letters.charAt(7);
		letters = letters.substring(0, 7);
		pattern = Pattern.compile("^["+letters+"]*$");
		for (String word: validWords) {
			matcher = pattern.matcher(word);
			if (word.contains(String.valueOf(mustHaveLetter)) && matcher.find()) {
				pw.println(word);
			}
		}
		pw.close();
		
	}
	
	
}
