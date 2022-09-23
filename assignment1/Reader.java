/*
 * Referenced the following link: https://www.geeksforgeeks.org/different-ways-reading-text-file-java/
 */

import java.io.FileReader;
import java.io.IOException;
import java.lang.Exception;

public class Reader {

    FileReader reader;
    int index;

    public Reader(String fileLocation) throws Exception {
        reader = new FileReader(Utils.DIRECTORY + fileLocation);
    }

    public Reader(String fileLocation, int num) throws Exception {
        reader = new FileReader(fileLocation);
    }

    public void printAll() throws IOException {
        int i;
        while ((i = reader.read()) != -1) {
            System.out.print((char) i);
        }
    }

    public int getNextChar() throws IOException {
        return reader.read();
    }

    public int[] getNextLine() throws IOException {
        int[] line = new int[0];

        int i = 0;
        while ((char) i != '\n') {

            i = getNextChar();
            line = Utils.expandArrayByOne(line);
            line[line.length - 1] = i;

            if (i == -1) {
                break;
            }
        }
        return line;
    }

}
