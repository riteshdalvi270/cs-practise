package foundation.chap22;

import java.util.List;
import java.util.Map;

/**
 * @author Ritesh Dalvi (rd026600).
 */
public class Graph
{

    Vertex[] vertices;
    Map<Vertex, List<Vertex>> adj;

    static enum Color
    {
        WHITE,

        BLACK,

        GREY
    }

    static class Vertex
    {
        int value;
        Color color;
        int distance;

        public Vertex(Vertex parent, String color)
        {

        }
    }
}
