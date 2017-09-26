package inf102o1;
import edu.princeton.cs.algs4.StdOut; 
import edu.princeton.cs.algs4.Stopwatch; 
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.BinarySearch;
import java.util.Arrays;

public class profitSorting{
	
    public static int LNsearch(int[] randomList, int Target){
        
        int size = randomList.length;
        for(int i=0;i<size;i++){
            if(randomList[i] == Target){
                return i;
            }
        }
        return -1;
    }
	
	public double runBS(int[] randomList,int Target){
		Stopwatch timer = new Stopwatch();
		Arrays.sort(randomList);
		BinarySearch.indexOf(randomList, Target);
		return timer.elapsedTime();
	}
	public double runLN(int[] randomList,int Target){
		Stopwatch timer = new Stopwatch();
		LNsearch(randomList, Target);
		return timer.elapsedTime();
	}
	
	public double test(int Nlength,int Times){
		int seachTarget = 0;
		double TimeAlg1 = 0.0;
		double TimeAlg2 = 0.0;
		int[] alg1 = new int[Nlength];
		int[] alg2 = new int[Nlength];
		for(int t=0; t < Times;t++){
			for(int k=0;k < Nlength;k++){
				alg1[k] = StdRandom.uniform((int) 1e7);
				alg2[k]=alg2[k];
			}
			seachTarget = StdRandom.uniform((int) 1e7);
			TimeAlg1 += runBS(alg1,seachTarget);
			TimeAlg2 += runLN(alg1,seachTarget);
		}
		
		return TimeAlg1/TimeAlg2;
	}
	
	public void main(){
		
		double Compared =test((int)1e6 ,5);
		StdOut.println("Binary / Linear = " + Compared);
		for(int s=10; s<80; s+=10){
			Compared = test((int)1e6 ,s);
			StdOut.println("Binary / Linear = " + Compared);
		}
	}

}
