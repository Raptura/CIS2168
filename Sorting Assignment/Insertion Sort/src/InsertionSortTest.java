import java.util.Random;

public class InsertionSortTest {
	
	static int count = 0;

	public static void main(String[] args){
		Random rand = new Random();
		int[] a = new int[32];

		System.out.println("Initial Array:");
		for(int i = 0; i < a.length; i++){
			a[i] = rand.nextInt(5000) + 1;
			System.out.println(a[i] + " ");
		}

		System.out.println();

		insertionSort(a);

		System.out.println("Sorted Array:");
		for(int i = 0; i < a.length; i++){
			System.out.println(a[i] + " ");
		}
		System.out.println("Done");
		System.out.println("Count: " +count);
	}

	public static void insertionSort(int[] arr){
		int[] sorted = new int[arr.length];
		for(int i = 0; i < arr.length; i++){
			sorted[i] = arr[i];
		}
		
		int pos = 0;
		boolean done = false;
		while(!done){
			done = true;
			while(){
				
			}
		}
		
		for(int i = 0; i < arr.length; i++){
			arr[i] = sorted[i];
		}
		
	}
}
