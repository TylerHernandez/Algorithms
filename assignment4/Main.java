
public class Main {

    // Driver for Assignment 4.
    public static void main(String[] args) throws Exception {

        // Graph g = new Graph();

        // g.addVertex(3);
        // g.addVertex(2);
        // g.addVertex(1);
        // g.addVertex(0);

        // g.addEdge(0, 1);
        // g.addEdge(1, 2);

        // System.out.println(g.findVertexById(1).getNeighbors());

        Reader reader = new Reader("./graphs1.txt");

        String line = reader.getNextLine();
        String[] words;

        Graph g = new Graph();

        while (!reader.endOfFile) { // Until we've reached the end of the file.


        System.out.println(line);

            words = line.split(" ");
            if (words[0].equals("--")){
                // Do nothing. This is a comment.
            }
            else if (words.length == 2){
                // NEW GRAPH
                g = new Graph();
            } else if (words.length == 3){
                // ADD VERTEX (INT)
                g.addVertex(Integer.parseInt(words[2])); 
            } else if (words.length == 5){
                // ADD EDGE (INT) - (INT)
                g.addEdge(Integer.parseInt(words[2]), Integer.parseInt(words[4]));
            }

            line = reader.getNextLine();
        }

    }

}