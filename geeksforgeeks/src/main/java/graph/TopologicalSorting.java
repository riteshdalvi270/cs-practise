package graph;

import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Topological sorting. Created by ritesh on 7/15/17.
 */
public class TopologicalSorting
{

    public static void main(String args[])
    {

        final Graph graph = new Graph();

        final Stack<Vertex> stack = new Stack<>();

        topologicalSorting(graph, stack);

        printStack(stack);
    }

    private static void topologicalSorting(final Graph graph, final Stack<Vertex> stack) {

        for(final Map.Entry<Vertex,List<Vertex>> entrySet : graph.adj.entrySet()) {

            Vertex vertex = entrySet.getKey();
            List<Vertex> adj = entrySet.getValue();

            if(!vertex.visited) {
                topologicalSorting(graph,adj,stack);
                stack.push(vertex);
            }
        }
    }

    private static void topologicalSorting(final Graph graph,List<Vertex> adj, Stack<Vertex> stack) {

        for(Vertex vertex : adj) {

            if(!vertex.visited) {
                topologicalSorting(graph, graph.adj.get(vertex),stack);
                vertex.visited = true;
                stack.push(vertex);
            }
        }
    }

    private static void printStack(Stack<Vertex> stack) {

        while(!stack.isEmpty()) {

            System.out.println(stack.pop().value);
        }
    }

    static class Graph
    {
        Vertex[] vertices;
        Map<Vertex, List<Vertex>> adj;
    }

    static class Vertex
    {

        int value;
        boolean visited;
    }
}
