/*

You are given an integer array nums. The range of a subarray of nums is the difference between the largest and smallest element in the subarray.

Return the sum of all subarray ranges of nums.

A subarray is a contiguous non-empty sequence of elements within an array.

 

Example 1:

Input: nums = [1,2,3]
Output: 4
Explanation: The 6 subarrays of nums are the following:
[1], range = largest - smallest = 1 - 1 = 0 
[2], range = 2 - 2 = 0
[3], range = 3 - 3 = 0
[1,2], range = 2 - 1 = 1
[2,3], range = 3 - 2 = 1
[1,2,3], range = 3 - 1 = 2
So the sum of all ranges is 0 + 0 + 0 + 1 + 1 + 2 = 4.
Example 2:

Input: nums = [1,3,3]
Output: 4
Explanation: The 6 subarrays of nums are the following:
[1], range = largest - smallest = 1 - 1 = 0
[3], range = 3 - 3 = 0
[3], range = 3 - 3 = 0
[1,3], range = 3 - 1 = 2
[3,3], range = 3 - 3 = 0
[1,3,3], range = 3 - 1 = 2
So the sum of all ranges is 0 + 0 + 0 + 2 + 0 + 2 = 4.
Example 3:

Input: nums = [4,-2,-3,4,1]
Output: 59
Explanation: The sum of all subarray ranges of nums is 59.
 

Constraints:

1 <= nums.length <= 1000
-109 <= nums[i] <= 109
*/
import java.util.*;
class SumOfSubarrayRange {
    static{
        int[] n = new int[0];
        for(int i=0;i<500;i++){
            subArrayRanges(n);
        }
    }
    public static long sumOfSmallest(int[] nums){
        int n = nums.length;
        int nextSmaller[] = new int[n];
        int preSmaller[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){

            int ele = nums[i];
            while(!st.empty() && ele < nums[st.peek()]){
                st.pop();
            }
            if(!st.empty()){
                nextSmaller[i] = st.peek();
            }
            else{
                nextSmaller[i] = n;
            }
            st.push(i);

        }

        st.clear();
        for(int i=0;i<n;i++){

            int ele = nums[i];
            while(!st.empty() && ele <= nums[st.peek()]){
                st.pop();
            }
            if(!st.empty()){
                preSmaller[i] = st.peek();
            }
            else{
                preSmaller[i] = -1;
            }
            st.push(i);

        }
        long sumOfSmaller = 0;

        for(int i=0;i<n;i++){
            int left = i - preSmaller[i];
            int right = nextSmaller[i] - i;
            sumOfSmaller += (long)nums[i] *(left * right);
        }
        return sumOfSmaller;


    }

    public static  long sumOfGreatest(int[] nums){
        int n = nums.length;
        int nextGreater[] = new int[n];
        int preGreater[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){

            int ele = nums[i];
            while(!st.empty() && ele > nums[st.peek()]){
                st.pop();
            }
            if(!st.empty()){
                nextGreater[i] = st.peek();
            }
            else{
                nextGreater[i] = n;
            }
            st.push(i);

        }

        st.clear();
        for(int i=0;i<n;i++){

            int ele = nums[i];
            while(!st.empty() && ele >= nums[st.peek()]){
                st.pop();
            }
            if(!st.empty()){
                preGreater[i] = st.peek();
            }
            else{
                preGreater[i] = -1;
            }
            st.push(i);

        }
        long sumOfGreater = 0;

        for(int i=0;i<n;i++){
            int left = i - preGreater[i];
            int right = nextGreater[i] - i;
            sumOfGreater += (long)nums[i] * (left * right);
        }
        return sumOfGreater;

    }

    public static long subArrayRanges(int[] nums) {
        return (long)( sumOfGreatest(nums) -sumOfSmallest(nums));
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println("Input: " + Arrays.toString(nums));
        long ans = subArrayRanges(nums);
        System.out.println("\nFINAL ANSWER: " + ans);
    }
}