/*

You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

 

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length
 */


package Queue;

import java.util.*;

public class WindowMax {
   public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];

        Deque<Integer> myDeque = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        int i = 0;

        for (int j = 0; j < nums.length; j++) {

            if (!myDeque.isEmpty() && myDeque.getFirst() <= j - k) {
                myDeque.pollFirst();
            }

            while (!myDeque.isEmpty() && nums[myDeque.getLast()] < nums[j]) {
                myDeque.pollLast();
            }

            myDeque.offerLast(j);

            if (j >= k - 1) {
                res[i++] = nums[myDeque.getFirst()];
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = new int[] {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));
    }
}
