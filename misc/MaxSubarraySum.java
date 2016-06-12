//This program finds the maximum sum of contiguous subarray using Kadane's algorithm
//https://en.wikipedia.org/wiki/Maximum_subarray_problem


public class MaxSubarraySum{
	
	static void findSum(int[] A, int n){
		int max_ending_here = A[0];
		int max_so_far = A[0];
		for(int i=1; i<n; i++){
			max_ending_here = Math.max(0,max_ending_here+A[i]);
			max_so_far = Math.max(max_ending_here, max_so_far);
		}
		System.out.println(max_so_far);
	}

	public static void main(String[] args){
		int[] A = {-2,-3,4,-1,-2,1,5,-3};
		findSum(A, A.length);
	}
} 
