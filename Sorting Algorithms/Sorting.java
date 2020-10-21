import java.util.*;

public class Sorting {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		
		int[] input = new int[size];
		
		for (int i = 0; i < size; i++) {
			input[i] = in.nextInt();
		}
		
		
//		BubbleSort.sort(input);
//		CountingSort.sort(input);
//		HeapSort.sort(input); // sort descending
//		InsertionSort.sort(input);
//		MergeSort.sort(input);
//		QuickSort.sort(input);
		SelectionSort.sort(input);
		
		
		
		print(input);
		
	}
	
	
	public static void print(int[] input) {
		
		for (int i : input) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		
	}
	
}
