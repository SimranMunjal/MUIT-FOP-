package dynamic_programming;

public class Lecture5 {
	
	public static int editDistance(String s1, String s2) {
		
		if(s1.length()==0) {
			return s2.length();
		}
		
		if(s2.length()==0) {
			return s1.length();
		}
		
		if(s1.charAt(0)==s2.charAt(0)) {
			return editDistance(s1.substring(1),s2.substring(1));
		}
		else{
			int insert = 1 + editDistance(s1, s2.substring(1));
			int delete = 1 + editDistance(s1.substring(1), s2);
			int replace = 1 + editDistance(s1.substring(1), s2.substring(1));
			return Math.min(replace, Math.min(insert, delete));
		}
		
	}
	
	public static int editDistanceUsingTabulation(String s1, String s2) {
		
		int m = s1.length();
		int n = s2.length();
		
		int dp[][] = new int[m+1][n+1];
		
		for(int i=0;i<=m;i++) {
			dp[i][0] = i;
		}
		
		for(int j=0;j<=n;j++) {
			dp[0][j] = j;
		}
		
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				}
				else {
					dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1], dp[i-1][j-1])) + 1; 
				}
			}
		}
		return dp[m][n];
	}
	public static void main(String[] args) {
	
		String s1 = "olo";
		String s2 = "role";
		int ans = editDistance(s1, s2);
		//System.out.println(ans);
		System.out.println(editDistanceUsingTabulation(s1, s2));
	}

}
