import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {
	public static void main(String[] args) throws Exception
	{
		File file = new File("res/S17 Text File.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String st;
		while((st = br.readLine()) != null)
			System.out.println(st);
		
		
	}
}

class Word{
	private String word;
	private int count;
	
	public Word(String w)
	{
		word = w;
		count = 0;
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
