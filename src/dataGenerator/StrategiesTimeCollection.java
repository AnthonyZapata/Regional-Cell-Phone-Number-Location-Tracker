package dataGenerator;

import java.io.FileNotFoundException;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Map;

import setIntersectionFinders.AbstractIntersectionFinder;
import setIntersectionFinders.GenerateDataSets;


/** Has the getters and needed methods to determine the execution time.
 * @author Ariel Silva Troche 802-14-7864 sec090
 * @author Anthony Zapata Beltran 802-15-9208 sec090
*/
public class StrategiesTimeCollection<E> extends ArrayList<Map.Entry<Integer, Float>> {
	
	public float sum, avgTime;
	private AbstractIntersectionFinder<E> strategy;
//	private int initialSize, finalSize, repetitionsPerSize, n, m, incrementsOfSize;
//	private StrategiesTimeCollection<Integer>[] resultsPerStrategy;
	AbstractMap.SimpleEntry<Integer, Float> simpleEntry;
	public static ArrayList<SimpleEntry<Integer,Float>> outPutArray = new ArrayList<>();
	
	public StrategiesTimeCollection(AbstractIntersectionFinder<E> strategy) {
		this.strategy = strategy;
	}
	/**
	 * Gets the strategy name.
	 * @return the name of the Strategy
	 */
	public String getStrategyName() {
		return strategy.getName();
	}
	
	/**
	 * Gets the strategy name.
	 * @param tc integer that refers to telephone company
	 * @param ce int that refers to the Crime event
	 * @param size int that refers to the size of the data
	 * @return A data set of all the numbers from all telephone companies and events
	 */
	public static Integer[][][] generateData(int tc, int ce, int size) {
		DataGenerator dg = new DataGenerator(tc, ce, size);
		Integer[][][] data = (Integer[][][]) dg.generateData();  

		return data;
	}
	/**
	 * Resets the sum of time.
	 * 
	 */
	public void resetSum() {
		sum = 0.0f;
	}
	
//	public void add(SimpleEntry<Integer, Float> simpleEntry) {
//		outPutArray.add(simpleEntry);
//	}
	
	/**
	 * Gives the sum of time of the implementation
	 * @return the float value of the time of some implementation
	 */
	public float getSum() {
		return sum;
	}
	
	/**
	 * Keeps adding the time for the current strategy.
	 * @param the time of the strategy
	 * @return the sum of the estimated time
	 */
	public void incSum(int estimatedTime) {
		sum += (float) estimatedTime;
	}
	
	/**
	 * Runs the strategy for the data.
	 * @param the complete data of all the events & companies
	 * @throws FileNotFoundException 
	 * @throws NumberFormatException 
	 */
	public void runTrial(Integer[][][] dataSet) throws NumberFormatException, FileNotFoundException {
		GenerateDataSets ds = new GenerateDataSets(dataSet);
		strategy.intersectSets(ds.generateSets(Integer.parseInt(strategy.getName())));
	}
	
	/**
	 * Computes the average time.
	 * @param 
	 * @return the average time
	 */
	public float computeAvgTime(int rps){
		avgTime = sum/((float) rps);
		return avgTime;
	}
}