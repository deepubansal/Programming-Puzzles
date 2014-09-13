package puzzles.classic;

public class BinaryStrings {

    // Program to print all the binary string of n bits.
    public static void main(String[] args) {
        int n = 4;
        
        printBinaryString("", n); 
        
    }

    private static void printBinaryString(String prefix, int n) {
        if (n == 1) {
            System.out.println(prefix + "0");
            System.out.println(prefix + "1");
        }
        else {
            printBinaryString(prefix + "0", n-1);
            printBinaryString(prefix + "1", n-1);
        }
        
    }
}
