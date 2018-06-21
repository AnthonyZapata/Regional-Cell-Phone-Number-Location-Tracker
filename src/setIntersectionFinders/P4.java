package setIntersectionFinders;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import interfaces.IntersectionFinder;
import interfaces.MySet;
import mySetImplementations.Set2;
import p1MainClasses.Part1Main;

/** Runs the algorithms from the Person 4 Esparragata asked.
 * @author Ariel Silva Troche 802-14-7864 sec090
 * @author Anthony Zapata Beltran 802-15-9208 sec090
*/
public class P4 extends AbstractIntersectionFinder implements IntersectionFinder{

	/**
	 * Sends the name to the superclass
	 * @param the name of the strategy
	 * @return the Name of the strategy to the super class
	 */
	public P4(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	/**
	 * Creates the Set to a type of String
	 * @return A string of the array 
	 * @throws FileNotFoundException
	 */	
	public String p4method() throws FileNotFoundException {
		MySet etr = intersectSets(createMegaSetP4());	
		return etr.toString();
	}
	/**
	 * Creates a set of all the numbers of all the criminals of all events from all companies using strategy 4
	 * @return a Set of type MySet<Integer> that contains all the numbers of all the criminals of all events from all companies
	 */
	public static MySet[] createMegaSetP4(){
		MySet<Integer>[] t = new MySet[Part1Main.m];
		for(int j = 0; j<Part1Main.m;j++) {
			MySet set = new Set2();
			for(int i = 0; i<Part1Main.n;i++) {
				for(int k = 0; k<Part1Main.data[i][j].length; k++) {
					set.add(Part1Main.data[i][j][k]);
				}
			}
			t[j]=set;
		}
		return t;
	}
	
	/**
	 * Gets all the numbers of all the criminals of all events from all companies using the 4th strategy
	 * @return the Intersection of sets in type MySet
	 */
	@Override
	public MySet intersectSets(MySet[] t) {
		
		ArrayList globalSet = new ArrayList();
		for(int j =0; j<Part1Main.m;j++) {
			Object[] tArray = t[j].toArray();
			for(int i=0;i<tArray.length;i++) {
				globalSet.add((Integer) tArray[i]);
			}
		}
		Collections.sort(globalSet);
		
		ArrayList<Integer> globalIntegerSet = globalSet;
		
		HashMap<Integer, Integer> map = new HashMap<>(); 
		for (Integer e : globalIntegerSet) { 
		     Integer c = map.getOrDefault(e, 0); 
		     map.put(e, c+1); 
		}
		MySet A = new Set2<>(); 
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == Part1Main.m) 
				A.add(entry.getKey()); 

		}
		    
		// TODO Auto-generated method stub
		return A;
	}

}
