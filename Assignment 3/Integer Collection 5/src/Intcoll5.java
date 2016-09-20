import java.util.LinkedList;
import java.util.ListIterator;

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
	 * @param i The length of the collection
	 */
	public Intcoll5(int i)
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
			ListIterator<Integer> iterator = c.listIterator();
			int current = 0;
			while(iterator.hasNext() && current != i){
				current = iterator.next();
			}
			if(current == i)
				iterator.remove();
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
		ListIterator<Integer> iterator = c.listIterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}

	/**
	 * Compares two integer collection objects
	 * @param obj The integer collection object
	 * @return true if the collections have the same values in the collection (in no particular order)
	 */
	public boolean equals(Intcoll5 obj)
	{

		//first check to see if they have the same number of integers
		boolean result = (c.size() == obj.c.size()); 

		ListIterator<Integer> I1 = c.listIterator();

		while(I1.hasNext() && result){
			result = obj.c.contains(I1.next());
		}

		return result;
	}
}
