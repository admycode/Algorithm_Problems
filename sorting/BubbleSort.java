import java.util.Arrays;

public class BubbleSort{
	
	private BubbleSort() {}

	public static void bubbleSort(int[] A){
		boolean swapped = true;
		int n = A.length;

		while(swapped != false){
			swapped = false;
			for(int i = 1; i < n; i++){
				if(A[i-1] > A[i]){
					int temp = A[i-1];
					A[i-1] = A[i];
					A[i] = temp;
					swapped = true;
				}
			}
			n = n-1;
		}
	}
	
	public static void print(int[] A){
		for(int i=0; i < A.length-1; i++){
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
	

	public static void main(String[] args){
	
		int[] A = {34, 7, 4, 123, 54, 3, 2, 111, 11, 34, 100, 99, 9};

		System.out.println("Before calling sort:");
		print(A);

		bubbleSort(A);	

		System.out.println("After calling sort:");
		print(A);
	}
}

