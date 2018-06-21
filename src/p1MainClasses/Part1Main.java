package p1MainClasses;

import dataGenerator.DataReader;
import interfaces.MySet;
import mySetImplementations.Set1;
import mySetImplementations.Set2;
import setIntersectionFinders.P1andP2;
import setIntersectionFinders.P3;
import setIntersectionFinders.P4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/** Main class for running all the types of solutions.
 * @author Ariel Silva Troche 802-14-7864 sec090
 * @author Anthony Zapata Beltran 802-15-9208 sec090
*/
public class Part1Main {
	
	
	public static int n;
	public static int m;
	public static Object[][][] data;
	public static int setType;
	
	public static void main(String[] args) throws FileNotFoundException{




		Scanner parameters = new Scanner(new File("inputFiles" , "parameters.txt")); 
		// the values of n and m shall be read from file: "inputFiles/parameters.txt". 
		n = parameters.nextInt(); 
		m = parameters.nextInt();
		parameters.close();
		
		FilesGeneratorMain main;
		
		


		DataReader dataReader = new DataReader();
		data = dataReader.readDataFiles();
		
		if(args.length>0) {
			if(args[0].equals("1")) {
				System.out.println(p1());
			}
			if(args[0].equals("2")) {
				System.out.println(p2());
			}
			if(args[0].equals("3")) {
				System.out.println(p3());
			}
			if(args[0].equals("4")) {
				System.out.println(p4());
			}

		}
		else if(args.length==0) {
			System.out.println(p1());
			System.out.println(p2());
			System.out.println(p3());
			System.out.println(p4());
			
		}
		
		
	}
	/**
	 * Determines which Set to use.
	 * @param the integer of the type of set to be used
	 * @return the int for type of Set to be used 
	 */
	public static int type(String[] args) {
		
		if(args.toString() == "1") {
			setType =1;
		}
		else {
			setType = 2;
		}
		return setType;
	}
	
	/**
	 * Gets the data element corresponding to given position.
	 * @param i int for the given company
	 * @param j int for the current job
	 * @return the data element in an Array of Integer
	 */
	public Integer[] getDataElement(int i, int j){
		return ((Integer[]) data[i][j]);
	}

	/**
	 * Sends 1 to run the Set 1 method
	 * @return 
	 * @throws FileNotFoundException
	 */
	public static String p1() throws FileNotFoundException{
		P1andP2<Integer> p1p2 = new P1andP2<Integer>("1");
		
		
		return p1p2.p1method();
	}
	/**
	 * Sends 2 to run the Set 1 method
	 * @return Runs the method for Set 2
	 * @throws FileNotFoundException
	 */
	public static String p2() throws FileNotFoundException {
		P1andP2<Integer> p1p2 = new P1andP2<Integer>("2");
		
		return p1p2.p2method();
	}
	/**
	 * Sends 3 to run the third strategy
	 * @return Runs the method for the third strategy
	 * @throws FileNotFoundException
	 */
	public static String p3() throws FileNotFoundException {
		P3 p3 = new P3("3");
		
		return p3.p3method();
	}
	/**
	 * Sends 4 to run the fourth strategy
	 * @return Runs the method for the 4th strategy
	 * @throws FileNotFoundException
	 */
	public static String p4() throws FileNotFoundException {
		P4 p4 = new P4("4");
		return p4.p4method();
	}
	
	/**
	 * Creates Files for each Job containing all the companies for that job
	 * @throws FileNotFoundException
	 */
	public static void createJFiles() throws FileNotFoundException {
		for(int j = 0; j<m; j++) {
			//crea J files
			String fileName = "J_" + j +".txt"; 	
			PrintWriter out = new PrintWriter(new File("ArrayHolder", fileName));
			//para cada J file, add todas las k en i
			for(int i = 0; i<n; i++) {	
				for (int k=0; k<data[i][j].length; k++)
					out.println(data[i][j][k]);
			}
			out.close();
		}
	}
	
	/**
	 * Creates an array of MySet with all the data
	 * @return An array of type MySet<Integer>
	 * @throws FileNotFoundException
	 */
	public static MySet<Integer>[] mySetArrayCreator() throws FileNotFoundException {
		MySet[] t = new MySet[data.length];
	
		for(int i = 0; i<data.length;i++) {
			if(setType==1) {
				t[i] = new Set1();
				
			}
			else {
				t[i]= new Set2();
			}
			for(int j = 0; j<data[i].length;j++) {
				for(int k = 0; k<data[i][j].length; k++) {
					t[i].add(data[i][j][k]);
				}
			}			
		}		
		return t;		
	}

	/**
	 * Sends 3 to run the Set 1 method
	 * @return A file of all the phones of all the companies for all events
	 * @throws FileNotFoundException
	 */
	public static MySet<Integer> createMegaSet() throws FileNotFoundException {
		MySet<Integer> fileContent;
		
		if(setType == 1) {
			fileContent = new Set1();
			
		}
		else {
			fileContent = new Set2();
		}
		
		for(int j = 0; j<m;j++) {
			String filename = "J_" + j + ".txt"; 
			Scanner inputFile = new Scanner(new File("ArrayHolder", filename)); 
			
			while (inputFile.hasNext())
				fileContent.add(inputFile.nextInt());
			
			inputFile.close();
		}

		return fileContent;
	}	
}
