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

    // Adds link to list of links in vertex, then returns it for graph's list.
    public Link addLink(int neighborId, int weight) {
        Link link = new Link(this.id, weight, neighborId);
        this.links.add(link);
        return link;
    }

    public String toString() {
        return "      Links:" + this.links;
    }

}
