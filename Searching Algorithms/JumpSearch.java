public class JumpSearch {
	
	static int search(int[] input, int key) {
		
		int size = input.length;
		
		int step = (int)Math.sqrt(size);
		int incr = (int)Math.sqrt(size);
		int prev = -1;
		while (input[Math.min(size, step) - 1] < key) {
			
			prev = step;
		    step += incr;
			
		    if (prev >= size) {
		    	return -1;
		    }
		}
		
		while(input[prev] < key) {
			prev++;
			
			if (prev >= size) {
				return -1;
			}
		}
		
		if (input[prev] == key) {
			return prev;
		}
		
		return -1;
	}
	
	
}
