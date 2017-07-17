package graph;

import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;

/**
 * Implement DFS using stack. Created by ritesh on 7/15/17.
 */
public class DFSUsingStack
{

    public static void main(String args[])
    {

        final Graph graph = new Graph(5);

        for (int i = 0; i < 5; i++)
        {
            graph.vertices[i] = new Vertex(i);
        }

        graph.adj.put(new Vertex(0), ImmutableList.of(new Vertex(1), new Vertex(2)));
        graph.adj.put(new Vertex(1), ImmutableList.of(new Vertex(3), new Vertex(4)));
        graph.adj.put(new Vertex(2), ImmutableList.of(new Vertex(4)));

        dfsUsingStack(graph);
    }

    private static void dfsUsingStack(final Graph graph)
    {

        Vertex vertex = graph.vertices[0];

        final Stack<Vertex> stack = new Stack<>();

        stack.push(vertex);

        while (!stack.isEmpty())
        {

            final Vertex startVertex = stack.pop();

            List<Vertex> neighbors = graph.adj.get(startVertex);

            for (Vertex nb : neighbors)
            {

                if (!nb.visited)
                {
                    nb.visited = true;
                    stack.push(nb);
                }
            }
        }

    }

    static class Graph
    {

        Vertex[] vertices;
        Map<Vertex, List<Vertex>> adj;

        public Graph(int numberOfVertex)
        {
            vertices = new Vertex[numberOfVertex];
            adj = Maps.newHashMap();
        }
    }

    static class Vertex
    {

        int value;
        boolean visited;

        public Vertex(int i)
        {
            this.value = i;
            visited = false;
        }
    }
}
