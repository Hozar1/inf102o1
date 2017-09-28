/**
 * @author Ole Tobias Bird
 * @author Martin Breistein
 */


package inf102o1;
import java.util.Stack;

public class rpTranslator {

	public static String rpToInf(String string) {
		//Takes string, tokenzises it using string.split and pushes it onto expressionStack.
		//Then we check for "+" and "*" and pop the two following tokens down, combine into one 
		//string and push back onto the stack.
		
		Stack<String> expressionStack = new Stack<String>();	
		
		string.replaceAll("\\s","");
		String[] splitString = string.split(" ");
		for(int i = 0; i<splitString.length ; i++)
		{
			String endString = "";
			String s = splitString[i];
			//System.out.println(splitString[i]);
			switch(s){
			case "∗" :
			case "*" :
			case "+" :
					endString +=expressionStack.pop();
					endString +=s;
					endString +=expressionStack.pop();
					endString = "(" + endString + ")";
					expressionStack.push(endString);	
				break;
			default :
				expressionStack.push(s);			
			}			
		}
		System.out.println(expressionStack.pop());
		return null;
	}
	
	public static void main(String[] args){
		//Main creates input string, and runs rpToInf(String) which prints the sorted string.
		//since "+" and "*" are associative we have not sorted the expression to match the output given in assignment text.
		  String a = "1 3 + 2 4 2 * + *";
		  rpToInf(a);
	  
		}

}
