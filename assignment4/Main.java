import java.util.ArrayList;
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
        ArrayList<Graph> graphs = new ArrayList<>();

        Graph g = new Graph();

        while (!reader.endOfFile) { // Until we've reached the end of the file.

            System.out.println(line);

            line = line.replaceAll("\n", "");

            words = line.split(" ");

            if (words[0].equals("--")){
                // Do nothing because this is a comment.
            }
            else if (words.length == 2){
                // Save previous graph to our list, if it was not the default graph.
                if (!g.isEmpty()){
                    graphs.add(g);
                }

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

        System.out.println("Graph 0- \n" + graphs.get(0));

        printMatrix(graphs.get(0).createMatrix());



    }

    public static void printMatrix(int[][] matrix){
        for (int i=0; i<matrix.length; i++){
            for(int x=0; x<matrix[i].length; x++){
                System.out.print(matrix[i][x]);
            }
            System.out.println();
        }
    }

}