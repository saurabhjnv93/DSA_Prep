/*
Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.

The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.

 

Example 1:

Input: nums = [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number. 
The second 1's next greater number needs to search circularly, which is also 2.
Example 2:

Input: nums = [1,2,3,4,3]
Output: [2,3,4,-1,4]
 

Constraints:

1 <= nums.length <= 104
-109 <= nums[i] <= 109
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreater2 {
    public  static int[] nextGreaterElements(int[] nums) {

        Stack<Integer> index = new Stack<>();
        Map<Integer,Integer> nge = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            while(!index.isEmpty() && nums[index.peek()] < nums[i]){
                nge.put(index.pop(), nums[i]);
            }
            index.push(i);
        }

        while(!index.isEmpty()){
            int indx = index.pop();
            boolean flag = false;
            for(int i=0;i<indx;i++){
                if(nums[i] > nums[indx]){
                    flag = true;
                    nge.put(indx,nums[i]);
                    break;
                }
            }
            if(!flag){
                nge.put(indx,-1);
            }
        }
        int res[] = new int[nums.length];
        for(int j=0;j<nums.length;j++){
            res[j] = nge.get(j);
        }
        return res;
    }

    public static void main(String[] args) {
            int[] nums = {3, 1, 2, 1};

        System.out.println("Input nums: " + Arrays.toString(nums));

        int[] result = nextGreaterElements(nums);

        System.out.println("\nFinal Result:");
        System.out.println(Arrays.toString(result));
    }
}
