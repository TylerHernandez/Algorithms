// I do not take credit for this sorting algorithm, this was found on https://www.geeksforgeeks.org/merge-sort/
// I am merely using it to count comparisons for an assignment.

class MergeSort {
    // Merges two subarrays of arr[].
    // First subarray is arr[left..mid]
    // Second subarray is arr[mid+1..right]
    int mergeCount = 0;

    // I was having trouble retaining mergeCount in the main class with these recursive functions. I speculate it having to do with
    // it's static type. Regardless, dragging it into this class allowed it to update properly.
    
    void merge(String arr[], int left, int m, int right) {
        // Find sizes of two subarrays to be merged
        int n1 = m - left + 1;
        int n2 = right - m;

        /* Create temp arrays */
        String LeftArray[] = new String[n1];
        String RightArray[] = new String[n2];

        /* Copy data to temp arrays */
        for (int i = 0; i < n1; ++i)
            LeftArray[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            RightArray[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = left;
        while (i < n1 && j < n2) {
            if (LeftArray[i].compareTo(RightArray[j]) <= 0) {
                arr[k] = LeftArray[i];
                i++;
            } else {
                arr[k] = RightArray[j];
                j++;
            }
            k++;
            mergeCount++;
        }

        /* Copy remaining elements of LeftArray[] if any */
        while (i < n1) {
            arr[k] = LeftArray[i];
            i++;
            k++;
        }

        /* Copy remaining elements of RightArray[] if any */
        while (j < n2) {
            arr[k] = RightArray[j];
            j++;
            k++;
        }
    }

    // Recursive merge sort: Also, divide and conquer!
    void sort(String arr[], int left, int right) {
        if (left < right) {
            mergeCount++;
            // Find the middle point
            int mid = left + (right - left) / 2;

            // Sort each half
            sort(arr, left, mid); // divide in to left array
            sort(arr, mid + 1, right); // divide into right array

            merge(arr, left, mid, right); // stitch arrays back together.
        }
    }

}