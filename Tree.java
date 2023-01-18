package project2;

/**
 * Tree class contains methods that allow for the information of each tree to be stored.
 * The class overrides the equals, toString, and compareTo methods. 
 *
 * @author Nicole Issagholian
 *
 */

public class Tree implements Comparable<Tree> {
		
	    //data fields
		private TreeSpecies species;
	    private int tree_ID;
	    private String status;
	    private String health;
	    private String spc_latin;
	    private String spc_common;
	    private int zipCode;
	    private String boroName;
	    private double x_sp;
	    private double y_sp;
	    

	    /**
		 * Constructor that validates and sets the species of the trees and their associated IDs. 
		 * @param species and treeID to be used for this Tree.
		 * @throws IllegalArgumentException if species is null and if treeID is negative. 
		 */
	    public Tree(int treeID, TreeSpecies species) throws IllegalArgumentException {
	        if (species == null) {
	            throw new IllegalArgumentException("Invalid value for species.This cannot be null.");
	        }
	        if (treeID < 0) {
	            throw new IllegalArgumentException("Invalid value for treeID. This cannot be negative.");
	        }
	        
	        this.species = species;
	        this.tree_ID = treeID;
	        this.spc_latin = species.getLatinName();
	        this.spc_common = species.getCommonName();
	    }

	    /**
		 * getter method returning the species of the trees. 
		 * @return the species of the trees. 
		 */
	    public TreeSpecies getSpecies() {
	        return species;
	    }
	    
	    /**
		 * setter method setting the species of the trees.  
		 */
	    public void setSpecies(TreeSpecies newSpecies) throws IllegalArgumentException {	    	
	    	if (newSpecies == null) {
	    		throw new IllegalArgumentException ("The species is invalid.");
	    	}
	    	this.species = newSpecies;
	    }

	    /**
		 * getter method returning the IDs of the trees. 
		 * @return the IDs of the trees. 
		 */
	    public int getTree_ID() {
	        return tree_ID;
	    }
	    
	    /**
		 * setter method setting the IDs of the trees.  
		 */
	    public void setTree_ID(int newTree_ID) throws IllegalArgumentException {	    	
	    	if (newTree_ID < 0) {
	    		throw new IllegalArgumentException ("The tree id is invalid.");
	    	}
	    	this.tree_ID = newTree_ID;
	    }
	    
	    /**
		 * getter method returning the status of the trees. 
		 * @return the status of the trees. 
		 */
	    public String getStatus() {
	        return status;
	    }
	    
	    /**
		 * setter method setting the status of the trees.  
		 */
	    public void setStatus(String newStatus) throws IllegalArgumentException {
	    	if (!(newStatus.equalsIgnoreCase("Alive") || newStatus.equalsIgnoreCase("Dead") || newStatus.equalsIgnoreCase("Stump") || newStatus == "" || newStatus == null)) {
	    		throw new IllegalArgumentException("The status is invalid.");
	    	}
	    	this.status = newStatus;
	    	
	    }
	    
	    /**
		 * getter method returning the health of the trees. 
		 * @return the health of the trees. 
		 */
	    public String getHealth() {
	        return health;
	    }
	    
	    /**
		 * setter method setting the health of the trees.  
		 */
	    public void setHealth(String newHealth) throws IllegalArgumentException {
	    	if (!(newHealth.equalsIgnoreCase("Good") || newHealth.equalsIgnoreCase("Fair") || newHealth.equalsIgnoreCase("Poor") || newHealth == "" || newHealth == null)) {
	    		throw new IllegalArgumentException("The health is invalid.");
	    	}
	    	this.health = newHealth;
	    	
	    }
	    
	    /**
		 * getter method returning the spc_latin of the trees. 
		 * @return the spc_latin of the trees. 
		 */
	    public String getSpc_latin() {
	        return spc_latin;
	    }
	    
	    /**
		 * setter method setting the spc_latin of the trees.  
		 */
	    public void setSpc_latin(String newSpc_latin) throws IllegalArgumentException {
	    	if (newSpc_latin == null) {
	    		throw new IllegalArgumentException ("The spc_latin is invalid.");
	    	}
	    	this.spc_latin = newSpc_latin;
	    	
	    }
	    
	    /**
		 * getter method returning the spc_common of the trees. 
		 * @return the spc_common of the trees. 
		 */
	    public String getSpc_common() {
	        return spc_common;
	    }
	    
	    /**
		 * setter method setting the spc_common of the trees.  
		 */
	    public void setSpc_common(String newSpc_common) throws IllegalArgumentException {
	    	if (newSpc_common == null) {
	    		throw new IllegalArgumentException ("The spc_common is invalid.");
	    	}
	    	this.spc_common = newSpc_common;
	    	
	    }
	    
	    /**
		 * getter method returning the zip code of the trees. 
		 * @return the zip code of the trees. 
		 */
	    public int getZipcode() {
	        return zipCode;
	    }
	    
	    /**
		 * setter method setting the zip code of the trees.  
		 */
	    public void setZipcode(int newZipCode) throws IllegalArgumentException {
	    	if (newZipCode < 0 || newZipCode > 99999) {
	    		throw new IllegalArgumentException ("The zip code is invalid.");
	    	}
	    	
	    	int length = String.valueOf(newZipCode).length();
	    	
	    	if (length < 5) {
	    		String fixZip = String.format("%05d", zipCode);
	    		this.zipCode = newZipCode;
	    	}
	    	this.zipCode = newZipCode;
	    	
	    }
	    
	    /**
		* getter method returning the borough name of the trees. 
		* @return the borough name of the trees. 
		*/
		public String getBoroname() {
			return boroName;
		}
		    
		/**
		* setter method setting the borough name of the trees.  
		*/
		public void setBoroname(String newBoroName) throws IllegalArgumentException {
		    if (newBoroName == null || newBoroName == "") {
		    	throw new IllegalArgumentException ("The borough name is null/empty.");
		    }
		    if (!(newBoroName.equalsIgnoreCase("Manhattan") || newBoroName.equalsIgnoreCase("Bronx") || newBoroName.equalsIgnoreCase("Brooklyn") || newBoroName.equalsIgnoreCase("Queens") || newBoroName.equalsIgnoreCase("Staten Island"))) {
				throw new IllegalArgumentException ("The borough name is invalid.");
			}
			this.boroName = newBoroName;
		}
		
		/**
		 * getter method returning the x_sp of the trees. 
		 * @return the x_sp of the trees. 
		 */
	    public double getX_sp() {
	        return x_sp;
	    }
	    
	    /**
		 * setter method setting the x_sp of the trees.  
		 */
	    public void setX_sp(double newX_sp) {
	    	this.x_sp = newX_sp;
	    }
	    
	    /**
		 * getter method returning the y_sp of the trees. 
		 * @return the y_sp of the trees. 
		 */
	    public double getY_sp() {
	        return y_sp;
	    }
	    
	    /**
		 * setter method setting the y_sp of the trees.  
		 */
	    public void setY_sp(double newY_sp) {
	    	this.y_sp = newY_sp;
	    }
	    
	    /** Compares this object with the specified object for order. 
		 * @param o the object to be compared.
		 * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
		 */
	    @Override
	    public int compareTo(Tree t) {
	    	if (this.species.getCommonName().compareToIgnoreCase(t.species.getCommonName()) != 0) {
	    		return (this.species.getCommonName()).compareToIgnoreCase(t.species.getCommonName()); 
	    	}
	    	
	    	if (this.tree_ID < t.tree_ID) {
        		return -1;
        	}
        	if (this.tree_ID > t.tree_ID) {
        		return 1;
        	}
	    	return 0;
	    }
	    

	    /**
		 * Indicates whether some object o is "equal to" this one. 
		 * Two Tree objects are considered equal if their species are the same (ignoring upper case or lower case)
		 * @return true if this object is the same as the o argument; false otherwise.
		 */
	    @Override
	    public boolean equals(Object o) {
	    	
	    	if (this == o) {
	    		return true;
	    	}
	        if (o == null) {
	            return false;
	        }
	        if (!(o instanceof Tree)) {
	            return false;
	        }
	        
	        Tree other = (Tree) o;
	        
	        if (!(this.getSpc_common().equalsIgnoreCase(other.getSpc_common()))) { 
				return false;
			}
	        if (!(this.getSpc_latin().equalsIgnoreCase(other.getSpc_latin()))) {
	        	return false;
	        }
	        if (!(this.tree_ID == (other.tree_ID))) {
	        	return false;
	        }
	        return true;
	    }
	    
	    /**
		 * Returns the tree species and its associated ID.
		 * @returns the tree species and its associated ID. 
		 */
	    @Override
	    public String toString () {
	        return ("" + species.getCommonName() + "" + getTree_ID());
	    }
}
