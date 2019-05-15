package com.exercise.prep;

public class BinarySearchTree {

  Node root;

  public BinarySearchTree() {
    this.root = null;
  }

  public void insert(int value) {
    Node newNode = new Node(value);
    if (this.root != null) {
      Node parent = this.root;
      boolean parentFound = false;
      while (!parentFound) {
        Node nextParent = value < parent.getValue() ? parent.left : parent.right;
        if (nextParent == null || nextParent.getValue() == value) {
          parentFound = true;
        } else {
          parent = nextParent;
        }
      }

      if (value < parent.getValue()) {
        parent.left = newNode;
      } else {
        parent.right = newNode;
      }
    } else {
      this.root = newNode;
    }
  }

  public Integer lookup(int value) {
    if (this.root == null){
      return null;
    }

    boolean found = false;
    Node current = this.root;
    while (!found) {
      current = value < current.getValue() ? current.left : current.right;

      if (current == null || current.getValue() == value) {
        found = true;
      }

    }
    return current == null ? null : current.getValue();
  }

  public void remove(int value) {
    if (this.root == null){
      return;
    } else if (this.root.getValue() == value) {
      this.root = null;
    }

    Node parent = this.root;
    boolean parentFound = false;
    while (!parentFound) {
      Node nextParent = value < parent.getValue() ? parent.left : parent.right;
      if (nextParent == null) {
        return;
      } else if (nextParent.getValue() == value) {
        parentFound = true;
      } else {
        parent = nextParent;
      }
    }

    Node childToRemove = value < parent.getValue() ? parent.left : parent.right;
    if (childToRemove.right == null && childToRemove.left == null) {
      removeFromParent(parent, childToRemove);
    } else if (childToRemove.right == null) {
      assignToParent(parent, childToRemove.left);
    } else if (childToRemove.left == null) {
      assignToParent(parent, childToRemove.right);
    } else {
      //TODO
    }

  }

  private void assignToParent(Node parent, Node child) {
    if (child.getValue() < parent.getValue()) {
      parent.left = child;
    } else {
      parent.right = child;
    }
  }

  private void removeFromParent(Node parent, Node childToRemove) {
    if (childToRemove.getValue() < parent.getValue() && parent.left.getValue() == childToRemove.getValue()) {
      parent.left = null;
    } else if (childToRemove.getValue() > parent.getValue() && parent.right.getValue() == childToRemove.getValue()) {
      parent.right = null;
    } else {
      throw new RuntimeException();
    }
  }

  public void traverse() {
    traverse(this.root);
  }

  private void traverse(Node node) {
    if (node.left != null) {
      traverse(node.left);
    }

    System.out.println(node.getValue());

    if (node.right != null) {
      traverse(node.right);
    }

  }

  class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
      this.value = value;
    }

    public int getValue() {
      return value;
    }
  }

  public static void main(String[] args) {
    BinarySearchTree tree = new BinarySearchTree();
    tree.insert(9);
    tree.insert(4);
    tree.insert(6);
    tree.insert(20);
    tree.insert(170);
    tree.insert(15);
    tree.insert(1);
    tree.traverse();

    System.out.println(tree.lookup(170));
    System.out.println(tree.lookup(64));


  }
}
