/*
Given a weighted, undirected, and connected graph with V vertices and E edges, your task is to find the sum of the weights of the edges in the Minimum Spanning Tree (MST) of the graph. The graph is provided as a list of edges, where each edge is represented as [u, v, w], indicating an edge between vertex u and vertex v with edge weight w.

Input: V = 3, E = 3, Edges = [[0, 1, 5], [1, 2, 3], [0, 2, 1]]
 
Output: 4
Explanation:

The Spanning Tree resulting in a weight
of 4 is shown above.
Input: V = 2, E = 1, Edges = [[0 1 5]]

 

Output: 5 
Explanation: Only one Spanning Tree is possible which has a weight of 5.
Constraints:
2 ≤ V ≤ 1000
V-1 ≤ E ≤ (V*(V-1))/2
1 ≤ w ≤ 1000
The graph is connected and doesn't contain self-loops & multiple edges.


*/

package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;

public class MSTPrims {
    public static int spanningTree(int V, int[][] edges) {
        // code here
        HashSet<Integer> includedInMST = new HashSet<>();
        
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        
        for(int i=0;i<V;i++){
            graph.add(new ArrayList<>());
        } 
        
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            
            graph.get(u).add(new int[] {v,w});
            graph.get(v).add(new int[] {u,w});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        pq.offer(new int[] {0,0});
        
        int res = 0;
        while(!pq.isEmpty() && includedInMST.size() < V){
            int[] curr = pq.poll();
            int u = curr[0];
            int w = curr[1];
            
            if(includedInMST.contains(u))continue;
            res += w;
            
            includedInMST.add(u);
            
            ArrayList<int[]> neighs = graph.get(u);
            
            for(int[] neigh:neighs){
                int v = neigh[0];
                int wt = neigh[1];
                
                if(!includedInMST.contains(v)){
                    pq.offer(new int[]{v,wt});
                }
            }
        }
        return res;
        
        
    }
    public static void main(String[] args) {
        int V = 3, E = 3;
        int[][] Edges = {{0, 1, 5}, {1, 2, 3}, {0, 2, 1}};

        System.out.println(spanningTree(V, Edges));
    }
}
