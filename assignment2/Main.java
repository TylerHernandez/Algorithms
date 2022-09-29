class Main {

    public static void main(String[] args) throws Exception {
        Reader reader = new Reader("assignment1/magicitems.txt");

        int quickCount = 0;
        int selectionCount = 0;
        int insertionCount = 0;
        int mergeCount = 0;

        int i = 0; // Will hold char as an integer.

        // Holds each line
        int[] line = reader.getNextLine();

        // Until i've reached the end of the file, keep looping
        while (i != -1) {

            // Each sorting method does not save the value into line.
            // And each sort will return the amount of comparisons it performed.


            quickCount += quickSort(line);
            selectionCount += selectionSort(line);
            insertionCount += insertionSort(line);
            mergeCount += mergeSort(line);


            // Grab the next line
            line = reader.getNextLine();
            i = line[0];

        } // ends while

        System.out.println("Quick sort: " + quickCount);
        System.out.println("Selection sort: " + selectionCount);
        System.out.println("Insertion sort: " + insertionCount);
        System.out.println("Merge sort: " + mergeCount);
        

    }

    public static int quickSort(int[] line) {
        return 1;
    }

    public static int selectionSort(int[] line) {
        return 1;
    }

    public static int insertionSort(int[] line) {
        return 1;
    }

    public static int mergeSort(int[] line) {
        return 1;
    }

}