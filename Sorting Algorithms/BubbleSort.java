public class BubbleSort {
	
	static void sort(int[] input) {
		
		int size = input.length;
		
		for (int i = 0; i < size; i++) {
			for (int j = 1; j < size - i; j++) {
				if (input[j] < input[j - 1]) {
					Swap.swap(input, j, j - 1);
				}
			}
		}
	}
	
}
