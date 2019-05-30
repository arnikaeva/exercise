package com.exercise.stacks;

import com.exercise.prep.QueueWithStack;
import com.sun.tools.jdi.IntegerValueImpl;

import java.util.Stack;

public class QueueWithStacks<T> {
  Stack<T> in;
  Stack<T> out;

  public QueueWithStacks() {
    this.in  = new Stack<>();
    this.out  = new Stack<>();
  }

  public T pop() {
    if (out.isEmpty()) {
      fillOutStack();
    }

    return out.pop();
  }

  public boolean isEmpty() {
    return in.isEmpty() && out.isEmpty();
  }

  public int size() {
    return in.size() + out.size();
  }

  public void push(T elem) {
    in.push(elem);
  }

  private void fillOutStack() {
    while (!in.isEmpty()) {
      out.push(in.pop());
    }
  }

  public static void main(String[] args) {
    QueueWithStacks<Integer> queue = new QueueWithStacks<>();

    queue.push(1);
    queue.push(2);
    System.out.println(queue.pop());
    System.out.println(queue.pop());


    queue.push(3);

    queue.push(4);
    queue.push(5);
    System.out.println(queue.pop());
    System.out.println(queue.pop());
    System.out.println(queue.pop());


  }
}
