/*
You are given an undirected graph with V vertices numbered from 0 to V-1 and E edges, represented as a 2D array edges[][], where each element edges[i] = [u, v] represents an undirected edge between vertices u and v.

Your task is to find the shortest path distance from a given source vertex src to all other vertices in the graph.
If a vertex is not reachable from the source, return -1 for that vertex.


Note: All edges have unit weight (1).

Examples :

Input: V = 9, E = 10, 
edges[][] = [[0, 1], [0, 3], [1, 2], [3, 4], [4, 5], [2, 6], [5, 6], [6, 7], [6, 8], [7, 8]], src = 0
Output: [0, 1, 2, 1, 2, 3, 3, 4, 4]

Input: V = 4, E = 3,
edges[][]= [[0, 3], [1, 3]], src = 3
Output: [1, 1, -1, 0]

Constraints:
1 ≤ V ≤ 104
0 ≤ E ≤ V*(V-1)/2
0 ≤ edges[i][0], edges[i][1] < V
*/

package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class ShortestPathInUndirectedGraph {
    public static int[] shortestPath(int V, int[][] edges, int src) {
        // code here

        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            int w = 1;
            graph.get(u).add(new int[]{v,w});
            graph.get(v).add(new int[] {u,w});
        }
        
        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        pq.offer(new int[] {src,0});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int nd = curr[0];
            int d = curr[1];
            
            ArrayList<int[]> neighs = graph.get(nd);
            for(int[] neigh:neighs){
                int nnd = neigh[0];
                int w = neigh[1];
                
                if(d+w < dist[nnd]){
                    dist[nnd] = d+w;
                    pq.offer(new int[]{nnd,dist[nnd]});
                }
            }
        }
        for(int i=0;i<V;i++){
            if(dist[i] == Integer.MAX_VALUE){
                dist[i] = -1;
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        int V = 9, E = 10;
        int edges[][] = {{0, 1}, {0, 3}, {1, 2}, {3, 4}, {4, 5}, {2, 6}, {5, 6}, {6, 7}, {6, 8}, {7, 8}};
        int src = 0;

        System.out.println(Arrays.toString(shortestPath(V, edges, src)));

    }
}
