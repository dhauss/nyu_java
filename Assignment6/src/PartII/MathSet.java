package PartII;
import java.util.HashSet;
import java.util.Set;

public class MathSet<E> extends HashSet<E> {
	
    public MathSet() {
		super();
	}
	
	public Set<E> intersection(Set<E> s2) {
		Set<E> res = new HashSet<>();
		
		for(E element: (Set<E>) super.clone()) {
			res.add(element);
		}
		
		res.retainAll(s2);
        return res;
    }
    
    public Set<E> union(Set<E> s2) {
		Set<E> res = new HashSet<>();
		
		for(E element: (Set<E>) super.clone()) {
			res.add(element);
		}
		
		res.addAll(s2);
		return res;
    }

	public <T> Set<Pair<E,T>> cartesianProduct(Set<T> s2) {
		Set<Pair<E, T>> res = new HashSet<>();
		
		for(E e1: (Set<E>) super.clone()) {
			for(T e2: s2) {
				Pair<E, T> temp = new Pair<>(e1, e2);
				res.add(temp);
			}
		}
		
        return res;  

    }
    
	public static void main(String[] args) {
		// create two MathSet objects of the same type.
		// See if union and intersection works.
		
		// create another MathSet object of a different type
		// calculate the cartesian product of this set with one of the
		// above sets
		MathSet<Integer> s1 = new MathSet<Integer>();
		s1.add(5);
		s1.add(7);
		s1.add(9);
		
		MathSet<Integer> s2 = new MathSet<Integer>();
		s2.add(5);
		s2.add(7);
		s2.add(4);
		s2.add(6);
		s2.add(8);
	
		MathSet<String> s3 = new MathSet<>();
		s3.add("cat");
		s3.add("dog");

		System.out.println(s1.intersection(s2));
		System.out.println(s1.union(s2));
		System.out.println(s1.cartesianProduct(s2));
		System.out.println(s2.cartesianProduct(s1));
		System.out.println(s1.cartesianProduct(s3));
		System.out.println(s3.cartesianProduct(s1));
	}
}
