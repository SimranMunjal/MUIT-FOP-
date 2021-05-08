package dynamic_programming;

import java.util.Scanner;

public class Lecture3 {
	
	public static int knapsack(int n, int[] weights, int[] values, int maxWeight) {
		
		if(n==0 || maxWeight==0) {
			return 0;
		}
		
		if(weights[n-1]>maxWeight) {
			int ans = knapsack(n-1,weights,values,maxWeight);
			return ans;
		}
		else {
			int includeItem = knapsack(n-1, weights, values, maxWeight-weights[n-1]) + values[n-1];
			int excludeItem = knapsack(n-1, weights, values, maxWeight);
			int ans = Math.max(includeItem, excludeItem);
			return ans;
		}
		
	}
	
	public static int knapsackUsingMemoization(int n, int[] weights, int[] values, int maxWeight, int[][] dpMemory) {
		
		if(n==0 || maxWeight==0) {
			return 0;
		}
		
		if(dpMemory[n][maxWeight]!=0) {
			return dpMemory[n][maxWeight];
		}
		
		if(weights[n-1]>maxWeight) {
			int ans = knapsackUsingMemoization(n-1,weights,values,maxWeight,dpMemory);
			dpMemory[n][maxWeight] = ans;
			return ans;
		}
		else {
			int includeItem = knapsackUsingMemoization(n-1, weights, values, maxWeight-weights[n-1],dpMemory) + values[n-1];
			int excludeItem = knapsackUsingMemoization(n-1, weights, values, maxWeight,dpMemory);
			int ans = Math.max(includeItem, excludeItem);
			dpMemory[n][maxWeight] = ans;
			return ans;
		}
	}
	
	public static int knapsackUsingTabulation(int n, int[] weights, int[] values, int maxWeight) {
		
		int dp[][] = new int[n+1][maxWeight+1];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=maxWeight;j++) {
				if(j-weights[i-1]>=0) {
					int includeItem = values[i-1] + dp[i-1][j-weights[i-1]];
					int excludeItem = dp[i-1][j];
					dp[i][j] = Math.max(includeItem, excludeItem);
				}
				else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		int i = n;
		int j = maxWeight;
		
		while(i>0 && j>0) {
			if(dp[i][j]==dp[i-1][j]) {
				i--;
			}
			else {
				System.out.println("Selected item weight: "+weights[i-1]);
				j = j-weights[i-1];
				i--;
			}
		}
		return dp[n][maxWeight];
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int n = 4;
		int weights[] = {2,1,3,2};
		int values[] = {12,10,21,15};
		int maxWeight = 8;
		//int ans = knapsack(n,weights,values,maxWeight);
		//System.out.println(ans);
		int dpMemory[][] = new int[n+1][maxWeight+1];
		//System.out.println(knapsackUsingMemoization(n,weights,values,maxWeight,dpMemory));
		System.out.println(knapsackUsingTabulation(n,weights,values,maxWeight));
	}

}
