import java.util.Random;

public class QuickSortTest {

	static int calls = 0;
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

		quickSort(a, 0, a.length - 1);

		System.out.println("Sorted Array:");
		for(int i = 0; i < a.length; i++){
			System.out.println(a[i] + " ");
		}
		System.out.println("Done");
		System.out.println("Numeber of Calls:" + calls);
		System.out.println("Count: " +count);
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
}
