package project2;

/**
* TreeList class creates a linked list with a node class.
* There is a method to add a tree object to the list and several methods to get the number of tree objects associated with certain criteria.
* This class overrides the toString method.
*
* @author Nicole Issagholian
*
*/

public class TreeList {
	
	/**
   	 * node class for linked list implementation.
   	 */
	class Node {
		Tree data; 
		Node next;
		
		public Node (Tree data) {
			this.data = data;
			this.next = null;
		} 
	}
	
	public Node head = null;
	public Node tail = null;
	
	/**
   	 * add method that adds a tree object to the list.
   	 */
	public void add(Tree tree) throws IllegalArgumentException { 
		Node n = new Node(tree);
		
		if (tree == null) {
        	throw new IllegalArgumentException("Invalid input, tree cannot be null.");
        }
        else {
        	if (head == null) {
        		head = n;
        		tail = n;
        	}
        	else {
        		tail.next = n; 
                tail = n;
        	}        	
        }
        
    }

	/**
   	 * getTotalNumberOfTrees method that returns the total number of tree objects stored in the list.
   	 * @param total number of tree objects stored in the list.
   	 * @ returns total of tree objects in the list.
   	 */
    public int getTotalNumberOfTrees() { 
    	int totalTrees = 0;
    	
    	Node current = head;
    	if (current != null) {
    		while (current != null) {
        		current = current.next;
        		totalTrees++;
        	}
    	}
    	
    	return totalTrees;
    }
    
    /**
   	 * getCountByCommonName method that returns the number of tree objects in the list with the common name the same as the speciesName.
   	 * @param number tree objects in the list with the common name the same as the speciesName.
   	 * @ returns tree objects in the list with common name same as speciesName.
   	 */
    public int getCountByCommonName (String speciesName) {
    	int totalCommon = 0;
    	
    	Node current = head;
    	if (current != null) {
    		while (current != null) {
    			current = current.next;
    			
    			if (current != null) {        			
            		if ((current.data.getSpc_common().equalsIgnoreCase(speciesName))) {
            			totalCommon++;
            		}
        		}
        	}
    	}
    	
    	return totalCommon;
    }
    
    /**
   	 * getCountByLatinName method that returns the number of tree objects in the list with the Latin name the same as the speciesName.
   	 * @param number tree objects in the list with the Latin name the same as the speciesName.
   	 * @ returns tree objects in the list with Latin name same as speciesName.
   	 */
    public int getCountByLatinName (String speciesName)  {
    	int totalLatin = 0;
    	
    	Node current = head;
    	if (current != null) {
    		while (current != null) {
    			
    			if (current != null) {        		
	        		if ((current.data.getSpc_latin().equalsIgnoreCase(speciesName))) { 
	        			totalLatin++;
	        		}
    			}
    			current = current.next;
        	}
    	}
    	
    	return totalLatin;
    }
    
    /**
   	 * getCountByBorough method that returns the number of tree objects in the list located in borough equal to boroName.
   	 * @param number tree objects in the list in the borough equal to boroName.
   	 * @ returns tree objects in the list in borough equal to boroName.
   	 */
    public int getCountByBorough (String boroName) {
    	int totalBoro = 0;
    	
    	Node current = head;
    	if (current != null) {
    		while (current != null) {
    			
    			if (current != null) {
	        		if ((current.data.getBoroname().equalsIgnoreCase(boroName))) { 
	        			totalBoro++;
	        		}
    			}
    			current = current.next;
        	}
    	}
    	
    	return totalBoro;
    }
    
    /**
   	 * getCountByCommonNameBorough method that returns the number of tree objects in the list whose common name is same as speciesName and located in borough boroName.
   	 * @param number tree objects in the list in with common name equal to speciesName and in borough boroName.
   	 * @ returns tree objects in the list with common name equal to speciesName and in borough boroName.
   	 */
    public int getCountByCommonNameBorough (String speciesName, String boroName) {
    	int totalComBoro = 0;
    	
    	Node current = head;
    	if (current != null) {
    		while (current != null) {
    			
    			if (current != null) {		        		
	        		if (((current.data.getSpc_common().equalsIgnoreCase(speciesName))) && ((current.data.getBoroname().equalsIgnoreCase(boroName)))) {
	        			totalComBoro++;
	        		}
    			}
    			current = current.next;
        	}
    	}
    	
    	return totalComBoro;
    }
    
    /**
   	 * getCountByLatinNameBorough method that returns the number of tree objects in the list whose Latin name is same as speciesName and located in borough boroName.
   	 * @param number tree objects in the list in with Latin name equal to speciesName and in borough boroName.
   	 * @ returns tree objects in the list with Latin name equal to speciesName and in borough boroName.
   	 */
    public int getCountByLatinNameBorough (String speciesName, String boroName) {
    	int totalLatBoro = 0;
    	
    	Node current = head;
    	if (current != null) {
    		while (current != null) {
      			current = current.next;
      			
    			if (current != null) {	        	
	        		if (((current.data.getSpc_latin().equalsIgnoreCase(speciesName))) && ((current.data.getBoroname().equalsIgnoreCase(boroName)))) {
	        			totalLatBoro++;
	        		}
    			}
        	}
    	}
    	
    	return totalLatBoro;
    }
    
    /**
   	 * Returns total number of trees from getTotalNumberOfTrees method
   	 * @returns total number of trees 
   	 */
    @Override
    public String toString () {
    	String totalTrees = "Total number of trees is" + getTotalNumberOfTrees();
    	
    	return totalTrees;
    	
    }
	
}
