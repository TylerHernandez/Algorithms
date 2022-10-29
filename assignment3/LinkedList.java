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

    public Node getHead() {
        return this.head;
    }

    // Finds a given node in our linked list and returns how many comparisons taken. Returns -1 if not found.
    public int findItem(String str){
        int comparisons = 0;
        boolean isFound = false;

        Node n = head; // grab our pointer to the head of the list.
        if (n == null){
            return -1;
        }

        // From head to tail, search the list for our desired item.
        while (n!= null){
            comparisons++;
            // If we find our desired node, flag isFound and break
            if (n.getData().equals(str)){
                isFound = true; 
                break;
            }

            n = n.getNext();
        }

        if (isFound) {
            return comparisons;
        }
        return -1;



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