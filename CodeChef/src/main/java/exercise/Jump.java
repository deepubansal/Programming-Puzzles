package exercise;





import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Jump {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(
				System.in));
		long parseInt = Long.parseLong(bufferRead.readLine());
		byte div = (byte) (parseInt % 6);
		if (div == 1 || div == 0 || div == 3)
			System.out.print("yes");
		else
			System.out.print("no");

	}

}
