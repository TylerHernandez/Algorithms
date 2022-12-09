import java.util.ArrayList;

public class Graph {

    public ArrayList<Vertex> vertices;
    private boolean isEmpty;
    private int highestIdFound;

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

        if (id > this.highestIdFound) {
            this.highestIdFound = id;
        }

        if (findVertexById(id).id == id) { // if we can find it's id (as non negative 1)
            System.out.println("The vertex ID " + id + " already exists.");
            return;
        }

        Vertex vertex = new Vertex(id);

        vertices.add(vertex);
    }

    // Takes in two vertex id's and adds themselves to each others neighbor lists.
    public void addEdge(int vertex1, int vertex2, int weight) {
        // Create a link from vertex 1 to vertex 2.
        this.findVertexById(vertex1).addLink(vertex2, weight);
    }

    // Looks at all vertices and edges inside this graph, and returns a matrix
    // representation.
    // public int[][] createMatrix() {

    // int[][] matrix = new int[this.highestIdFound + 1][this.highestIdFound + 1];

    // // Grab each vertex associated with each other and set their coordinates to
    // 1.
    // for (Vertex v : this.vertices) {
    // int vertexId = v.getId();

    // for (int neighborId : v.getNeighbors()) {
    // matrix[vertexId][neighborId] = 1;
    // matrix[neighborId][vertexId] = 1;
    // }
    // }

    // return matrix;
    // }

    // Prints out adjacency list representation for each vertex in graph.
    // Initially, I was going to return it similar to createMatrix, however this was
    // a lot easier and more efficient as I do not have to loop once again for
    // display.
    public void printList() {

        // Grab each vertex associated with each other and set their coordinates to 1.
        for (Vertex v : this.vertices) {
            int vertexId = v.getId();

            System.out.println("[" + vertexId + "]" + " ->" + v.getLinks().toString());
        }

    }

    public boolean isEmpty() {
        return this.isEmpty;
    }

    public String toString() {
        String retStr = "";
        for (Vertex v : vertices) {
            retStr += "   Vertex: " + v.id + "\n";
            retStr += v.toString();
            retStr += "\n\n";
        }
        return retStr;
    }

}
