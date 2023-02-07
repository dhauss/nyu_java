
public class TwoDimensionalArray {

	public static void main(String[] args) {
		
		int[][] twoDimArray = new int[2][5];
		int[] arrayOne = {5, 9, 55, 23, 89};
		int[] arrayTwo = {15, 3, 23, 19, 64};
		
		/* copy arrayOne and arrayTwo into twoDimArray */
		/* print out the first list of 5 numbers in twoDimArray
		 * on one line, and the second list of 5 numbers in twoDimArray
		 * on the next line
		 */
		
		/* the solution should use nested loops: one loop to loop over
		 * each array in twoDimArray, and one loop to loop over each element
		 * in that array
		 */
		
		copyTwoDimArrays(arrayOne, arrayTwo, twoDimArray, arrayOne.length);
		printTwoDimArray(twoDimArray);
	}
	
	public static void copyTwoDimArrays(int[] arr1, int[] arr2, int[][] resArray, int size) {
		int[] sourceArray;
		for(int i = 0; i < 2; i++) {		//copies two 1D arrays of equal length into a single 2D array, resArray should be initialized to proper size
			sourceArray = (i == 0)? arr1: arr2;	
			for(int j = 0; j < size; j++) {
				resArray[i][j] = sourceArray[j];
			}
		}
		
	}
	
	public static void printTwoDimArray(int[][] array) {
		for(int i = 0; i < 2; i++) {
			System.out.printf("2D Array[%d]:[ ", i);
			for(int j = 0; j < array[i].length; j++) {
				System.out.printf("%d ", array[i][j]);
			}
			System.out.println("]");
		}
	}
}
