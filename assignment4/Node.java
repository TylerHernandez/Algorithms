
class Node {
    private Vertex vertex;
    private Node next;

    public Node(){
        vertex = null;
        next = null;
    }
    public Node(Vertex vertex) {
        this.vertex = vertex;
        this.next = null;
    }
    public Node(Vertex vertex, Node node) {
        this.vertex = vertex;
        this.next = node;
    }
    public void setVertex(Vertex vertex) {
        this.vertex = vertex;
    }
    public void setNext(Node node) {
        this.next = node;
    }
    public Vertex getVertex(){
        return this.vertex;
    }
    public Node getNext(){
        return this.next;
    }
    public String toString(){
        return "" + this.vertex.toString();
    }

}