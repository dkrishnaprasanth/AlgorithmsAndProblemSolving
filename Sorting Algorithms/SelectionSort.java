public class SelectionSort {
	
	static void sort(int[] input) {
		
		int size = input.length;
		
		for (int i = 0; i < size; i++) {
			int minIndex = i;
			for (int j = i + 1; j < size; j++) {
				if (input[minIndex] > input[j]) {
					minIndex = j;
				}
			}
			Swap.swap(input, i, minIndex);
		}
	}
	
}
