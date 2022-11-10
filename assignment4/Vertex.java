import java.util.ArrayList;

public class Vertex {

    public String data;

    public int id;
    private ArrayList<Integer> neighbors;
    public boolean isProcessed = false;

    public Vertex(int id) {
        data = "";
        this.id = id;
        this.neighbors = new ArrayList<>();
    }

    // Data.
    // public void setData(String data) {
    // this.data = data;
    // }

    // public String getData() {
    // return this.data;
    // }

    // ID.
    public int getId() {
        return this.id;
    }

    // Neighbors.
    public ArrayList<Integer> getNeighbors() {
        return this.neighbors;
    }

    public void addNeighbor(int neighborId) {
        // Do not add neighbors more than once.
        if (this.neighbors.contains(neighborId)) {
            return;
        }
        this.neighbors.add(neighborId);
    }

    public String toString() {
        return "" + this.data;
    }

}
