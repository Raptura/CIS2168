public class MultiStringcoll {

	// The inner class for btNode
	private static class btNode
	{
		private String info;
		private int count;
		private btNode left, right;

		public btNode()
		{
			info = ""; count = 0; left= null; right=null;
		}

		public btNode(String i, btNode lt, btNode rt)
		{
			info=i; left=lt; right=rt;
		}
	}



	/**
	 * @summary the collection of integers
	 */
	private btNode c;

	/**
	 * How many elements are in the collection
	 */
	private int how_many;



	/**
	 * Instantiates a Collection of Integers
	 */
	public MultiStringcoll()
	{
		c = null;
		how_many = 0;
	}

	/**
	 * Instantiates a Collection of Integers
	 * @param i The specified length
	 */
	public MultiStringcoll(int i)
	{
		c = null;
		how_many = 0;
	}

	/** 
	 * Copies the information from a new integer collection object into this object
	 * @param obj The integer collection object
	 */
	public void copy(MultiStringcoll obj)
	{
		if (this!=obj)
		{
			how_many=obj.how_many;
			c = copyTree(obj.c);  
		}
	}

	private btNode copyTree(btNode t){
		btNode root = null;

		if(t != null){
			root = new btNode();
			root.info = t.info;
			root.count = t.count;
			root.left = copyTree(t.left);
			root.right = copyTree(t.right);
		}

		return root;
	}

	/**
	 * Checks to see if the integer belongs in the collection
	 * @param i The integer
	 * @return true if the integer belongs in the collection
	 */
	public boolean belongs(String i){
		btNode p = c;
		while((p != null) && (!p.info.equals(i))){
			if(p.info.compareTo(i) > 0)
				p = p.left;
			else
				p = p.right;
		}
		return (p != null);
	}

	/**
	 * Inserts the integer into the collection
	 * Note: Does not insert duplicate integers
	 * @param i The integer
	 */
	public void insert(String i)
	{
		if(!i.equals("###")){
			btNode pred = null;
			btNode curr = c;

			while((curr != null) && (!curr.info.equals(i))){
				pred = curr;
				if(curr.info.compareTo(i) > 0)
					curr = curr.left;
				else
					curr = curr.right;
			}

			how_many++;
			if(curr == null){
				curr = new btNode(i, null, null);
				if(pred != null){
					if(pred.info.compareTo(i) > 0)
						pred.left = curr;
					else
						pred.right = curr;
				}else
					c = curr;

				curr.count++;
			}else{
				curr.count++;
			}
		}
	}      


	/**
	 * Removes the instance of an integer from the collection
	 * @param i The integer
	 */
	public void omit(String i)
	{
		if(!i.equals("###")){
			btNode pred = null;
			btNode curr = c;

			while((curr != null) && (!curr.info.equals(i))){
				pred = curr;
				if(curr.info.compareTo(i) > 0)
					curr = curr.left;
				else
					curr = curr.right;
			}

			//iF its found
			if(curr != null){
				how_many--;
				curr.count --;

				if(curr.count == 0){
					if(curr.left != null && curr.right != null){
						btNode predq = curr;
						btNode q = curr.right;
						while(q.left != null){
							predq = q;
							q = q.left;
						}
						curr.info = q.info;

						//Q can NEVER have a left subtree
						//has a right subtree
						if (q.right != null){
							if(predq != curr)
								predq.left = q.right;
							else 
								predq.right = q.right;
							q = null;
						}
						else{ //Has no Subtrees
							//if pred isnt the current
							if(predq != curr)
								predq.left = null;
							q = null;

						}


						//If there is a left
					}else if (curr.left != null){
						if(pred != null){
							if(pred.left == curr)
								pred.left = curr.left;
							else
								pred.right = curr.left;
						}else
							c = curr.left;

						curr = null;
						//has a right subtree
					}else if (curr.right != null){
						if(pred != null){
							if(pred.right == curr)
								pred.right = curr.right;
							else
								pred.left = curr.right;
						}else
							c = curr.right;

						curr = null;
					}
					else{ //has no sub trees
						if(pred != null){
							if(pred.info.compareTo(i) > 0){
								pred.left = null;
								curr = null;
							}
							else{
								pred.right = null;
								curr = null;
							}
						}else
							c = null;
					}
				}
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
		printTree(c);
	}

	private void printTree(btNode tree){
		if(tree != null){
			printTree(tree.left);
			System.out.println(tree.info + " (" +tree.count + ")");
			printTree(tree.right);
		}
	}

	private static int toArray(btNode tree, String[] a, int i){
		int num_nodes = 0;
		if(tree != null){
			num_nodes = toArray(tree.left, a , i);
			a[num_nodes + i] = tree.info;
			num_nodes = num_nodes + 1 + toArray(tree.right, a, num_nodes + i + 1);
		}
		return num_nodes;

	}

	/**
	 * Compares two integer collection objects
	 * @param obj The integer collection object
	 * @return true if the collections have the same values in the collection (in no particular order)
	 */
	public boolean equals(MultiStringcoll obj)
	{

		boolean result = (how_many == obj.how_many);
		String[] a1 = new String[how_many];
		String[] a2 = new String[how_many];
		toArray(c, a1, 0);
		toArray(c, a2, 0);

		int i = 0;
		//They are in order, so it only makes sense to do it this way
		while(result && i < how_many){
			result = (a1[i] == a2[i]);
			i++;
		}

		return result;
	}
}
