import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) throws Exception
	{
		File file = new File("res/S17 Text File.txt");
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String sc;
		String text = new String();
		
		while((sc = br.readLine()) != null)
			text = text.concat(sc + "\n");
	
		String regex = "\\w[a-zA-Z]*[0-9]*\\+*(’[a-zA-Z]+[0-9]*)*(-[a-zA-Z]+[0-9]*)*";
		
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
				if(w.getWord().equalsIgnoreCase(s))
				{
					w.incrementCount();
					found = true;
				}
			
			
			if(!found)
			{
				if(s.indexOf("’") != -1)
					s = s.replace("’", "�");

				words.add(new Word(s));
			}
		}
		
		int sum = 0;
		
		for(Word w : words)
			sum += w.getCount();
		
		System.out.println("Total Word Count: " + sum);

		for(Word w : words) 
			System.out.println(w.getWord() + " : " + w.getCount());
		
		br.close();
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
