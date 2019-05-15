package com.exercise.prep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
  int numberOfNodes;
  Map<Integer, List<Integer>> adjacencies;

  public Graph() {
    this.numberOfNodes = 0;
    this.adjacencies = new HashMap<>();
  }

  public void addVertex(int node)  {
    this.adjacencies.put(node, new ArrayList<>());
    this.numberOfNodes++;
  }

  public void addEdge(int node1, int node2) {
    this.adjacencies.get(node1).add(node2);
    this.adjacencies.get(node2).add(node1);
  }

}
