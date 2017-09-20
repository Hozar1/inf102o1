package inf102o1;
import java.util.Arrays;
import java.util.Stack;

public class rpTranslator {

	public static String rpToInf(String string) {
		
		Stack<String> operators = new Stack<String>();
		Stack<String> shitStack = new Stack<String>();	
		
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
				if(operators.toArray().length > 1){
					tempString += operators.pop(); 
					operators.push(s);
					tempString += operators.pop(); 
					tempString += operators.pop();
					tempString = "(" + tempString + ")";
					shitStack.push(tempString);
					tempString = "";
				}
				else if(operators.toArray().length > 0) 
				{
					tempString +=operators.pop();
					tempString +=s;
					tempString +=shitStack.pop();
					tempString = "(" + tempString + ")";
					shitStack.push(tempString);
					tempString = "";
				}
				else
				{
					endString +=shitStack.pop();
					endString +=s;
					endString +=shitStack.pop();
					endString = "(" + endString + ")";
				}				
				break;
			default :
				operators.push(s);			
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
