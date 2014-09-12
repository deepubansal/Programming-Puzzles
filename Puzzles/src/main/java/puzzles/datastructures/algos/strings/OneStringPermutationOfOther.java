package puzzles.datastructures.algos.strings;

public class OneStringPermutationOfOther {

    public static void main(String[] args) {

        String a = "abcd";
        String b = "bacd";
        String c = "sdab";

        System.out.println(checkIfOneStringIsPermutationOfOther(a, b));
        System.out.println(checkIfOneStringIsPermutationOfOther(a, c));

    }

    /**
     * checks whether str1 is a permutation of str2
     * @param str1
     * @param str2
     * @return
     */
    private static boolean checkIfOneStringIsPermutationOfOther(String str1, String str2) {

        if (str1.length() != str2.length())
            return false;
        int[] counts = new int[256];
        for (int i = 0; i < str1.length(); ++i) {
            counts[str1.charAt(i)]++;
        }
        for (int i = 0; i < str2.length(); ++i) {
            counts[str2.charAt(i)]--;
        }
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0)
                return false;
        }
        return true;
    }

}
