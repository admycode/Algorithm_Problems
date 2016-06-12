//Yhis program finds all possible splits of a set

import java.util.*;

public class allpossiblesplits{
	static HashSet<Integer> S1;
	static HashSet<Integer> S2;

	static void split(int[] A, int index, HashSet<Integer> S1, HashSet<Integer> S2){
		
		if(index == -1){
			System.out.print(S1 + " " + S2);
			System.out.println();
		}
		else{
			if(index == A.length-1){
				S1.add(A[index]);
				split(A, index-1, S1, S2);
				S1.remove(A[index]);
			}
			else{
				S1.add(A[index]);
				split(A,index-1,S1, S2);
				S1.remove(A[index]);	//backtrack
				S2.add(A[index]);
				split(A, index-1, S1, S2);
				S2.remove(A[index]);	//backtrack
			}
		}
	}
	public static void main(String[] args){
		int[] A = {1,2,3,4,5};
		int n = A.length;
		S1 = new HashSet<Integer>();
		S2 = new HashSet<Integer>();
		split(A,n-1, S1, S2);
	}
}
