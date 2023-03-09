package complexmatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ComplexMatrix {
		private ArrayList<ArrayList<Complex>> matrix;
		private int rows;
		private int cols;
		
		//m = rows, n = cols
		public ComplexMatrix(int m, int n) {
			matrix = new ArrayList<ArrayList<Complex>>(m);
			setRows(m);
			setCols(n);
			
			ArrayList<Complex> init = new ArrayList<Complex>(n);
			for(int i = 0; i < n; i++) {
				init.add(new Complex());
			}
			
			for(int i = 0; i < m; i++) {
				matrix.add(init);
			}
			
		}
		
		public ComplexMatrix(Complex[][] inArray) {
			int m = inArray.length;
			//assuming col lengths are all equal, otherwise I'd loop through and find the max length
			int n = inArray[0].length;
			setRows(m);
			setCols(n);
			
			matrix = new ArrayList<ArrayList<Complex>>(m);
			for(int i = 0; i < m; i++) {
				ArrayList<Complex> in = new ArrayList<>(Arrays.asList(inArray[i]));
				matrix.add(in);
			}	
		}
		
		@Override
		public String toString() {
			for(int i = 0; i < getRows(); i++) {
				for(int j = 0; j < getCols(); j++) {
					System.out.print(getMatrix().get(i).get(j) + " ");
				}
				System.out.println();
			}
			
			
			return "";
		}
	
		public ArrayList<ArrayList<Complex>> getMatrix() {
			return matrix;
		}

		public void setMatrix(ArrayList<ArrayList<Complex>> matrix) {
			this.matrix = matrix;
		}
		
		

	public int getRows() {
			return rows;
		}

		public void setRows(int rows) {
			this.rows = rows;
		}

	public int getCols() {
			return cols;
		}

		public void setCols(int cols) {
			this.cols = cols;
		}

	public static void main(String[] args) {

	}
}
