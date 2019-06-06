package com.exercise.graphs.problem;

import com.exercise.graphs.BinaryNode;

public class FirstCommonAncestor {

  public BinaryNode find(BinaryNode nodeA, BinaryNode nodeB) {
    BinaryNode firstCommonAncestor = null;

    while (firstCommonAncestor == null) {
      if (nodeA.isVisited()) {
        firstCommonAncestor = nodeA;
      } else {
        nodeA = moveUp(nodeA);
      }

      if (nodeB.isVisited()) {
        firstCommonAncestor = nodeB;
      } else {
        nodeB = moveUp(nodeB);
      }
    }

    return firstCommonAncestor;
  }


  private BinaryNode moveUp(BinaryNode node) {
    node.setVisited(true);
    return node.getParent() != null ? node.getParent() : node;
  }
}
