import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordFinder implements Comparable<String>{
	
	private ArrayList<String> validWords;
	private ArrayList<String> foundWords = new ArrayList<String>();
	private String letters;
	private char mustHaveLetter;
	private String regexPatternForAllLetters = "";
	private PrintWriter pw;
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
				foundWords.add(word);
			}
		}
		for (String letter: letters.split("")) {
			regexPatternForAllLetters += String.format("(?=[^%s]*+%s)", letter, letter);
		}
		regexPatternForAllLetters = "^" + regexPatternForAllLetters;
		Collections.sort(foundWords, Comparator.comparing(String::length));
		pattern = Pattern.compile(regexPatternForAllLetters);
		for (String word: foundWords) {
			matcher = pattern.matcher(word);
			if (matcher.find()) {
				word += "****";
			}
			pw.println(word);
		}
		pw.close();
		
	}

	@Override
	public int compareTo(String o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
