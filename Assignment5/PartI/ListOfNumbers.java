import java.io.*;
import java.util.List;
import java.util.ArrayList;
 
public class ListOfNumbers {
	
    private ArrayList<RDFTriple<Integer, Integer, Integer>> rdfTripleList;
    private String fileName;
 
    public ListOfNumbers () {
        // create an ArrayList of Pairs of Integers
    	rdfTripleList = new ArrayList<RDFTriple<Integer, Integer, Integer>>();
    	fileName = null;
    }
    
    public ArrayList<RDFTriple<Integer, Integer, Integer>> getrdfTripleList() {
    	return this.rdfTripleList;
    }
    
    public void createList() {
    	for (int i = 0 ; i< 100 ; i++) {
    		Integer number1 = (int) (Math.random()*10000);
    		Integer number2 = (int) (Math.random()*10000);
    		Integer number3 = (int) (Math.random()*10000);
    		// fill the existing list with RDFTriple objects
    		// of three numbers.
    		rdfTripleList.add(new RDFTriple<Integer, Integer, Integer>(number1, number2, number3));
    	}
    }
    

    public ListOfNumbers (String fileName) {
    	this();
    	this.fileName = fileName;	
    }
    
    public void readList() {
    	rdfTripleList = new ArrayList<RDFTriple<Integer, Integer, Integer>>();
    	FileReader fr = null;
    	BufferedReader br = null;

    	try {
    		fr = new FileReader(fileName);
    	}
    	catch(FileNotFoundException e) {
			System.err.println("File not found: " + e.getMessage());
			System.exit(1);
    	}
  
    	br = new BufferedReader(fr);
    	
    	try {
    		String curLine = br.readLine();
    		while(curLine != null) {
    			String[] nums = curLine.split(" ");
    			System.out.println(nums[0] + ", " + nums[1] + ", " + nums[2]);
    			try {
    				rdfTripleList.add(new RDFTriple<Integer, Integer, Integer>(Integer.parseInt(nums[0]),
    											Integer.parseInt(nums[1]), Integer.parseInt(nums[2])));
    			}
    			catch (NumberFormatException nfe) {
    				System.err.println("Number format problem: " + nfe.getMessage());
    			}
    			curLine = br.readLine();
    		}
    		fr.close();
    	}
    	catch (IOException e) {
			System.err.println("Error reading file: " + e.getMessage());
    	}
    	
    	
    }
    
    public void writeList() {
        PrintWriter out = null;
        try {
            System.out.println("Entering try statement");
            out = new PrintWriter(new FileWriter(this.fileName));
            for (int i = 0; i < rdfTripleList.size(); i++) {
                out.println(rdfTripleList.get(i).getSubj() + " " + rdfTripleList.get(i).getPred()
                			+ " " + rdfTripleList.get(i).getObj());
            }
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
        }
        catch(FileNotFoundException fnfe) {
        	System.out.println("File not found: " + fnfe.getMessage());
        }
        catch(IOException ioe) {
        	System.out.println("I/O error: " + ioe.getMessage());
        }
        finally {
            if (input != null) {
                try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        }
        
    }
    
    
    public static void main(String[] args) {
    	
    	ListOfNumbers listOfNumbers = new ListOfNumbers("numberfile.txt");
    	ListOfNumbers.cat("numberfile.txt");
    	listOfNumbers.readList();
    	
        /*for (int i = 0; i < listOfNuetrdfTripleList().size(); i++) {
            System.out.println(listOfNumbers.getrdfTripleList().get(i).getSubj() + " " + listOfNumbers.getPairList().get(i).getPred()
            			+ " " + listOfNumbers.getrdfTripleList().get(i).getObj());
        }
        
    	ListOfNumbers lon = new ListOfNumbers("test.txt");
    	lon.createList();
    	lon.writeList();
		
		/*
    	ListOfNumbers listOfNumbers = new ListOfNumbers();
    	listOfNumbers.createList();
        for (int i = 0; i < listOfNumbers.getrdfTripleList().size(); i++) {
            System.out.println(listOfNumbers.getrdfTripleList().get(i).getSubj() + " " + listOfNumbers.getrdfTripleList().get(i).getPred()
            			+ " " + listOfNumbers.getrdfTripleList().get(i).getObj());
        }
        */

    }
}
