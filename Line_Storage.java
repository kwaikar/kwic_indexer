import java.awt.List;
import java.io.IOException;
import java.util.LinkedList;

public class Line_Storage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Line_Storage ls = new Line_Storage();
		ls.Setchar(1,1,1, 'H');
		ls.Setchar(1,1,1, 'O');
		System.out.println(ls.Char(1, 1, 2));

	}

	private LinkedList<LinkedList<LinkedList<String>>> list = new LinkedList<LinkedList<LinkedList<String>>>();

	public void Setchar( int l, int w, int c, char d)
	  {
		
		
		LinkedList<LinkedList<String>> line = (list!=null && list.size()>l-1)?list.get(l-1):null;
		
		if (line == null) {
			line = new LinkedList<LinkedList<String>>();
			list.add(l-1, line);
		}
		LinkedList<String> word = (line!=null && line.size()>w-1)? line.get(w-1):null;

		if (word == null) {
			word = new LinkedList<String>();
			line.add( w-1,word);
		}

		String letter = (word!=null && word.size()>c-1)? word.get(c-1):null;

		if (letter == null)
		{
			letter = d + "";
			word.add(c-1, letter);
		}

		// String NewText="";
		// int count =1;
		// String line="";
		// BufferedReader reader = new BufferedReader(
		// new StringReader(text));
		// try {
		// while ((line = reader.readLine()) != null && count< l){
		// count++;
		// }
		// } catch(IOException e) {
		// e.printStackTrace();
		// }
		//
		// //String[] lines =
		// string.split(System.getProperty("line.separator"));
		//
		// // Finding the wth word
		// String[] lineArr= line.trim().split(" ");
		// int n=0;
		// for (String str : lineArr ){
		// n++;
		// if (n==w) {
		// char[] strChar = str.toCharArray();
		//
		// if (strChar.length < c)
		// System.out.print("Number of the word character is less than your index");
		// strChar[c-1] = d;
		//
		// str = "";
		// for (char ch: strChar)
		// str +=ch;
		// }
		// }

	}

	public char Char(int l, int w, int c)  {

		try{

			return list.get(l-1).get(w-1).get(c-1).charAt(0);
		} catch (Exception e)
		{
			return ' ';
		}
	}

	public int Word(int l) throws IOException {

		return 1;
	}

}
