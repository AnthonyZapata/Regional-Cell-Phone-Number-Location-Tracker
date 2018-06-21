package mySetImplementations;

import java.lang.reflect.Array;
import java.util.Iterator;

import interfaces.MySet;

public abstract class AbstractMySet<E> implements MySet<E> {
	public boolean isEmpty() { 
		return size() == 0; 
	}
	
	public String toString() { 
		String s = ""; 
		boolean first = true; 
		for (E e : this) {
			if (first) {
				s = "{" + e; 
				first = false;     
			}
			else
				s += ", " + e;
		}
		return s + "}"; 
	}
	
	public <T> T[] toArray(T[] arr) { 
	    if (arr.length < this.size()) { 
	        // if arr.length < this.size, allocate a new array of the same 
	    	// type as arr (components of the new array are set to be of equal
	    	// runtime type as components of the original array arr) 
	    	// and big enough to hold all the elements in this set. For 
	    	// this, we need to use the Array class....
	    	arr = (T[]) Array.newInstance(arr.getClass().getComponentType(), this.size());
	    } else if (arr.length > this.size()) 
	    	// Set to null all those positions of arr that won't be used. 
	    	for (int j=this.size(); j< arr.length; j++) 
	    		arr[j] = null;
	    
	    int i = 0;
	    for (E e: this) {
	    	arr[i] = (T) e;   // It is assumed E can be casted to T
	        i++;
	    }
	    return arr;	
	}
	
	public Object[] toArray() { 
		Object[] array = new Object[this.size()]; 
	    int i = 0;
	    for (E e: this) {
	        array[i] = e;
	        i++;
	    }
	    return array;	

	}
	
	public abstract Iterator<E> iterator(); 
	public abstract Object clone()  throws CloneNotSupportedException; 
}

