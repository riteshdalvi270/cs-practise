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

    private static void topologicalSorting(final Graph graph, final Stack<Vertex> stack)
    {

        for (int vertexIndex = 0; vertexIndex < graph.vertices.length; vertexIndex++)
        {

            final Vertex startVertex = graph.vertices[vertexIndex];
            if (!startVertex.visited)
                topologicalSortingUtil(stack, graph.adj, startVertex);
        }
    }

    private static void topologicalSortingUtil(Stack<Vertex> stack, Map<Vertex, List<Vertex>> adj, Vertex vertex)
    {

        final List<Vertex> vertices = adj.get(vertex);
        for (final Vertex adjVertex : vertices)
        {

            if (!adjVertex.visited)
            {

                adjVertex.visited = true;
                topologicalSortingUtil(stack, adj, adjVertex);
            }

            stack.push(adjVertex);
        }
    }

    private static void printStack(final Stack<Vertex> stack)
    {

        while (stack.isEmpty())
        {

            System.out.print(stack.pop() + "->");
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
