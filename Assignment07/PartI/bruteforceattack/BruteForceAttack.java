package bruteforceattack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class BruteForceAttack {

	static final char startLower = 'a';
	static final char startUpper = 'A';
	static final char startNumber = '0';
	static final char[] letters = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k','l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v','w','x', 'y', 'z', 'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9'};
	public static char getChar(int i) {
		return letters[i];
		
	}
	public static int numfound;
	private static Object numfoundLock = new Object();
	public Object digestLock = new Object();
	
	public static String bytesToHex(byte[] hash) {
	    StringBuilder hexString = new StringBuilder(2 * hash.length);
	    for (int i = 0; i < hash.length; i++) {
	        String hex = Integer.toHexString(0xff & hash[i]);
	        if(hex.length() == 1) {
	            hexString.append('0');
	        }
	        hexString.append(hex);
	    }
	    return hexString.toString();
	}
	
	public static int getInt(char c) {
		if ((c >= 'a') && (c <= 'z')) {
			return c - 'a';
		} else if ((c >= 'A') && (c <= 'Z')) {
			return 26 + (c - 'A');
		} else if ((c >= '0') && (c <= '9')) {
			return 52 + (c - '0');
		} else {
			return 0;
		}
	}
	
	public static Set<String> hashedpasswords(String filename) {
		Set<String> hashSet = Collections.synchronizedSet(new HashSet<String>());
		try {
			FileReader fr = new FileReader("hashedpassword.txt");
			BufferedReader br = new BufferedReader(fr);
			String inline = br.readLine();
			while (inline != null) {
				hashSet.add(inline);
				inline = br.readLine();
			}
		} catch (Exception e) {
			
		}
		return hashSet;
	}
	
	public static void threadWork(int len, long min, long max, MessageDigest digest, Set<String> passwordSet) {
		//initialize pass based on thread's min
		byte[] pass = new byte[5];
		for (int k = 0;k<pass.length ;k++) {
			double num = ((min/(Math.pow(26, k))))%26;
			pass[k] = (byte)letters[(int)num];
		}
		/*		pass debug
		for (int k = 0;k<pass.length ;k++) {
			System.out.print((char)pass[k]);
		}
		System.out.println();
		*/
		
		for (long j=min ; j < max ;j++) { 
			//get an int between 0 and 26 (letters in alphabet) from j
			int v = (int)(j % 26L);
			//when j = 26 and v = 0
			if ((v == 0) && (j!=0)) {
				//pw starts with a
				pass[0] = startLower;
				for (int k = 1;k<pass.length ;k++) {
					//If pass[k] = reset to a
					if (pass[k] == 'z') {
						if (k != pass.length-1) {
							pass[k] = startLower;
							continue;
						} else {
							break;
						}
						//otherwise get the a, increment and reset pass[k] to b? because pass is shared between loop! need to initialize it correctly between loops
					} else {
						int val = getInt((char)pass[k]);
						val++;
						pass[k] = (byte)letters[val];
						break;
					}
				} 
				//otherwise just use the letter of v 0 > v > 26
			} else {
				pass[0] = (byte)letters[v];
			}
				byte[] encodedhash = digest.digest(pass);
				String hashpass = BruteForceAttack.bytesToHex(encodedhash);
				if (passwordSet.contains(hashpass)) {
					String passString = new String(pass);
					System.out.println("found password " + passString);
					synchronized(numfoundLock) {
						numfound++;
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		Set<String> passwordSet = hashedpasswords("hashedpassword.txt");
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		MessageDigest digest2 = MessageDigest.getInstance("SHA-256");
		MessageDigest digest3 = MessageDigest.getInstance("SHA-256");
		MessageDigest digest4 = MessageDigest.getInstance("SHA-256");


		numfound = 0;
		int len = 5;
		double max = Math.pow(26, len);
		long start = System.currentTimeMillis();	
		
		//thread goes here, split into max divided by Runtime.getRuntime().availableProcessors()
		//put whole function into a thread, min/max gets replaced with each thread
		
		Runnable r1 = () -> threadWork(len, 0, (long)(max/4), digest, passwordSet);
		Runnable r2 = () -> threadWork(len, (long)(max/4), (long)(max/2), digest2, passwordSet);
		Runnable r3 = () -> threadWork(len, (long)(max/2), 3 *(long)(max/4), digest3, passwordSet);
		Runnable r4 = () -> threadWork(len, 3 *(long)(max/4), (long)max, digest4, passwordSet);

		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		Thread t3 = new Thread(r3);
		Thread t4 = new Thread(r4);

		t1.start();
		t2.start();
		t3.start();
		t4.start();

		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		
		long end = System.currentTimeMillis();
		System.out.println("found " + numfound + " out of " + passwordSet.size());
		System.out.println(end - start);
	}
}
