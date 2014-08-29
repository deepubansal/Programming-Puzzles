package exercise;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Stone {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(
				System.in));
		String firstLine = bufferRead.readLine();
		String[] split = firstLine.split(" ");
		int n = Integer.parseInt(split[0]);
		long k = Long.parseLong(split[1]);
		String secondLine = bufferRead.readLine();
		String[] split2 = secondLine.split(" ");
		if (k == 0) {
			System.out.println(secondLine);
		} else if (k % 2 == 0) {
			long min = Integer.parseInt(split2[0]);
			for (int i = 1; i < n; ++i) {
				long curr = Long.parseLong(split2[i]);
				if (min > curr)
					min = curr;
			}
			for (int i = 0; i < n; ++i) {
				long curr = Long.parseLong(split2[i]);
				System.out.print(curr - min);
				if (i != n - 1) {
					System.out.print(" ");
				}
			}
		} else {
			long max = Integer.parseInt(split2[0]);
			for (int i = 1; i < n; ++i) {
				long curr = Long.parseLong(split2[i]);
				if (max < curr)
					max = curr;
			}
			for (int i = 0; i < n; ++i) {
				long curr = Long.parseLong(split2[i]);
				System.out.print(max - curr);
				if (i != n - 1) {
					System.out.print(" ");
				}
			}
		}
	}

}
