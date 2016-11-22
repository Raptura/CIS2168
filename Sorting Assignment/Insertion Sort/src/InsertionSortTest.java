import java.util.Random;
import java.util.Scanner;

public class InsertionSortTest {

	static int count = 0;

	public static void main(String[] args){
		//		Random rand = new Random();
		//		int[] a = new int[32];
		//
		//		System.out.println("Initial Array:");
		//		for(int i = 0; i < a.length; i++){
		//			a[i] = rand.nextInt(5000) + 1;
		//			System.out.println(a[i] + " ");
		//		}
		//
		//		System.out.println();
		//
		//		insertionSort(a);
		//
		//		System.out.println("Sorted Array:");
		//		for(int i = 0; i < a.length; i++){
		//			System.out.println(a[i] + " ");
		//		}
		//		System.out.println("Done");
		//		System.out.println("Count: " +count);

		Scanner sc = new Scanner(System.in);
		System.out.println("How many runs: ");
		int runs = sc.nextInt();

		makeTables(runs);
	}

	public static void insertionSort(int[] arr){
		int temp;

		for(int i = 1; i < arr.length; i++){
			for(int j = i; j > 0; j--){
				if(arr[j] < arr[j - 1]){
					temp = arr[j];
					arr[j] = arr[j - 1];
					arr[j - 1] = temp;
					count++;
				}
			}
		}

	}

	public static void makeTables(int amt){
		//Size, Minimum, Average, Max
		int[][] table = new int[4][4];
		table[0][0] = 2048;
		table[1][0] = 4096;
		table[2][0] = 8192;
		table[3][0] = 16384;

		Random rand = new Random();

		for(int i = 0; i < 4; i++){

			int sum = 0;
			int minimum = 0;
			int maximum = 0;

			for (int j = 0; j < amt; j++){
				int a[] = new int[table[i][0]];
				count= 0;

				//Set up the array
				for(int k = 0; k < a.length; k++){
					a[k] = rand.nextInt(5000) + 1;
				}

				insertionSort(a);
				//System.out.println(moves);
				sum += count;

				if(j == 0){
					minimum = count;
					maximum = count;
				}else{
					if(count > maximum)
						maximum = count;
					if(count < minimum)
						minimum = count;
				}
			}
			table[i][1] = minimum;
			table[i][2] = sum / amt;
			table[i][3] = maximum;
		}

		for(int i = 0; i < table.length; i++){
			System.out.println("Array Size: " +table[i][0]);
			System.out.println("Minimum: " +table[i][1]);
			System.out.println("Average: " +table[i][2]);
			System.out.println("Maximum: " +table[i][3]);
			System.out.println();
		}
	}
}
