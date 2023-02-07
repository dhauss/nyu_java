
public class CopyShift {

	public static void copyShift(int[] sourceArray, int[] destArray, int shift) {
		if(shift <= 0) {
			System.out.println("shift must be positive value.");
			return;
		}
		
		for(int destI = 0, sourceI = (shift - 1); destI < 50; destI++, sourceI++) {
			sourceI %= 50;
			destArray[destI] = sourceArray[sourceI];		
		}
		
	}
	
	public static void printArray(int[] array, int size) {
		for(int i = 0; i < size; i++){
			System.out.printf("%d ", array[i]);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		int[] sourceArray = new int[50];
		int[] destArray = new int[50];
		
		/* initialize the source Array */
		for (int i = 0;i < sourceArray.length; i++) {
			sourceArray[i] = (int)(Math.random()*100);
		}
		
		int shiftValue = 3;
		copyShift(sourceArray, destArray, shiftValue);
		System.out.println("sourceArray:");
		printArray(sourceArray, 50);
		System.out.println("destArray:");
		printArray(destArray, 50);
		
		
		
		/* destArray should have the contents of sourceArray
		 * but in shifted over "shiftValue" values
		 * if sourceArray has the contents [1,5,6,7,9] and we want to shift it 
		 * 3 spaces over, destArray should have the contents [6,7,9,1,5].
		 * 
		 * It should work for arbitrarily large values of shift
		 */
	}
}
