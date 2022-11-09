import java.util.ArrayList;

public class Vertex {
    // This is pretty much a node class, with some extra stuff :)

    public String data;

    public int id;
    private ArrayList<Integer> neighbors;
    public boolean isProcessed = false;

    // public Vertex() {
    // data = "";
    // }

    public Vertex(int id) {
        data = "";
        this.id = id;
        this.neighbors = new ArrayList<>();
    }

    // public Vertex(String data) {
    // this.data = data;
    // }

    // Data.
    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return this.data;
    }

    // ID.
    public int getId() {
        return this.id;
    }

    // Neighbors.
    public ArrayList<Integer> getNeighbors() {
        return this.neighbors;
    }

    public void addNeighbor(int neighborId) {
        // TODO: check if neighborId is already in this list.
        this.neighbors.add(neighborId);
    }

    public String toString() {
        return "" + this.data;
    }

}
