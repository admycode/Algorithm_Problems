/**Lexicographic sort*/
import java.util.Arrays;
import java.util.Comparator;

class LexCompare<T extends Comparable<T>> implements Comparator<T>{
	@Override
	public int compare(T x, T y){
		if((x.getClass().getName() == "java.lang.Integer") && (y.getClass().getName() == "java.lang.Integer"))
			return x.toString().compareTo(y.toString());
		else
			return -1;
	}
}

public class LexSort{
	public static void main(String[] args){
		
		Integer[] A = {1, 2, 11, 100, 21, 23, 3, 300, 212, 24};

		System.out.println("Array before sort:");
		for(int i=0; i < A.length; i++){
			System.out.print(A[i] + " ");
		}
		System.out.println();

		Arrays.sort(A, new LexCompare());

		System.out.println("Array after sort:");
		for(int i=0; i < A.length; i++){
			System.out.print(A[i] + " ");
		}
		System.out.println();
		
	}
}
