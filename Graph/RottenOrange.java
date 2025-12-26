/*

Topics
premium lock icon
Companies
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 

Example 1:


Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.
*/

package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOrange {
    private class Vertex{
        int i;
        int j;
         Vertex(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Vertex> q = new LinkedList<>();
        int fresh = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    q.offer(new Vertex(i,j));
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        if(fresh == 0)return 0;

        int[][]  dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        int res = -1;
        while(!q.isEmpty()){
            int rot = q.size();
            res++;
            for(int k = 0; k<rot; k++){
                
                Vertex coord = q.poll();
                int r = coord.i;
                int c = coord.j;

                for(int[] dir:dirs){
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if(nr>=0 && nr < m && nc >=0 && nc < n && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        fresh --;
                        q.offer(new Vertex(nr,nc));
                    }
                }
            }
        }

        
        return (fresh == 0)? res:-1;
    }
    public static void main(String[] args) {
       int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
       RottenOrange ro = new RottenOrange();
       System.out.println(ro.orangesRotting(grid));
    }

}
