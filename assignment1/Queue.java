class Queue {

    private Node head;
    private Node tail;

    public Queue() {
        head = null;
        tail = head;
    }

    // Appends given node to tail.
    public void enqueue(Node node) {
        // First enqueue will have a null head and tail.
        if ((tail == null) && (head == null)) {
            head = node;
            tail = head;
        } else {
            tail.setNext(node);
            tail = node;
        }
    }

    // Removes head from linked list.
    public Node Dequeue() {
        // Holds head to be dequeued.
        Node temp = head;
        // Sets the new head to be the upcoming first element.
        head = head.getNext();
        return temp;
    }

    public boolean isEmpty() {
        if (head == null)
            return true;
        else
            return false;
    }

    public String toString() {
        String str = "Head- ";

        // Retrieves head to loop through queue without modifying it.
        Node tempNode = head;
        while (tempNode != null) {
            str += (tempNode + ", ");
            tempNode = tempNode.getNext();
        }
        return str + "- Tail";
    }
}