package project2;

/**
 * TreeSpeciesList class is used to store all the species objects. 
 * This class inherits all of its properties from an ArrayList<TreeSpecies>. 
 *
 * @author Nicole Issagholian
 *
 */

import java.util.ArrayList;

public class TreeSpeciesList extends ArrayList<TreeSpecies> {
	 
		public TreeSpeciesList () {
			super();
		}
	    
	    /**
		 * getByCommonName method that returns a list of species whose common name contains keyword as a substring. 
		 * @param keyword value to be used to compare to list of species.
		 * @throws IllegalArgumentException if keyword parameter is null 
		 */
	    public TreeSpeciesList getByCommonName(String keyword) throws IllegalArgumentException {   	
	    	if (keyword == null) {
	    		throw new IllegalArgumentException("Invalid input, keyword cannot be null.");
	    	}
	    	
	    	TreeSpeciesList commonList = new TreeSpeciesList();
	    	
	    	for (int i = 0; i < this.size(); i++) {
	    		TreeSpecies speciesName1 = this.get(i);
	    		
	    		if (speciesName1.getCommonName().toLowerCase().contains(keyword.toLowerCase())) {
	    			commonList.add(speciesName1);
	    		}

	        }
	        
	    	if (commonList.isEmpty()) {
	    		return null;
	    	}
	    	
	    	return commonList;
	    }
	    
	    /**
		 * getByLatinName method that returns a list of species whose Latin name contains keyword as a substring. 
		 * @param keyword value to be used to compare to list of species.
		 * @throws IllegalArgumentException if keyword parameter is null 
		 */
	    public TreeSpeciesList getByLatinName(String keyword) throws IllegalArgumentException {   	
	    	if (keyword == null) {
	    		throw new IllegalArgumentException("Invalid input, keyword cannot be null.");
	    	}
	    	
	    	TreeSpeciesList latinList = new TreeSpeciesList();
	    	
	    	for (int i = 0; i < this.size(); i++) {
	    		TreeSpecies speciesName2 = this.get(i);
	    		
	    		if (speciesName2.getLatinName().toLowerCase().contains(keyword.toLowerCase())) {
	    			latinList.add(speciesName2);
	    		}

	        }
	    	
	    	if (latinList.isEmpty()) {
	    		return null;
	    	}
	    	
	        return latinList; 
	    }
	
}
