class LinkedList {

    private Node head;
    private Node tail;
    public int length;

    public LinkedList() {
        head = null;
        tail = head;
        length = 0;
    }

    // Appends given node to tail.
    public void append(Node node) {
        // First append will have a null head and tail.
        if ((tail == null) && (head == null)) {
            head = node;
            tail = head;
        } else {
            tail.setNext(node);
            tail = node;
        }
        length++;
    }

    // Removes head from linked list.
    public Node removeHead() {
        // Holds head to be dequeued.
        Node temp = head;
        // Sets the new head to be the upcoming first element.
        head = head.getNext();
        length--;
        return temp;
    }

    public boolean isEmpty() {
        if (length == 0)
            return true;
        else
            return false;
    }

    public Node findNode(Node n) {
        // TODO: implement function.
        return new Node();
    }

    public Node getHead() {
        return this.head;
    }

    public String toString() {
        String str = "Head- ";

        // Retrieves head to loop through LinkedList without modifying it.
        Node tempNode = head;
        while (tempNode != null) {
            str += (tempNode + ", ");
            tempNode = tempNode.getNext();
        }
        return str + "- Tail";
    }
}