public class TernarySearch {
	
	static int search(int[] input, int key) {
		
		int size = input.length;
		
		int start = 0, end = size - 1;
		int index = -1;
		while (start <= end) {
			
			int mid1 = start + (end - start)/3;
			int mid2 = end - (end - start)/3;
			
			if (input[mid1] == key) {
				index = mid1;
				end = mid1 - 1;
			} else if (input[mid2] == key) {
				index = mid2;
				start = mid1 + 1;
				end = mid2 - 1;
			} else if (input[mid1] > key) {
				end = mid1 - 1;
			} else if (input[mid2] < key) {
				start = mid2 + 1;
			} else {
				start = mid1 + 1;
				end = mid2 - 1;
			}
			
		}
		
		if (index != -1 && input[index] == key) {
			return index;
		}
		
		return -1;
	}
	
}
