import java.util.ArrayList;

public class Graph {

    ArrayList<Vertex> vertices;
    int[][] matrix;

    public Graph() {
        this.vertices = new ArrayList<>();
    }

    public Vertex findVertexById(int id) {

        // Loop through vertices list to find a vertex with our desired id.
        Vertex v;
        for (int i = 0; i < vertices.size(); i++) {
            v = vertices.get(i);
            if (v.getId() == id) {
                return v;
            }
        }

        // Vertex does not exist.
        return new Vertex(-1);
    }

    // Given an id, creates a vertex and adds it to the graph.
    public void addVertex(int id) {
        Vertex vertex = new Vertex(id);

        vertices.add(vertex);
    }

    // Takes in two vertex id's and adds themselves to each others neighbor lists.
    public void addEdge(int vertex1, int vertex2) {
        // Add vertex2 to vertex 1's neighbor list.
        this.findVertexById(vertex1).addNeighbor(vertex2);

        // Add vertex1 to vertex2's neighbor list.
        this.findVertexById(vertex2).addNeighbor(vertex1);
    }

}
