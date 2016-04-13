public class EditDistance {
	public static int min(int a, int b, int c){
		return Math.min(Math.min(a,b), c);
	}
	public static int editDistanceDP(String s1, String s2){
		int m = s1.length();
		int n = s2.length();

		int[][] dp = new int[m+1][n+1];

		for(int i=0; i<=m; ++i){
			for(int j=0; j <=n; ++j){
				if(i == 0)
					dp[i][j] = j;
				else if(j == 0)
					dp[i][j] = i;
				else if(s1.charAt(i-1) == s2.charAt(j-1))
					dp[i][j] = dp[i-1][j-1];
				else
					dp[i][j] = 1 + min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1]);
			}
		}
		return dp[m][n];
	}
	public static void main(String[] args) {
		String str1 = args[0];
		String str2 = args[1];

		int solution = editDistanceDP(str1, str2);
		
		System.out.println(solution); 
	}
}
