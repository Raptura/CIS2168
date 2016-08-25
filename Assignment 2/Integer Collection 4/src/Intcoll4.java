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

			ListNode current = obj.c.peekFirst();
			while(current != null){
				c.add(current);
				current = current.link;
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

		ListNode current = c.peekFirst();
		while((current.link != null) && (current.info != i)){

			current = current.link;
		}

		return current.info == i;
	}

	/**
	 * Inserts the integer into the collection
	 * Note: Does not insert duplicate integers
	 * @param i The integer
	 */
	public void insert(int i)
	{
		if (i > 0 && belongs(i) == false)
		{
			ListNode newElement = new ListNode();
			newElement.info = i; //puts the number into the info slot

			if(how_many > 0){
				ListNode current = c.peekFirst();
				while(current.link != null)
					current = current.link;

				current.link = newElement; //links the last element to this new element
			}

			c.add(newElement); //adds the element to the list
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
			ListNode current = c.peekFirst();
			while((current.link != null) && (current.info != i)){
				current = current.link;
			}

			if(current.info == i){
				ListNode currentLink = current.link;

				//Get the previous one		
				ListNode previous = c.peekFirst();
				while((previous.link != current) && (previous.link != null)){ //second check is just a safety check, its redundant
					previous = previous.link;
				}

				previous.link = currentLink; //set the previous one to the current's link

				c.remove(current); //actually remove it now
				how_many --;
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

		ListNode current = c.peekFirst();
		while(current != null){
			System.out.println(current.info);
			current = current.link;
		}

	}

	/**
	 * Compares two integer collection objects
	 * @param obj The integer collection object
	 * @return true if the collections have the same values in the collection (in no particular order)
	 */
	public boolean equals(Intcoll4 obj)
	{
		//first check to see if they have the same number of integers
		boolean result = (obj.how_many == how_many); 

		//First object check
		ListNode current = c.peekFirst();
		while ((current != null) && result)
		{
			result = obj.belongs(current.info); 
			current = current.link;
		}

		//Second object check
		current = obj.c.peekFirst();
		while ((current != null) && result)
		{
			result = obj.belongs(current.info); 
			current = current.link;
		}
		return result;
	}
}
