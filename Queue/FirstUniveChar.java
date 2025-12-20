/*
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

 

Example 1:

Input: s = "leetcode"

Output: 0

Explanation:

The character 'l' at index 0 is the first character that does not occur at any other index.

Example 2:

Input: s = "loveleetcode"

Output: 2

Example 3:

Input: s = "aabb"

Output: -1

 

Constraints:

1 <= s.length <= 105
s consists of only lowercase English letters.
*/

package Queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FirstUniveChar {
    public static int firstUniqChar(String s) {
        Queue<Integer> q = new LinkedList<>();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            q.offer(i);

            while (!q.isEmpty() && map.get(s.charAt(q.peek())) > 1) {
                q.poll();
            }
        }

        return q.isEmpty() ? -1 : q.peek();
    }

    public static void main(String[] args) {
        String s = "leetcodel";
        System.out.println(firstUniqChar(s));
    }
}
