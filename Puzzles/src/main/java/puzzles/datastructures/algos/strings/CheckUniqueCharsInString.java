package puzzles.datastructures.algos.strings;

public class CheckUniqueCharsInString {

    // Assuming that a character can only contain ASCII characters
    // check whether any character repeats or not. Use bit vector to save space.

    public static void main(String[] args) {

        String str = "abcd,efg ";
        System.out.println(checkUnique(str));
    }

    private static boolean checkUnique(String str) {
        long _0To63 = 0;
        long _64To127 = 0;
        long _128To191 = 0;
        long _192To255 = 0;

        for (int i = 0; i < str.length(); ++i) {
            int val = str.charAt(i);
            if (val < 64) {
                if ((_0To63 & (1 << val)) != 0) {
                    return false;
                }
                _0To63 |= (1 << val);
            }
            else if (val < 128) {
                if ((_64To127 & (1 << val)) != 0) {
                    return false;
                }
                _64To127 |= (1 << val);
            }
            else if (val < 192) {
                if ((_128To191 & (1 << val)) != 0) {
                    return false;
                }
                _128To191 |= (1 << val);
            }
            else {
                if ((_192To255 & (1 << val)) != 0) {
                    return false;
                }
                _192To255 |= (1 << val);
            }
        }
        return true;
    }
}
