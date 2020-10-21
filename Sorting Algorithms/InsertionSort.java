public class InsertionSort {
	
	static void sort(int[] input) {
		
		int size = input.length;
		
		for (int i = 0; i < size; i++) {
			for (int j = i; j > 0; j--) {
				if (input[j] < input[j - 1]) {
					Swap.swap(input, j, j - 1);
				}
			}
		}
		
		
	}
	
}
