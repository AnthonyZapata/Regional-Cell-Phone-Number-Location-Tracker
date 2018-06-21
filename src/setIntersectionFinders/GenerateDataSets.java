package setIntersectionFinders;

import interfaces.MySet;
import mySetImplementations.Set1;
import mySetImplementations.Set2;

/** Creates a Set of all the data from all the companies, in all jobs and all phones.
 * @author Ariel Silva Troche 802-14-7864 sec090
 * @author Anthony Zapata Beltran 802-15-9208 sec090
*/
public class GenerateDataSets {

	Object[][][] rawData;
	
	public GenerateDataSets(Object[][][] rawData){
		this.rawData = rawData;
	}
	
	/**
	 * Creates an Data set of type MySet[]
	 * @param The set 
	 * @return and array of type MySet with all the elements
	 */
	public MySet[] generateSets(int mySet) {
		MySet[] T = new MySet[rawData.length];
		for(int i = 0; i < rawData.length; i++) {
			if(mySet == 1)
				T[i] = new Set1();
			else
				T[i] = new Set2();
			for(int j = 0; j < rawData[i].length; j++) {
				for(int k = 0; k < rawData[i][j].length; k++) {
					T[i].add(rawData[i][j][k]);
				}
			}
		}
		return T;
	}
	
}