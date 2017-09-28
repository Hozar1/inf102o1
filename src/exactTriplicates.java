/**
 * @author Ole Tobias Bird
 * @author Martin Breistein
 */

package inf102o1;
import java.util.Iterator; 
import java.util.ArrayList; 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.princeton.cs.algs4.StdOut;

public class exactTriplicates<Stringkey extends Comparable<Stringkey> , ListValue> {

		public static String findTrip(ArrayList<String> arr){
			//Sort imported array
			//go through each element in list
			//if the item == pKey

			arr.sort(null);
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
			Iterator<String> iter = dCoutlist.keysIterator();
			 while (iter.hasNext()) {
			      String next = iter.next();
			       if (dCoutlist.get(next) == 3){
			    	   StdOut.println("Triplicate found: " + next);
			       }
			    		   
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
			findTrip(combined);


		}



}