public class Vertex {
    // This is pretty much a node class, with some extra stuff :)

    public String data;

    public int id;
    public int[] neighbors;
    public boolean isProcessed = false;

    public Vertex() {
        data = "";
    }

    public Vertex(String data) {
        this.data = data;
    }

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
    public int[] getNeighbors() {
        return this.neighbors;
    }

    public void addNeighbors(int neighborId) {
        // TODO.
    }

    public String toString() {
        return "" + this.data;
    }

}
