public class GenerateAllPermutations {

	public static void generatepermutations(char[] ch, int l, int r){
		if(l == r)
			System.out.println(String.valueOf(ch));
		else {
			for(int i = l; i <= r; i++){
				//swap characters at indices l and i
				char tmp = ch[i];
				ch[i] = ch[l];
				ch[l] = tmp;
				//recursion
				generatepermutations(ch, l+1, r);
				//backtrack
				tmp = ch[i];
				ch[i] = ch[l];
				ch[l] = tmp;
			}
		}
	}
	public static void generateAll(String input) {
		char[] ch = input.toCharArray();
		int N = input.length();

		generatepermutations(ch, 0, N-1);
	}
	public static void main(String[] args) {

		String in = args[0];
		generateAll(in);
	}
}
