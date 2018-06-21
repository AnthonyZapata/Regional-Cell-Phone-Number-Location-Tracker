package dataGenerator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author pedroirivera-vega
 *
 */
public class DataReader {

	private int n;    // number of data generators (telephone companies in p1_4035_4020_172
	private int m;    // number of data sets produced per data generator
	private Integer[][][] dataSet; 
	private String parentDirectory; 
	

	public DataReader() throws FileNotFoundException {
		parentDirectory = "inputFiles"; 
		Scanner parameters = new Scanner(new File(parentDirectory, "parameters.txt")); 
		// the values of n and m shall be read from file: "inputFiles/parameters.txt". 
		this.n = parameters.nextInt(); 
		this.m = parameters.nextInt();
		parameters.close();
	}
	
	/**
	 * 
	 * @return
	 * @throws FileNotFoundException 
	 */
	public Object[][][] readDataFiles() throws FileNotFoundException {
		dataSet = new Integer[n][m][];

		for (int i=0; i<n; i++) { 
			for (int j=0; j<m; j++) {
				
				String fileName = "F_" + i + "_" + j + ".txt"; 
				Scanner inputFile = new Scanner(new File(parentDirectory, fileName)); 
				ArrayList<Integer> fileContent = new ArrayList<>(); 
				while (inputFile.hasNext())
					fileContent.add(inputFile.nextInt());
				inputFile.close();
				dataSet[i][j] = (Integer[]) fileContent.toArray(new Integer[0]);  
			}
		}	
		return dataSet; 
	}

	
	public void printSets() { 
		System.out.println("Sets Fij are: " ); 
		for (int i=0; i<n; i++)
			for (int j=0; j<m; j++) { 
				System.out.print("Set["+i+"]["+j+"] = "); 
				printArray((Integer[]) dataSet[i][j]); 
			}
	}
	
	public void printArray(Integer[] numbers) {
		for (int i=0; i<numbers.length; i++) 
			System.out.print(numbers[i] + "  "); 
		System.out.println(); 
	}


}
