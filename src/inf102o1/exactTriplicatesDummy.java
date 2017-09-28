package inf102o1;
import java.util.Iterator; 
import java.util.ArrayList; 
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class exactTriplicatesDummy<Stringkey extends Comparable<Stringkey> , ListValue> {

	  private int N = 0;     // number of key-value pairs
	  private ArrayList<Stringkey> StringValue = new ArrayList<Stringkey>();
	  private ArrayList<ListValue> Countvalues = new ArrayList<>();
	
	  public boolean isEmpty() { return N == 0; }
	  public int     size()    { return N; }
	  public Iterator<Stringkey> keysIterator() { return StringValue.iterator(); }
	  
	  public int orderingPlacement(Stringkey stringinput){
		  int low = 0, high = N-1;
		  while(low<=high){// want all keys to the left than stringinput to be lower than low and 
			  							// all inputs to the right to be higher than stringinput
			  int mid = (high+low)/2;
			  int comparedValue = stringinput.compareTo(StringValue.get(mid));//returns -1 for <mid, 0 for mid== and +1 for mid<
			  if (comparedValue == 0) return mid;
			  if (comparedValue < 0) high = mid-1; //if lower than mid set the highest point in the spot where 
			  else low = mid +1;
		  }
	  return low;
	  }
	  
	  public void put(Stringkey keystring,ListValue v ){//put the stringkey into the arraylist at the position decided by orderingPlacement
		  int position = orderingPlacement(keystring);
		  if (position < N && keystring.equals(StringValue.get(position))) Countvalues.set(position,v );
		  else {
			  StringValue.add(position,keystring); // adds element to the list stringValue if there is none
			  Countvalues.add(position,v );
			  N++;
		  }
	  }
	  
	  public ListValue getelem(Stringkey keystring){
		  int position = orderingPlacement(keystring);
		  if (position < N && keystring.equals(StringValue.get(position))) return Countvalues.get(position);
		  else return null;
	  }
	  public ListValue deleteelem(Stringkey keystring){
		  int position = orderingPlacement(keystring);
		  if (position < N && keystring.equals(StringValue.get(position))){
			  ListValue deleteelement = Countvalues.get(position);
			  StringValue.remove(position);
			  Countvalues.remove(position);
			  return deleteelement;
		  }
		  else return null;
	  }
	  
	  	//Merge all lists
		//sort the long list
		//go through each element in list
		//if the item == pKey
		//dCount++ --> if dCount ==3 return pKey and break
		//else set pKey == Item

		public static String findTrip(ArrayList<String> arr){
			//Sort
			arr.sort(null);
			//go through each element in list
			//if the item == pKey
			//dCount++ --> if dCount ==3&& it is either the last element or
			//the next item is not equals, then return pKey
			//else set pKey == Item
			ArrayListST<String,Integer> dCoutlist = new ArrayListST<>();
			String item="";
			for(int i=0;i<arr.size();i++)
			{
				item =arr.get(i);
				Integer nrInArray = dCoutlist.get(item);
				if(nrInArray != null) {
					dCoutlist.put(item,nrInArray+1);
				}
				else dCoutlist.put(item, 1);
				
			}
//			for (int i=0; i<dCoutlist.size();i++){
//				if (dCoutlist==3){
//					
//				}
//				
			//}	
			Iterator<String> iter = dCoutlist.keysIterator();
			 while (iter.hasNext()) {
			      String next = iter.next();
			      StdOut.println(dCoutlist.get(next) + "\t" + next);
			    }
			return null;
		}


		@SuppressWarnings("unchecked")
		public static void main(String[] args) throws FileNotFoundException{
			//Create empty lists, ready for input. Add them to an outerlist
			ArrayList<String> list0 = new ArrayList<String>();
			ArrayList<String> list1 = new ArrayList<String>();
			ArrayList<String> list2 = new ArrayList<String>();
			ArrayList<String> list3 = new ArrayList<String>();
			@SuppressWarnings("rawtypes")
			ArrayList<ArrayList> outerList = new ArrayList<ArrayList>();
			outerList.add(list0);
			outerList.add(list1);
			outerList.add(list2);
			outerList.add(list3);

			//Read in 4 files from user directory, throwing them into their respective lists
			for(int i=0;i<4;i++){
				File inFile = new File (System.getProperty("user.dir") + "\\src\\inf102o1\\list"+i+".txt");
				Scanner sc = new Scanner (inFile);
				while (sc.hasNextLine())
				{
					String line = sc.nextLine();
					if(!outerList.get(i).contains(line))
						outerList.get(i).add(line);
				}
				sc.close();
			}

			//merge all lists
			ArrayList<String> combined = new ArrayList<String>();
			for(int i=0;i<4;i++){
				outerList.get(i).sort(null);
				combined.addAll(outerList.get(i));	
			}

			System.out.println(findTrip(combined));



		}



}
