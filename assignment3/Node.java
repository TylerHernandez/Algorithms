
class Node {
    private String data;
    private Node next;

    public Node(){
        data = "";
        next = null;
    }
    public Node(String data) {
        this.data = data;
        this.next = null;
    }
    public Node(String data, Node node) {
        this.data = data;
        this.next = node;
    }
    public void setData(String data) {
        this.data = data;
    }
    public void setNext(Node node) {
        this.next = node;
    }
    public String getData(){
        return this.data;
    }
    public Node getNext(){
        return this.next;
    }
    public String toString(){
        return "" + this.data;
    }

}