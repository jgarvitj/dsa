package com.personal.dsa;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class WaterAndWellDijkstra {
	
	// Dijkstra algorithm
	private static void bfs(int index, boolean[] isvis, int[][] adj, int n) {
		isvis[index] = true;
		Queue<Integer> nextNodes = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			if (adj[index][i] >= 0) {
			    
				// any nodes visited shall have a path from 0
				
				if (adj[0][i] < 0 || adj[0][index] + adj[index][i] < adj[0][i]) {
				    
					adj[0][i] = adj[0][index] + adj[index][i];
					nextNodes.add(i);
				}
			}
		}
		while (!nextNodes.isEmpty()) {
			int edge = nextNodes.poll();
			bfs(edge, isvis, adj, n);
		}
	}

	private static int findShortestPath(int[][] adj, int totalNodes) {
		boolean[] isvis = new boolean[totalNodes];
		for (int i = 0; i < totalNodes; i++) {
			isvis[i] = false;
		}
        Queue<Integer> nextNodes = new LinkedList<>();
        for(int i = 1; i < totalNodes; i++) {
            if(adj[0][i] >= 0) {
                nextNodes.add(i);
            }
        }
        while (!nextNodes.isEmpty()) {
			int edge = nextNodes.poll();
			bfs(edge, isvis, adj, totalNodes);
		}
		return adj[0][totalNodes - 1];

	}

	public static double findMaxWaterLeft(double capacity, int n, double speed, int[][] adj) {
		double capInMl = capacity * 1000;
		int shortestPath = findShortestPath(adj, n + 1);
		System.out.println("Min Dist = " + shortestPath);
		double waterLeft = capInMl - (shortestPath / speed);
		return waterLeft;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		double capacity = sc.nextDouble();
		double speed = sc.nextDouble();
		int n = sc.nextInt();
		
		int[][] adj = new int[n+1][n+1];
		for(int i = 0; i < n+1; i++) {
			for(int j = 0; j < n+1; j++) {
				int x = sc.nextInt();
				adj[i][j] = x;
			}
		}
		double maxLeft = findMaxWaterLeft(capacity, n, speed, adj);
		System.out.println("Capacity left in ml =" + maxLeft);
		sc.close();	
	}
}

