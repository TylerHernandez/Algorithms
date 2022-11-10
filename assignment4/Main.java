
public class Main {

    // Driver for Assignment 4.
    public static void main(String[] args) throws Exception {

        // Graph g = new Graph();

        // g.addVertex(3);
        // g.addVertex(2);
        // g.addVertex(1);
        // g.addVertex(0);

        // g.addEdge(0, 1);
        // g.addEdge(1, 2);

        // System.out.println(g.findVertexById(1).getNeighbors());

        Reader reader = new Reader("./graphs1.txt");

        String line = reader.getNextLine();

        Graph g;
        Vertex v;

        while (!reader.endOfFile) { // Until we've reached the end of the file.

            // if (line == "new graph") {
            // g = new Graph();
            // }

            // if (line == "add")
            System.out.println(line);

        }

    }

}