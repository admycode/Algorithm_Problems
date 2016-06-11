//This program finds the number of rotations in a sorted array. This also uses a variant of binary search

public class FindRotation{

	static int findRotationCount(int[] A){

		int n = A.length;

		int low=0, high=n-1;

		while(low <= high){

			if(A[low] <= A[high]) return low;		//case 1
			int mid = (low + high)/2;
			int next = (mid+1)%n;
			int prev = (mid+n-1)%n;
			if(A[mid] <= A[next] && A[mid]<=A[prev])	//case 2
				return mid;
			else if(A[mid] <= A[high]) high = mid-1;	//case 3
			else if(A[mid] >= A[low]) low = mid+1;		//case 4
		}
		return -1;
		
	}

	public static void main(String[] args){

		int[] A = {7,8,9,1,2,3,4,5,6};

		int r = findRotationCount(A);
		System.out.println(r);
	}
} 
