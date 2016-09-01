
public class Intcoll3 {

	/**
	 * The collections boolean counterpart
	 * indicies that have true, are those that have integers in them
	 */
	private boolean[] c;

	/**
	 * how many items are in the collection
	 */
	private int how_many;


	/**
	 * Instantiates a Collection of Integers with a default length of 501
	 */
	public Intcoll3()
	{
		c = new boolean[500];
		for(int i = 0; i < c.length; i++){
			c[i] = false;
		}
		how_many = 0;
	}

	/**
	 * Instantiates a collection of Integers with a specified length + 1
	 * @param i The length of the collection
	 */
	public Intcoll3(int i)
	{
		c = new boolean[i];
		for(int j = 0; j < c.length; j++){
			c[j] = false;
		}
		how_many = 0;
	}

	/**
	 * Copies the information from a new integer collection object into this object
	 * @param obj The integer collection object
	 */
	public void copy(Intcoll3 obj)
	{
		if (this != obj)
		{
			c = new boolean[obj.c.length];

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

		return (c[i]);

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
			if(c[i] == false){
				c[i] = true;
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
			if (c[i] == true)
			{
				c[i] = false;
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
		for(int i = 0; i < c.length; i++){
			if(c[i])
				System.out.println(i);
		}
	}

	/**
	 * Compares two integer collection objects
	 * @param obj The integer collection object
	 * @return true if the collections have the same values in the collection (in no particular order)
	 */
	public boolean equals(Intcoll3 obj)
	{
		int j = 0;

		//first check to see if they have the same number of integers
		boolean result = (obj.how_many == how_many); 

		while ((j < c.length) && result)
		{
			if(c[j])
				result = obj.belongs(j); 

			j++;
		}
		return result;
	}
}
