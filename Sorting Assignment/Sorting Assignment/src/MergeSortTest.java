import java.util.Random;

public class MergeSortTest {

	static int calls = 0;
	static int count = 0;
	static int moves = 0;

	public static void main(String[] args){
		Random rand = new Random();
		int[] a = new int[32];

		System.out.println("Initial Array:");
		for(int i = 0; i < a.length; i++){
			a[i] = rand.nextInt(5000) + 1;
			System.out.println(a[i] + " ");
		}

		System.out.println();

		mergeSort(a, 0, a.length - 1);
		
		System.out.println("Sorted Array:");
		for(int i = 0; i < a.length; i++){
			System.out.println(a[i] + " ");
		}
		System.out.println("Done");
		System.out.println("Numeber of Calls:" + calls);
		System.out.println("Count: " +count);
		System.out.println("Number of Moves:" +moves);
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
}
