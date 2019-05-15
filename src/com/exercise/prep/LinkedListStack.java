package com.exercise.prep;

public class LinkedListStack<T> implements Stack<T>{

  private Node top;
  private Node bottom;
  private int length;

  public LinkedListStack() {
    top = null;
    bottom = null;
    length = 0;
  }

  @Override
  public T peek() {
    return (T) this.top.getValue();
  }

  @Override
  public T pop() {
    if (this.isEmpty()) {
      return null;
    } else if (this.length == 1) {
      this.bottom = null;
    }

    Node result = this.top;
    this.top = this.top.next;
    this.length --;

    return (T) result.getValue();
  }

  @Override
  public void push(T value) {
    Node newTop = new Node(value);

    if (this.isEmpty()) {
      this.top = newTop;
      this.bottom = newTop;
    } else {
      newTop.next = this.top;
      this.top = newTop;
    }

    this.length ++;
  }

  @Override
  public boolean isEmpty() {
    return this.length == 0;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    Node current = this.top;
    while (current != null) {
      sb.append(current.value + "->");
      current = current.next;
    }

    return sb.toString();
  }

  class Node<T> {
    T value;
    Node next;

    public Node(T value) {
      this.value = value;
    }

    public T getValue() {
      return value;
    }
  }

  public static void main(String[] args) {
    LinkedListStack<Integer> stack = new LinkedListStack<>();
    stack.push(3);
    stack.push(4);
    stack.push(5);
    stack.push(7);

    System.out.println(stack.peek());
    stack.pop();
    System.out.println(stack.peek());

    System.out.println(stack);

  }
}
