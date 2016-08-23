import java.util.LinkedList;

public class Intcoll4 {

	// The inner class for ListNode
	private class ListNode
	{
		private int info;
		private ListNode link;

		public ListNode()
		{
			info=0; link = null;
		}
	}

	/**
	 * @summary the collection of integers
	 */
	private LinkedList<ListNode> c;

	/**
	 * how many items are in the collection
	 */
	private int how_many;


	/**
	 * Instantiates a Collection of Integers
	 */
	public Intcoll4()
	{
		c = new LinkedList<ListNode>();
		how_many = 0;
	}

	/** 
	 * Copies the information from a new integer collection object into this object
	 * @param obj The integer collection object
	 */
	public void copy(Intcoll4 obj)
	{
		if (this != obj)
		{
			c = new LinkedList<ListNode>();

			for(int i = 0; i < obj.how_many; i++)
			{
				c.add(obj.c.get(i));
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
		int index = 0;

		while(c.get(index).info != i && index < how_many - 1)
			index++;

		return c.get(index).info == i;
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
			ListNode newElement = new ListNode();
			newElement.info = i; //puts the number into the info slot

			if(c.size() > 0)
				c.getLast().link = newElement; //links the last element to this new element

			c.addLast(newElement); //adds the element to the list
			how_many++;
		}
	}

	/**
	 * Removes the instance of an integer from the collection
	 * @param i The integer
	 */
	public void omit(int i)
	{
		if (i > 0 && how_many > 0)
		{
			int index = 0;
			while(c.get(index).info != i && index < how_many - 1)
				index++;

			if(c.get(index).info == i){
				c.remove(index);
				how_many --;

				if(c.getLast() != c.get(index))
					c.get(index).link = c.get(index + 1); //replace the links
				else
					c.get(index).link = null; //null link if its last
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
			System.out.println(c.get(i).info); i++;
		}
	}

	/**
	 * Compares two integer collection objects
	 * @param obj The integer collection object
	 * @return true if the collections have the same values in the collection (in no particular order)
	 */
	public boolean equals(Intcoll4 obj)
	{
		int j = 0;

		//first check to see if they have the same number of integers
		boolean result = (obj.how_many == how_many); 

		while ( (j < how_many) && result)
		{
			result = obj.belongs(c.get(j).info); 
			j++;
		}
		j = 0;
		while ( (j < how_many) &&result)
		{
			result = belongs(obj.c.get(j).info); 
			j++;
		}
		return result;
	}
}
