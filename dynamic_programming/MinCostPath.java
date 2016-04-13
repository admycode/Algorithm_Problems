public class MinCostPath {
	public static int min(int a, int b, int c){
		return Math.min(Math.min(a,b), c);
	}
	public static int minCost(int[][] A, int m, int n) {
		int[][] dp = new int[A.length][A[0].length];

		dp[0][0] = A[0][0];

		for(int i=1; i<= m; ++i)
			dp[i][0]  = dp[i-1][0] + A[i][0];

		for(int j=1; j<= n; ++j)
			dp[0][j] = dp[0][j-1] + A[0][j];
		
		for(int i=1; i <= m; ++i){
			for(int j=1; j <= n; ++j){
				dp[i][j] = min(dp[i-1][j-1], dp[i][j-1], dp[i-1][j]) + A[i][j];
			}
		}
		return dp[m][n];
	}
	public static void main(String[] args) {
		int[][] A = { {1,2,3},
			      {4,8,2},
			      {1,5,3}
			    };
		int m = Integer.parseInt(args[0]);
		int n = Integer.parseInt(args[1]);

		int sol = minCost(A, m, n);
		System.out.println(sol);
	}
}
