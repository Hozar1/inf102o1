/**
 * @author Ole Tobias Bird
 * @author Martin Breistein
 */

package inf102o1;
import edu.princeton.cs.algs4.StdOut;  
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.BinarySearch;
import java.util.Arrays;

public class profitSorting{
	
	
    public static int LNsearch(int[] randomList, int target){
        
        int size = randomList.length;
        for(int i=0;i<size;i++){
            if(randomList[i] == target){
                return i;
            }
        }
        return -1;
    }
	
	public static long runBS(int[] randomList,int target){
		long timer = System.currentTimeMillis();
		Arrays.sort(randomList);
		int BNSearchvar = BinarySearch.indexOf(randomList, target);
		long savedTimer = System.currentTimeMillis() - timer;
		StdOut.println("BNSearch Result: " + BNSearchvar);
		return savedTimer;
	}
	
	public static long runLN(int[] randomList,int target){
		long timer = System.currentTimeMillis();
		int lnSearchvar =LNsearch(randomList, target);
		long savedTimer = System.currentTimeMillis() - timer;
		StdOut.println("lnSearch Result: " + lnSearchvar);
		return savedTimer;
	}
	
	public static long test(int nLength,int times){
		int seachTarget = 0;
		long timeAlg1 = 0L;
		long timeAlg2 = 0L;
			int[] alg1 = new int[nLength];
			int[] alg2 = new int[nLength];
			for(int k=0;k < nLength;k++){
				alg1[k] = StdRandom.uniform((int)10e6);
				alg2[k]= alg1[k];
			}
			for(int t=0; t < times;t++){ 
				seachTarget = StdRandom.uniform((int)10e6);
				timeAlg1 += runBS(alg1,seachTarget);
				timeAlg2 += runLN(alg2,seachTarget);
		}
		StdOut.println("TimeBN " + timeAlg1 + "\n" + "TimeLN " + timeAlg2);
		return timeAlg1/timeAlg2;
	}
	
	public static void main(String args[]){
		//
		for(int s=5; s<641; s*=2){
			long compared = test((int)10e6,s);
			StdOut.println("("+ s +")"+"Binary / Linear = " + compared);
		}
		
	}

}

