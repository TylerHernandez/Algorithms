
class Node {
    private int data;
    private Node next;

    public Node(){
        data = 0;
        next = null;
    }
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
    public Node(int data, Node node) {
        this.data = data;
        this.next = node;
    }
    public void setData(int data) {
        this.data = data;
    }
    public void setNext(Node node) {
        this.next = node;
    }
    public int getData(){
        return this.data;
    }
    public Node getNext(){
        return this.next;
    }
    public String toString(){
        return Integer.toString(this.data);
    }

}