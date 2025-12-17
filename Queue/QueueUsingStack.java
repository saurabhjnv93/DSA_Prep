/*


Topics
premium lock icon
Companies
Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

Implement the MyQueue class:

void push(int x) Pushes element x to the back of the queue.
int pop() Removes the element from the front of the queue and returns it.
int peek() Returns the element at the front of the queue.
boolean empty() Returns true if the queue is empty, false otherwise.
Notes:

You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
 

Example 1:

Input
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 1, 1, false]

Explanation
MyQueue myQueue = new MyQueue();
myQueue.push(1); // queue is: [1]
myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
myQueue.peek(); // return 1
myQueue.pop(); // return 1, queue is [2]
myQueue.empty(); // return false
 

Constraints:

1 <= x <= 9
At most 100 calls will be made to push, pop, peek, and empty.
All the calls to pop and peek are valid.
 */
package Queue;
import java.util.*;
class MyQueue {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> st1 = new Stack<>();
        
    public MyQueue() {
       
    }
    
    public void push(int x) {
        st.push(x);
        
    }
    
    public int pop() {
        if(st1.empty()){
            fillSt2();
        }
        try{
            return st1.pop();
        }
        catch(Exception e){
            System.out.print("You Queue is Empty!");
        }
        return -1;
        
    }
    
    public int peek() {
        if(st1.empty()){
            fillSt2();
        }
        try{
            return st1.peek();
        }
        catch(Exception e){
            System.out.print("You Queue is Empty!");
        }
        return -1;
        
    }
    
    public boolean empty() {
        if(st1.empty()){
            fillSt2();
        }
        return st1.empty();
    }
    public void fillSt2(){
        while(!st.empty()){
            int temp = st.pop();
            st1.push(temp);
        }
    }
    public int size(){
        return st1.size() + st.size();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

public class QueueUsingStack {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(19);
        queue.push(3);
        queue.push(4);
        queue.push(1);
        queue.push(13);
        queue.push(14);
        
        System.out.println(queue.peek());

        System.out.println(queue.empty());
        
        System.out.println(queue.size());
    }
}
