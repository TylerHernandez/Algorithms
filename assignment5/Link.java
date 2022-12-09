// Wrapper for weight + neighbor link.
public class Link {

    public int sourceId;
    public int weight;
    public int destinationId;

    public Link(int sourceId, int weight, int destinationId) {
        this.sourceId = sourceId;
        this.weight = weight;
        this.destinationId = destinationId;
    }

    public String toString() {
        return ("--(" + this.weight + ")-->" + this.destinationId);
    }

}