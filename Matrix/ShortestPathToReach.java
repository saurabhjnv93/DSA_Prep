/*
1091. Shortest Path in Binary Matrix
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.

 

Example 1:


Input: grid = [[0,1],[1,0]]
Output: 2
Example 2:


Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
Output: 4
Example 3:

Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
Output: -1
 

Constraints:

n == grid.length
n == grid[i].length
1 <= n <= 100
grid[i][j] is 0 or 1
 

*/
package Matrix;

import java.util.PriorityQueue;

public class ShortestPathToReach {
     private static class Pair{
        int x;
        int y;
        int w;
        Pair(int x, int y, int w){
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }
    public static  int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0] == 1 || grid[n-1][m-1] == 1)return -1;
        int[][] dirs = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(a.w, b.w));
        pq.offer(new Pair(0,0,1));

        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            int xCoord = pair.x;
            int yCoord = pair.y;
            int wt = pair.w;

            if(xCoord == n-1 && yCoord == m - 1){
                return wt;
            }
            if (grid[xCoord][yCoord] == 1) continue;
            grid[xCoord][yCoord] = 1;

            for(int[]  dir:dirs){
                int nx = xCoord + dir[0];
                int ny = yCoord + dir[1];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m && grid[nx][ny] != 1){
                    pq.offer(new Pair(nx, ny, wt+1));
                }
            }
        }
    return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }
}
