/*

You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.

We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.

 

Example 1:


Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2
Example 2:

Input: times = [[1,2,1]], n = 2, k = 1
Output: 1
Example 3:

Input: times = [[1,2,1]], n = 2, k = 2
Output: -1
 

Constraints:

1 <= k <= n <= 100
1 <= times.length <= 6000
times[i].length == 3
1 <= ui, vi <= n
ui != vi
0 <= wi <= 100
All the pairs (ui, vi) are unique. (i.e., no multiple edges.)
*/

package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class NetworkDelayTime {
    public static  int networkDelayTime(int[][] times, int n, int k) {
        int[] time = new int[n];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[k - 1] = 0;

        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] t:times){
            int u = t[0] - 1;
            int v = t[1] -1;
            int w = t[2];
            graph.get(u).add(new int[]{v,w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[] {k-1, 0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();

            int nd = curr[0];
            int wt = curr[1];

            ArrayList<int[]> neighs = graph.get(nd);

            for(int[] neigh:neighs){
                int nnd = neigh[0];
                int w = neigh[1];

                if(w + time[nd] < time[nnd]){
                    time[nnd] = w + time[nd];
                    pq.offer(new int[]{nnd,time[nnd]});
                }
            }
        }

        int minTime = 0;
        for(int i=0;i<n;i++){
            if(time[i] == Integer.MAX_VALUE){
                return -1;
            }
            minTime = Math.max(minTime,time[i]);
        }
        return minTime;

    }
    public static void main(String[] args) {
        int[][] times = new int[][] {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4;
        int k = 2;
        System.out.println(networkDelayTime(times, n, k));
    }
}
