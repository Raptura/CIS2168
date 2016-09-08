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

		public ListNode(int i, ListNode obj){
			info = i;
			link = obj;
		}
	}

	/**
	 * @summary the collection of integers head node
	 */
	private ListNode c;

	/**
	 * how many items are in the collection
	 */
	private int how_many;


	/**
	 * Instantiates a Collection of Integers
	 */
	public Intcoll4()
	{
		c = new ListNode();
		how_many = 0;
	}

	/**
	 * Instantiates a Collection of Integers with specified length
	 * @param i The specified length
	 */
	public Intcoll4(int i)
	{
		c = new ListNode();
		for(int j = 0; j < i; j++){

		}

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
			c = new ListNode(); //re-make the head node

			ListNode currentFrom = obj.c; //the info we are currently copying
			ListNode currentInto = null; //The object we are copying to
			ListNode previous = c; //the previous element

			while(currentFrom != null){
				currentInto = new ListNode(currentFrom.info, null);

				previous.link = currentInto;

				previous = currentInto;
				currentFrom = currentFrom.link; //move to the next
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

		ListNode current = c;
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
			ListNode newElement = new ListNode(i, c);
			c = newElement;

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
			ListNode current = c; //to be used when the integer is found
			while((current.link != null) && (current.info != i)){
				current = current.link;
			}

			if(current.info == i){ //if it is found
				ListNode currentLink = current.link; //even if it is null, its okay

				//Get the previous one		
				ListNode previous = c;
				while((previous.link != current)){
					previous = previous.link;
				}

				previous.link = currentLink; //set the previous one to the current's link

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

		ListNode current = c;
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
		ListNode current = c;
		while ((current != null) && result)
		{
			result = obj.belongs(current.info); 
			current = current.link;
		}

		//Second object check
		current = obj.c;
		while ((current != null) && result)
		{
			result = obj.belongs(current.info); 
			current = current.link;
		}
		return result;
	}
}
