public class ExponentialSearch {
	
	static int search(int[] input, int key) {
		
		int size = input.length;
		
		if (size == 0) {
			return -1;
		}
		
		if (input[0] == key) {
			return 0;
		}
		
		
		int i = 1;
		
		while (i < size && input[i] < key) {
			i *= 2;
		}
		
		return BinarySearch.search(input, key, i/2, (i < size) ? i : size - 1);
	}
	
}
