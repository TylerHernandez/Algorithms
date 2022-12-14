import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("\n\n");

        // do stuff.

        Reader reader = new Reader("./final-project-text-file.txt");

        String line = reader.getNextLine();
        String[] words;

        ArrayList<Resident> clients = new ArrayList<>();
        ArrayList<Hospital> hospitals = new ArrayList<>();

        // Flag to make sure while loop runs one time after reader flags end of file
        boolean readingLastLine = false;

        while (!readingLastLine) { // Until we've reached the end of the file.

            if (reader.endOfFile) {
                readingLastLine = true; // We've reached end of file, we can stop looping.
            }

            line = line.replaceAll("\n", "");
            line = line.replaceAll(":", "");
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
            } else if (words[0].contains("R")) {
                // resident insertion.

                String id = words[0];

                // Gather all preferences in a list.
                ArrayList<String> preferences = new ArrayList<>();
                for (int i = 1; i < words.length; i++) {
                    preferences.add(words[i]);
                }

                // Add the client... who is also a resident... but if they don't have a hospital
                // are they residents??
                clients.add(new Resident(id, preferences));
            } else if (words[0].contains("H")) {

                String id = words[0];

                int allowedResidents = Integer.parseInt(words[1]);

                // Gather all preferences in a list.
                ArrayList<String> preferences = new ArrayList<>();
                for (int i = 3; i < words.length; i++) {
                    preferences.add(words[i]);
                }

                hospitals.add(new Hospital(id, allowedResidents, preferences));

            } else {
                System.out.println("Error reading words: ");
                Utils.printArray(words);
            }

            // Grab the next line so we can keep going!
            line = reader.getNextLine();
        } // end of while.

        printAllResidents(clients);
        printAllHospitals(hospitals);

        System.out.println("\n\n");
    }

    public int calculateHappinessScore() {
        // TODO.
        return 1;
    }

    // Helper functions for printing hospitals and residents.
    public static void printAllHospitals(ArrayList<Hospital> hospitals) {
        for (Hospital h : hospitals) {
            System.out.println(h);
        }
    }

    public static void printAllResidents(ArrayList<Resident> residents) {
        for (Resident r : residents) {
            System.out.println(r);
        }
    }

}