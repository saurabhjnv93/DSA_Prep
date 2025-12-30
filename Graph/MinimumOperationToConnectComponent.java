/*
There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network where connections[i] = [ai, bi] represents a connection between computers ai and bi. Any computer can reach any other computer directly or indirectly through the network.

You are given an initial computer network connections. You can extract certain cables between two directly connected computers, and place them between any pair of disconnected computers to make them directly connected.

Return the minimum number of times you need to do this in order to make all the computers connected. If it is not possible, return -1.

 

Example 1:


Input: n = 4, connections = [[0,1],[0,2],[1,2]]
Output: 1
Explanation: Remove cable between computer 1 and 2 and place between computers 1 and 3.
Example 2:


Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
Output: 2
Example 3:

Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
Output: -1
Explanation: There are not enough cables.
 

Constraints:

1 <= n <= 105
1 <= connections.length <= min(n * (n - 1) / 2, 105)
connections[i].length == 2
0 <= ai, bi < n
ai != bi
There are no repeated connections.
No two computers are connected by more than one cable.
*/

package Graph;

import java.util.Arrays;

public class MinimumOperationToConnectComponent {
    private class UnionFind{
        int[] parent;
        int[] rank;
        UnionFind(int n){
            this.parent = new int[n];
            this.rank = new int[n];
            for(int i=0;i<n;i++){
                parent[i] = i;
            }
            Arrays.fill(rank,1);
         }

        private int findParent(int x){
            if(this.parent[x] == x)return x;
            this.parent[x] = findParent(this.parent[x]);

            return parent[x];
        }
        private void union(int x, int y){
            int px = findParent(x);
            int py = findParent(y);

            if(rank[px] > rank[py]){
                parent[py] = px;
            }
            else if(rank[px] < rank[py]){
                parent[px] = py;
            }
            else{
                parent[px] = py;
                rank[px]++;
            }

        }
    }
    public int makeConnected(int n, int[][] connections) {
        
        if(connections.length < n-1)return -1;

        UnionFind uf = new UnionFind(n);


        int count = 0;
        for(int[] connection:connections){
            int u = connection[0];
            int v = connection[1];
            int pu = uf.findParent(u);
            int pv = uf.findParent(v);

            if(pu == pv){
                count++;
            }
            else{
               
                uf.union(u,v);
            }
        }

        int comp  = 0;
        for(int i = 0;i<n;i++){
            if(uf.findParent(i) == i)comp++;
        }

        return (count >= comp-1)? comp-1:-1;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] connections = {{0,1},{0,2},{0,3},{1,2},{1,3}};
        MinimumOperationToConnectComponent motc = new MinimumOperationToConnectComponent();
        System.out.println(motc.makeConnected(n,connections));
    }
}
