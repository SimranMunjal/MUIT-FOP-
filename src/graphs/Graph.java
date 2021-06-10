package graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph {
	
	public static void dfsHelper(int[][] graph, int sv, boolean[] visited) {
		
		System.out.println(sv);
		visited[sv] = true;
		
		for(int i=0;i<graph.length;i++) {
			if(graph[sv][i]==1 && visited[i]==false) {
				dfsHelper(graph,i,visited);
			}
		}
	}
	
	public static void bfs(int[][] graph, int sv, boolean[] visited) {
		
		Queue<Integer> q = new LinkedList<>();
		q.add(sv);
		visited[sv] = true;
		
		while(!q.isEmpty()) {
			int v = q.poll();
			System.out.println(v);
			for(int i=0;i<graph.length;i++) {
				if(graph[v][i]==1 && visited[i]==false) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
	}
	
	public static void dfs(int[][] graph) {
		
		int n = graph.length;
		boolean visited[] = new boolean[n];
		for(int i=0;i<n;i++) {
			if(visited[i]==false)
				//dfsHelper(graph,i,visited);
				bfs(graph,i,visited);
		}
	}
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int v = s.nextInt();
		int e = s.nextInt();
		
		int graph[][] = new int[v][v];
		
		for(int i=0;i<e;i++) {
			int v1 = s.nextInt();
			int v2 = s.nextInt();
			graph[v1][v2] = 1;
			graph[v2][v1] = 1;
		}
		dfs(graph);
	}
}
