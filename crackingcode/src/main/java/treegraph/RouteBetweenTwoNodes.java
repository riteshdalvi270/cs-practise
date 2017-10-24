package treegraph;

import java.util.*;

/**
 * @author Ritesh Dalvi
 **/
public class RouteBetweenTwoNodes {

    static int V = 4;
    static int E = 4;

    public static void main(String args[]) {

        final Graph graph = new Graph();

        final Vertex start = new Vertex();
        final Vertex end = new Vertex();

        routeBetweenTwoNodesDFS(graph, start,end);
    }

    private static boolean routeBetweenTwoNodesBFS(final Graph graph, final Vertex node1, final Vertex node2) {

        final Queue<Vertex> queue = new PriorityQueue<Vertex>();

        queue.add(node1);

        while(!queue.isEmpty()) {

            Vertex node = queue.remove();
            node.isVisited = true;

            final List<Vertex> neighbors = graph.edges.get(node);

            for(Vertex vertex : neighbors) {

                if(vertex == node2) {
                    return true;
                }

                if(!vertex.isVisited) {
                    queue.add(vertex);
                }
            }
        }

        return false;
    }

    private static boolean routeBetweenTwoNodesDFS(final Graph graph,final Vertex node1, final Vertex node2) {

        final List<Vertex> neighbors = graph.edges.get(node1);

        for (Vertex vertex : neighbors) {

            return dfsUtil(graph,vertex, node2);
        }

        return false;
    }

    private static boolean dfsUtil(final Graph graph, final Vertex vertex, final Vertex node2) {

        if(vertex == node2) {
            return true;
        }

        if(vertex.isVisited) {
            return false;
        }

        vertex.isVisited = true;
        final List<Vertex> neightbors = graph.edges.get(vertex);

        for(Vertex vertex1 : neightbors) {
            dfsUtil(graph, vertex1, node2);
        }

        return false;
    }

    static class Graph {
        Vertex vertex;
        Map<Vertex,List<Vertex>> edges;
    }

    static class Vertex {
        int value;
        boolean isVisited = false;
    }
}
