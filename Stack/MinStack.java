/* Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 

Constraints:

-231 <= val <= 231 - 1
Methods pop, top and getMin operations will always be called on non-empty stacks.
At most 3 * 104 calls will be made to push, pop, top, and getMin.

*/

class MinStack {
    private int capacity;
    private int indx;
    private int[] placeHolder;
    private int[] minStack;
    
    public MinStack() {
        capacity = 10;
        indx = 0;
        placeHolder = new int[capacity];
        minStack = new int[capacity];
    }
    
    public void push(int val) {
        if (indx == capacity) {
            resize();
        }
        placeHolder[indx] = val;
        if (indx == 0) {
            minStack[indx] = val;
        } else {
            minStack[indx] = Math.min(minStack[indx - 1], val);
        }
        indx++;
    }
    
    public void pop() {
        if (this.isEmpty()) {
            throw new RuntimeException("Stack is empty.");
        }
        indx--;
    }
    
    public int top() {
        if (this.isEmpty()) {
            throw new RuntimeException("Stack is empty.");
        }
        return placeHolder[indx - 1];
    }
    
    public int getMin() {
        if (this.isEmpty()) {
            throw new RuntimeException("Stack is empty.");
        }
        return minStack[indx - 1];
    }

    private void resize() {
        capacity *= 2;
        int[] newPlaceHolder = new int[capacity];
        int[] newMinStack = new int[capacity];
        for (int i = 0; i < indx; i++) {
            newPlaceHolder[i] = placeHolder[i];
            newMinStack[i] = minStack[i];
        }
        placeHolder = newPlaceHolder;
        minStack = newMinStack;
    }

    private boolean isEmpty() {
        return indx == 0;
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        System.out.println("--- MinStack Initialized ---");

        System.out.println("Pushing -2");
        stack.push(-2);
        
        System.out.println("Pushing 0");
        stack.push(0);
        
        System.out.println("Pushing -3");
        stack.push(-3);

        System.out.println("Current Minimum: " + stack.getMin()); 

        System.out.println("Popping top element...");
        stack.pop();

        System.out.println("Current Top: " + stack.top());       

        System.out.println("Current Minimum: " + stack.getMin()); 
        
        
    }
}

