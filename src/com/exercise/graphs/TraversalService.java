package com.exercise.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class TraversalService {

  public void depthFirstSearch(Node root) {
    if (root == null) {
      return;
    }

    visit(root);
    for (Edge edge : root.getEdges()) {
      Node node = edge.getNode();
      if (!node.isVisited()) {
        depthFirstSearch(node);
      }
    }
  }

  public void breadthFirstSearch(Node root) {
    if (root == null) {
      return;
    }

    Queue<Node> nodesToVisit = new LinkedList<>();
    nodesToVisit.add(root);

    while(!nodesToVisit.isEmpty()) {
      Node nextNode = nodesToVisit.poll();
      if (!nextNode.isVisited()) {
        visit(nextNode);
        nextNode.getEdges().forEach(edge -> nodesToVisit.add(edge.getNode()));
      }
    }

  }

  private void visit(Node node) {
    System.out.println("Visiting node " + node.getLabel());
    node.setVisited(true);
  }

}
