import java.util.Random; 

class QuickSort {

    static int quickCount = 0;

    // A utility function to swap two elements
    static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /*
     * This function takes last element as pivot, places
     * the pivot element at its correct position in sorted
     * array, and places all smaller (smaller than pivot)
     * to left of pivot and all greater elements to right
     * of pivot
     */
    static int partition(String[] arr, int low, int high) {

        // pivot
        String pivot = arr[getPivot(arr)];

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller
            // than the pivot
            if (arr[j].compareTo(pivot) <= 0) {
                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
            quickCount++;
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    /*
     * The main function that implements QuickSort
     * arr[] --> Array to be sorted,
     * low --> Starting index,
     * high --> Ending index
     */
    static void sort(String[] arr, int low, int high) {
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    // Select small amt of random indexes in list and get median.
    public static int getPivot(String[] line) {
        int n = line.length;

        if (n <= 0) {
            quickCount++;
            return -1;
        } else if (n <= 3) { // n is between 1 and 3.
            quickCount++;
            // grab median of all 3.

            // grab the latest alphabetical string
            String max = line[0];
            int maxIndex = 0;

            if (line[1].compareTo(max) > 0) {
                quickCount++;
                max = line[1];
                maxIndex = 1;
            }
            if (line[2].compareTo(max) > 0) {
                quickCount++;
                max = line[2];
                maxIndex = 2;
            }

            // grab the smallest number.

            String min = line[0];
            int minIndex = 0;
            // 0, 3, 1

            if (line[1].compareTo(min) < 0) {
                quickCount++;
                min = line[1];
                minIndex = 1;
            }
            if (line[2].compareTo(min) < 0) {
                quickCount++;
                min = line[2];
                minIndex = 2;
            }

            // if largest is the smallest, return 1. all numbers are already sorted.
            if (minIndex == maxIndex) {
                quickCount++;
                return 1;
            } else {
                quickCount++;
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
    } // the fact that this function is constant time is hilarious... hopefully
      // itll
      // be used for big arrays!

    // Returns indexes of parameters one, two, and three rather than the number
    // themselves.
    public static int medianOfThree(String one, String two, String three) {
        // 6 permutations with three numbers.

        if (one.compareTo(two) > 0) {
            if (two.compareTo(three) >= 0) {
                return 2;
            } else if (one.compareTo(three) >= 0) {
                return 3;
            } else {
                return 1;
            }
        } else {
            if (one.compareTo(three) >= 0) {
                return 1;
            } else if (two.compareTo(three) >= 0) {
                return 3;
            } else {
                return 2;
            }
        }
    }

}