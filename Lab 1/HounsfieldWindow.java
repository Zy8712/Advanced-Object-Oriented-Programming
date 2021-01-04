package eecs2030.lab1;

/**
 * A class that represents a windowed view of Hounsfield units. A Hounsfield
 * window is defined by two values: (1) the window level, and (2) the window
 * width. The window level is the Hounsfield unit value that the window is
 * centered on. The window width is the range of Hounsfield unit values that the
 * window is focused on.
 * 
 * <p>
 * A window has a lower and upper bound. The lower bound is defined as the
 * window level minus half the window width:
 * 
 * <p>
 * lo = level - (width / 2)
 * 
 * <p>
 * The upper bound is defined as the window level plus half the window width:
 * 
 * <p>
 * hi = level + (width / 2)
 * 
 * <p>
 * Hounsfield units are mapped by the window to a real number in the range of
 * {@code 0} to {@code 1}. A Hounsfield unit with a value less than lo is mapped
 * to the value {@code 0}. A Hounsfield unit with a value greater than hi is
 * mapped to the value {@code 1}. A Hounsfield unit with a value v between lo
 * and hi is mapped to the value:
 * 
 * <p>
 * (v - lo) / width
 * 
 *
 */
public class HounsfieldWindow { 

	private int level; // declare fields for the window level with private access modifier
	private int width; // declare fields for the window width with private access modifier
	
	/**
	 * Initializes this window to have the specified level and width.
	 * @param level
	 * @param width
	 */
	public HounsfieldWindow(int level, int width)
	{
		setLevel(level);
		setWidth(width);
	}
	
	/**
	 * Initializes this window to have a level of 0 and a width of 400.
	 */
	public HounsfieldWindow()	
	{
	    this(0, 400); // sends values to constructor method HounsfieldWindow(int, int)
	}
	
	/**
	 * Returns the level of this window.
	 * @return level value
	 */
	public int getLevel() 
	{
		return this.level; // returns level value
	}
	
	/**
	 * Returns the width of this window.
	 * @return width value
	 */
	public int getWidth() 
	{
		return this.width; // returns width value
	}
	
	/**
	 * Sets the level of this window to the specified value returning the value that was overwritten.
	 * @param level
	 * @return old level value that was overwritten
	 */
	public int setLevel(int level) 
	{
		if (level < Hounsfield.MIN_VALUE || level > Hounsfield.MAX_VALUE) // condition if level is not within normal Hounsfield unit range
		{
			throw new IllegalArgumentException("Outisde of Hounsfield range"); // throws exception
		}
		int old = this.level; // saves old value before overwriting
		this.level = level; // sets new level value
		return old; // returns old value that was overwritten
	}
	
	/**
	 * Sets the width of this window to the specified value returning the value that was overwritten.
	 * @param width
	 * @return old width value that was overwritten
	 */
	public int setWidth(int width) 
	{
		if (width < 1) // condition if width is less than 1
		{
			throw new IllegalArgumentException("Value is less than 1"); // throws exception
		}
		int old = this.width; // saves old value before overwriting
		this.width = width; // sets new width value
		return old; // returns old value that was overwritten
	}
	
	/**
	 * Maps the value of the specified Hounsfield unit to a value between zero and one; see the class description for details.
	 * @param h
	 * @return Hounsfield mapped value
	 */
	public double map(Hounsfield h) 
	{
		double lo = (this.level + 0.0) - ((this.width + 0.0)/2); // calculates lower bound of window
		double hi = (this.level + 0.0) + ((this.width + 0.0)/2); // calculates upper bound of window
				
		if (h.get() < lo) // if Hounsfield unit is less than lo
		{
			return 0.0; // Hounsfield unit mapped to the value 0
		}
		
		else if (h.get() > hi) // if Hounsfield unit is more than hi
		{

			return 1.0; // Hounsfield unit mapped to the value 1
		}
		
		else { // if Hounsfield unit is in between 0 and 1
			return ((h.get() - (lo))/this.width); // Hounsfield unit mapped to the value
		}
		
	}
}
