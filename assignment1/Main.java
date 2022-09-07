class Main {
    public static void main(String[] args) {
        // Creates Node Class
        Node firstNode = new Node();
        Node secondNode = new Node();
        Node thirdNode = new Node();
        Node fourthNode = new Node();
        firstNode.setData(5);
        secondNode.setData(10);
        thirdNode.setData(15);
        fourthNode.setData(20);
        firstNode.setNext(secondNode);
        secondNode.setNext(thirdNode);
        thirdNode.setNext(fourthNode);


        Stack stack = new Stack();

        // for(Node n = firstNode; n != null; n = n.getNext()) {
        //     stack.append(n);
        // }

        System.out.println(stack);


    }


}