package com.exercise.prep;

import java.util.Stack;

public class QueueWithStack {
  Stack<Integer> stack;

  public QueueWithStack() {
    this.stack = new Stack<>();
  }

  public void push(int x) {
    Stack newStack = new Stack();
    newStack.push(x);

    int[] elems = new int[stack.size()];

    for(int i = 0; i < elems.length; i++) {
      elems[i] = stack.pop();
    }

    for(int i = elems.length - 1; i >= 0; i--) {
      newStack.push(elems[i]);
    }

    stack = newStack;
  }

  /** Removes the element from in front of queue and returns that element. */
  public int pop() {
    return stack.pop();
  }

  /** Get the front element. */
  public int peek() {
    return stack.peek();
  }

  /** Returns whether the queue is empty. */
  public boolean empty() {
    return stack.empty();
  }

  public static void main(String[] args) {

    QueueWithStack obj = new QueueWithStack();
    obj.push(1);
    obj.push(2);
    obj.push(3);
    System.out.println(obj.pop());
    System.out.println(obj.pop());
    System.out.println(obj.pop());
    System.out.println(obj.empty());
    }
}
