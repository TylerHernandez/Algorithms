/*
 * Referenced the following link: https://www.geeksforgeeks.org/different-ways-reading-text-file-java/
 */

import java.io.FileReader;
import java.io.IOException;
import java.lang.Exception;

public class Reader {

    FileReader reader;
    int index;
    boolean endOfFile = false;

    public Reader(String fileLocation, int num) throws Exception {
        reader = new FileReader(Utils.DIRECTORY + fileLocation);
    }

    public Reader(String fileLocation) throws Exception {
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

    public String getNextLine() throws IOException {
        String str = "";

        // Since we're checking if i is not -1, we cannot cast it to a char right away.
        int i = 0;
        while ((char) i != '\n') {

            i = getNextChar();

            if (i == -1) {
                endOfFile = true;
                break;
            }
            
            str += ((char) i);

            
        }
        return str;
    }

    // gets the next line, ignoring specific chars.
    public int[] getNextLine(char[] ignoreList) throws IOException {
        int[] line = new int[0];

        int i = 0;
        while ((char) i != '\n') {

            i = getNextChar();

            // char is not in list, add it to the array.
            if (!charInList((char) i, ignoreList)) {
                line = Utils.expandArrayByOne(line);
                line[line.length - 1] = i;
            }

            if (i == -1) {
                break;
            }
        }
        return line;
    }

    // returns the next line of characters, ignoring specific chars and option for
    // uppercase only
    public char[] getNextLineOfChars(char[] ignoreList, boolean toUpperCase) throws IOException {
        char[] line = new char[0];

        int i = getNextChar();
        while ((i != -1)) {

            // end of line.
            if ((char) i == '\n') {
                line = Utils.expandArrayByOne(line);
                line[line.length - 1] = '\n';
                return line;
            }

            // char is not in list, add it to the array.
            if (!charInList((char) i, ignoreList)) {
                line = Utils.expandArrayByOne(line);
                if (toUpperCase) {
                    line[line.length - 1] = Character.toUpperCase((char) i);
                } else {
                    line[line.length - 1] = (char) i;
                }
            }
            i = getNextChar();
        } // ends while
        return line;
    }

    // given a list and a char, return whether or not the char is in the list.
    public boolean charInList(char ch, char[] list) {
        for (int i = 0; i < list.length; i++) {
            if (ch == list[i]) {
                return true;
            }
        }
        return false;
    }

}
