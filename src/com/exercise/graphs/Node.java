package com.exercise.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node {

  private String label;
  private List<Edge> edges;
  private boolean visited;

  public Node(String label) {
    this.label = label;
    this.edges = new ArrayList<>();
  }

  public void addEdge(Edge edge) {
    this.edges.add(edge);
  }

  public List<Edge> getEdges() {
    return edges;
  }

  public String getLabel() {
    return label;
  }

  public boolean isVisited() {
    return visited;
  }

  public void setVisited(boolean visited) {
    this.visited = visited;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Node node = (Node) o;
    return Objects.equals(label, node.label);
  }

  @Override
  public int hashCode() {

    return Objects.hash(label);
  }
}
