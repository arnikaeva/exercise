package com.exercise.graphs.problem;

import com.exercise.graphs.Edge;
import com.exercise.graphs.Graph;
import com.exercise.graphs.Node;

import java.util.LinkedList;
import java.util.Queue;

public class RouteBetweenNodes {

  public boolean isConnected(Graph graph, Node start, Node end) {
    if (start == null || end == null) {
      throw new RuntimeException();
    }
    else if (start == end) {
      return true;
    }

    initaliseVisitStatus(graph);

    Queue<Node> toBeVisited = new LinkedList<>();
    toBeVisited.add(start);

    while(!toBeVisited.isEmpty()) {

      Node currentNode = toBeVisited.poll();
      if (!currentNode.isVisited()) {

        currentNode.setVisited(true);
        if (currentNode == end) {
          return true;
        }

        for (Edge edge : currentNode.getEdges()) {
          toBeVisited.add(edge.getNode());
        }
      }
    }

    return false;
  }

  private void initaliseVisitStatus(Graph graph) {
    graph.getNodes().forEach(node -> node.setVisited(false));
  }

  public static void main(String[] args) {

  }
}
