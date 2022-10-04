import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WordGetter {
	
	private Scanner sc;
	private Scanner input;
	private FileReader fr;
	
	public WordGetter(){
		try {
			fr = new FileReader("res/EngWords.txt");
			sc = new Scanner(fr);
			input = new Scanner(System.in);
		} catch (FileNotFoundException fnfe) {
			System.out.println(fnfe);
		}
	}
	
	public ArrayList<String> getWords(){
		ArrayList<String> engWordsAL = new ArrayList<String>();
		while (sc.hasNextLine()) {
			engWordsAL.add(sc.nextLine());
		}
		return engWordsAL;
	}
	
	public String getLetters(){
		String letters = "";
		String letters2 = "";
		String mustHaveLetter = "";
		while(!(letters.length() == 7)) {
			letters2 = "";
			System.out.print("Please enter the 7 unique letters on the board:\n> ");
			letters = input.nextLine().toUpperCase();
			System.out.printf("Please enter the must have letter in the center of the board:[%s]\n> ", letters);
			mustHaveLetter = input.nextLine().toUpperCase();
			if (mustHaveLetter.length() > 1) {
				System.out.println("Please enter only one letter.");
				letters = "";
			} else if (!(letters.contains(mustHaveLetter))) {
				System.out.printf("Please enter on of the characters provided: [%s]\n", letters);
				letters = "";
			}
			for(int i = 0; i < letters.length(); i++) {
				if (letters2.contains(String.valueOf(letters.charAt(i)))) {
					letters = "";
					System.out.println("Please enter 7 UNIQUE letters.");
				} else {
					letters2 += letters.charAt(i);
				}
			}
		}
		return letters + mustHaveLetter;
	}

}
