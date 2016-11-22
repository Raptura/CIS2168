import java.util.Random;
import java.util.Scanner;

public class MergeSortTest {

	static int calls = 0;
	static int count = 0;
	static int moves = 0;

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
//		mergeSort(a, 0, a.length - 1);
//
//		System.out.println("Sorted Array:");
//		for(int i = 0; i < a.length; i++){
//			System.out.println(a[i] + " ");
//		}
//		System.out.println("Done");
//		System.out.println("Numeber of Calls:" + calls);
//		System.out.println("Count: " +count);
//		System.out.println("Number of Moves:" +moves);
		Scanner sc = new Scanner(System.in);
		System.out.println("How many runs: ");
		int runs = sc.nextInt();
		
		makeTables(runs);

	}

	public static void mergeSort(int[] arr, int top, int bottom){
		calls++;
		if(top != bottom){
			int middle = (top + bottom) /2;
			mergeSort(arr, top, middle);
			mergeSort(arr, middle + 1, bottom);
			merge(arr, top, bottom);
		}
	}

	public static void merge(int[] arr, int top, int bottom){
		int t = top;
		int middle = (top + bottom) /2;
		int b = middle + 1;
		int pos = 0;
		int[] s = new int[bottom - top + 1];

		while((t <= middle) && (b <= bottom)){
			if(arr[t] < arr[b]){
				s[pos] = arr[t];
				t++;
			}else{
				s[pos] = arr[b];
				b++;
			}
			count++;
			pos++;
			moves++;
		}
		int last = middle;
		if(b <= bottom){
			t = b;
			last = bottom;
		}
		while(t <= last){
			s[pos] = arr[t];
			t++;
			pos++;
			moves++;
		}

		for(int i = 0; i < s.length; i++){
			arr[i + top] = s[i];
			moves++;
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
				moves = 0;
				
				//Set up the array
				for(int k = 0; k < a.length; k++){
					a[k] = rand.nextInt(5000) + 1;
				}
				
				mergeSort(a, 0, a.length -  1);
				//System.out.println(moves);
				sum += moves;
				
				if(j == 0){
					minimum = moves;
					maximum = moves;
				}else{
					if(moves > maximum)
						maximum = moves;
					if(moves < minimum)
						minimum = moves;
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
