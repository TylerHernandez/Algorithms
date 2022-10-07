import java.util.Random;

class Main {

    static int quickCount = 0;
    static int selectionCount = 0;
    static int insertionCount = 0;
    static int mergeCount = 0;

    public static void main(String[] args) throws Exception {
        Reader reader = new Reader("assignment1/magicitems.txt");

        // Characters we will ignore when reading from the file.
        char[] ignoreList = { ' ', ',', '.', '\'', '-', '+' };

        // Holds each line
        char[] line = reader.getNextLineOfChars(ignoreList, true);

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

            char[] ORIGINAL_LINE = line;

            // These sorts will return the amount of comparisons they performed.

            // Insertion Sort!
            insertionCount += insertionSort(line);
            line = ORIGINAL_LINE;

            // Selection Sort!
            selectionCount += selectionSort(line);
            line = ORIGINAL_LINE;

            // Recursive functions in java are trickier when it comes to returning values,
            // soooo... global variables.

            // Merge Sort!
            mergeSort(line, 0, line.length - 1);
            line = ORIGINAL_LINE;

            // Quick Sort!
            // quickSort(line);
            // line = ORIGINAL_LINE;

            // Grab the next line
            line = reader.getNextLineOfChars(ignoreList, true);

        } // ends while

        System.out.println("Insertion sort: " + insertionCount);
        System.out.println("Selection sort: " + selectionCount);
        System.out.println("Merge sort: " + mergeCount);
        System.out.println("Quick sort: " + quickCount);

    }

    // Without Recursion
    public static int selectionSort(char[] line) {
        int recordedComparisons = 0;

        // loop over entire array with ptr1.
        for (int ptr1 = 0; ptr1 < line.length - 1; ptr1++) {
            recordedComparisons++; // (ptr1 < line.length - 1)

            // Retrieve index of the earliest alphabetical character in the subarray.
            int minimum = ptr1;
            for (int i = ptr1 + 1; i < line.length; i++) {
                if (line[i] < line[minimum]) {
                    minimum = i;
                }
                recordedComparisons += 2; // (i < line.length) and if statement.
            }

            // Swap the found minimum element with line[ptr1].
            char temp = line[minimum]; // record before writing over.
            line[minimum] = line[ptr1];
            line[ptr1] = temp;
        }
        // Utils.printArray(line);
        return recordedComparisons;
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
    public static void mergeSort(char[] array, int left, int right) {
        if (right <= left) {
            return; // base case. you know, in another language i'd be able to return any type and
                    // this would be a heck of a lot more convenient.
        }
        int mid = (left + right) / 2;
        mergeSort(array, left, mid);// divide in to left array
        mergeSort(array, mid + 1, right);// divide into right array
        merge(array, left, mid, right); // stitch arrays back together.
    }

    public static void merge(char[] array, int left, int mid, int right) {
        // Creating temporary subarrays
        char leftArray[] = new char[mid - left + 1];
        char rightArray[] = new char[right - mid];

        // Copying our subarrays into temporaries
        for (int i = 0; i < leftArray.length; i++) {
            leftArray[i] = array[left + i];
        }
        for (int i = 0; i < rightArray.length; i++) {
            rightArray[i] = array[mid + i + 1];
        }
        // Iterators containing current index of temp subarrays
        int leftIndex = 0;
        int rightIndex = 0;

        // Copying from leftArray and rightArray back into array
        for (int i = left; i < right + 1; i++) {
            // If there are still uncopied elements in R and L, copy minimum of the two
            if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                } else {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            } else if (leftIndex < leftArray.length) {
                // If all elements have been copied from rightArray, copy rest of leftArray
                array[i] = leftArray[leftIndex];
                leftIndex++;
            } else if (rightIndex < rightArray.length) {
                // If all elements have been copied from leftArray, copy rest of rightArray
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
        mergeCount++;
    }

    // Recursive quickSort: divide and conquer!
    public static void quickSort(char[] line, int left, int right) {
        int pivot;
        if (left < right) {

            quickCount++; // count this as a comparison (not sure if this is right)
            pivot = getPivot(line);
            quickSort(line, left, pivot - 1);
            quickSort(line, pivot + 1, right);
        }
    }

    // Select small amt of random indexes in list and get median. 
    public static int getPivot(char[] line) {
        int n = line.length;

        if (n <= 0) {
            return -1;
        } else if (n <= 3) { // n is between 1 and 3.
            // grab median of all 3.

            // grab the largest number.
            int max = line[0];
            int maxIndex = 0;

            if (line[1] > max) {
                max = line[1];
                maxIndex = 1;
            }
            if (line[2] > max) {
                max = line[2];
                maxIndex = 2;
            }

            // grab the smallest number.

            int min = line[0];
            int minIndex = 0;
            // 0, 3, 1

            if (line[1] < min) {
                min = line[1];
                minIndex = 1;
            }
            if (line[2] < min) {
                min = line[2];
                minIndex = 2;
            }

            // if largest is the smallest, return 1. all numbers are already sorted.
            if (minIndex == maxIndex) {
                return 1;
            } else {
                // deduce number that hasn't been grabbed, that is the median.
                if ((minIndex != 0) && (minIndex != 0))
                    return 0;
                if ((minIndex != 1) && (minIndex != 1))
                    return 1;
                if ((minIndex != 2) && (minIndex != 2))
                    return 2;
            }
        } else { // n > 3. Grab 3 and return the median's index in line[].

            int first = 0;
            int last = n - 1;
            Random rand = new Random();
            int random = rand.nextInt(1, n - 2);

            // Results will return 1, 2, or 3. Based on the first, second, and third
            // parameter given.
            int results = medianOfThree(line[first], line[last], line[random]);
            if (results == 1) {
                return first;
            } else if (results == 2) {
                return last;
            } else {
                return random;
            }
        }
        return 1;
    } // the fact that this function is constant time is hilarious... hopefully it'll be used for big arrays!

    // Returns indexes of parameters one, two, and three rather than the number
    // themselves.
    public static int medianOfThree(int one, int two, int three) {
        // 6 permutations with three numbers.

        if (one > two) {
            if (two > three) {
                return 2;
            } else if (one > three) {
                return 3;
            } else {
                return 1;
            }
        } else {
            if (one > three) {
                return 1;
            } else if (two > three) {
                return 3;
            } else {
                return 2;
            }
        }
    }

}