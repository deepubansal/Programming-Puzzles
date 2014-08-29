package exercise;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Parsers {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(
				System.in));

		short parseInt = Short.parseShort(bufferRead.readLine());
		for (int i = 0; i < parseInt; i++) {
			int n;
			int sum = 0;
			int count = -1;
			int win = 0;
			String line = bufferRead.readLine();
			int length = line.length();
			while (sum >= 0 && (count + 1) < length) {
				n = line.charAt(count + 1);
				sum += (-1 * (n - 61));
				count++;
				if (sum == 0) {
					win = count+1;
				}
			}
			System.out.println(win);
		}
	}
}
