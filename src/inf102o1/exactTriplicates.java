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
		//Sort,removing duplicates within each list


		//go through each element in list
		//if the item == pKey
		//dCount++ --> if dCount ==3 return pKey and break
		//else set pKey == Item
		String pKey="";
		String item="";
		int dCount =0;

		for(int i=0;i<arr.size();i++)
		{
			if(arr.get(i) == pKey)
			{
				dCount++;
				if(dCount == 3)
					return pKey;
			}
			else
			{
				pKey = arr.get(i);
				dCount = 1;
			}
		}




		return null;

	}





	public static void main(String[] args) throws FileNotFoundException{

		ArrayList<String> list0 = new ArrayList<String>();
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();
		ArrayList<String> list3 = new ArrayList<String>();
		ArrayList<ArrayList> outerList = new ArrayList<ArrayList>();
		outerList.add(list0);
		outerList.add(list1);
		outerList.add(list2);
		outerList.add(list3);


		for(int i=0;i<4;i++){

			File inFile = new File (System.getProperty("user.dir") + "\\src\\inf102o1\\list"+i+".txt");
			Scanner sc = new Scanner (inFile);
			while (sc.hasNextLine())
			{
				String line = sc.nextLine();
				if(!outerList.contains(outerList.get(i)))
					outerList.get(i).add(line);
			}
			sc.close();
		}

		//merge all lists
		ArrayList<String> combined = new ArrayList<String>();
		for(int i=0;i<4;i++)
			combined.addAll(outerList.get(i));
		findTrip(combined);


	}



}
