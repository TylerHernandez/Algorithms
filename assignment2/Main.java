class Main {

    public static void main(String[] args) throws Exception {
        Reader reader = new Reader("assignment1/magicitems.txt");

        // Characters we will ignore when reading from the file.
        char[] ignoreList = { ' ', ',', '.', '\'' };

        int quickCount = 0;
        int selectionCount = 0;
        int insertionCount = 0;
        int mergeCount = 0;

        // Holds each line
        char[] line = reader.getNextLineOfChars(ignoreList, true);

        // Until i've reached the end of the file, keep looping.
        // Even empty lines in the file will have at least a '\n' character.
        while (line.length > 0) {
            // Though, we must ignore '\n' characters manually in order to keep looping
            // based on if there is a character in the next line.
            if (line[line.length - 1] == '\n') {
                // it seems that '\n' characters only show up at the end of the array (and not
                // in the last line).
                line = Utils.removeLastElementOfArray(line);
            }

            printArray(line);
            // Each sorting method does not save the value into line.
            // And each sort will return the amount of comparisons it performed.

            quickCount += quickSort(line);
            selectionCount += selectionSort(line);
            insertionCount += insertionSort(line);
            mergeCount += mergeSort(line);

            // Grab the next line
            line = reader.getNextLineOfChars(ignoreList, true);

        } // ends while

        System.out.println("Quick sort: " + quickCount);
        System.out.println("Selection sort: " + selectionCount);
        System.out.println("Insertion sort: " + insertionCount);
        System.out.println("Merge sort: " + mergeCount);

    }

    // Recursive quickSort: divide and conquer!
    public static int quickSort(char[] line) {
        return 1;
    }

    // Without Recursion
    public static int selectionSort(char[] line) {
        return 1;
    }

    // Insertion Sort! (does not use recursion).
    public static int insertionSort(char[] line) {
        int recordedComparisons = 0;
        for (int ptr1 = 1; ptr1 < line.length; ptr1++) { // we do not need to compare the first index.
            recordedComparisons++; // one comparison (ptr1 < line.length).
            char key = line[ptr1]; // record our character to copy over.
            int ptr2 = ptr1 - 1;

            // Moves over every character greater than our key by one.
            while (ptr2 >= 0 && line[ptr2] > key) { // this counts as two comparisons.
                recordedComparisons += 2;
                line[ptr2 + 1] = line[ptr2];
                ptr2--;
            }
            line[ptr2 + 1] = key; // paste over (insert) our recorded character.
        }
        return recordedComparisons;
    }

    // Recursive merge sort: Also, divide and conquer!
    public static int mergeSort(char[] line) {
        return 1;
    }

    // I kept wanting to see the output of the array to make sure it was sorted and
    // kept getting
    // "[I@18b4aac2", hence the creation of this function.
    public static void printArray(int[] array) {
        System.out.print("[ ");
        for (int i = 0; i < array.length; i++) {
            System.out.print((char) array[i] + ", ");
        }
        System.out.println("]");
        System.out.println();
    }

    public static void printArray(char[] array) {
        System.out.print("[ ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println("]");
        System.out.println();
    }

}