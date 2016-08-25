import java.util.TreeMap;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Intcoll6 {


	// The inner class for btNode
	private static class btNode
	{
		private int info;
		private btNode left, right;

		public btNode()
		{
			info=0; left=right=null;
		}

		public btNode(int i, btNode lt, btNode rt)
		{
			info=i; left=lt; right=rt;
		}
	}



	/**
	 * @summary the collection of integers
	 */

	/**
	 * How many elements are in the collection
	 */
	private int how_many;



	/**
	 * Instantiates a Collection of Integers
	 */
	public Intcoll6()
	{

	}

	/** 
	 * Copies the information from a new integer collection object into this object
	 * @param obj The integer collection object
	 */
	public void copy(Intcoll6 obj)
	{
		throw new NotImplementedException();
	}

	/**
	 * Checks to see if the integer belongs in the collection
	 * @param i The integer
	 * @return true if the integer belongs in the collection
	 */
	public boolean belongs(int i){
		throw new NotImplementedException();
	}

	/**
	 * Inserts the integer into the collection
	 * Note: Does not insert duplicate integers
	 * @param i The integer
	 */
	public void insert(int i)
	{
		throw new NotImplementedException();
	}      


	/**
	 * Removes the instance of an integer from the collection
	 * @param i The integer
	 */
	public void omit(int i)
	{
		throw new NotImplementedException();
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
		throw new NotImplementedException();
	}

	/**
	 * Compares two integer collection objects
	 * @param obj The integer collection object
	 * @return true if the collections have the same values in the collection (in no particular order)
	 */
	public boolean equals(Intcoll6 obj)
	{
		throw new NotImplementedException();
	}
}
