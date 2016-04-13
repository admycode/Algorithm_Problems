import java.util.Arrays;

public class BinarySearch {

	private BinarySearch() {}

	public static int IndexOf(int[] A, int key){
	
		int lo = 0;
		int hi = A.length - 1;

		while(lo <= hi){
			int mid = lo + (hi-lo)/2;

			if(key < A[mid]) hi = mid-1;
			else if(key > A[mid]) lo = mid+1;
			else return mid;
		}
		return -1;
	}

	public static void main(String[] args){
		int A[] = {23, 432, 1, 44543, 330, 120, 342134, 550};

		//Sort the array
		Arrays.sort(A);

		int index;

		for(int i : A){
			System.out.print(i + " ");
		}
		System.out.println();
		
		index = IndexOf(A, 432);
		System.out.println("Index of 432 : " + index);	
		index = IndexOf(A, 120);
		System.out.println("Index of 120 : " + index);	
		index = IndexOf(A, 1);
		System.out.println("Index of 1 : " + index);	
	}	
}
