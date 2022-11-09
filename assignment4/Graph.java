import java.util.ArrayList;

public class Graph {

    ArrayList<Vertex> vertices;
    int[][] matrix;

    public Graph() {
        this.vertices = new ArrayList<>();
    }

    public Vertex findVertexById(int id) {
        return vertices.get(id);
    }

    // Given an id, creates a vertex and adds it to the graph.
    public void addVertex(int id) {
        Vertex vertex = new Vertex(id);

        vertices.add(vertex);
    }

    // Takes in two vertex id's and adds themselves to each others neighbor lists.
    public void addEdge(int vertex1, int vertex2) {
        // Add vertex2 to vertex 1's neighbor list.
        vertices.get(vertex1).addNeighbor(vertex2);

        // Add vertex1 to vertex2's neighbor list.
        vertices.get(vertex2).addNeighbor(vertex1);
    }

}
