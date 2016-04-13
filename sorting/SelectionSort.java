import java.util.Arrays;

public class SelectionSort{

	public static void print(int[] A){

		for(int i=0; i < A.length; i++){
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}

	public static void sort(int[] A){
		int minIndex;
	
		for(int i=0; i < A.length; i++){
			minIndex = i;
			for(int j=i+1; j < A.length; j++){
				if(A[j] < A[minIndex]){
					minIndex = j;
				}
			}
			int temp = A[i];
			A[i] = A[minIndex];
			A[minIndex] = temp;
		}
	}

	public static void main(String[] args){

		int[] A = {12,32,23,1,54,45,6,456,8,688,68,7,6899,7,6,55,88,6,5,67,7,88,66,5,4,77,88,9,9,76,55,43,6,7,88,6,54,8,75,5,9};

		System.out.println("Array before sorting : ");
		print(A);

		sort(A);

		System.out.println("Array after sorting : ");
		print(A);
	}
}
