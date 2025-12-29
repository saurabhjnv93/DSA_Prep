/*

Floyd Warshall
Difficulty: MediumAccuracy: 32.89%Submissions: 239K+Points: 4Average Time: 15m
You are given a weighted directed graph, represented by an adjacency matrix, dist[][] of size n x n, where dist[i][j] represents the weight of the edge from node i to node j. If there is no direct edge, dist[i][j] is set to a large value (i.e., 108) to represent infinity.
The graph may contain negative edge weights, but it does not contain any negative weight cycles.

Your task is to find the shortest distance between every pair of nodes i and j in the graph.

Note: Modify the distances for every pair in place.

Examples :
inf = 10^8
Input: dist[][] = [[0, 4, inf, 5, inf], [inf, 0, 1, inf, 6], [2, inf, 0, 3, inf], [inf, inf, 1, 0, 2], [1, inf, inf, 4, 0]]

Output: [[0, 4, 5, 5, 7], [3, 0, 1, 4, 6], [2, 6, 0, 3, 5], [3, 7, 1, 0, 2], [1, 5, 5, 4, 0]]

Explanation: Each cell dist[i][j] in the output shows the shortest distance from node i to node j, computed by considering all possible intermediate nodes. 
Input: dist[][] = [[0, -1, 2], [1, 0, inf], [3, 1, 0]]

Output: [[0, -1, 2], [1, 0, 3], [2, 1, 0]]

Explanation: Each cell dist[i][j] in the output shows the shortest distance from node i to node j, computed by considering all possible intermediate nodes.
From 2 to 0 shortest distance should be 2 by following path 2 -> 1 -> 0
From 1 to 2 shortest distance should be 3 by following path 1 -> 0 -> 2
Constraints:
1 ≤ dist.size() ≤ 100
-1000 ≤ dist[i][j] ≤ 1000
dist[i][j] can be inf to represent infinity.*/

package Graph;

import java.util.Arrays;

public class FloydWarshall {
      public void floydWarshall(int[][] dist) {
        // Code here
        int n = dist.length;
        int inf = (int)Math.pow(10,8);
        for(int k=0;k < n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][k] != inf && dist[k][j] != inf)dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
      }
      public static void main(String[] args) {
        int inf = (int)Math.pow(10,8);
        int[][] dist = {{0, 4, inf, 5, inf}, {inf, 0, 1, inf, 6}, {2, inf, 0, 3, inf}, {inf, inf, 1, 0, 2}, {1, inf, inf, 4, 0}};
        FloydWarshall fw = new FloydWarshall();
        fw.floydWarshall(dist);

        System.out.println(Arrays.deepToString(dist));

      }
}
