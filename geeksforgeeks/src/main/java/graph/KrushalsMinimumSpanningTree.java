package graph;

import java.util.Arrays;

/**
 * Psuedo:
 * 1. Sort all the edges in non-decreasing order of their weight.

 2. Pick the smallest edge. Check if it forms a cycle with the spanning tree
 formed so far. If cycle is not formed, include this edge. Else, discard it.

 3. Repeat step#2 until there are (V-1) edges in the spanning tree.
 * Created by ritesh on 7/29/17.
 */
public class KrushalsMinimumSpanningTree {

    public static void main(String args[]) {

        int V= 9;
        int E = 13;

        final Graph graph = new Graph(V,E);

        krushalsAlgo(graph);
    }

    private static void krushalsAlgo(final Graph graph) {

        Subset subset[] = new Subset[graph.V];

        final Edge[] edges = graph.edges;

        Arrays.sort(edges);

        for(int i=0; i<graph.V; i++) {
            subset[i].parent = i;
            subset[i].rank = 0;
        }

        int edge = 0;

        int vertex = 0;

        if(vertex <  graph.V) {

            // first edge
            Edge ed = edges[edge];

            int x = find(subset,ed.src);
            int y = find(subset,ed.destination);

            if(x!=y) {
                // add to result array by V size
                union(subset,x,y);
            }
        }
    }

    private static void union(Subset[] subsets, int x, int y) {

        if(subsets[x].rank<subsets[y].rank) {

            subsets[x].parent = y;
        }else if(subsets[y].rank<subsets[x].rank) {

            subsets[y].parent = x;
        }else {
            // join y to x and increase the rank.
            subsets[x].parent = y;
            subsets[x].rank++;
        }
    }

    private static int find(Subset[] subsets, int i) {

        // Missing path compression http://www.geeksforgeeks.org/union-find-algorithm-set-2-union-by-rank/
        if(subsets[i].parent == i) {

            return i;
        }

        return find(subsets,subsets[i].parent);
    }

    static class Graph {

        int V;
        int E;

        Edge[] edges;

        public Graph(int V, int E) {
            this.V=V;
            this.E=E;

            for(int i=0; i<E;i++) {
                edges[i] = new Edge();
            }
        }

        public void addEdge(int index, int src, int dest) {
            edges[index].src = src;
            edges[index].destination = dest;
        }
    }

    static class Edge implements Comparable<Edge>{
        int src;
        int destination;
        int weight;

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static class Subset {
        int parent;
        int rank;
    }
}
