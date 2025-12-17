/*
You are given the head of a Singly Linked List and a value x, insert that value x at the end of the LinkedList and return the head of the modified Linked List.

Examples :

Input: x = 6,
   
Output: 1 -> 2 -> 3 -> 4 -> 5 -> 6
Explanation: We can see that 6 is inserted at the end of the linkedlist.
   
Input: x = 1,
   
Output: 4 -> 5 -> 1
Explanation: We can see that 1 is inserted at the end of the linked list.
      
Constraints:
0 ≤ number of nodes ≤ 105
0 ≤ node->data , x ≤ 103


*/

package LLQuestion;



class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

class Solution {
    // Function to insert a node at the end of the linked list.
    static Node insertAtEnd(Node head, int x) {
        // code here
        if(head == null)return new Node(x);
        Node nd = new Node(x);
        Node curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = nd;
        return head;
    }
}

public class LLInsertionAtEnd {
    static void printList(Node head) {
        Node curr = head;
        System.out.print("Linked List: ");
        while (curr != null) {
            System.out.print(curr.data);
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    
    public static void main(String[] args) {
        // create Linked list
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Before insertion:");
        printList(head);

        head = Solution.insertAtEnd(head, 6);

        System.out.println("\nAfter insertion:");
        printList(head);
    }
}
