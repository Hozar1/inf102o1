package inf102o1;
import java.util.Stack;

public class rpTranslator {

	public static String rpToInf(String string) {
		
		Stack<String> operators = new Stack<String>();
//		Stack<String> wSpace = new Stack<String>();
		Stack<String> numbers = new Stack<String>();
		
		String[] splitString = string.split(" ");
		
		for(int i = 0; i<splitString.length ; i++)
		{
			String s = splitString[i];
			
			switch(s){
//			case " " :
//				wSpace.push(s);
//				break ;
			case "+" :
				operators.push(s);
				
				break;
			case "*" :
				operators.push(s);
				break;
			default :
				numbers.push(s);
			
			}
			System.out.println(operators);
			System.out.println(numbers);
		}
		
		
		
		return null;
	}
	
	public static void main(String[] args){
		  String a = "1 3  +  2 4 2 * + *";
		  rpToInf(a);
	  
		}

}
