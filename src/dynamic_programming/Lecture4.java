package dynamic_programming;

public class Lecture4 {
	
	
	public static int lcs(String s1, String s2, int m, int n) {
		
		if(m==0 || n==0)
			return 0;
		
		if(s1.charAt(m-1)==s2.charAt(n-1)) {
			return lcs(s1,s2,m-1,n-1) + 1;
		}
		
		else {
			int op1 = lcs(s1,s2,m,n-1);
			int op2 = lcs(s1,s2,m-1,n);
			return Math.max(op1, op2);
		}
	}
	
	public static int lcs(String s1, String s2, int m, int n, int dp[][]) {
		
		if(m==0 || n==0)
			return 0;
		
		if(dp[m][n]!=0) {
			return dp[m][n];
			
		}
		if(s1.charAt(m-1)==s2.charAt(n-1)) {
			return dp[m][n] = lcs(s1,s2,m-1,n-1,dp) + 1;
		}
		
		else {
			int op1 = lcs(s1,s2,m,n-1,dp);
			int op2 = lcs(s1,s2,m-1,n,dp);
			return dp[m][n] =  Math.max(op1, op2);
		}
	}
	
	public static int lcsUsingTabulation(String s1, String s2) {
		
		int m = s1.length();
		int n = s2.length();
		
		int dp[][] = new int[m+1][n+1];
		
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1]+1;
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}
		return dp[m][n];
	}
	
	public static void main(String[] args) {
		
		String s1 = "abcabba";
		String s2 = "cbabaca";
		int dp[][] = new int[s1.length()+1][s2.length()+1];
		//int ans = lcs(s1,s2,s1.length(),s2.length(),dp);
		int ans = lcsUsingTabulation(s1, s2);
		System.out.println(ans);
	}

}
