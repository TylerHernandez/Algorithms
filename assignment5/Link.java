// Wrapper for weight + neighbor link.
public class Link {

    public int weight;
    public int neighborId;

    public Link(int weight, int neighborId) {
        this.weight = weight;
        this.neighborId = neighborId;
    }

    public String toString() {
        return ("--" + this.weight + "-->" + this.neighborId);
    }

}