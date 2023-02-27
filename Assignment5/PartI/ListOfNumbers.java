import java.io.*;
import java.util.List;
import java.util.ArrayList;
 
public class ListOfNumbers {
	
    private ArrayList<RDFTriple<Integer, Integer, Integer>> pairList;
    private String fileName;
 
    public ListOfNumbers () {
        // create an ArrayList of Pairs of Integers
    	pairList = new ArrayList<RDFTriple<Integer, Integer, Integer>>();
    	fileName = null;
    }
    
    public ArrayList<RDFTriple<Integer, Integer, Integer>> getPairList() {
    	return this.pairList;
    }
    
    public void createList() {
    	for (int i = 0 ; i< 100 ; i++) {
    		Integer number1 = (int) (Math.random()*10000);
    		Integer number2 = (int) (Math.random()*10000);
    		Integer number3 = (int) (Math.random()*10000);
    		// fill the existing list with RDFTriple objects
    		// of three numbers.
    		pairList.add(new RDFTriple(number1, number2, number3));
    	}
    }
    

    public ListOfNumbers (String fileName) {
    	this();
    	this.fileName = fileName;	
    }
    
    public void readList() {

    }
    
    public void writeList() {
        PrintWriter out = null;
        try {
            System.out.println("Entering try statement");
            out = new PrintWriter(new FileWriter(this.fileName));
            for (int i = 0; i < pairList.size(); i++)
                out.println(pairList.get(i).getSubj() + " " + pairList.get(i).getPred()
                			+ " " + pairList.get(i).getObj());
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Caught IndexOutOfBoundsException: " +
                                 e.getMessage());
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        } finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            } else {
                System.out.println("PrintWriter not open");
            }
        }
    }
    
    /*
    public static void cat(String fileName) {
        RandomAccessFile input = null;
        String line = null;
        File file = new File(fileName);
        try {
            input = new RandomAccessFile(file, "r");
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            return;
        } finally {
            if (input != null) {
                input.close();
            }
        }
        
    }
    */
    
    public static void main(String[] args) {
    	/*
    	ListOfNumbers listOfNumbers = new ListOfNumbers("numberfile.txt");
    	ListOfNumbers.cat("numberfile.txt");
    	listOfNumbers.readList();
    	*/
    	
    	ListOfNumbers listOfNumbers = new ListOfNumbers();
    	listOfNumbers.createList();
        for (int i = 0; i < listOfNumbers.getPairList().size(); i++) {
            System.out.println(listOfNumbers.getPairList().get(i).getSubj() + " " + listOfNumbers.getPairList().get(i).getPred()
            			+ " " + listOfNumbers.getPairList().get(i).getObj());
        }

    }
}
