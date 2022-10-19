
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

        String[] ORIGINAL_TEXT = fullText;

        


    }
}