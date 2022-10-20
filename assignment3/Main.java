import java.util.Random;
import java.util.Arrays;

class Main {

    // Driver for Assignment 3.
    public static void main(String[] args) throws Exception {
        Reader reader = new Reader("./magicitems.txt");

        // Characters we will ignore when reading from the file.
        char[] ignoreList = {};

        // Holds each char of a line
        char[] line = reader.getNextLineOfChars(ignoreList, true);

        // Holds each line as a string
        String[] fullText = new String[0]; // Start the array at 0 length in case given an empty list.

        // Until we've reached the end of the file, keep adding each line to our array.
        // Even empty lines in the file will have at least a '\n' character.
        while (line.length > 0) {
            // Though, we must ignore '\n' characters manually in order to keep looping
            // based on if there is a character in the next line.
            if (line[line.length - 1] == '\n') {
                // it seems that '\n' characters only show up at the end of the array (and not
                // in the last line).
                line = Utils.removeLastElementOfArray(line);
            }

            // Expand array by one every time we add a new value to it.
            fullText = Utils.expandArrayByOne(fullText);
            // Takes line of characters and puts them into fullText as a concatted string.
            fullText[fullText.length - 1] = String.valueOf(line);

            // Grab the next line
            line = reader.getNextLineOfChars(ignoreList, true);
        } // ends while

        // Unsorted Original Text.
        String[] ORIGINAL_TEXT = fullText;

        // Sort fullText.
        Arrays.sort(fullText);

        // Pick 42 random addresses in magicitems.txt
        int[] randomAddresses = new int[42];
        Random rand = new Random();
        for (int i = 0; i < 42; i++) {
            randomAddresses[i] = rand.nextInt(0, ORIGINAL_TEXT.length);
        }

        int linearSearchCounter = 0;

        // Loop over randomAddresses and plug each into a linear search.
        for (int i = 0; i < randomAddresses.length; i++) {
            // Linear search for each address.
            linearSearchCounter += linearSearch(randomAddresses[i], fullText);
        }

        System.out.println(linearSearchCounter / 42);

        int binarySearchCounter = 0;

        // Loop over randomAddresses and plug each into a linear search.
        //for (int i = 0; i < randomAddresses.length; i++) {
        // Linear search for each address.
        binarySearchCounter += binarySearch(83, fullText, 0, fullText.length, 0);
       // }

        System.out.println(binarySearchCounter / 42);

    }

    // Performs a linearSearch for a givenAddress over a givenArray. Returns number
    // of comparisons.
    public static int linearSearch(int givenAddress, String[] givenArray) {
        int counter = 0;
        for (int i = 0; i < givenArray.length; i++) {
            if (i == givenAddress) {
                break;
            }
            counter++;
        }
        return counter;
    }

    // Performs a binary search for a given Address over a given Array, considering
    // min and max bounds for our recursive calls to focus on. Returns number of
    // comparisons taken.
    public static int binarySearch(int givenAddress, String[] givenArray, int minAddress, int maxAddress, int counter) {
        System.out.println("iteration-");
        int midPoint = (int) Math.floor((minAddress + maxAddress / 2));
        System.out.println(counter);

        // left and right pointer have not intersected.
        if (minAddress <= maxAddress) {
            counter++;

            // Item found, end recursive calls.
            if (givenAddress == midPoint) {
                return counter;
            }

            // Not in this part of the array, narrow down array bounds by 1/2 (lowering the
            // cieling).
            else if (givenAddress < midPoint) {
                counter++;
                return binarySearch(givenAddress, givenArray, minAddress, midPoint - 1, counter);
            }

            // Not in this part of the array, narrow down array bounds by 1/2 (increasing
            // the floor).
            else {
                return binarySearch(givenAddress, givenArray, midPoint - 1, maxAddress, counter);
            }
        } else {
            System.out.println("Item was not found. Took " + counter + " comparisons.");
            return counter;
        }

    }

}