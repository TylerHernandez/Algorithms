import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("\n\n");

        // do stuff.

        Reader reader = new Reader("./final-project-text-file.txt");

        String line = reader.getNextLine();
        String[] words;

        // Flag to make sure while loop runs one time after reader flags end of file
        boolean readingLastLine = false;

        while (!readingLastLine) { // Until we've reached the end of the file.

            if (reader.endOfFile) {
                readingLastLine = true; // We've reached end of file, we can stop looping.
            }

            line = line.replaceAll("\n", "");
            line = line.toUpperCase();

            // Remove all extra white spaces.
            while (line.contains("  ")) {
                line = line.replaceAll("  ", " ");
            }

            // Take our line of text and put each word into an array.
            words = line.split(" ");
            Utils.printArray(words);

            if (words.length == 0) {
                // Blank line.
            } else if (words[0].equals("--")) {
                // Do nothing because this is a comment.
            } else if (words[0].equals("CONFIG:")) {
                // words[1] = number of residents, words[2] = number of hospitals.
            } else if (words[0].contains("r")) {
                // resident insertion.
            } else if (words[0].contains("h")) {
                // hospital insertion.
            }

            // Grab the next line so we can keep going!
            line = reader.getNextLine();
        } // end of while.

        System.out.println("\n\n");
    }

}