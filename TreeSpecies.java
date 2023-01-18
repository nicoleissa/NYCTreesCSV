package project2;

/**
 * TreeSpecies class represents a single tree species by their common name and Latin name 
 * and compares the TreeSpecies objects.
 * The class overrides the equals method. 
 *
 * @author Nicole Issagholian
 *
 */

public class TreeSpecies {
	
	//instance variables
	private String commonName;
	private String latinName;
	
	
	/**
	 * Constructor that validates and sets common name and Latin name of tree species. 
	 * @param commonName and latinName to be used for this TreeSpecies.
	 * @throws IllegalArgumentException if commonName or latinName is null string. 
	 */
	public TreeSpecies (String commonName, String latinName) throws IllegalArgumentException {
		if (commonName == null || latinName == null) {
			throw new IllegalArgumentException("The arguments cannot be null.");
		}
		
		this.commonName = commonName;
		this.latinName = latinName;
	}
	
	/**
	 * Accessor method returning the common name of the trees. 
	 * @return the common name of the trees. 
	 */
    public String getCommonName(){
        return commonName;
    }

    /**
	 * Accessor method returning the latin name of the trees. 
	 * @return the latin name of the trees. 
	 */
    public String getLatinName(){
        return latinName;
    }
	
	/** 
	 * Compares this object with the specified object. 
	 * @param o the object to be compared.
	 * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null) {
			return false;
		}
		if (!(o instanceof TreeSpecies)) {
			return false;
		}
		
		TreeSpecies other = (TreeSpecies) o;
		
		if ((this.commonName.equalsIgnoreCase(other.getCommonName())) && (this.latinName.equalsIgnoreCase(other.getLatinName()))) {
			return true;
		}
		return false;
	}

}
