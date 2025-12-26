/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 

Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.
*/


package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedeule {
    public  static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] dependsOn = new int[numCourses];

        ArrayList<ArrayList<Integer>> relatedCourses = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            relatedCourses.add(new ArrayList<Integer>());
        }
        for(int[] prerequisite:prerequisites){
            int ai = prerequisite[0];
            int bi = prerequisite[1];
            dependsOn[bi]++;
            relatedCourses.get(ai).add(bi);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(dependsOn[i] == 0){
                q.offer(i);
            }
        }

        int count = 0;
        while(!q.isEmpty()){
            int sub = q.poll();
            count++;
            ArrayList<Integer> lst = relatedCourses.get(sub);
            for(int qDependSub:lst){
                dependsOn[qDependSub]--;
                if(dependsOn[qDependSub] == 0){
                    q.offer(qDependSub);
                }
            }
        }   
        return numCourses == count;     
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1,0},{0,1}};
        System.out.println(canFinish(numCourses, prerequisites));
    }
}
