
public class DumbPasswords {
	public static void printDumbPasswords(int m, int n) {
		final int ASCII_a = 97;
		
		if(n < 1 || n > 26 || m < 0) {
			System.out.println("usage:  m > 0, 0 < n < 27");
		}
		else {
			for(int char1 = 1; char1 < m; char1++) {
				for(int char2 = 1; char2 < m; char2++) {
					for(int char3 = ASCII_a; char3 < ASCII_a + n; char3++) {
						for(int char4 = ASCII_a; char4 < ASCII_a + n; char4++) {
							for(int char5 = Math.max(char1, char2) + 1; char5 <= m; char5++) {
								System.out.printf("%d%d%s%s%d ", char1, char2, (char)char3, (char)char4, char5);
							}
						}
					}
				}
			}
		}
		
	}

	public static void main(String[] args) {
		printDumbPasswords(3, 1);

	}

}
