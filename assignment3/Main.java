import java.util.Random;
import java.util.Arrays;

class Main {

    public static int linearCounter;
    public static int binaryCounter;

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
        String[] randomAddresses = new String[42];
        Random rand = new Random();
        for (int i = 0; i < 42; i++) {
            randomAddresses[i] = ORIGINAL_TEXT[rand.nextInt(0, ORIGINAL_TEXT.length)].toUpperCase();
        }

        // Linear search with our random addresses!
        for (int i = 0; i < randomAddresses.length; i++) {
            // Linear search for each address.
            linearSearch(randomAddresses[i], fullText);
        }

        // Binary search with our random addresses!
        for (int i = 0; i < randomAddresses.length; i++) {
            // Binary search for each address.
            binarySearch(randomAddresses[i], fullText, 0, fullText.length);
        }

        System.out.println("Linear Search Average: " + linearCounter / 42);
        System.out.println("Binary Search Average: " + binaryCounter / 42);

    }

    // Performs a linearSearch for a target string over a given array. Returns index
    // in array of where target is found.
    public static int linearSearch(String targetString, String[] givenArray) {
        int foundAddress = -1; // Initializes at -1 in case not found.

        for (int i = 0; i < givenArray.length; i++) {
            linearCounter++;

            if (givenArray[i].equals(targetString)) {
                foundAddress = i;
                break;
            }
        }
        return foundAddress;
    }

    // Performs a binary search for a target string over a given Array, considering
    // min and max bounds for our recursive calls to focus on. Returns index of
    // where targetString exists in array or -1 if not found.
    public static int binarySearch(String targetString, String[] givenArray, int minAddress, int maxAddress) {
        int foundAddress = -1; // Initializes at -1 in case not found.
        int midPoint = (int) ((minAddress + maxAddress) / 2);

        // left and right pointer have not crossed.
        if (minAddress <= maxAddress) {
            binaryCounter++;

            // Item found, end recursive calls.
            if (givenArray[midPoint].equals(targetString)) {
                binaryCounter++;
                foundAddress = midPoint;
            }

            // Not in this part of the array, narrow down array bounds by 1/2 (lowering the
            // cieling).
            else if (givenArray[midPoint].compareTo(targetString) > 0) {
                return binarySearch(targetString, givenArray, minAddress, midPoint - 1);
            }

            // Not in this part of the array, narrow down array bounds by 1/2 (increasing
            // the floor).
            else {
                return binarySearch(targetString, givenArray, midPoint + 1, maxAddress);
            }
        }
        return foundAddress;

    }

}