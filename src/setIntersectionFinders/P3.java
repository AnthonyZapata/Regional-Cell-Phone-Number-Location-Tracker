package setIntersectionFinders;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

import interfaces.IntersectionFinder;
import interfaces.MySet;
import mySetImplementations.Set1;
import mySetImplementations.Set2;
import p1MainClasses.Part1Main;

/** Runs the algorithms from the Person 3 Esparragata asked.
 * @author Ariel Silva Troche 802-14-7864 sec090
 * @author Anthony Zapata Beltran 802-15-9208 sec090
*/
public class P3 extends AbstractIntersectionFinder implements IntersectionFinder{

	/**
	 * Sends the name to the superclass
	 * @param the name of the strategy
	 * @return the Name of the strategy to the super class
	 */
	public P3(String name) {
		super("3");
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * Creates the Set to a type of String
	 * @return A string of the array 
	 * @throws FileNotFoundException
	 */	
	public String p3method() throws FileNotFoundException {
		MySet etr = intersectSets(createMegaSetP3());	
	return etr.toString();
}
	
	/**
	 * Creates a set of all the numbers of all the criminals of all events from all companies
	 * @return a Set of type MySet<Integer> that contains all the numbers of all the criminals of all events from all companies
	 */
	public static MySet[] createMegaSetP3(){
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
	 * Gets all the numbers of all the criminals of all events from all companies using the 3rd strategy
	 * @return the Intersection of sets in type MySet
	 */
	@Override
	public MySet intersectSets(MySet[] t) {
		
		//converts MySet[] into a global array for sorting
		ArrayList globalSet = new ArrayList();
		for(int j =0; j<Part1Main.m;j++) {
			Object[] tArray = t[j].toArray();
			for(int i=0;i<tArray.length;i++) {
				globalSet.add((Integer) tArray[i]);
			}
		}
		Collections.sort(globalSet);
		//output set
		MySet<Integer> finalSet = new Set2();
		
		//choose first value
		if((int)globalSet.size()==0) {
			return finalSet;
		}
		Integer e = (Integer)globalSet.get(0);
		//counter
		int c = 1;
		for (int i=1; i<globalSet.size(); i++) {
			Integer toCompare = (Integer)globalSet.get(i);
			if(toCompare.equals(e)) {
				c++;
			}
			else {
				if(c==Part1Main.m) {
					finalSet.add(e);
				}
				e = (Integer)globalSet.get(i);
				c=1;
			}
		}

		if(c==Part1Main.m) {
			finalSet.add((Integer)globalSet.get(globalSet.size()-1));
		}
	
		return finalSet;
	}

}
