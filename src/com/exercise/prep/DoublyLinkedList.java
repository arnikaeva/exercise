package com.exercise.prep;

public class DoublyLinkedList<T> {
  Node head;
  Node tail;
  int length;

  public DoublyLinkedList(T head) {
    this.head = new Node(head);
    this.tail = this.head;
    length = 1;
  }

  public void append(T value) {
    Node newNode = new Node(value);

    this.tail.next = newNode;
    newNode.prev = this.tail;

    this.tail = newNode;
    this.length++;
  }

  public void prepend(T value) {
    Node firstNode = new Node(value);

    firstNode.next = this.head;
    this.head.prev = firstNode;

    this.head = firstNode;
    this.length++;
  }

  public void insert(int index, T value) {
    if (index == 0) {
      prepend(value);
    } else if (index == this.length) {
      append(value);
    }

    Node nodeAfterInsert = traverseToIndex(index);
    Node nodeBeforeInsert = nodeAfterInsert.prev;
    Node newNode = new Node(value);

    setNeighbours(nodeBeforeInsert, newNode);
    setNeighbours(newNode, nodeAfterInsert);


    this.length ++;
  }

  public Node lookUp(int index) {
    return traverseToIndex(index);
  }

  public void delete(int index) {
    Node nodeBefore = traverseToIndex(index - 1);
    Node nodeAfter = nodeBefore.next.next;

    setNeighbours(nodeBefore, nodeAfter);
    this.length --;
  }

  private void setNeighbours(Node first, Node after) {
    if (first != null) {
      first.next = after;
    }

    if (after != null) {
      after.prev = first;
    }
  }

  private Node traverseToIndex(int index) {
    if (index < 0 || index > this.length) {
      throw new RuntimeException();
    }

    if (index < length / 2) {
      return traverseToIndexFromHead(index);
    } else {
      return traverseToIndexFromTail(index);
    }
  }

  private Node traverseToIndexFromTail(int index) {
    int currentIndex = this.length - 1;
    Node currentNode = this.tail;
    while (currentIndex > index) {
      currentNode = currentNode.prev;
      currentIndex --;
    }

    return currentNode;
  }

  private Node traverseToIndexFromHead(int index) {
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
    Node prev;

    public Node(T value) {
      this.value = value;
    }
  }

  public static void main(String[] args) {
    DoublyLinkedList<Integer> myList = new DoublyLinkedList<>(2);
    myList.append(3);
    myList.append(5);

    myList.prepend(4);
    myList.prepend(20);

    myList.insert(2, 66);

    myList.delete(5);

    System.out.println(myList.lookUp(3).value);
    System.out.println(myList.lookUp(4).value);




    System.out.println(myList);

  }
}
