import java.math.BigInteger;
import java.util.Random;

public class KeyGeneration {
	private static final int nbit = 4;

	private static BigInteger bigP, bigQ, bigN, bigPI, bigE, bigD, bigTemp;

	public static void main(String[] args) {
		bigP = BigInteger.probablePrime(nbit, new Random());
		System.out.println("p : " + bigP);

		bigQ = BigInteger.probablePrime(nbit, new Random());
		System.out.println("q : " + bigQ);

		bigN = bigP.multiply(bigQ);
		System.out.println("n : " + bigN);

		bigPI = bigP.add(BigInteger.valueOf(-1)).multiply(
				bigQ.add(BigInteger.valueOf(-1)));
		System.out.println("pi : " + bigPI);

		while ((bigE = gcd(bigPI,
				new BigInteger(bigPI.bitCount(), new Random())))
				.equals(BigInteger.ONE)) {
			;
		}
		System.out.println("e : " + bigE);

		int cnt = 1;
		while ((bigTemp = bigPI.multiply(BigInteger.valueOf(cnt)).add(
				BigInteger.ONE)).mod(bigE).equals(BigInteger.ZERO)) {
			++cnt;
		}
		bigD = bigTemp.divide(bigE);
		System.out.println("d : " + bigD);
		// --------------------------------------------------------------------------------------

		String key = "T";
		String code = "";
		for(int i=0; i<key.length();i++){
			code += (int)key.charAt(i);
		}
		BigInteger encrypt = (new BigInteger(code).pow(bigE.intValue())).mod(bigN);
		
		System.err.println("---------------------------------------------------------------");
		System.err.println("평문 : "+key);
		System.err.println("암호화 : "+encrypt);
		System.err.println("---------------------------------------------------------------");

		BigInteger decrypt = encrypt.pow(bigD.intValue()).mod(bigN);
		System.err.println("복호화 : "+decrypt.intValue());
	}

	public static BigInteger gcd(BigInteger p, BigInteger q) {
		if (q.equals(BigInteger.ZERO))
			return p;
		else
			return gcd(q, p.mod(q));
	}
}
