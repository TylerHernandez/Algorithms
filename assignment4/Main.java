import java.util.ArrayList;
public class Main {

    // Driver for Assignment 4.
    public static void main(String[] args) throws Exception {

        Reader reader = new Reader("./graphs1.txt");

        String line = reader.getNextLine();
        String[] words;
        ArrayList<Graph> graphs = new ArrayList<>();

        Graph g = new Graph(); // Initialize so our compiler will stop complaining.

        while (!reader.endOfFile) { // Until we've reached the end of the file.

            // System.out.println(line);

            // Take our next line of text and put each word into an array.
            line = line.replaceAll("\n", "");
            words = line.split(" ");

            // Now, we can determine which action to take strictly based on sentence length!

            if (words[0].equals("--")) {
                // Do nothing because this is a comment.
            }
            else if (words.length == 2) {
                // Save previous graph to our list, if it was not the default graph.
                if (!g.isEmpty()){
                    graphs.add(g);
                }

                // NEW GRAPH command
                g = new Graph();
            } else if (words.length == 3) {
                // ADD VERTEX (INT) command
                g.addVertex(Integer.parseInt(words[2])); 
            } else if (words.length == 5) {
                // ADD EDGE (INT) - (INT) command
                g.addEdge(Integer.parseInt(words[2]), Integer.parseInt(words[4]));
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

            //  display it's matrix!
            System.out.println("Matrix\n");
            printMatrix(graph.createMatrix());
            System.out.println("--------------------------------------------");

            // display it's adjacency list!
            System.out.println("Adjacency List\n");
            graph.printList();
            System.out.println("--------------------------------------------");

            // Depth First Search.
            System.out.println("Depth First Search\n");
            Graph.DFS(graph.vertices.get(0), graph); // Grab the first vertex held in our graph.
            System.out.println("--------------------------------------------");

            // Reset graph, since all of it's vertices have been processed.
            for (Vertex vertex : graph.vertices){
                vertex.isProcessed = false;
            }

            // Breadth First Search.
            System.out.println("Breadth First Search\n");
            Graph.BFS(graph.vertices.get(0), graph);
            System.out.println("--------------------------------------------");
            System.out.println("\n\n\n");


        }
        
        // Create a binary search tree!

    }




    public static void printMatrix(int[][] matrix) {    
        // This helps display the coordinate location.
        System.out.println();
        int length = matrix.length;

        System.out.print("x-");// Display top horizontal indices.
        for (int i=0; i<length; i++) {
            System.out.print(i + "-");
        }
        System.out.println();
        System.out.println("|");

        for (int i=0; i<length; i++) {
            System.out.print(i + "-"); // Display left-side vertical indices.
            for(int x=0; x<matrix[i].length; x++) {
                System.out.print(matrix[i][x] + "-");
            }
            System.out.println();
            System.out.println("|");
        }
        System.out.println();

    }

}