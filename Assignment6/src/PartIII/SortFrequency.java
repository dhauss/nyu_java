package PartIII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SortFrequency {
	
    /*
     * An alternative method would be to create a new hashMap, reverseHash, with the
     * countHash keys and values reversed, so that the reverseHash keys are the count and
     * its values are the actual integers. We then sort a list of reverseHash keys
     * and access reverseHash by iterating through this list in order to create our final,
     * 'sorted' list. Whenever two integers from ar have the same count, however, this will lead 
     * to hashMap entries being overwritten, thereby losing entries with duplicate 
     * counts. By storing each entry in a list and overriding the comparator before
     * sorting, we can avoid this issue and successfully sort the original ar by count
     * even with duplicate counts
     * */

    public static void sortByFrequency(ArrayList<Integer> ar) {
            HashMap<Integer, Integer> countHash = new HashMap<>();
            ArrayList<Map.Entry<Integer, Integer>> countArray = new ArrayList<>();
            
            //create count hashMap
            for(int num: ar) {
            	if(countHash.containsKey(num)) {
            		int count = countHash.get(num);
            		count++;
            		countHash.put(num, count);
            	}
            	else {
            		countHash.put(num, 1);
            	}
            }
                
            //add countHash entries to arrayList, override comparator and sort by value (count)
            countArray.addAll(countHash.entrySet());
            countArray.sort((e1, e2) -> e1.getValue() - e2.getValue());

            //populate original array with keys sorted and repeated by value (count) 
            ar.clear();
            for(int i = 0; i < countArray.size(); i++) {
            	for(int j = 0; j < countArray.get(i).getValue(); j++) {
            		ar.add(countArray.get(i).getKey());
            	}
            }
    }
    
    public static void main(String[] args) {
            ArrayList<Integer> ar = new ArrayList<Integer>();
            for (int i=0;i<100;i++) {
                    ar.add((int)(Math.random()*10));                        
            }
            System.out.println(ar.toString());
            sortByFrequency(ar);
            System.out.println(ar.toString());
           
    }
}
