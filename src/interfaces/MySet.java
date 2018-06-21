package interfaces;

import java.util.Iterator;

public interface MySet<E> extends Iterable<E>, Cloneable { 
    /**
     * To get the current size of the set
     * @return the current size (number of elements in it) of the set
     */
    int size();  
    
    /**
     * To detect if the set is empty.
     * @return true is set is non-empty; otherwise, it returns false.
     */
    boolean isEmpty(); 

    /** 
     * To determine if a given object belongs to the set.  
     * @param e the object to test for.
     * @return true if e is element in the set; false, otherwise.
     */
    boolean contains(E e); 

    /**
     *  To remove an element from the set. If the element to remove is not a 
     *  member of the set, then this operation has not effect. Otherwise, the
     *  specified element is removed from the set. 
     *  @param e the element to remove. 
     */
    void remove(E e); 

    /** 
     * To add an element to the set. If the specified element is already
     * an element in the set, then this operation has no effect. Otherwise, 
     * the element is added to the set. 
     * @param e the element to add. 
     */
    void add(E e); 

    /**
     *  Returns an Iterator object through which all the elements of the
     *  set can be accessed, one by one, by properly invoking that iterator’s 
     *  methods. 
     */ 
    Iterator<E> iterator(); 
    
    /**
     * To return a shallow copy of current set. 
     * @return a shallow copy of this set.
     * @throws CloneNotSupportedException
     */
    Object clone() throws CloneNotSupportedException; 
    
    /**
     * Construct an array with elements in the set. 
     * @return the array of type T[] containing all elements of the set in
     * an unspecified order. The runtime type of the array being returned
     * is that of the specified array (arr) when the method is invoked. 
     * It fills and returns the same array arr if arr.length >= this.size(); 
     * otherwise, a new array of length = this.size() and of runtime type
     * that is the same as for arr is created, filled with the elements 
     * of this set and then a reference to it returned.  
     * 
     * It is assumed that E can be casted to T. 
     * 
     * @param arr the driver array being used. 
     */
    <T> T[] toArray(T[] arr); 
    
    /**
     * Returns an array containing all of the elements in this list in 
     * and unspecified order. The returned array will be "safe" in that 
     * no references to it are maintained by this list. (In other words, 
     * this method must allocate a new array). The caller is thus free 
     * to modify the returned array.
     * 
     * @return array of type Object[] containing all the elements of
     * this set. 
     */
    Object[] toArray(); 
}

