package dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class Lecture1 {
	
	public static int fact(int n) {
		
		if(n==0) {
			return 1;
		}
		
		int smallAns = fact(n-1);
		int finalAns = n*smallAns;
		return finalAns;
	}
	
	public static int fibUsingRecursion(int n) {
		
		if(n==0 || n==1)
			return n;
		
		int smallAns1 = fibUsingRecursion(n-1);
		int smallAns2 = fibUsingRecursion(n-2);
		int finalAns = smallAns1 + smallAns2;
		return finalAns;
	}
	
	public static int fibUsingMemoization(int n, int dpMemory[]) {
		
		if(n==0 || n==1) {
			dpMemory[n] = n;
			return n;
		}
		
		if(dpMemory[n]!=-1) {
			return dpMemory[n];
		}
		
		int smallAns1 = fibUsingMemoization(n-1,dpMemory);
		int smallAns2 = fibUsingMemoization(n-2,dpMemory);
		int finalAns = smallAns1 + smallAns2;
		dpMemory[n] = finalAns;
		return finalAns;
	}
	
	public static int fibUsingTabulation(int n) {
		
		int dp[] = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i=2;i<=n;i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		//System.out.println(fact(n));
		//System.out.println(fib(n));
		int dpMemory[] = new int[n+1];
		Arrays.fill(dpMemory, -1);
		//System.out.println(fibUsingMemoization(n,dpMemory));
		System.out.println(fibUsingTabulation(n));
	}

}
