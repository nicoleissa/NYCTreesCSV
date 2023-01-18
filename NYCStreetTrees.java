package project2;

/**
 * NYCStreetTrees class is the program printing the tree species and popularity corresponding to the species the user inputs.
 * The program is interactive. 
 * The program takes in data from the provided csv file and creates objects and arraylists that store the file's header, 
 * treeIDs, common names, latin names, statuses, health, zip codes, borough names, x_sp's, and y_sp's.
 * In the interactive part, the user enters a tree species. The program responds by printing all the matching species 
 * and its popularity in NYC and its boroughs.  
 *
 * @author Nicole Issagholian
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;

public class NYCStreetTrees {
	
		//instance variables
		String fileName;
		File censusFile;
		
		/**
		 * The main() method of this program. 
		 * @param a String array args provided on the command line when the program begins; 
		 * the first string should be the name of the input file containing the data for the tree species. 
		 */
		public static void main(String[] args) {
			
			//verify that the command line argument exists
			if (args.length == 0) {
				System.err.println("Usage Error: the program expects file name as an argument.\n");
				System.exit(1);
			}
			
			//verify that command line argument contains a name of an existing file
			File censusFile = new File(args[0]); 
			
			if (!censusFile.exists()){
				System.err.println("Error: the file "+censusFile.getAbsolutePath()+" does not exist.\n"); 
				System.exit(1);
			}
			if (!censusFile.canRead()){ 
				System.err.println("Error: the file "+censusFile.getAbsolutePath()+" cannot be opened for reading.\n");
			}
			
			//arraylist holding data for header from csv file
			ArrayList<String> headerLine = new ArrayList<String>();
			
			//arraylist of type tree holding trees
			ArrayList<Tree> trees = new ArrayList<Tree>();
			
			
			TreeSpeciesList wholeList = new TreeSpeciesList(); 
			
			//treelist that contains all the trees and their corresponding data
			TreeList allTrees = new TreeList();
			
			try {
				CSV csv = new CSV(new Scanner(censusFile));		
				
				//for loop going through rows in csv file
				for (int i=0; i<csv.getNumOfRows(); i++) {
					ArrayList<String> row = csv.getNextRow();	
					
					if (row.size() == 45) {
						if (row.get(0).equals("tree_id")) {
							headerLine = row;
						}
						else {
							
							//treespecies object that contains the common name and latin name of each tree 
							TreeSpecies treeSpecies = new TreeSpecies(row.get(8), row.get(9));
							
							wholeList.add(treeSpecies);
							
							//tree object that contains the treeID and treeSpecies object for each tree
							Tree tree = new Tree(Integer.parseInt(row.get(0)), treeSpecies);
							
							//accesses data associated with each tree
							tree.setStatus(row.get(6));
							tree.setHealth(row.get(7));
							tree.setZipcode(Integer.parseInt(row.get(25)));
							tree.setBoroname(row.get(29));
							tree.setX_sp(Double.parseDouble(row.get(39)));
							tree.setY_sp(Double.parseDouble(row.get(40)));
							
							//adds all the trees and their data to the treelist
							allTrees.add(tree);
							
						}
					}
				}
			}
			catch(FileNotFoundException e) {
				System.err.println("Error: the file file"+censusFile.getAbsolutePath()+"cannot be opened for reading");
				System.exit(1);
			}
			catch (IllegalArgumentException e) {
				System.err.println("Error: null or invalid entry given.");
				System.err.println(e.getLocalizedMessage());
				System.exit(1);
			}
			
			//interactive mode
			Scanner userInput = new Scanner(System.in);
			
			System.out.println("Enter the tree species to learn more about it ('quit' to stop): ");
			String userValue = userInput.nextLine();
			
			while (userValue != "quit") {

				TreeSpeciesList matchingList = wholeList.getByCommonName(userValue); //null because wholeList is null-wholeList updated in try catch block but not accessible here
				
				//if the user input is in the species in the file
				if (matchingList != null) {	
					
					System.out.println("All matching species:");
					
					for (int i=0; i<matchingList.size(); i++) {
						System.out.println(String.format("%8s%n", matchingList));
					}
						
					System.out.println("Popularity in the city: ");
						
					String[] boroughs = {"NYC", "Manhattan", "Bronx", "Brooklyn", "Queens", "Staten Island"};
						
					//print boroughs followed by total number of all trees containing user input in each borough, 
					//then total number of trees in that borough, then percentage found by dividing first number by second x 100
					//for rounding percentage use double y = Math.round(x * 100.0) / 100.0 (where x is the number to be rounded)
					
					for (int i=0; i<boroughs.length; i++) {
						int boroList = allTrees.getCountByCommonNameBorough(userValue, boroughs[i]);
						System.out.println(String.format("%8s : %n", boroughs[i]));
						System.out.println(String.format("%03d %,.2f", "" + boroList + "(" + allTrees.getCountByBorough(boroughs[i]) + ")", ((Math.round((boroList/allTrees.getCountByBorough(boroughs[i])) * 100)) * 100.0) / 100.0 ));
					}
					
					
					System.out.println("Enter the tree species to learn more about it ('quit' to stop): ");
					String userSpec = userInput.nextLine();
						
				}	
//				else {
//					System.out.println("There are no records of " + userValue + " on NYC streets");
//				}
				
			}

			if (userValue == "quit"){
				System.exit(0);
			}

			
			userInput.close();

		}

}
