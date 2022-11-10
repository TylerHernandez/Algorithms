import java.util.ArrayList;

public class Graph {

    ArrayList<Vertex> vertices;
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

        if (id > this.highestIdFound){
            this.highestIdFound = id;
        }

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

    // Looks at all vertices and edges inside this graph, and returns a matrix representation.
    public int[][] createMatrix(){
        // Retrieve the highest number vertexId found.

        int[][] matrix = new int[this.highestIdFound + 1][this.highestIdFound + 1];
        
        // This helps display the coordinate location.
        for (int i=0; i<matrix.length; i++){
            matrix[0][i] = i;
            matrix[i][0] = i;
        }

        // Grab each vertex associated with each other and set their coordinates to 1.
        for (Vertex v : this.vertices){
            int vertexId = v.getId();

            for (int neighborId : v.getNeighbors()){
                matrix[vertexId][neighborId] = 1;
                matrix[neighborId][vertexId] = 1;
            }
        }

        return matrix;
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
