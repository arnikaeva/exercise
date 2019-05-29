package com.exercise.graphs;

import java.util.*;

public class Graph {
  private Node rootNode;

  private Map<Node, Edge> dijkstraPaths;
  private Map<Node, Integer> bellmannFordPaths;

  private List<Node> nodes;

  public Graph() {
    this.dijkstraPaths = new HashMap<>();
    this.bellmannFordPaths = new HashMap<>();
    this.nodes = new ArrayList<>();
  }

  public void setRootNode(Node rootNode) {
    this.rootNode = rootNode;
  }

  public void addNode(Node node) {
    this.nodes.add(node);
  }

  public int shortestPathWithDijkstra(Node destination) {
    if (dijkstraPaths.containsKey(destination)) {
      return dijkstraPaths.get(destination).getWeight();
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
          dijkstraPaths.put(edge.getNode(), new Edge(newDistance, currentNode));
        }
      }
      visited.add(currentNode);
      unvisited.remove(currentNode);
      currentNode = getNextNodeToVisit(unvisited);
    }

    return dijkstraPaths.get(destination).getWeight();
  }

  public int shortesPathWithBellmannFord(Node destination) {
    initBellmannFord();

    boolean changedSomething = true;
    int iteration = 0;
    while (changedSomething && iteration < nodes.size() - 1) {
      changedSomething = false;
      for (Node currentNode : nodes) {
        for(Edge edge : currentNode.getEdges()) {
          int originalDistance = bellmannFordPaths.get(edge.getNode());
          int newDistance = bellmannFordPaths.get(currentNode) + edge.getWeight();

          if (newDistance < originalDistance) {
            bellmannFordPaths.put(edge.getNode(), newDistance);
            changedSomething = true;
          }
        }
        iteration++;
      }
    }

    return bellmannFordPaths.get(destination);
  }

  private void initBellmannFord() {
    for (Node node : nodes) {
      if (node != rootNode) {
        bellmannFordPaths.put(node, Integer.MAX_VALUE);
      }
    }

    bellmannFordPaths.put(rootNode, 0);
  }

  private void initDijkstra() {
    for (Node node : nodes) {
      if (node != rootNode) {
        dijkstraPaths.put(node, new Edge(Integer.MAX_VALUE, null));
      }
    }

    dijkstraPaths.put(rootNode, new Edge(0, null));
  }

  private int getCurrentShortestPath(Node n) {
    return dijkstraPaths.get(n).getWeight();
  }

  private Node getNextNodeToVisit(Set<Node> unvisitedNodes) {
    Edge minimumPath = null;
    Node minimumNode = null;
    for (Node node : unvisitedNodes) {
      Edge currentPath = dijkstraPaths.get(node);
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


    System.out.println(graph.shortesPathWithBellmannFord(nodeE));
  }
}
