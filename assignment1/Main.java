// TODO: Import IO to read from files.

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



        Stack stack = new Stack();
        stack.push(firstNode);
        stack.push(secondNode);
        stack.push(thirdNode);
        stack.push(fourthNode);
        System.out.println(stack.pop());
        
        System.out.println(stack);

        System.out.println(stack.pop());

        System.out.println(stack);

    }


}