class Utils {

    public static final String DIRECTORY = "/Users/tylerhernandez/ALGORITHMS/Algorithms/";

    public static int[] expandArrayByOne(int[] originalArray) {
        int[] newArray = new int[originalArray.length + 1];
        System.arraycopy(originalArray, 0, newArray, 0, originalArray.length);
        return newArray;
    }

}
