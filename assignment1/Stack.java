
class Stack {

    private Node head;
    public int length;

    public Stack() {
        head = null;
        length = 0;
    }

    // Appends a node to the stack.
    public void push(Node n) {
        n.setNext(head);
        head = n;
        length++;
    }

    // Removes and returns a node from the stack.
    public Node pop() {
        // Retrieve the head as local var, then update global var to the new head.
        Node n = head;
        if (head != null) {
            head = head.getNext();
            length--;
        } else {
            System.out.println("Stack is empty");
        }
        return n;
    }

    // Checks if there are any nodes in the stack.
    public boolean isEmpty() {
        if (head == null)
            return true;
        else
            return false;
    }

    public String toString() {
        String str = "Head- ";

        // Retrieves head to loop through stack without modifying it.
        Node tempNode = head;

        while (tempNode != null) {
            str += (tempNode + ", ");
            tempNode = tempNode.getNext();
        }
        return str + "- Tail";
    }

}