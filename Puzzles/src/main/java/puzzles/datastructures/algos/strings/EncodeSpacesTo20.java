package puzzles.datastructures.algos.strings;

public class EncodeSpacesTo20 {

    public static void main(String[] args) {

        String str = " Hi this is deepak       ";
        char[] charArray = str.toCharArray();

        char[] characters = encodeSpaces(charArray);
        System.out.println(new String(characters) + "------");

    }

    /**
     * method to encode each space in between words of a string to %20. 
     * Accepts a character array and does an in-place replacement.
     * Char Array should have enough spaces at the end to accomodate the extra chars (%20). 
     * @param charArray
     * @return
     */
    private static char[] encodeSpaces(char[] charArray) {
        int beforeLast = 0;
        int afterLast = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == ' ') {
                afterLast++;
            }
            else {
                beforeLast += afterLast;
                afterLast = 0;
            }
        }
        if (afterLast < 2*beforeLast) 
            throw new RuntimeException("Not Enough space at the end of string");
        for (int i = charArray.length - 1 - (afterLast - 2 * beforeLast); i >= 0 && beforeLast > 0; --i) {
            while (i > 0 && charArray[i - 2 * beforeLast] != ' ') {
                charArray[i] = charArray[i - 2 * beforeLast];
                i--;
            }
            charArray[i--] = '0';
            charArray[i--] = '2';
            charArray[i] = '%';
            beforeLast--;
        }

        return charArray;
    }

}
