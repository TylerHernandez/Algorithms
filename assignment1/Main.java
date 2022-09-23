class Main {
    public static void main(String[] args) throws Exception {
        // 12 Palindromes in test cases.
        Stack stack = new Stack();

        Queue queue = new Queue();

        Reader reader = new Reader("INSERT_DIRECTORY_HERE", 0);

        int i = 0; // Will hold char as an integer.

        // Holds each line 
        int[] line = reader.getNextLine();

        // Until i've reached the end of the file, keep looping
        while (i != -1) {

            // Loop through line, add each char to stack and queue.
            for (int x = 0; x < line.length; x++) {
                char ch = Character.toUpperCase((char) line[x]);
                if ((ch != ' ') && (ch != ',') && (ch != '.') && (ch != '\'') && (ch != '\n')) {
                    stack.push(new Node(ch));
                    queue.enqueue(new Node(ch));
                }

            }

            isPalindrome(stack, queue);

            // Reset queue and stack.
            queue = new Queue();
            stack = new Stack();

            // Grab the next line
            line = reader.getNextLine();
            i = line[0];

        } // ends while

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

        // String to print out if it is a palindrome.
        String str = "";

        for (int i = 0; i < length; i++) {
            str += queue.getHead().getData();

            // Compare each Node's data. If they do not match, return false.
            if (stack.pop().getData() != queue.dequeue().getData()) {
                return false;
            }
        }
        System.out.println(str);
        return true;
    }

}