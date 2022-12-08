import java.util.ArrayList;

public class Vertex {

    public String data;

    public int id;
    private ArrayList<Link> links;
    public boolean isProcessed = false;

    public Vertex(int id) {
        data = "";
        this.id = id;
        this.links = new ArrayList<>();
    }

    // ID.
    public int getId() {
        return this.id;
    }

    // Links.
    public ArrayList<Link> getLinks() {
        return this.links;
    }

    public void addLink(int neighborId, int weight) {
        this.links.add(new Link(weight, neighborId));
    }

    public String toString() {
        return "      Links:" + this.links;
    }

}
