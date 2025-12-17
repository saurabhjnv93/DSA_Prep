/*
Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

Do not modify the linked list.

 

Example 1:


Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.
Example 2:


Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.
Example 3:


Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.
 

Constraints:

The number of the nodes in the list is in the range [0, 104].
-105 <= Node.val <= 105
pos is -1 or a valid index in the linked-list.
*/


package LLQuestion;

import LLQuestion.LinkedList;

public class StartOfCycleInLL {
    public static LinkedList detectCycle(LinkedList head) {
        LinkedList slow = head, fast = head;
        
        // Detect if a cycle exists using Floyd’s cycle-finding algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { 
                LinkedList temp = head;
                while (temp != slow) { // Find the cycle start
                    temp = temp.next;
                    slow = slow.next;
                }
                return temp;
            }
        }
        return null;
    }

   public static void main(String[] args) {
     LinkedList ll = new LinkedList();
        LinkedList curr = ll;
        LinkedList connection = null;
        for(int i=1;i<6;i++){
            LinkedList temp = new LinkedList(i);
            curr.next = temp;
            curr = curr.next;
            // make connection to create cycle; Can change this i value to connect somewhere else

            if(i == 3){
                connection = temp;
            }
        }
        curr.next = connection;

        LinkedList connectingNode = detectCycle(ll);
        System.out.println(connectingNode.val);

   }
}
