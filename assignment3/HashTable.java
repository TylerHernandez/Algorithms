public class HashTable {

    // Hash Table uses chaining.

    LinkedList arr[];
    private static final int ROWS = 250;

    HashTable(){
        arr = new LinkedList[ROWS]; // Creates a new array with rows length.
    }

    // Takes in a string, creates a hash for it, then stores it in our array.
    void storeHashFromString(String str) {
        int hashCode = makeHashCode(str);

        // Use hashCode address in arr to store our given str.
        // arr[hashCode] = str;
        storeStringWithChaining(hashCode, str);;
    }

    // Properly inserts string into hashCode address by implementing chaining.
    void storeStringWithChaining(int hashCode, String str){

        Node n = new Node(str);


        // Store our new node in the linked list at hashCode address.
        if (arr[hashCode] == null){
            arr[hashCode] = new LinkedList();
            arr[hashCode].append(n);
        } else {
            arr[hashCode].append(n);
        }

        /*
         Use a node class with a pointer to either the front or the end. When retrieving the chained items, 

         # average is 3 or 4 ish 

         # 1 for the hash, comparisons for the colissions 


        */
        
        // hashCode address is not empty, retrieve 
    }

    // Creates a hashCode given a string.
    public static int makeHashCode(String str) {
        str = str.toUpperCase();
        int length = str.length();
        int letterTotal = 0;

        // Iterate over all letters in the string, totalling their ASCII values.
        for (int i = 0; i < length; i++) {
            char thisLetter = str.charAt(i);
            int thisValue = (int) thisLetter;
            letterTotal = letterTotal + thisValue;

            // Test: print the char and the hash.
            /*
             * System.out.print(" [");
             * System.out.print(thisLetter);
             * System.out.print(thisValue);
             * System.out.print("] ");
             * //
             */
        }

        // Scale letterTotal to fit in ROWS.
        int hashCode = (letterTotal * 3) % ROWS;

        return hashCode;
    }


}