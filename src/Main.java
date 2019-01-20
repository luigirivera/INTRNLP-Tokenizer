import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) throws Exception
	{
		File file = new File("res/S17 Text File.txt");
		
		Scanner sc = new Scanner(file);
		
		String text = new String();
		
		while(sc.hasNextLine())
			text = text.concat(sc.nextLine() + "\n");
		
		String regex = "[^\\W][a-zA-Z]*[0-9]*([a-zA-Z]*[0-9]*\\+)*(’[a-zA-Z]+[0-9]*)*";
		
		Pattern r = Pattern.compile(regex);
		Matcher m = r.matcher("Hello");
		
		
		//for some reason, the matcher doesnt work. i cant get the individual results
		
		//arraylist for all unique words
		//loop
		//check if word is in list
		//if true, increment the counter
		//else, make a new word object
		//increment total word count
		
		//display
		
	}
}

class Word{
	private String word;
	private int count;
	
	public Word(String w)
	{
		word = w;
		count = 1;
	}
	
	public void incrementCount() {count++;}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
}
