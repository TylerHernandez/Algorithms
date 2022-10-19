public class Utils {

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

    public static String[] expandArrayByOne(String[] originalArray) {
        String[] newArray = new String[originalArray.length + 1];
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

    // I kept wanting to see the output of the array to make sure it was sorted and
    // kept getting
    // "[I@18b4aac2", hence the creation of this function.
    public static void printArray(int[] array) {
        if (array.length == 0) {
            System.out.println("[ ]");
            System.out.println();
        } else {
        System.out.print("[ ");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print((char) array[i] + ", ");
        }
        System.out.print(array[array.length - 1]);
        System.out.println("]");
        System.out.println();
    }
    }

    public static void printArray(char[] array) {
        if (array.length == 0) {
            System.out.println("[ ]");
            System.out.println();
        } else {
            System.out.print("[ ");
            for (int i = 0; i < array.length - 1; i++) {
                System.out.print(array[i] + ", ");
            }
            System.out.print(array[array.length - 1]);
            System.out.println(" ]");
            System.out.println();
        }
    }

    public static void printArray(String[] array) {
        if (array.length == 0) {
            System.out.println("[ ]");
            System.out.println();
        } else {
            System.out.print("[ ");
            for (int i = 0; i < array.length - 1; i++) {
                System.out.print(array[i] + ", ");
            }
            System.out.print(array[array.length - 1]);
            System.out.println(" ]");
            System.out.println();
        }
    }

}
