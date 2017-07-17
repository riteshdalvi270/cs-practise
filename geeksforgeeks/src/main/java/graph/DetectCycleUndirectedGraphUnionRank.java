package graph;

/**
 * Detect cycle in undirected graph using union-rank. Created by ritesh on 7/15/17.
 */
public class DetectCycleUndirectedGraphUnionRank
{

    public static void main(String args[])
    {

    }

    static class Graph
    {

        int V;
        int E;

        Edge[] egdes;
    }

    static class Edge
    {

        int src;
        int destination;
    }

    class Subset
    {
        int parent;
        int rank;
    }
}
