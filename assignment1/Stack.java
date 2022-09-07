
class Stack {

    private Node first_node;
    private int index;

    public Stack(){
        Node first_node = new Node();
    }

    public Node pop(){
        // Carry current and next node.
        Node current_node = first_node;
        Node next_node = first_node.getNext();

        // Stops at last two nodes.
        while (next_node.getNext() != null){
            current_node = current_node.getNext();
            next_node = next_node.getNext();
        }

        // Remove going to pop node from linked list.
        current_node.setNext(null);
        return next_node;
    }


    // public void append(Node n){
    // }

    public boolean isEmpty(){
        if(first_node == null)
            return true;
        else
            return false;
    }

    // public String toString() {
    //     for (Node x : list) {
    //         System.out.println(x);
    //     }
    //     return "/";
    // }

}