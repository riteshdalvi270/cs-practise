package graph.part1;

/**
 * Detect cycle in an undirected graph using union-find. Created by ritesh on 7/14/17.
 */
public class DetectCycleInUndirectedGraphUnionFind
{

    static int V = 5;
    static int E = 5;

    public static void main(String args[])
    {

        final Graph graph = new Graph(V, E);

        graph.edges[0].src = 0;
        graph.edges[0].dest = 1;

        graph.edges[1].src = 0;
        graph.edges[1].dest = 2;

        graph.edges[2].src = 2;
        graph.edges[2].dest = 3;

        graph.edges[3].src = 2;
        graph.edges[3].dest = 4;

        if (isCycle(graph))
        {
            System.out.println("Cycle detected");
        }
        else
        {
            System.out.println("Cycle not detected");
        }
    }

    private static boolean isCycle(final Graph graph)
    {

        int parent[] = new int[graph.V];

        for (int i = 0; i < graph.V; i++)
        {

            parent[i] = -1;
        }

        for (int i = 0; i < graph.E; i++)
        {

            int src = graph.edges[i].src;
            int dest = graph.edges[i].dest;

            if (find(parent, src) == find(parent, dest))
            {
                return true;
            }

            union(parent, src, dest);
        }

        return false;
    }

    private static int find(int[] parent, int i)
    {

        if (parent[i] == -1)
        {
            return i;
        }

        return find(parent, parent[i]);
    }

    private static void union(int[] parent, int x, int y)
    {

        int xParent = find(parent, x);
        int yParent = find(parent, y);

        parent[xParent] = yParent;
    }

    static class Graph
    {

        int V;
        int E;

        Edge[] edges;

        public Graph(final int V, int E)
        {

            this.V = V;
            this.E = E;

            edges = new Edge[E];
            for (int i = 0; i < E; ++i)
                edges[i] = new Edge();
        }
    }

    static class Edge
    {
        int src;
        int dest;
    }
}
