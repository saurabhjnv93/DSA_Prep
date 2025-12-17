package LLQuestion;

class LinkedList {
      int val;
      LinkedList next;
      LinkedList() {}
      LinkedList(int val) { this.val = val; }
      LinkedList(int val, LinkedList next) { this.val = val; this.next = next; }
  }