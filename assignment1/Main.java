// TODO: Import IO to read from files.

class Main {
    public static void main(String[] args) throws Exception {
        // 12 Palindromes in test cases.
        Stack stack = new Stack();

        Queue queue = new Queue();

        Reader reader = new Reader("assignment1/magicitems.txt");

        int palindromesFound = 0;
        int i; // Will hold char as an integer.
        while ((i = reader.getNextChar()) != -1) {
            char ch = Character.toUpperCase((char) i);

            if (ch == '\n') { // new line detected, start the comparison.
                System.out.println(stack);

                if (isPalindrome(stack, queue)) {
                    palindromesFound++;
                }

                queue = new Queue();
                stack = new Stack();

            } else if ((ch != ' ') || (ch != ',') || (ch != '.') || (ch != '\'')) { // if character is not a space, add it to the stack and queue.
                stack.push(new Node(ch));
                queue.enqueue(new Node(ch));
            } // Ends space not found.

        } // Ends while.

        System.out.println(palindromesFound);

    }

    public static Boolean isPalindrome(Stack stack, Queue queue) {
        // If both are empty, return true. If only one is empty, return false.
        if (stack.isEmpty() && queue.isEmpty()) {
            return true;
        } else if (stack.isEmpty() && !queue.isEmpty()) {
            return false;
        } else if (!stack.isEmpty() && queue.isEmpty()) {
            return false;
        }

        // Stack length is constantly changing, so record length first.
        int length = stack.length;

        for (int i = 0; i < length; i++) {
            // Compare each Node's data. If they do not match, return false.
            if (stack.pop().getData() != queue.Dequeue().getData()) {
                return false;
            }
        }
        return true;
    }

}