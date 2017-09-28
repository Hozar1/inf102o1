/**
 * 
 * @author Ole Tobias Bird
 * @author Martin Breistein
 * 
 */
package inf102o1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class exactTriplicates {

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
		String pKey="";
		String item="";
		int dCount =0;
		for(int i=0;i<arr.size();i++)
		{
			item =arr.get(i);
			if(item.equals(pKey))
			{
				dCount++;
				if((dCount == 3)&&(i < arr.size() - 1 ||!arr.get(i+1).equals(pKey)))
					return pKey;
			}
			else
			{
				pKey = item;
				dCount = 1;
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
			
			combined.addAll(outerList.get(i));
		}

		System.out.println(findTrip(combined));



	}



}
