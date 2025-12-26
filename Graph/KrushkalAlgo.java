/*
Given a weighted, undirected, and connected graph with V vertices and E edges, the task is to find the sum of the weights of the edges in the Minimum Spanning Tree (MST) of the graph using Kruskal's Algorithm. The graph is represented as an edge list edges[][], where edges[i] = [u, v, w] denotes an undirected edge between u and v with weight w.

Input: V = 3, E = 3, edges[][] = [[0, 1, 5], [1, 2, 3], [0, 2, 1]]

Output: 4
Explanation:

The Spanning Tree resulting in a weight of 4 is shown above.
Input: V = 2, E = 1, edges = [[0, 1, 5]]
  
Output: 5 
Explanation: Only one Spanning Tree is possible which has a weight of 5.
Constraints:
2 ≤ V ≤ 1000
V-1 ≤ E ≤ (V*(V-1))/2
1 ≤ w ≤ 1000
The graph is connected and doesn't contain self-loops & multiple edges.
*/

package Graph;

import java.util.Arrays;

public class KrushkalAlgo {
     static int kruskalsMST(int V, int[][] edges) {
        // code here
        int[] parent = new int[V];
        for(int i=0;i<V;i++){
            parent[i] = i;
        }
        int[] rank = new int[V];
        Arrays.fill(rank,1);
        
        UnionFind uf = new UnionFind(parent,rank);
        
        Arrays.sort(edges,(a,b)->Integer.compare(a[2],b[2]));
        
        int res = 0;
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            
            int pv = uf.findParent(u);
            int pu = uf.findParent(v);
            
            if(pv == pu)continue;
            else{
                uf.union(u,v);
                res += w;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int V = 3, E = 3;
        int edges[][] = {{0, 1, 5}, {1, 2, 3}, {0, 2, 1}};
        System.out.println(kruskalsMST(V, edges));
    }
}
