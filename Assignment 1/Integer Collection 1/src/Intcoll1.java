public class Intcoll1
{
	/**
	 * @summary the collection of integers
	 */
	private int[] c;


	/**
	 * Instantiates a Collection of Positive Integers with a default capacity of 500
	 */
	public Intcoll1()
	{
		c = new int[500+1];
		c[0] = 0;
	}

	/**
	 * Instantiates a collection of Positive Integers with a specified capacity
	 * @param i The capacity of the collection
	 */
	public Intcoll1(int i)
	{
		c = new int[i+1];
		c[0] = 0;
	}

	/**
	 * Copies the information from an existing integer collection object into this object
	 * @param obj The integer collection object
	 */
	public void copy(Intcoll1 obj)
	{
		if (this != obj)
		{
			c = new int[obj.c.length];
			int j = 0;
			while (obj.c[j] != 0)
			{
				c[j] = obj.c[j]; j++;
			}
			c[j] = 0;
		}
	}

	/**
	 * Checks to see if the positive integer belongs in the collection
	 * @param i The integer
	 * @return true if the integer belongs in the collection and is a positive value
	 */
	public boolean belongs(int i)
	{
		int j = 0; //index variable
		while ((c[j] != 0)&&(c[j] != i)) j++; //get to the correct j value
		return ((i>0)&&(c[j] == i));
	}

	/**
	 * Inserts the integer into the collection
	 * Note: Does not insert duplicate integers
	 * @param i The integer
	 */
	public void insert(int i)
	{
		if (i > 0)
		{
			int j = 0; //index variable
			while ((c[j] != 0) && (c[j] != i)) j++; //get to the correct j value
			if (c[j] == 0)
				
			{
				if (j == c.length - 1) //if there are too many integers in the array
				{

					// ADD CODE HERE
					//expand the length of the array by recreating the array and adding to its length

					int [] newC = new int[c.length * 2];

					for(int k = 0; k < c.length; k ++){
						newC[k] = c[k];
					}

					c = newC;

				}
				c[j] = i; c[j + 1] = 0;
			}
		}
	}

	/**
	 * Removes the instance of an integer from the collection
	 * @param i The integer
	 */
	public void omit(int i)
	{
		if (i>0)
		{
			int j = 0;
			while ((c[j] != 0)&&(c[j] != i)) j++; //get to the correct j value
			if (c[j] == i)
			{
				int k = j+1;
				while (c[k] != 0) k++;
				c[j] = c[k-1]; c[k-1]=0;
			}
		}
	}

	/**
	 * @return How many integers there are in the collection
	 */
	public int get_howmany()
	{
		int j=0, howmany=0;

		while (c[j]!=0) {howmany++; j++;}
		return howmany;
	}

	/**
	 * Prints all the integers in the collection
	 */
	public void print()
	{
		int j = 0;
		System.out.println();
		while (c[j] != 0)
		{
			System.out.println(c[j]); j++;
		}
	}

	/**
	 * Compares two integer collection objects
	 * @param obj The integer collection object
	 * @return true if the collections have the same values in the collection (in no particular order)
	 */
	public boolean equals(Intcoll1 obj)
	{
		int j = 0; boolean result = true;
		while ((c[j] != 0)&&result)
		{
			result = obj.belongs(c[j]); j++;
		}
		j = 0;
		while ((obj.c[j] != 0)&&result)
		{
			result = belongs(obj.c[j]); j++;
		}
		return result;
	}
}
