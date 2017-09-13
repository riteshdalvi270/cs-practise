package yelp;

import java.util.*;

/**
 * Created by ritesh on 9/10/17.
 */
public class SkyLine {

    public static void main(String args[]) {

        int[][] input = new int[][] {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};

        List<int[]> skyline = getSkyline(input);

        for(int[] in : skyline) {

            for(int ot: in) {
                System.out.print(ot);
                System.out.print("  ");
            }

            System.out.println();
        }
    }

    public static List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();

        if (buildings == null || buildings.length == 0
                || buildings[0].length == 0) {
            return result;
        }

        List<Edge> edges = new ArrayList<Edge>();

        // add all left/right edges
        for (int[] building : buildings) {
            Edge startEdge = new Edge(building[0], building[2], true);
            edges.add(startEdge);
            Edge endEdge = new Edge(building[1], building[2], false);
            edges.add(endEdge);
        }

        // sort edges
        Collections.sort(edges, new Comparator<Edge>() {
            public int compare(Edge a, Edge b) {
                if (a.x != b.x)
                    return Integer.compare(a.x, b.x);

                if (a.isStart && b.isStart) {
                    return Integer.compare(b.height, a.height);
                }

                if (!a.isStart && !b.isStart) {
                    return Integer.compare(a.height, b.height);
                }

                return a.isStart ? -1 : 1;
            }
        });

        // process edges
        PriorityQueue<Integer> heightHeap = new PriorityQueue<Integer>(10, Collections.reverseOrder());

        for (Edge edge : edges) {
            if (edge.isStart) {
                if (heightHeap.isEmpty() || edge.height > heightHeap.peek()) {
                    result.add(new int[] { edge.x, edge.height });
                }
                heightHeap.add(edge.height);
            } else {
                heightHeap.remove(edge.height);

                if(heightHeap.isEmpty()){
                    result.add(new int[] {edge.x, 0});
                }else if(edge.height > heightHeap.peek()){
                    result.add(new int[]{edge.x, heightHeap.peek()});
                }
            }
        }

        return result;
    }

    static class Edge {
        int x;
        int height;
        boolean isStart;

        public Edge(int x, int height, boolean isStart) {
            this.x = x;
            this.height = height;
            this.isStart = isStart;
        }
    }
}
