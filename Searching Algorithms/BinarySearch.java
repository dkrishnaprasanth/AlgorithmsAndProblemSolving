public class BinarySearch {
	
	static int search(int[] input, int key) {
		
		int size = input.length;
		
		int start = 0, end = size - 1;
		int index = -1;
		while (start <= end) {
			
			int mid = start + (end - start)/2;
			
			if (input[mid]  >= key) {
				index = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
			
		}
		
		if (index != -1 && input[index] == key) {
			return index;
		}
		
		return -1;
	}
	
    static int search(int[] input, int key, int start, int end) {
		
		int size = input.length;
		
		if (size == 0 || start < 0 || end > size || start > end) {
			return -1;
		}
		
		int index = -1;
		while (start <= end) {
			
			int mid = start + (end - start)/2;
			
			if (input[mid]  >= key) {
				index = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
			
		}
		
		if (index != -1 && input[index] == key) {
			return index;
		}
		
		return -1;
	}
	
}
