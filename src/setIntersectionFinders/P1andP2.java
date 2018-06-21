package setIntersectionFinders;

import java.io.FileNotFoundException;

import java.util.ArrayList;

import interfaces.IntersectionFinder;
import interfaces.MySet;
import mySetImplementations.Set1;
import p1MainClasses.Part1Main;

/** Runs the algorithms from the Persons 1 and 2 Esparragata asked.
 * @author Ariel Silva Troche 802-14-7864 sec090
 * @author Anthony Zapata Beltran 802-15-9208 sec090
*/
@SuppressWarnings("hiding")
public class P1andP2<E> extends AbstractIntersectionFinder<Integer> implements IntersectionFinder<Integer>{
	Part1Main main = new Part1Main();

	/**
	 * Sends the name to the superclass
	 * @return the Name of the strategy to the super class
	 */
	public P1andP2(String name) {
		super(name);		
		// TODO Auto-generated constructor stub
	}
	/**
	 * Sets the type equal to 1 for using Set1 and returns an array of the Set 
	 * @return A string of the array 
	 * @throws FileNotFoundException
	 */
	public String p1method() throws FileNotFoundException {
		Part1Main.setType=1;
			MySet<Integer> etr = intersectSets(Part1Main.mySetArrayCreator());	
		return etr.toString();
	}
	/**
	 * Sets the type equal to 2 for using Set2 and returns an array of the Set 
	 * @return A string of the array 
	 * @throws FileNotFoundException
	 */
	public String p2method() throws FileNotFoundException {
		Part1Main.setType=2;
		   MySet<Integer> etr = intersectSets(Part1Main.mySetArrayCreator());	
		return etr.toString();
	}
	

	/**
	 * Gets all the numbers of all the criminals of all events from all companies
	 * @throws FileNotFoundException
	 * @return a Set of type MySet<Integer> that contains all the numbers of all the criminals of all events from all companies
	 */
	@Override
	public MySet<Integer> intersectSets(MySet<Integer>[] t) throws FileNotFoundException {
		
			MySet<Integer> megaSet = Part1Main.createMegaSet();

			for(int x = 0; x < t.length; x++) {
				for(int j = 0; j<Part1Main.m; j++) {
					if(!(t[x].contains((Integer) megaSet.toArray()[j]))) {
						megaSet.remove(x);
					}
				}
			}

			return megaSet;

		}

	
		

	

	
	
	
}
