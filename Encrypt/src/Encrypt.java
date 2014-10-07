import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class Encrypt {
	public static void main(String[] args) {
		int ran = (int) (Math.random() * 25 + 1);

		File file = new File("C:/Users/C3-23/Desktop/sample.txt");
		File encryptFile = new File("C:/Users/C3-23/Desktop/encrypt.txt");
		FileOutputStream fos = null;
		FileReader fr = null;
		try {
			fr = new FileReader(file);
			fos = new FileOutputStream(encryptFile);

			int c;
			while ((c = fr.read()) != -1) {
				c += ran;
				if (c > 'z') {
					c = c - 'z' + 'a' - 1;
				}

				fos.write(c);
				fos.flush();
			}
			System.err.println("key = " + ran);
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
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
