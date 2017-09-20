package inf102o1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class siteBrowser {

	public static void main(String[] args) throws IOException {
		Stack<String> baseStack = new Stack<String>();
		Stack<String> backStack = new Stack<String>();
		Stack<String> forwardStack = new Stack<String>();
		
		File inFile = new File (System.getProperty("user.dir") + "\\src\\inf102o1\\timeline.txt");
	    Scanner sc = new Scanner (inFile);
	    while (sc.hasNextLine())
	    {
	      String line = sc.nextLine();
	      baseStack.push(line);	      
	    }
	    sc.close();
	    
	    Collections.reverse(baseStack);    	
	    Integer lengthCommand = Integer.valueOf(baseStack.pop()); 
	    
	    String tempString2="";
	    for(int i=1;i<lengthCommand;i++)
	    {
	    	String tempString = "";
	    	
	    	tempString = baseStack.pop();
	    	//if(tempString=((tempString2= "∗back∗") && (tempString!="∗back∗")||(tempString!="∗forward∗")))
	    	//if(tempString2== "∗back∗" && (tempString !="∗back∗")||(tempString!="∗forward∗")) 
	    	//	forwardStack.removeAllElements();
	    	switch(tempString){   	   	
	    		
	    	case"∗back∗":
	    		tempString = backStack.pop();	    		
	    		forwardStack.push(tempString);
	    		System.out.println(backStack.peek());
	    		break;
	    	case"∗forward∗":
	    		if(!forwardStack.empty()){
	    			tempString = forwardStack.pop();
	    			backStack.push(tempString);
	    			System.out.println(backStack.peek());
	    		}
	    		else
	    			System.out.println("Warning :   l a s t   w e b s i t e");
	    		
	    		break;
	    	default:
	    		if (tempString2== "∗back∗" || tempString2== "∗forward∗" ){
	    			forwardStack.clear();
	    		}
	    		backStack.push(tempString);
	    		System.out.println(backStack.peek());
	    		    	   		
	    	tempString2 = tempString;
	    	}
	    	
	    	
	    }
	    
	  }
	

}
