import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    // Driver for Assignment 5.
    public static void main(String[] args) throws Exception {

        Reader reader = new Reader("./graphs2.txt");

        String line = reader.getNextLine();
        String[] words;
        ArrayList<Graph> graphs = new ArrayList<>();

        Graph g = new Graph(); // Initialize so our compiler will stop complaining.

        // Flag to make sure while loop runs one time after reader flags end of file
        boolean readingLastLine = false;

        while (!readingLastLine) { // Until we've reached the end of the file.

            if (reader.endOfFile) {
                readingLastLine = true; // We've reached end of file, we can stop looping.
            }
            // System.out.println(line);

            // Take our next line of text and put each word into an array.
            line = line.replaceAll("\n", "");
            line = line.replaceAll("  ", " "); // Nice try, professor.
            words = line.split(" ");

            // Now, we can determine which action to take strictly based on sentence length!

            if (words.length == 0) {
                // Blank line.
            } else if (words[0].equals("--")) {
                // Do nothing because this is a comment.
            } else if (words.length == 2) {
                // Save previous graph to our list, if it was not the default graph.
                if (!g.isEmpty()) {
                    graphs.add(g);
                }

                // NEW GRAPH command
                g = new Graph();
            } else if (words.length == 3) {
                // ADD VERTEX (INT) command
                g.addVertex(Integer.parseInt(words[2]));
            } else if (words.length == 6) {
                // ADD EDGE (INT) - (INT) (WEIGHT) command
                g.addEdge(Integer.parseInt(words[2]), Integer.parseInt(words[4]), Integer.parseInt(words[5]));
            }

            // Grab the next line so we can keep going!
            line = reader.getNextLine();
        } // end of while.

        // Since the final graph never reaches our 'save' in while loop.
        graphs.add(g);

        // For each graph,
        for (Graph graph : graphs) {
            System.out.println("--------------------------------------------");
            System.out.println("GRAPH: ");

            // display it's adjacency list!
            System.out.println("Adjacency List\n");
            graph.printList();
            System.out.println("--------------------------------------------");
            int[] distances = SSSP(graph, 1);

            for (int i = 0; i < distances.length; i++) {
                System.out.println("1 -> " + (i + 1) + " cost is " + distances[i]);
            }

            System.out.println("\n");

        }
        System.out.println("\n\n\n");

        // Part 2: Spice.txt
        ArrayList<Spice> spices = new ArrayList<>(); // will hold all spices.
        ArrayList<Integer> commands = new ArrayList<>();

        // First, read in all spices into spices arraylist and gather all 'knapsack
        // capacity' commands.
        reader = new Reader("./spice.txt");
        line = reader.getNextLine();
        readingLastLine = false; // reset flag from previous use.
        while (!readingLastLine) { // Until we've reached the end of the file.

            if (reader.endOfFile) {
                readingLastLine = true; // We've reached end of file, we can stop looping.
            }

            line = line.replaceAll("\n", "");
            line = line.replaceAll(";", ""); // gets rid of those semicolons.
            line = line.replaceAll("  ", " "); // There's a lot of double
            line = line.replaceAll("  ", " "); // spaces we need to get
            line = line.replaceAll("  ", " "); // rid of :)
            line = line.replaceAll("  ", " "); // ... and this ones for good luck.
            words = line.split(" ");

            if (words.length == 0) {
                // Blank line.
            } else if (words[0].equals("--")) {
                // Do nothing because this is a comment.
            } else if (words.length == 4) {
                // Declaring commands here.
                // Knapsack capacity = (int) command.
                commands.add(Integer.parseInt(words[3]));
            } else if (words.length == 10) {
                // Declaring spices here.
                // 3 : (name), 6 : (price), 9 : (quantity).
                spices.add(new Spice(words[3], words[6], words[9]));
            }

            line = reader.getNextLine();
        }

        // For each command (quantity), run our fractionalKnapsack algorithm.
        for (int command : commands) {
            Spice[] bag = fractionalKnapsack(spices, command);
            printSpices(bag);
        }

    }

    public static void printSpices(Spice[] spices) {
        System.out.println();
        System.out.print("[");
        for (Spice spice : spices) {
            System.out.print(spice + ", ");
        }
        System.out.println("]");
        System.out.println();
    }

    // Sort by the highest value per unit and take them in that order.
    public static Spice[] fractionalKnapsack(ArrayList<Spice> spices, int quantity) {

        // Comparator for comparing spices by unit price.
        Comparator<Spice> compareByUnitPrice = new Comparator<Spice>() {
            @Override
            public int compare(Spice spice1, Spice spice2) {
                return spice2.compareTo(spice1);
            }
        };

        // Sort spices by unit price.
        Collections.sort(spices, compareByUnitPrice);

        // Initialize bag to be quantity length
        Spice[] myBag = new Spice[quantity];
        int counter = 0; // Counter to place spices in order of value and prevent out of bounds
                         // exception.

        // Loop through spices and grab the first 'quantity' many.
        for (Spice spice : spices) {
            if (counter == quantity) {
                break;
            } else {

                // Keep appending this spice until it either runs out or we don't have anymore
                // space.
                double spiceQuantity = spice.quantity;
                while ((spiceQuantity > 0) && (counter < quantity)) {

                    spiceQuantity -= 1;
                    myBag[counter] = spice;
                    counter++;
                }

            }
        }

        return myBag;

    }

    // This is not my algorithm, I am using it for this assignment's purpose and
    // have modified it for my better understanding and to match my data set.
    // Here is the original source:
    // https://www.geeksforgeeks.org/bellman-ford-algorithm-dp-23/
    public static int[] SSSP(Graph graph, int src) {
        // Grab the length of our vertices and links to know how many options we have at
        // a given moment.
        int lengthOfVerticesList = graph.vertices.size();
        int lengthOfLinksList = graph.links.size();
        int dist[] = new int[lengthOfVerticesList];

        // First, set the distance from source to every other vertices as
        // Integer.MAX_VALUE so we don't blindly choose an unexplored path.
        for (int i = 0; i < lengthOfVerticesList; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[src - 1] = 0;

        // Next, check each edge's weight to find the single shortest path.
        for (int i = 1; i < lengthOfVerticesList; i++) {
            for (int j = 0; j < lengthOfLinksList; j++) {
                int u = graph.links.get(j).sourceId - 1;
                int v = graph.links.get(j).destinationId - 1;
                int weight = graph.links.get(j).weight;
                if (dist[u] != Integer.MAX_VALUE
                        && dist[u] + weight < dist[v])
                    dist[v] = dist[u] + weight;
            }
        }

        // Lastly, we need to ensure a negative weight cycle is not found or else we
        // will infinitely find "shorter" paths every time.
        for (int j = 0; j < lengthOfLinksList; j++) {
            int u = graph.links.get(j).sourceId - 1;
            int v = graph.links.get(j).destinationId - 1;
            int weight = graph.links.get(j).weight;
            if (dist[u] != Integer.MAX_VALUE
                    && dist[u] + weight < dist[v]) {
                System.out.println(
                        "Error: Graph contains negative weight cycle");
                return dist;
            }
        }
        return dist;
    }

    public static void printMatrix(int[][] matrix) {
        // This helps display the coordinate location.
        System.out.println();
        int length = matrix.length;

        System.out.print("x-");// Display top horizontal indices.
        for (int i = 0; i < length; i++) {
            System.out.print(i + "-");
        }
        System.out.println();
        System.out.println("|");

        for (int i = 0; i < length; i++) {
            System.out.print(i + "-"); // Display left-side vertical indices.
            for (int x = 0; x < matrix[i].length; x++) {
                System.out.print(matrix[i][x] + "-");
            }
            System.out.println();
            System.out.println("|");
        }
        System.out.println();

    }

}
