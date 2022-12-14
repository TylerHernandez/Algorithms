import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("\n\n");

        Reader reader = new Reader("./final-project-text-file.txt");

        String line = reader.getNextLine();
        String[] words;

        ArrayList<Resident> clients = new ArrayList<>();
        ArrayList<Resident> allResidents = new ArrayList<>();
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
            // Utils.printArray(words);

            if (words.length == 0) {
                // Blank line.
            } else if (words[0].equals("--")) {
                // Do nothing because this is a comment.
            } else if (words[0].equals("CONFIG")) {
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
                Resident r = new Resident(id, preferences);
                clients.add(r);
                allResidents.add(r);
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

        // Give preference to clients who do not have a lot of options.
        // Order clients by their preference sizes.
        Comparator<Resident> residentWithLeastPreferences = new Comparator<Resident>() {
            @Override
            public int compare(Resident r1, Resident r2) {
                return r2.compareTo(r1);
            }
        };

        // Give preference to hospitals with the most space.
        Comparator<Hospital> hospitalWithMostSpace = new Comparator<Hospital>() {
            @Override
            public int compare(Hospital h1, Hospital h2) {
                return h2.compareTo(h1);
            }
        };

        // Fill in clients needs with hospitals that have the most space.
        clients.sort(residentWithLeastPreferences);
        hospitals.sort(hospitalWithMostSpace);

        // Now, start matching our clients
        while (clients.size() > 0) {

            Resident currentClient = clients.remove(0);

            Hospital matchedHospital = new Hospital("fake", 0, null);

            // Look to match this client.
            outerloop: for (String preference : currentClient.preferences) {
                for (Hospital hospital : hospitals) {

                    if (preference.equals(hospital.id)) {
                        System.out.println("Matching resident " + currentClient.id + " to " + hospital.id);
                        matchedHospital = hospital;
                        matchedHospital.residents.add(currentClient.id);
                        break outerloop;
                    }
                }
            }

            // After each match, check our hospital slots to see where we can fit people.

            clients.sort(residentWithLeastPreferences);
            hospitals.sort(hospitalWithMostSpace);

            // if matched hospital is full, look through all clients and remove this
            // preference from their list.
            System.out.println("\n\n");
            printAllHospitals(hospitals);

            if (!matchedHospital.id.equals("fake")) {
                if (matchedHospital.allowedResidents == matchedHospital.residents.size()) {
                    // Hospital is full, remove this from all clients preferences.
                    for (Resident client : clients) {
                        if (client.preferences.contains(matchedHospital.id)) {
                            client.preferences.remove(matchedHospital.id);
                        }
                    }
                }
            } else {
                System.out.println("Error- no match was found for resident " + currentClient);
                printAllHospitals(hospitals);
            }

        } // Ends while loop.

        System.out.println("\n\n");
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