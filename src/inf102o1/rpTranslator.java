/**
 * 
 * @author Ole Tobias Bird
 * @author Martin Breistein
 * 
 */
package inf102o1;
import java.util.Arrays;
import java.util.Stack;

public class rpTranslator {

	public static String rpToInf(String string) {
		//Split into 2 stacks, eleStack where all the numbers and operators go
		//tempStack where we hold them when we incapsulate them
		Stack<String> eleStack = new Stack<String>();
		Stack<String> tempStack = new Stack<String>();	
		//Split them up into elements in a list
		string.replaceAll("\\s","");
		String[] splitString = string.split(" ");		
		String endString = "";
		String tempString = "";
		for(int i = 0; i<splitString.length ; i++)
		{
			String s = splitString[i];			
			switch(s){
			case "*" :
			case "+" :
				//Since we want it to be number operator number we have to pop before pushing
				if(eleStack.toArray().length > 1){
					tempString += eleStack.pop(); 
					eleStack.push(s);
					tempString += eleStack.pop(); 
					tempString += eleStack.pop();
					tempString = "(" + tempString + ")";
					tempStack.push(tempString);
					tempString = "";
				}
				//Case of only number and operator
				else if(eleStack.toArray().length > 0) 
				{
					tempString +=eleStack.pop();
					tempString +=s;
					tempString +=tempStack.pop();
					tempString = "(" + tempString + ")";
					tempStack.push(tempString);
					tempString = "";
				}
				//Case of only operator
				else
				{
					endString +=tempStack.pop();
					endString +=s;
					endString +=tempStack.pop();
					endString = "(" + endString + ")";
				}				
				break;
			//If it is not an operator, simply push to stack
			default :
				eleStack.push(s);			
			}			
		}
		System.out.println(endString);
		return null;
	}
	
	public static void main(String[] args){
		  String a = "1 3 + 2 4 2 * + *";
		  rpToInf(a);
	  
		}

}
