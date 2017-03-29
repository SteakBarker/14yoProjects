import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class highscore {
	static String Hname;
	
	
	
	public static void main(String[] args) {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("Hname.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Hname = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(Hname);
		
	}

}
