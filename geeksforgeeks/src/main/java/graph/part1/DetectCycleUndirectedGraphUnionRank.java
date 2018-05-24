package graph.part1;

/**
 * Detect cycle in undirected graph using union-rank. Created by ritesh on 7/15/17.
 */
public class DetectCycleUndirectedGraphUnionRank
{

    public static void main(String args[])
    {
        int V = 5;
        int E = 5;

        final Graph graph = new Graph(V, E);

        if(isCycle(graph)) {
            System.out.println("Cycle detected");
        }else {
            System.out.println("Cycle not detected");
        }
    }

    private static boolean isCycle(final Graph graph) {

        final Subset subset[] = new Subset[graph.V];

        for(int i=0; i<graph.V;i++) {
            subset[i].parent = i;
            subset[i].rank = 0;
        }


        for(int e=0; e<graph.E-1;e++) {

           final Edge edge = graph.edges[e];

           int x = find(subset,edge.src);
           int y = find(subset,edge.destination);

           if(x == y) {
               return true;
           }

           union(subset,edge.src, edge.destination);
        }

        return false;
    }

    private static int find(Subset[] subset, int src) {

        if(subset[src].parent == src) {
            return src;
        }

        return find(subset,subset[src].parent);
    }


    private static void union(Subset[] subsets,int src, int destination) {

        int srcparent = find(subsets,src);
        int destparent = find(subsets,destination);

        if(subsets[srcparent].rank > subsets[destination].rank) {
            subsets[destination].parent = subsets[srcparent].parent;
        }else if(subsets[srcparent].rank < subsets[destination].rank) {
            subsets[srcparent].parent = subsets[destination].parent;
        }else if(subsets[srcparent].rank == subsets[destparent].rank) {
            subsets[destination].parent = subsets[srcparent].parent;
            subsets[srcparent].rank++;
        }
    }

    static class Graph
    {

        int V;
        int E;

        Edge[] edges;

        Graph(int V, int E) {
            this.V = V;
            this.E = E;

            for(int i=0; i<E;i++) {
                edges[i] = new Edge();
            }
        }
    }

    static class Edge implements Comparable<Edge>
    {
        int src;
        int destination;

        @Override
        public int compareTo(Edge o) {
            return 0;
        }
    }

    class Subset
    {
        int parent;
        int rank;
    }
}
