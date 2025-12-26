/*

Topics
premium lock icon
Companies
There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

 

Example 1:


Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
Output: 700
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
Example 2:


Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
Output: 200
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 2 is marked in red and has cost 100 + 100 = 200.
Example 3:


Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
Output: 500
Explanation:
The graph is shown above.
The optimal path with no stops from city 0 to 2 is marked in red and has cost 500.
 

Constraints:

2 <= n <= 100
0 <= flights.length <= (n * (n - 1) / 2)
flights[i].length == 3
0 <= fromi, toi < n
fromi != toi
1 <= pricei <= 104
There will not be any multiple flights between two cities.
0 <= src, dst, k < n
src != dst
*/

package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlight {
    private static class Pair {
        int node;
        int cost;
        Pair(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        // Build adjacency list
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for(int[] flight : flights){
            int u = flight[0], v = flight[1], w = flight[2];
            graph.get(u).add(new Pair(v, w));
        }

        // dist[node] = min cost to reach node
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // BFS queue: {node, cost so far, stops used}
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0, 0});

        int res = Integer.MAX_VALUE;

        while(!q.isEmpty()){
            int[] s = q.poll();
            int nd = s[0];
            int cost = s[1];
            int stop = s[2];

            // If destination reached, update result
            if(nd == dst){
                res = Math.min(res, cost);
            }

            if(stop>k)continue;
            // If we can still take flights
            if(stop <= k){
                for(Pair nei : graph.get(nd)){
                    int newCost = cost + nei.cost;
                    if(newCost < dist[nei.node]) {
                        dist[nei.node] = newCost;
                        q.offer(new int[]{nei.node, newCost, stop+1});
                    }
                }
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
    public static void main(String[] args) {
        int n = 4; 
        int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int  src = 0, dst = 3, k = 1;
        System.out.println(findCheapestPrice(n, flights, src, dst, k));

    }
}
