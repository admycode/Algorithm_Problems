//This programme finds the number of occurances of an element in sorted array in complexity O(log n) where n is the
//number of elements in the array. It uses modified binary search to find the first and last indexes of an element
//in the sorted array

public class countOccurances {

	static int find_first(int[] A, int n, int x){
		
		int low = 0;
		int high = n-1;
		int index = -1;
		while(low <= high){
			int mid = (low+high)/2;

			if(x == A[mid]){
				index = mid;
				high = mid-1;
			}
			else if(x < A[mid]) high = mid-1;
			else	low = mid+1;
		}
		return index;
	}
	static int find_last(int[] A, int n, int x){
		
		int low = 0;
		int high = n-1;
		int index = -1;
		while(low <= high){
			int mid = (low+high)/2;

			if(x == A[mid]){
				index = mid;
				low = mid+1;
			}
			else if(x < A[mid]) high = mid-1;
			else	low = mid+1;
		}
		return index;
	}

	static void count_occurances(int[] A, int n, int x){
		
		int first = -1;
		int last = -1;

		first = find_first(A,n,x);
		if(first != -1){
			last = find_last(A,n,x);
			System.out.println(last-first+1);
		}
		else
			System.out.println("Element does not exists");
	}
	public static void main(String[] args){
		
		int[] array = {1,2,2,3,3,3,3,4,5,6,7,7,7,7,8};

		int n = array.length;

		count_occurances(array, n, 3);
	}
}
