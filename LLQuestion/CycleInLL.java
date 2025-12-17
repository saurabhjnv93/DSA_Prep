/*
Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

 

Example 1:


Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
Example 2:


Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
Example 3:


Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.
 

Constraints:

The number of the nodes in the list is in the range [0, 104].
-105 <= Node.val <= 105
pos is -1 or a valid index in the linked-list.

*/

package LLQuestion;

import LLQuestion.LinkedList;

public class CycleInLL {
    public static boolean hasCycle(LinkedList head) {
        if(head == null){return false;}
        LinkedList fastMove = head;
        LinkedList slowMove = head;
        while (fastMove.next != null && fastMove.next.next != null) {
            slowMove = slowMove.next;
            fastMove = fastMove.next.next;
           if (slowMove == fastMove){return true;}
        }
        return false;
    }
     public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        LinkedList curr = ll;
        LinkedList connection = null;
        for(int i=1;i<6;i++){
            LinkedList temp = new LinkedList(i);
            curr.next = temp;
            curr = curr.next;
            // make connection to create cycle

            if(i == 2){
                connection = temp;
            }
        }
        // Comment this line  to break cycle -> to get answer as : false
        curr.next = connection;

        System.out.println(hasCycle(ll));


        

        
    }


}
