package complexmatrix;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class ComplexMatrix {
		private ArrayList<ArrayList<Complex>> matrix;
		private int rows;
		private int cols;
		
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
			//assuming legal input, e.g. col lengths are all equal
			setRows(inArray.length);
			setCols(inArray[0].length);
			
			matrix = new ArrayList<ArrayList<Complex>>(getRows());
			for(int i = 0; i < getRows(); i++) {
				ArrayList<Complex> in = new ArrayList<>(Arrays.asList(inArray[i]));
				matrix.add(in);
			}	
		}
		
		public ComplexMatrix add(ComplexMatrix cm) throws MatrixDimensionException {
			if(this.getRows() != cm.getRows() || this.getCols() != cm.getCols())
				throw new MatrixDimensionException("Incompatible Matrix Dimensions for Addition");
			
			Complex[][] res = new Complex[this.getRows()][this.getCols()];
			
			for(int i = 0; i < getRows(); i++) {
				for(int j = 0; j < getCols(); j++) {
					Complex cell = this.getMatrix().get(i).get(j).add(cm.getMatrix().get(i).get(j));
					res[i][j] = cell;
					}
				}
			
			return new ComplexMatrix(res);
		}
		
		
		public ComplexMatrix mult(ComplexMatrix cm) throws MatrixDimensionException {
			if(this.getCols() != cm.getRows())
				throw new MatrixDimensionException("Incompatible Matrix Dimensions for Multiplication");
			
			Complex[][] res = new Complex[this.getRows()][cm.getCols()];
			
			for(int i = 0; i < this.getRows(); i++) {
				for(int j = 0; j < cm.getCols(); j++) {
					res[i][j] = new Complex();
					for(int k = 0; k < this.getCols(); k++) {
						res[i][j] = res[i][j].add(this.getMatrix().get(i).get(k).multiply(cm.getMatrix().get(k).get(j)));
					}
				}
			}
			
			return new ComplexMatrix(res);
		}
		
		public void write(String filename) {
			FileWriter fout = null;
			BufferedWriter out;
			try {
				fout = new FileWriter(filename);
			} catch (IOException e) {
				System.err.println("Filewriter error: "+ e.getMessage());
				System.exit(1);
			}
			out = new BufferedWriter(fout);
			
			for (ArrayList<Complex> cList: this.getMatrix()) {
				try {
					for(Complex c: cList) {
						String temp = String.format("%.2f_%.2f ", c.getReal(), c.getImaginary());
						out.write(temp);
					}
					out.newLine();
					out.flush();
				} catch (IOException e) {
					System.err.println("Error writing to file: "+ e.getMessage());
				}
			}
			try {
				out.flush();
				fout.close();
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}
		
		public static ComplexMatrix read(String filename) throws IncompatibleMatrixException {
			FileReader fr = null;
			BufferedReader br = null;
			ArrayList<ArrayList<Complex>> matrix = new ArrayList<ArrayList<Complex>>();
			Complex[][] arrMatrix;
			int rows, cols;
			
			try {
				fr = new FileReader(filename);
			}
			catch(FileNotFoundException fnfe) {
				System.out.println("File not found: " + fnfe.getMessage());
				System.exit(1);
			}
			br = new BufferedReader(fr);
			
			try {
				String curLine = br.readLine();
				int i = 0;
				while(curLine != null) {
					matrix.add(new ArrayList<Complex>());
					curLine = curLine.trim();
					String[] nums = curLine.split(" ");
					for(String num: nums) {
						String[] temp = num.split("_");
						matrix.get(i).add(new Complex(Double.parseDouble(temp[0]), Double.parseDouble(temp[1])));
					}
					i++;
					curLine = br.readLine();
				}
				fr.close();
			}
			catch(IOException ioe){
				System.err.println("Error reading file: " + ioe.getMessage());
			}
			
			rows = matrix.size();
			cols = matrix.get(0).size();
			arrMatrix = new Complex[rows][cols];
			
			for(ArrayList<Complex> c: matrix) {
				if(c.size() != cols) {
					throw new IncompatibleMatrixException("Incompatible Matrix Dimensions");
				}
			}
			
			for(int i = 0; i < rows; i++) {
				for(int j = 0; j < cols; j++) {
					arrMatrix[i][j] = matrix.get(i).get(j);
				}
			}
			
			return new ComplexMatrix(arrMatrix);
		}
		
		@Override
		public String toString() {
			StringBuilder res = new StringBuilder("");
			
			for(int i = 0; i < getRows(); i++) {
				for(int j = 0; j < getCols(); j++) {
					res.append(getMatrix().get(i).get(j));
					res.append(" ");
				}
				res.append("\n");
			}
			return res.toString();
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
