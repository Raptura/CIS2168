
public class Intcoll2 {

	/**
	 * @summary the collection of integers
	 */
	private int[] c;

	/**
	 * how many items are in the collection
	 */
	private int how_many;


	/**
	 * Instantiates a Collection of Integers with a default length of 501
	 */
	public Intcoll2()
	{
		c = new int[500];
		how_many = 0;
	}

	/**
	 * Instantiates a collection of Integers with a specified length + 1
	 * @param i The length of the collection
	 */
	public Intcoll2(int i)
	{
		c = new int[i];
		how_many = 0;
	}

	/**
	 * Copies the information from a new integer collection object into this object
	 * @param obj The integer collection object
	 */
	public void copy(Intcoll2 obj)
	{
		if (this != obj)
		{
			c = new int[obj.c.length];

			for(int i = 0; i < obj.how_many; i++)
			{
				c[i] = obj.c[i];
			}

			how_many = obj.how_many;
		}
	}

	/**
	 * Checks to see if the integer belongs in the collection
	 * @param i The integer
	 * @return true if the integer belongs in the collection
	 */
	public boolean belongs(int i){

		if(how_many == 0)
			return false;

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
			while ((j < how_many) && (c[j] != i)) j++; //get to the correct j value
			if (j == how_many && c[j] != i)
			{
				if (j == c.length - 1) //if there are too many integers in the array
				{
					//expand the length of the array by recreating the array and adding two to its length

					int [] newC = new int[c.length * 2];

					for(int k = 0; k < c.length; k ++){
						newC[k] = c[k];
					}

					c = newC;

				}
				c[j] = i;
				how_many++;
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
			while ((j < how_many )&&(c[j] != i)) j++; //get to the correct j value
			if (c[j] == i)
			{
				int k = j+1;
				while (c[k] != 0) k++;
				c[j] = c[k-1]; c[k-1]=0;
				how_many--;
			}
		}
	}

	/**
	 * @return How many integers there are in the collection
	 */
	public int get_howmany()
	{
		return how_many;
	}

	/**
	 * Prints all the integers in the collection
	 */
	public void print()
	{
		System.out.println();
		for(int i = 0; i < how_many; i++){
			System.out.println(c[i]); i++;
		}
	}

	/**
	 * Compares two integer collection objects
	 * @param obj The integer collection object
	 * @return true if the collections have the same values in the collection (in no particular order)
	 */
	public boolean equals(Intcoll2 obj)
	{
		int j = 0;

		//first check to see if they have the same number of integers
		boolean result = (obj.how_many == how_many); 

		while ( (j < how_many) && result)
		{
			result = obj.belongs(c[j]); j++;
		}
		return result;
	}
}
