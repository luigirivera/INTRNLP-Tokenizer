import java.io.File;
import java.util.ArrayList;
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
		Matcher m = r.matcher(text);
		
		ArrayList<String> matches = new ArrayList<String>();
		ArrayList<Word> words = new ArrayList<Word>();
		while(m.find())
			matches.add(m.group(0));
		
		
		for(String s : matches)
		{
			boolean found = false;
			for(Word w : words)
			{
				if(w.getWord().equalsIgnoreCase(s))
				{
					w.incrementCount();
					found = true;
				}
			}
				
			
			if(!found)
				words.add(new Word(s));
		}
		
		System.out.println("Total Word Count: " + matches.size());

		for(Word w : words)
		{
			System.out.println(w.getWord() + " : " + w.getCount());
		}
		
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
