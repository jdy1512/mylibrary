import java.util.ArrayList;

public class Encrypt {
	private static final byte[] KEY = { 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0,
			0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0,
			0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0,
			1, 0, 1, 1, 0, 0, 1 };

	private static final byte[] SECRET_KEY = { 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0,
			1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0,
			1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

	private static final byte[] IP = { 58, 50, 42, 34, 26, 18, 10, 2, 60, 52,
			44, 36, 28, 20, 12, 4, 62, 54, 46, 38, 30, 22, 14, 6, 64, 56, 48,
			40, 32, 24, 16, 8, 57, 49, 41, 33, 25, 17, 9, 1, 59, 51, 43, 35,
			27, 19, 11, 3, 61, 53, 45, 37, 29, 21, 13, 5, 63, 55, 47, 39, 31,
			23, 15, 7 };

	private static final byte[] E = { 32, 1, 2, 3, 4, 5, 4, 5, 6, 7, 8, 9, 8,
			9, 10, 11, 12, 13, 12, 13, 14, 15, 16, 17, 16, 17, 18, 19, 20, 21,
			20, 21, 22, 23, 24, 25, 24, 25, 26, 27, 28, 29, 28, 29, 30, 31, 32,
			1 };

	private static final byte[][] S = {
			{ 14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7, 0, 15, 7,
					4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8, 4, 1, 14, 8,
					13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0, 15, 12, 8, 2, 4,
					9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13 },
			{ 15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10, 3, 13, 4,
					7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5, 0, 14, 7, 11,
					10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15, 13, 8, 10, 1, 3,
					15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9 },
			{ 10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8, 13, 7, 0,
					9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1, 13, 6, 4, 9, 8,
					15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7, 1, 10, 13, 0, 6, 9,
					8, 7, 4, 15, 14, 3, 11, 5, 2, 12 },
			{ 7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15, 13, 8, 11,
					5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9, 10, 6, 9, 0, 12,
					11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4, 3, 15, 0, 6, 10, 1,
					13, 8, 9, 4, 5, 11, 12, 7, 2, 14 },
			{ 2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9, 14, 11, 2,
					12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6, 4, 2, 1, 11, 10,
					13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14, 11, 8, 12, 7, 1, 14,
					2, 13, 6, 15, 0, 9, 10, 4, 5, 3 },
			{ 12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11, 10, 15, 4,
					2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8, 9, 14, 15, 5, 2,
					8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6, 4, 3, 2, 12, 9, 5, 15,
					10, 11, 14, 1, 7, 6, 0, 8, 13 },
			{ 4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1, 13, 0, 11,
					7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6, 1, 4, 11, 13,
					12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2, 6, 11, 13, 8, 1, 4,
					10, 7, 9, 5, 0, 15, 14, 2, 3, 12 },
			{ 13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7, 1, 15, 13,
					8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2, 7, 11, 4, 1, 9,
					12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8, 2, 1, 14, 7, 4, 10,
					8, 13, 15, 12, 9, 0, 3, 5, 6, 11 } };

	private static final byte[] P = { 16, 7, 20, 21, 29, 12, 28, 17, 1, 15, 23,
			26, 5, 18, 31, 10, 2, 8, 24, 14, 32, 27, 3, 9, 19, 13, 30, 6, 22,
			11, 4, 25 };

	enum Keystore {
		INSTANCE;
		byte[] ip = new byte[64];
		byte[] l = new byte[32];
		byte[] r = new byte[32];
		byte[] e = new byte[48];
		byte[] ex_key = new byte[48];
		byte[] ex_l = new byte[32];
		ArrayList<Byte> s = new ArrayList<Byte>();
		byte[] p = new byte[32];
	}

	public static void main(String[] args) {
		convert(Keystore.INSTANCE.ip, KEY, IP);

		viewConsole(Keystore.INSTANCE.ip);

		convert2(Keystore.INSTANCE.e, Keystore.INSTANCE.r, E);

		// exclusive e ^ secretkey
		exclusive(Keystore.INSTANCE.ex_key, Keystore.INSTANCE.e, SECRET_KEY);

		viewConsole2(Keystore.INSTANCE.ex_key);

		convert3(Keystore.INSTANCE.s, Keystore.INSTANCE.ex_key, S);

		viewConsole3(Keystore.INSTANCE.s);

		convert4(Keystore.INSTANCE.p, Keystore.INSTANCE.s, P);

		// exclusive p ^ l
		exclusive(Keystore.INSTANCE.ex_l, Keystore.INSTANCE.p,
				Keystore.INSTANCE.l);

		viewConsole4(Keystore.INSTANCE.ex_l);

		System.out.println();
		
		// l1
		System.err.println("l1 : ");
		for (byte b : Keystore.INSTANCE.r) {
			System.err.print(b);
		}
		
		System.err.println();
		
		// r1
		System.err.println("r1 : ");
		for (byte b : Keystore.INSTANCE.ex_l) {
			System.err.print(b);
		}
	}

	public static void exclusive(byte[] newTbl, byte[] oldTbl, byte[] key) {
		for (int i = 0; i < oldTbl.length; i++) {
			newTbl[i] = (byte) (oldTbl[i] ^ key[i]);
		}
	}

	public static void convert(byte[] newTbl, byte[] oldTbl, byte[] targetTbl) {
		for (int i = 0; i < targetTbl.length; i++) {
			newTbl[i] = oldTbl[targetTbl[i] - 1];
			if (i < 32) {
				Keystore.INSTANCE.l[i] = oldTbl[targetTbl[i] - 1];
			} else {
				Keystore.INSTANCE.r[i - 32] = oldTbl[targetTbl[i] - 1];
			}
		}
	}

	public static void convert2(byte[] newTbl, byte[] oldTbl, byte[] targetTbl) {
		for (int i = 0; i < targetTbl.length; i++) {
			newTbl[i] = oldTbl[targetTbl[i] - 1];
		}
	}

	public static void convert3(ArrayList<Byte> newTbl, byte[] oldTbl,
			byte[][] targetTbl) {
		for (int i = 0; i < oldTbl.length; i++) {
			if (i != 0 && i % 6 == 5) {
				int j = i / 6;
				int k = oldTbl[i - 5] * 2 + oldTbl[i];
				int l = oldTbl[i - 4] * 8 + oldTbl[i - 3] * 4 + oldTbl[i - 2]
						* 2 + oldTbl[i - 1];

				int num = targetTbl[j][k * 16 + l];

				int org = 1, bin = -1;
				while (org <= num) {
					org *= 2;
					bin++;
				}

				int temp = bin;
				while (temp < 3) {
					++temp;
					Keystore.INSTANCE.s.add((byte) 0);
				}
				while (bin >= 0) {
					Keystore.INSTANCE.s.add((byte) (num >> bin & 1));
					bin--;
				}
			}
		}
	}

	public static void convert4(byte[] newTbl, ArrayList<Byte> oldTbl,
			byte[] targetTbl) {
		for (int i = 0; i < targetTbl.length; i++) {
			newTbl[i] = oldTbl.get(targetTbl[i] - 1);
		}
	}

	public static void viewConsole(byte[] tbl) {
		System.out.println("-- IP table--");
		for (int i = 0; i < tbl.length; i++) {
			if (i != 0 && i % 8 == 0) {
				System.out.println();
			}
			System.out.print(tbl[i]);
		}
		System.out.println();
	}

	public static void viewConsole2(byte[] tbl) {
		System.out.println("-- E, xor --");
		for (int i = 0; i < tbl.length; i++) {
			if (i != 0 && i % 6 == 0) {
				System.out.println();
			}
			System.out.print(tbl[i]);
		}
		System.out.println();
	}

	public static void viewConsole3(ArrayList<Byte> tbl) {
		System.out.println("-- s table --");
		for (int i = 0; i < tbl.size(); i++) {
			if (i != 0 && i % 4 == 0) {
				System.out.println();
			}
			System.out.print(tbl.get(i));
		}
		System.out.println();
	}

	public static void viewConsole4(byte[] tbl) {
		System.out.println("-- p, xor --");
		for (int i = 0; i < tbl.length; i++) {
			if (i != 0 && i % 4 == 0) {
				System.out.println();
			}
			System.out.print(tbl[i]);
		}
		System.out.println();
	}
}
