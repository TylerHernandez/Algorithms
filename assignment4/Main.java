
public class Main {

    // Driver for Assignment 4.
    public static void main(String[] args) throws Exception {

        Graph g = new Graph();

        g.addVertex(0);
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);

        g.addEdge(0, 1);
        g.addEdge(1, 2);

        System.out.println(g.findVertexById(1).getNeighbors());

    }

}