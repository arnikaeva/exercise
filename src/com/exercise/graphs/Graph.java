package com.exercise.graphs;

import java.util.*;

public class Graph {
  private Node rootNode;

  private Map<Node, Edge> dijkstraPathes;

  private List<Node> nodes;

  public Graph() {
    this.dijkstraPathes = new HashMap<>();
    this.nodes = new ArrayList<>();
  }

  public void setRootNode(Node rootNode) {
    this.rootNode = rootNode;
  }

  public void addNode(Node node) {
    this.nodes.add(node);
  }

  public int shortestPathWithDijkstra(Node destination) {
    if (dijkstraPathes.containsKey(destination)) {
      return dijkstraPathes.get(destination).getWeight();
    }

    Set<Node> visited = new HashSet<>();
    Set<Node> unvisited = new HashSet<>(nodes);
    initDijkstra();

    Node currentNode = rootNode;

    while (currentNode != null && currentNode != destination) {
      System.out.println("Current node is " + currentNode.getLabel());
      List<Edge> neighbours = currentNode.getEdges();
      int currentDistance = getCurrentShortestPath(currentNode);
      for (Edge edge : neighbours) {
        int newDistance = currentDistance + edge.getWeight();
        int originalDistance = getCurrentShortestPath(edge.getNode());

        if (newDistance < originalDistance) {
          dijkstraPathes.put(edge.getNode(), new Edge(newDistance, currentNode));
        }
      }
      visited.add(currentNode);
      unvisited.remove(currentNode);
      currentNode = getNextNodeToVisit(unvisited);
    }

    return dijkstraPathes.get(destination).getWeight();
  }

  private void initDijkstra() {
    for (Node node : nodes) {
      if (node != rootNode) {
        dijkstraPathes.put(node, new Edge(Integer.MAX_VALUE, null));
      }
    }

    dijkstraPathes.put(rootNode, new Edge(0, null));
  }

  private int getCurrentShortestPath(Node n) {
    return dijkstraPathes.get(n).getWeight();
  }

  private Node getNextNodeToVisit(Set<Node> unvisitedNodes) {
    Edge minimumPath = null;
    Node minimumNode = null;
    for (Node node : unvisitedNodes) {
      Edge currentPath = dijkstraPathes.get(node);
      if (minimumPath == null) {
        minimumPath = currentPath;
        minimumNode = node;
      }

      int distance = currentPath.getWeight();
      if (distance < minimumPath.getWeight()) {
        minimumPath = currentPath;
        minimumNode = node;
      }
    }

    return minimumNode;
  }

  public static void main(String[] args) {
    Graph graph = new Graph();

    Node rootNodeA = new Node("A");
    Node nodeB = new Node("B");
    Node nodeC = new Node("C");
    Node nodeD = new Node("D");
    Node nodeE = new Node("E");
    Node nodeF = new Node("F");

    rootNodeA.addEdge(new Edge(3, nodeC));
    nodeC.addEdge(new Edge(3, rootNodeA));

    rootNodeA.addEdge(new Edge(7, nodeB));
    nodeB.addEdge(new Edge(7, rootNodeA));

    nodeC.addEdge(new Edge(1, nodeB));
    nodeB.addEdge(new Edge(1, nodeC));

    nodeC.addEdge(new Edge(2, nodeD));
    nodeD.addEdge(new Edge(2, nodeC));

    nodeD.addEdge(new Edge(2, nodeB));
    nodeB.addEdge(new Edge(2, nodeD));

    nodeD.addEdge(new Edge(4, nodeE));
    nodeE.addEdge(new Edge(4, nodeD));

    nodeB.addEdge(new Edge(6, nodeE));
    nodeE.addEdge(new Edge(6, nodeB));

    graph.setRootNode(rootNodeA);
    graph.addNode(rootNodeA);
    graph.addNode(nodeB);
    graph.addNode(nodeC);
    graph.addNode(nodeD);
    graph.addNode(nodeE);
    graph.addNode(new Node("F"));


    System.out.println(graph.shortestPathWithDijkstra(nodeF));
  }
}
