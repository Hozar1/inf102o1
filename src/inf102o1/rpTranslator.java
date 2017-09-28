package inf102o1;
import java.util.Arrays;
import java.util.Stack;

public class rpTranslator {

	public static String rpToInf(String string) {
		
		Stack<String> shitStack = new Stack<String>();	
		
		string.replaceAll("\\s","");
		String[] splitString = string.split(" ");
		for(int i = 0; i<splitString.length ; i++)
		{
			String endString = "";
			String s = splitString[i];
			//System.out.println(splitString[i]);
			switch(s){
			case "∗" :
			case "-" :
			case "/" :	
			case "*" :
			case "+" :
					endString +=shitStack.pop();
					endString +=s;
					endString +=shitStack.pop();
					endString = "(" + endString + ")";
					shitStack.push(endString);	
				break;
			default :
				shitStack.push(s);			
			}			
		}
		System.out.println(shitStack.pop());
		return null;
	}
	
	public static void main(String[] args){
		  String a = "1 3 + 2 4 2 * + * 4 / 4 5 + +";
		  rpToInf(a);
	  
		}

}
