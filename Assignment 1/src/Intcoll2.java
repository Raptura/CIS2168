
public class Intcoll2 {

	private int[] c;
	private int how_many;

	public Intcoll2(){
		c = new int[500];
		how_many = 0;
	}

	public Intcoll2(int i){
		c = new int[i];
		how_many = 0;
	}

	public void copy(Intcoll2 obj){
		if(this != obj){
			c = new int[obj.c.length];

			//ensures that c's object data is the same
			for(int i = 0; i < obj.c.length; i++){				
				c[i] = obj.c[i];
			}

			how_many = obj.how_many;
		}
	}

	public boolean belongs(int i){

		int j = 0; //counter variable
		while(c[j] != i){
			j++;
		}

		return((i != 0) && (c[j] == i));
	}

	public void insert(int i){
		int j = 0;
		while((c[j] != 0) && (c[j] != i)){

			j++;
		}

	}

}
