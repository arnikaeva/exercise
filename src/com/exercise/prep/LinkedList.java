package com.exercise.prep;

public class LinkedList<T> {
  Node head;
  Node tail;
  int length;

  public LinkedList(T head) {
    this.head = new Node(head);
    this.tail = this.head;
    length = 1;
  }

  public void append(T value) {
    Node newNode = new Node(value);
    this.tail.next = newNode;
    this.tail = newNode;
    this.length++;
  }

  public void prepend(T value) {
    Node firstNode = new Node(value, this.head);
    this.head = firstNode;
    this.length++;
  }

  public void insert(int index, T value) {
    if (index == 0) {
      prepend(value);
    } else if (index == this.length) {
      append(value);
    }

    Node leaderNode = traverseToIndex(index - 1);

    Node newNode = new Node(value, leaderNode.next);
    leaderNode.next = newNode;
    this.length ++;
  }

  public T lookUp(int index) {
    return (T) traverseToIndex(index);
  }

  public void basicReverse() {
    Node prev = this.head;
    Node current = prev.next;
    Node next;

    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }

    this.tail = this.head;
    this.head = prev;
    this.tail.next = null;
  }

  public void reverse() {
    reverseNextNodes(null, this.head);

    Node oldHead = this.head;
    this.head = this.tail;
    this.tail = oldHead;
  }

  private Node reverseNextNodes(Node before, Node current) {
    if (current.next != null) {
      current = reverseNextNodes(current, current.next);
    }

    current.next = before;
    return before;

  }

  public void delete(int index) {
    if (index == 0) {
      this.head = this.head.next;
    } else {
      Node leaderNode = traverseToIndex(index - 1);
      leaderNode.next = leaderNode.next.next;
      if (index == this.length - 1) {
        this.tail = leaderNode;
      }
    }

    this.length --;
  }

  private Node traverseToIndex(int index) {
    if (index < 0 || index > this.length) {
      throw new RuntimeException();
    }

    int currentIndex = 0;
    Node currentNode = this.head;
    while (currentIndex < index) {
      currentNode = currentNode.next;
      currentIndex ++;
    }

    return currentNode;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    Node currentNode = this.head;
    while (currentNode.next != null) {
      sb.append(currentNode.value + "->");
      currentNode = currentNode.next;
    }

    sb.append(currentNode.value);

    return sb.toString();
  }

  private class Node<T> {
    T value;
    Node next;

    public Node(T value) {
      this.value = value;
    }

    public Node(T value, Node next) {
      this.value = value;
      this.next = next;
    }
  }

  public static void main(String[] args) {
    LinkedList<Integer> myList = new LinkedList<>(2);
    myList.append(3);
    myList.append(5);

    myList.prepend(4);
    myList.prepend(20);

    myList.insert(2, 66);

    myList.delete(5);

    System.out.println(myList);

    myList.basicReverse();

    System.out.println(myList);

  }
}
