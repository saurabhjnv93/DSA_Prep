/*
You are given the head of a doubly linked list. You have to reverse the doubly linked list and return its head.

Examples:

Input:
   
Output: 5 <-> 4 <-> 3
Explanation: After reversing the given doubly linked list the new list will be 5 <-> 4 <-> 3.
   
Input: 
   
Output: 196 <-> 59 <-> 122 <-> 75
Explanation: After reversing the given doubly linked list the new list will be 196 <-> 59 <-> 122 <-> 75.
   
Constraints:
1 ≤ number of nodes ≤ 106
0 ≤ node->data ≤ 104

*/

package LinkedList;




class DLLNode {
    int data;
    DLLNode next;
    DLLNode prev;

    DLLNode(int val) {
        data = val;
        next = null;
        prev = null;
    }
}


class MySolution {
    public  DLLNode reverseDLL(DLLNode head) {
        if (head == null || head.next == null) return head;
        
        DLLNode current = head;
        DLLNode prev = null;
        
        while (current != null) {
            prev = current.prev;
            current.prev = current.next;
            current.next = prev;
            current = current.prev;
        }
        
        return prev.prev;
    }
}
public class ReverseDLL {

    static void printDLL(DLLNode head){

        while(head != null){
            System.out.print(head.data);
            if (head.next != null) System.out.print(" <-> ");
            head = head.next;
        }
        System.out.println();

    }

    public static void main(String[] args) {

        DLLNode head = new DLLNode(0);
        DLLNode curr = head;

        for (int i = 1; i <= 5; i++) {
            DLLNode temp = new DLLNode(i);
            curr.next = temp;
            temp.prev = curr;
            curr = temp;
        }

        System.out.println("Original DLL:");
        printDLL(head);

        MySolution sol = new MySolution();
        head = sol.reverseDLL(head);

        System.out.println("\nReversed DLL:");
        printDLL(head);

    }
    
}
