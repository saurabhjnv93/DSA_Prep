/*
Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.

 

Example 1:


Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.
Example 2:


Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 

Constraints:

The number of nodes in the list is in the range [1, 100].
1 <= Node.val <= 100
*/

package LLQuestion;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 

public class MiddleOfLL {
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast=head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast.next != null){
            return slow.next;
        }
        return slow;
    }
    public static void printNodes(ListNode head){
        while(head != null){
            System.out.print(head.val);
            System.out.print("->");
            head = head.next;
            
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ListNode ll = new ListNode();
        ListNode curr = ll;
        for(int i=1;i<6;i++){
            ListNode temp = new ListNode(i);
            curr.next = temp;
            curr = curr.next;
        }

        System.out.println("Original Linked list.");
        printNodes(ll);
        ListNode res = middleNode(ll);
        printNodes(res);

        
    }
}
