public class Swap {
	
	static void swap(int[] input, int index1, int index2) {
		
		int size = input.length;
		
		if (index1 < 0 || index1 >= size || index2 < 0 || index1 >= size) {
			return;
		}
		
		int tmp = input[index1];
		input[index1] = input[index2];
		input[index2] = tmp;
		
	}
	
}
