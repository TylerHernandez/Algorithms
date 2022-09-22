
class Node {
    private char data;
    private Node next;

    public Node(){
        data = 0;
        next = null;
    }
    public Node(char data) {
        this.data = data;
        this.next = null;
    }
    public Node(char data, Node node) {
        this.data = data;
        this.next = node;
    }
    public void setData(char data) {
        this.data = data;
    }
    public void setNext(Node node) {
        this.next = node;
    }
    public char getData(){
        return this.data;
    }
    public Node getNext(){
        return this.next;
    }
    public String toString(){
        return "" + this.data;
    }

}