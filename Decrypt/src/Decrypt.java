import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Decrypt {
	public static void main(String[] args) {
		File encryptFile = new File("C:/Users/C3-23/Desktop/encrypt.txt");
		BufferedReader br = null;
		FileReader fr = null;
		try {
			int tempKey = 0;
			String str;
			String result = null;
			do {
				fr = new FileReader(encryptFile);
				tempKey++;
				str = "";
				int c;

				if(result != null)
					tempKey = Integer.parseInt(result);
				while ((c = fr.read()) != -1) {
					int temp = c;
					c -= tempKey;
					if (temp > 'Z' && c > 'A' && c < 'Z') {
						c = 'z' - ('a' - c) + 1;
					}
					str += (char) c;
				}
				System.out.println(str);
				System.out.println();

				System.err.println("key = " + tempKey);
				System.err.print("n : ");
				result = new BufferedReader(new InputStreamReader(System.in))
						.readLine();
			} while (!result.equals("n"));
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}