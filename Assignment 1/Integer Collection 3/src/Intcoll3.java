
public class Intcoll3 {
	/**
	 * @summary the collection of integers
	 */
	private int[] collection;


	/**
	 * 
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
		collection = new int[500];
		c = new boolean[500];
		how_many = 0;
	}

	/**
	 * Instantiates a collection of Integers with a specified length + 1
	 * @param i The length of the collection
	 */
	public Intcoll3(int i)
	{
		collection = new int[i];
		c = new boolean[i];
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
			collection = new int[obj.collection.length];

			for(int i = 0; i < obj.how_many; i++)
			{
				collection[i] = obj.collection[i];
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

		int j = 0; //index variable
		while ((collection[j] != 0)&&(collection[j] != i)) j++; //get to the correct j value
		return ((i>0)&&(collection[j] == i));


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
			while ((collection[j] != 0) && (collection[j] != i)) j++; //get to the correct j value
			if (j > how_many - 1)
			{
				if (j == collection.length - 1) //if there are too many integers in the array
				{

					// ADD CODE HERE
					//expand the length of the array by recreating the array and adding two to its length

					int [] newCollection = new int[collection.length + 1];
					boolean[] newC = new boolean[collection.length + 1];
					
					for(int k = 0; k < collection.length; k ++){
						newCollection[k] = collection[k];
					}

					collection = newCollection;

				}
				collection[j] = i;
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
			int j = 0; //indexer for omission
			while ((collection[j] != 0) && (collection[j] != i)) j++; //get to the correct j value

			if (collection[j] == i)
			{
				int k = j + 1; //indexer to replace
				while (collection[k] != 0) 
					k++; //get to the correct k value

				collection[j] = collection[k-1]; 
				c[j] = true; //Repetitive but, i wanted to ensure it stayed true
				collection[k - 1] = 0;
				c[k] = false;
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
			System.out.println(collection[i]); i++;
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

		while ( (j < how_many) && result)
		{
			result = obj.belongs(collection[j]); j++;
		}
		j = 0;
		while ( (j < how_many) &&result)
		{
			result = belongs(obj.collection[j]); j++;
		}
		return result;
	}
}
