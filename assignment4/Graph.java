import java.util.ArrayList;

public class Graph {

    ArrayList<Vertex> vertices;
    int[][] matrix;
    private boolean isEmpty;

    public Graph() {
        this.vertices = new ArrayList<>();
        this.isEmpty = true;
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
        this.isEmpty = false;
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

    public boolean isEmpty(){
        return this.isEmpty;
    }

    public String toString(){
        String retStr = "";
        for (Vertex v : vertices){
            retStr += "   Vertex: " + v.id + "\n";
            retStr += v.toString();
            retStr += "\n\n";
        }
        return retStr;
    }

}
