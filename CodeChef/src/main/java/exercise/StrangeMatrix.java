package exercise;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

class StrangeMatrix {

	public static void main(String[] args) throws IOException {
		 InputStream inputStream = System.in;
//		FileInputStream inputStream = new FileInputStream(new File(
//				"src/main/java/in.txt"));
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(
				inputStream));
		String[] split = getNextLine(bufferRead);
		int n = Integer.parseInt(split[0]);
		int m = Integer.parseInt(split[1]);
		int p = Integer.parseInt(split[2]);
		int[][] metaData = new int[n][];
		if (m > 1 ) {
			
		for (int k = 0; k < p; k++) {
			String[] nextLine = getNextLine(bufferRead);
			int i = Integer.parseInt(nextLine[0]);
			int j = Integer.parseInt(nextLine[1]);
			i = i -1;
			if (metaData[i] == null) {
				metaData[i] = new int[m];
				metaData[i][0] = m -1;
			}
			if (j == m) {
				metaData[i][0] += 1;
				metaData[i][m - 1] += 1;
			} else {
				if (j == 1) {
					metaData[i][0] -= 1;
					metaData[i][j] -= 1;
				}
				else {
				metaData[i][j] -= 1;
				metaData[i][j-1] += 1;
				}
			}
//			printMetaData(metaData, i, j);
		}
		for (int i = 0; i < n; i++) {
			if (metaData[i] == null) {
				System.out.println(m - 1);
			} else {
//				System.out.println("MetaData"+metaData[i]);
				boolean isNegative = false;
				for (int j = 1; j < m; ++j) {
					if (metaData[i][j]	< -1)
						isNegative = true;
 				}
				if (isNegative) 
					System.out.println(-1);
				else
					System.out.println(metaData[i][0]);
			}
		}
		}
		
		else {
			for (int k = 0 ; k < n; ++k) {
				System.out.println(0);
			}
		}

	}

//	private static void printMetaData(int[][] metaData, int i, int j) {
//		System.out.println("PrintMetadata:STart"+(i+1)+","+j);
//		for (int l = 0; l < metaData.length; ++l) {
//			System.out.println();
//			System.out.print(l + "\t\t:");
//			if (metaData[l] != null) {
//				for (int b = 0; b < metaData[l].length; ++b) {
//					System.out.print(metaData[l][b] + " ");
//				}
//			}
//		}
//		System.out.println();
//		System.out.println("PrintMetadata:End");
//	}

	private static String[] getNextLine(BufferedReader bufferRead)
			throws IOException {
		String firstLine = bufferRead.readLine();
		String[] split = firstLine.split(" ");
		return split;
	}

}
