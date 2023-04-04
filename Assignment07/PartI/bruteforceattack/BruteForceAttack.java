package bruteforceattack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* 
 My computer:
 * 2.4 GHz Quad-Core Intel Core i5 2019 13".
 * Runtime.getRuntime().availableProcessors() shows 8 available processors 
 * due to hyperthreading capacity
  
 Brute force on 5 char passwords:
 * About 16.3-16.5 seconds to find 4772 passwords
  
 Max number of productive threads:
 * 2 threads roughly halved the time and 3 shaved off another second or so.
 * With 4 threads the program runs consistently at about 4.5 to 5 seconds. Between 5-8 I would
 * sometimes see slightly better results, down to about 4.3 seconds, and some of the improvement is
 * likely due to efficient hyperthreading, but some is certainly related to what was running in the
 * background and scheduling at the Mac OS level. At 9+ threads, overhead from thread creation led
 * to runtimes around 5 seconds and above, which is to be expected given my computer has 4 physical
 * cores, with another virtual 4 thanks to hyperthreading. 4-8 threads seems to be the sweet spot, 6 seemed
 * to strike a consistently good balance, but without testing the program more empirically and dooming
 * my SSD to an early death, it was hard to establish a definitively best number of threads. Anything
 * between 4-8 will produce consistently good results between 4.5-5 seconds.
   
 6 char passwords:
 * A single thread took nearly 400 seconds to find 13,549 passwords. 4 threads improved
 * the time to 128.916 seconds, and 8 came in slightly better at 128.336 seconds, but again the improvement
 * due to hyperthreading vs the improvement due to scheduling luck is difficult to establish without
 * running at least a few dozen tests.
 */

public class BruteForceAttack {

	static final char startLower = 'a';
	static final char startUpper = 'A';
	static final char startNumber = '0';
	static final char[] letters = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k','l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v','w','x', 'y', 'z', 'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9'};
	public static char getChar(int i) {
		return letters[i];
		
	}
	private static int numfound;
	private static Object numfoundLock = new Object();
	
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
		//synchronized for good measure
		Set<String> hashSet = Collections.synchronizedSet(new HashSet<String>());
		try {
			FileReader fr = new FileReader("hashedpassword.txt");
			BufferedReader br = new BufferedReader(fr);
			String inline = br.readLine();
			while (inline != null) {
				hashSet.add(inline);
				inline = br.readLine();
			}
			br.close();
		} catch (Exception e) {
			
		}
		return hashSet;
	}
	
	public static void threadWork(int len, long min, long max, MessageDigest digest, Set<String> passwordSet) {
		//initialize local pass[] based on thread's min
		byte[] pass = new byte[len];
		for (int k = 0;k<pass.length ;k++) {
			double i = ((min/(Math.pow(26, k))))%26;
			pass[k] = (byte)letters[(int)i];
		}
		
		for (long j=min ; j < max ;j++) { 
			int v = (int)(j % 26L);
			if ((v == 0) && (j!=0)) {
				pass[0] = startLower;
				for (int k = 1;k<pass.length ;k++) {
					if (pass[k] == 'z') {
						if (k != pass.length-1) {
							pass[k] = startLower;
							continue;
						} else {
							break;
						}
					} else {
						int val = getInt((char)pass[k]);
						val++;
						pass[k] = (byte)letters[val];
						break;
					}
				} 
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

	public static int getNumfound() {
		return numfound;
	}

	public static void setNumfound(int numfound) {
		BruteForceAttack.numfound = numfound;
	}

	public static void main(String[] args) throws NoSuchAlgorithmException {
		Set<String> passwordSet = hashedpasswords("hashedpassword.txt");
		setNumfound(0);
		int len = 5;
		double max = Math.pow(26, len);
		double time_start = System.currentTimeMillis();	
		int numThreads = 4;
		
		Thread[] threads = new Thread[numThreads];
		for(int i = 0; i < numThreads; i++) {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			long begin = i * (long)(max/numThreads);
			long end = (i + 1) * (long)(max/numThreads);
			//long arithmetic caused uneven numThread to miss last few passwords
			Runnable r = null;
			if(i == numThreads - 1) {
				r = () -> threadWork(len, begin, (long)max, digest, passwordSet);
			}
			else {
				r = () -> threadWork(len, begin, end, digest, passwordSet);
			}
			threads[i] = new Thread(r);
			threads[i].start();
		}
		for(Thread thread: threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		long time_end = System.currentTimeMillis();
		System.out.println("found " + getNumfound() + " out of " + passwordSet.size()
							+ " in " + (time_end - time_start)/1000 + " seconds.");
	}
}
