/*
Given the head of a singly linked list, reverse the list, and return the reversed list.

 

Example 1:


Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
Example 2:


Input: head = [1,2]
Output: [2,1]
Example 3:

Input: head = []
Output: []
 

Constraints:

The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000

*/

package LLQuestion;

public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)return head;
        
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
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
        ListNode res = reverseList(ll);
        System.out.println("Reverse Linkedlist: ");
        printNodes(res);

        
    }
}
