package foundation.chap22;

/**
 * Depth first search recursively
 * @author Ritesh Dalvi (rd026600).
 */
public class DFSRecursive
{
    public static int distance = 0;

    public static void main(String args[])
    {
        Graph graph = new Graph();

        DFS(graph);
    }

    public static void DFS(Graph graph)
    {
        final Graph.Vertex[] vertices = graph.vertices;

        for (int vertex = 0; vertex < graph.vertices.length; vertex++)
        {
            vertices[vertex].color = Graph.Color.BLACK.WHITE;
        }

        distance = 0;

        for (Graph.Vertex vertex : vertices)
        {
            if (vertex.color == Graph.Color.BLACK.WHITE)
            {
                dfsUtil(vertex, graph);
            }
        }
    }

    private static void dfsUtil(final Graph.Vertex vertex, Graph graph)
    {
        vertex.color = Graph.Color.BLACK.GREY;
        for (Graph.Vertex neighbors : graph.adj.get(vertex))
        {
            if (neighbors.color == Graph.Color.WHITE)
            {
                dfsUtil(vertex, graph);
            }
        }

        vertex.color = Graph.Color.BLACK.BLACK;
        distance = distance + 1;
        vertex.distance = distance;
    }
}
