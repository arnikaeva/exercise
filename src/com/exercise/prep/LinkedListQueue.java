package com.exercise.prep;

public class LinkedListQueue<T> {

  private Node<T> first;
  private Node<T> last;
  private int length;

  public LinkedListQueue() {
    this.first = null;
    this.last = null;
    length = 0;
  }

  public T peek() {
    return this.first.getValue();
  }

  public void enqueue(T value){
    Node newLast = new Node(value);
    if (this.isEmpty()) {
      this.last = newLast;
      this.first = this.last;
    } else {
      this.last.next = newLast;
      this.last = newLast;
    }
    this.length ++;
  }

  public T dequeue(){
    if (this.isEmpty()) {
      return null;
    }

    Node first = this.first;
    if (this.length == 1) {
      this.first = null;
      this.last = null;
    } else {
      this.first = this.first.next;
    }

    this.length --;
    return (T) first.getValue();
  }
  public boolean isEmpty() {
    return this.length == 0;
  }
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
