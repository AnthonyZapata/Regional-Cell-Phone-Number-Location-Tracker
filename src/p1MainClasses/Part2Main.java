package p1MainClasses;

import java.io.FileNotFoundException;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;

import dataGenerator.StrategiesTimeCollection;
import setIntersectionFinders.P1andP2;
import setIntersectionFinders.P3;
import setIntersectionFinders.P4;

/** Main class for receiving and setting information from command prompt.
 * @author Ariel Silva Troche 802-14-7864 sec090
 * @author Anthony Zapata Beltran 802-15-9208 sec090
*/
public class Part2Main {

	private static int[] defParms = {10, 50, 1000, 50000, 1000, 200};
	private static int telComp, crimeEv, initSize, finalSize, increment, repetitionsPerSize;

	public static void main(String[] args) throws NumberFormatException, FileNotFoundException {


		for (int i = 0; i < args.length; i++)
			defParms[i] = Integer.parseInt(args[i]);

		telComp = defParms[0];
		crimeEv = defParms[1];
		initSize = defParms[2];
		finalSize = defParms[3];
		increment = defParms[4];
		repetitionsPerSize = defParms[5];

		ExperimentController ec = new ExperimentController(telComp, crimeEv, initSize, finalSize, increment, repetitionsPerSize); 

		/**/	
		ec.addStrategy(new StrategiesTimeCollection<Integer>(new P1andP2("1")));
		ec.addStrategy(new StrategiesTimeCollection<Integer>(new P1andP2("2")));
		ec.addStrategy(new StrategiesTimeCollection<Integer>(new P3("3")));
		ec.addStrategy(new StrategiesTimeCollection<Integer>(new P4("4")));
		/**/

		try {
			ec.run();
		} catch (CloneNotSupportedException e1) {
			e1.printStackTrace();
		}    // run the experiments on all the strategies added to the controller object (ec)

		// save the results for each strategy....
		try {
			ec.saveResults();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}