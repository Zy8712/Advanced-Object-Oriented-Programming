package eecs2030.lab2;

public class Nickel implements Comparable<Nickel> {

	private int year;

	/**
	 * The monetary value of a nickel in cents.
	 */
	public final int CENTS = 5;
	
    /**
     * Sets year of nickel
     * @param year
     * @throws IllegalArgumentException if year is less than 1858
     */
	public Nickel (int year){
		if (year < 1858)
		{
			throw new IllegalArgumentException("Invalid year of coin");
		}
		this.year = year;
	}
	
    /**
     * 
     * @return issue year of coin
     */
	public int issueYear() 
	{
		return this.year;
	}
	
	/**
	 * 
	 * @param object other nickel coin
	 * @returns difference between issue years
	 */
	public int compareTo(Nickel other) 
	{ 
		return this.year - other.year;
	}
	
	/**
	 * @return boolean value 
	 */
	public boolean equals(Object obj)
	{
		// checking if both the object references are  
	    // referring to the same object. 
	    boolean result = true;
	    if(this == obj)
	    {
	      result = true; 
	    }
	          
	    // it checks if the argument is of the  
	    // type Nickel by comparing the classes  
	    // of the passed argument and this object. 
	    // if(!(obj instance of Nickel)) return false; ---> avoid. 
	    if(obj == null || obj.getClass()!= this.getClass()) 
	    {
	       result = false; 
	    }
	    return result;
	   } 
	
	@Override
	/**
	 * @return year of nickel
	 */
	public int hashCode() 
	{
		return this.year;
	}


}
