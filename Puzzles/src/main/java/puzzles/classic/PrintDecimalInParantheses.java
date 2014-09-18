package puzzles.classic;

/**
 * Write a function which, given two integers (a numerator and a denominator),
 * prints the decimal representation of the rational number
 * "numerator/denominator". Since all rational numbers end with a repeating
 * section, print the repeating section of digits inside parentheses; the
 * decimal printout will be/must be Example: 1 , 3 = 0.(3) 2 , 4 = 0.(5) 22, 7 =
 * 3.(142857) etc..
 * 
 * @author deepak
 * 
 */
public class PrintDecimalInParantheses {

	public static void main(String[] args) {
		printDecimalConversion(1, 3);
		printDecimalConversion(2, 4);
		printDecimalConversion(22, 7);
	}

	private static void printDecimalConversion(int p, int q) {
		int quotient = p/q;
		p = p%q;
		
		StringBuffer sb = getDecimalPart(p, q);
		sb.insert(0, quotient + ".(");
		sb.append(")");
		System.out.println(sb);
	}

	private static StringBuffer getDecimalPart(int p, int q) {
		int initP = p;
		StringBuffer sb = new StringBuffer();
		do {
			p *= 10;
			sb.append(p / q);
			p = p % q;
		} while (p != 0 && p != initP);
		return sb;
	}
}
