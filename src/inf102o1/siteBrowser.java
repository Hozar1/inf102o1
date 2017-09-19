package inf102o1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class siteBrowser {

	public static void main(String[] args) throws IOException {
		System.out.println(System.getProperty("user.dir"));
		
		File inFile = new File (System.getProperty("user.dir") + "\\src\\inf102o1\\timeline.txt");
	    Scanner sc = new Scanner (inFile);
	    while (sc.hasNextLine())
	    {
	      String line = sc.nextLine();
	      System.out.println (line);
	    }
	    sc.close();
	  }
	

}
