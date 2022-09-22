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

    public void printAll() throws IOException {
        int i;
        while ((i = reader.read()) != -1) {
            System.out.print((char)i);
        }
    }

    public int getNextChar() throws IOException {
        return reader.read();
    }

}
