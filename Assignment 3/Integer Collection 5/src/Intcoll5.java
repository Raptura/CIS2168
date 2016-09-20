import java.util.LinkedList;

public class Intcoll5 {
	/**
	 * @summary the collection of integers
	 */
	private LinkedList<Integer> c;


	/**
	 * Instantiates a Collection of Integers
	 */
	public Intcoll5()
	{
		c = new LinkedList<Integer>();
	}

	/** 
	 * Copies the information from a new integer collection object into this object
	 * @param obj The integer collection object
	 */
	public void copy(Intcoll5 obj)
	{
		if (this != obj)
		{
			c = new LinkedList<Integer>();

			for(int i = 0; i < obj.c.size(); i++)
			{
				c.add(obj.c.get(i));
			}
		}
	}

	/**
	 * Checks to see if the integer belongs in the collection
	 * @param i The integer
	 * @return true if the integer belongs in the collection
	 */
	public boolean belongs(int i){
		return c.contains(i);
	}

	/**
	 * Inserts the integer into the collection
	 * Note: Does not insert duplicate integers
	 * @param i The integer
	 */
	public void insert(int i)
	{
		if ((i>0)&&(!c.contains(i))) 
		{  
			c.add(i);
		}
	}      


	/**
	 * Removes the instance of an integer from the collection
	 * @param i The integer
	 */
	public void omit(int i)
	{
		if (i > 0 && c.contains(i))
		{
			int index = 0;
			while(c.get(index) != i && index < c.size()){
				if(index < c.size() - 1) index++;
			}

			if(c.get(index) == i){
				c.remove(index);
			}
		}
	}

	/**
	 * @return How many integers there are in the collection
	 */
	public int get_howmany()
	{
		return c.size();
	}

	/**
	 * Prints all the integers in the collection
	 */
	public void print()
	{
		System.out.println();
		for(int i = 0; i < c.size(); i++){
			System.out.println(c.get(i)); i++;
		}
	}

	/**
	 * Compares two integer collection objects
	 * @param obj The integer collection object
	 * @return true if the collections have the same values in the collection (in no particular order)
	 */
	public boolean equals(Intcoll5 obj)
	{
		int j = 0;

		//first check to see if they have the same number of integers
		boolean result = (c.size() == obj.c.size()); 

		while ( (j < c.size()) && result)
		{
			result = obj.belongs(c.get(j)); j++;
		}
		j = 0;
		while ( (j < c.size()) &&result)
		{
			result = belongs(obj.c.get(j)); j++;
		}
		return result;
	}
}
