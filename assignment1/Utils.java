class Utils {

    public static final String DIRECTORY = "/Users/tylerhernandez/ALGORITHMS/Algorithms/";

    public static int[] expandArrayByOne(int[] originalArray) {
        int[] newArray = new int[originalArray.length + 1];
        System.arraycopy(originalArray, 0, newArray, 0, originalArray.length);
        return newArray;
    }

    public static char[] expandArrayByOne(char[] originalArray) {
        char[] newArray = new char[originalArray.length + 1];
        System.arraycopy(originalArray, 0, newArray, 0, originalArray.length);
        return newArray;
    }

    // removes last element of the array... I wouldnt give it an empty array if I
    // were you.
    public static char[] removeLastElementOfArray(char[] originalArray) {
        char[] newArray = new char[originalArray.length - 1];
        System.arraycopy(originalArray, 0, newArray, 0, originalArray.length - 1);
        return newArray;
    }
}
