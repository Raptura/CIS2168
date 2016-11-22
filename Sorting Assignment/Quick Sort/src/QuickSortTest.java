import java.util.Random;
import java.util.Scanner;

public class QuickSortTest {

	static int calls = 0;
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
//		quickSort(a, 0, a.length - 1);
//
//		System.out.println("Sorted Array:");
//		for(int i = 0; i < a.length; i++){
//			System.out.println(a[i] + " ");
//		}
//		System.out.println("Done");
//		System.out.println("Numeber of Calls:" + calls);
//		System.out.println("Count: " +count);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("How many runs: ");
		int runs = sc.nextInt();
		
		makeTables(runs);
	}

	public static void quickSort(int[] arr, int top, int bottom){
		calls++;
		int p;
		if(top < bottom){
			p = partition(arr, top, bottom);
			quickSort(arr, top, p - 1);
			quickSort(arr, p + 1, bottom);
		}
	}

	public static int partition(int[] arr, int top, int bottom){
		int upper, lower, pivot;
		upper = top;
		lower = bottom;
		pivot = arr[top];

		while(upper != lower){
			while((upper < lower) && (pivot >= arr[lower])){
				lower--;
				count++;
			}

			if(upper != lower)
				arr[upper] = arr[lower];

			while((upper < lower) && (pivot <= arr[upper])){
				upper++;
				count++;
			}

			if(upper != lower)
				arr[lower] = arr[upper];
		}
		arr[upper] = pivot;

		return upper;
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
				
				quickSort(a, 0, a.length -  1);
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
