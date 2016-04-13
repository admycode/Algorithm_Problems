// Givn a list of N coins, their values(v1,v2,...,vn) and the total sum S.
//Find the minimum number of coins the sum of which is S (we can use as many
//coins of one type as we want), or report that it is not possible to select
//coins in such a way that they sum up to S.

import java.util.Scanner;
import java.util.*;

public class CoinChange{

	public Scanner console;
	public static int N;
	public static int S;
	public int[] A;
	public int[] min;
	
	public CoinChange(){

		console = new Scanner(System.in);
		C = new HashSet<Integer>();
		N = console.nextInt(); //number of coins
		S = console.nextInt(); //total denomination
		A = new int[N];
		min = new int[S+1];
		for(int i=0; i <= S; i++){
			min[i] = 99999999;
		}
		for(int i=0; i < N; i++){
			A[i] = console.nextInt();
		}
		min[0] = 0;
		for(int i = 0; i <=S; i++){
			for(int j=0; j < N; j++){
				if((A[j] <= i) && (min[i-A[j]]+1 < min[i])){
					min[i] = min[i-A[j]] + 1;
				}
			}
		}
	
		System.out.println("Minimum number of coins: " + min[S]);
		
	}
	public static void main(String[] args){
		CoinChange c = new CoinChange();
		System.exit(0);
	}
} 
