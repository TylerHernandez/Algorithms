import java.util.Random;

class Main {

    static int quickCount = 0;
    static int selectionCount = 0;
    static int insertionCount = 0;

    public static void main(String[] args) throws Exception {
        Reader reader = new Reader("./magicitems.txt", 0);

        // Characters we will ignore when reading from the file.
        char[] ignoreList = { ' ', ',', '.', '\'', '-', '+' };

        // Holds each char of a line
        char[] line = reader.getNextLineOfChars(ignoreList, true);

        // Holds each line as a string
        String[] fullText = new String[0]; // Start the array at no length in case given an empty list.

        // Until we've reached the end of the file, keep looping.
        // Even empty lines in the file will have at least a '\n' character.
        while (line.length > 0) {
            // Though, we must ignore '\n' characters manually in order to keep looping
            // based on if there is a character in the next line.
            if (line[line.length - 1] == '\n') {
                // it seems that '\n' characters only show up at the end of the array (and not
                // in the last line).
                line = Utils.removeLastElementOfArray(line);
            }

            // Expand array by one everytime we add a new value to it.
            fullText = Utils.expandArrayByOne(fullText);
            // Takes line of characters and puts them into fullText as a concatted string.
            fullText[fullText.length - 1] = String.valueOf(line);

            // Grab the next line
            line = reader.getNextLineOfChars(ignoreList, true);

        } // ends while

        String[] ORIGINAL_TEXT = fullText;

        // These sorts will return the amount of comparisons they performed.

        // Insertion Sort!
        insertionCount += insertionSort(fullText);
        fullText = ORIGINAL_TEXT;

        // Selection Sort!
        selectionCount += selectionSort(fullText);
        fullText = ORIGINAL_TEXT;

        // Recursive functions in java are trickier when it comes to returning values,
        // soooo... global variables.

        // Merge Sort!
        MergeSort msort = new MergeSort();
        msort.sort(fullText, 0, fullText.length - 1);
        fullText = ORIGINAL_TEXT;

        // Quick Sort!
        QuickSort qsort = new QuickSort();
        qsort.sort(fullText, 0, fullText.length - 1);
        Utils.printArray(fullText);
        fullText = ORIGINAL_TEXT;

        System.out.println("Insertion sort: " + insertionCount);
        System.out.println("Selection sort: " + selectionCount);
        System.out.println("Merge sort: " + msort.mergeCount);
        System.out.println("Quick sort: " + qsort.quickCount);

    }

    // Without Recursion
    public static int selectionSort(String[] line) {
        int recordedComparisons = 0;

        // loop over entire array with ptr1.
        for (int ptr1 = 0; ptr1 < line.length - 1; ptr1++) {

            // Retrieve index of the earliest alphabetical character in the subarray.
            int minimum = ptr1;
            for (int i = ptr1 + 1; i < line.length; i++) {
                if (line[i].compareTo(line[minimum]) < 0) {
                    minimum = i;
                }
                recordedComparisons++;
            }

            // Swap the found minimum element with line[ptr1].
            String temp = line[minimum]; // record before writing over.
            line[minimum] = line[ptr1];
            line[ptr1] = temp;
        }
        return recordedComparisons;
    }

    // Insertion Sort! (does not use recursion).
    public static int insertionSort(String[] line) {
        int recordedComparisons = 0;
        for (int ptr1 = 1; ptr1 < line.length; ptr1++) { // we do not need to compare the first index.
            String key = line[ptr1]; // record our character to copy over.
            int ptr2 = ptr1 - 1;

            // Moves over every character greater than our key by one.
            while (ptr2 >= 0 && line[ptr2].compareTo(key) >= 0) { // this counts as two comparisons.
                recordedComparisons++;
                line[ptr2 + 1] = line[ptr2];
                ptr2--;
            }
            line[ptr2 + 1] = key; // paste over (insert) our recorded character.
        }
        return recordedComparisons;
    }

    // // Recursive quickSort: divide and conquer!
    // public static void quickSort(String[] line, int left, int right) {
    // int pivot;
    // if (left < right) {

    // quickCount++;
    // pivot = getPivot(line);
    // quickSort(line, left, pivot - 1);
    // quickSort(line, pivot + 1, right);
    // }
    // }

    // // Select small amt of random indexes in list and get median.
    // public static int getPivot(String[] line) {
    // int n = line.length;

    // if (n <= 0) {
    // quickCount++;
    // return -1;
    // } else if (n <= 3) { // n is between 1 and 3.
    // quickCount++;
    // // grab median of all 3.

    // // grab the latest alphabetical string
    // String max = line[0];
    // int maxIndex = 0;

    // if (line[1].compareTo(max) > 0) {
    // quickCount++;
    // max = line[1];
    // maxIndex = 1;
    // }
    // if (line[2].compareTo(max) > 0) {
    // quickCount++;
    // max = line[2];
    // maxIndex = 2;
    // }

    // // grab the smallest number.

    // String min = line[0];
    // int minIndex = 0;
    // // 0, 3, 1

    // if (line[1].compareTo(min) < 0) {
    // quickCount++;
    // min = line[1];
    // minIndex = 1;
    // }
    // if (line[2].compareTo(min) < 0) {
    // quickCount++;
    // min = line[2];
    // minIndex = 2;
    // }

    // // if largest is the smallest, return 1. all numbers are already sorted.
    // if (minIndex == maxIndex) {
    // quickCount++;
    // return 1;
    // } else {
    // quickCount++;
    // // deduce number that hasn't been grabbed, that is the median.
    // if ((minIndex != 0) && (minIndex != 0))
    // return 0;
    // if ((minIndex != 1) && (minIndex != 1))
    // return 1;
    // if ((minIndex != 2) && (minIndex != 2))
    // return 2;
    // }
    // } else { // n > 3. Grab 3 and return the median's index in line[].

    // int first = 0;
    // int last = n - 1;
    // Random rand = new Random();
    // int random = rand.nextInt(1, n - 2);

    // // Results will return 1, 2, or 3. Based on the first, second, and third
    // // parameter given.
    // int results = medianOfThree(line[first], line[last], line[random]);
    // if (results == 1) {
    // return first;
    // } else if (results == 2) {
    // return last;
    // } else {
    // return random;
    // }
    // }
    // return 1;
    // } // the fact that this function is constant time is hilarious... hopefully
    // it'll
    // // be used for big arrays!

    // // Returns indexes of parameters one, two, and three rather than the number
    // // themselves.
    // public static int medianOfThree(String one, String two, String three) {
    // // 6 permutations with three numbers.

    // if (one.compareTo(two) > 0) {
    // if (two.compareTo(three) > 0) {
    // return 2;
    // } else if (one.compareTo(three) > 0) {
    // return 3;
    // } else {
    // return 1;
    // }
    // } else {
    // if (one.compareTo(three) > 0) {
    // return 1;
    // } else if (two.compareTo(three) > 0) {
    // return 3;
    // } else {
    // return 2;
    // }
    // }
    // }

}