import java.util.Arrays;

public class RotateArray{

	public static void reverse(int[] A, int left, int right){
		if(A == null || A.length == 1)
			return;

		while(left < right){
			int temp = A[left];
			A[left] = A[right];
			A[right] = temp;
			left++;
			right--;
			
		}
	}

	public static void main(String[] args){
		int[] A = {1,2,3,4,5,6,7,8,9};
		
		System.out.println("Rotate an array of n elements to the right by k steps");
		if(args.length < 1)
			System.out.println("usage : java <program> k");

		System.out.println("Array before rotation");
		for(int i=0; i < A.length; i++){
			System.out.print(A[i] + " ");
		}
		System.out.println();

		int k = Integer.parseInt(args[0]);

		int a = A.length - k;

		reverse(A, 0, a-1);
		reverse(A, a, A.length-1);
		reverse(A, 0, A.length-1);
		
		System.out.println("Array after rotation");
		for(int i=0; i < A.length; i++){
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
}
