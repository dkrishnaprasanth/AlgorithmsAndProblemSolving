public class CountingSort {
	
	public static void sort(int[] input) {
		
		int size = input.length;
		
		int max = input[0];
		for (int i = 0; i < size; i++) {
			max = Math.max(input[i], max);
		}
		
		int[] map = new int[max + 1];
		
		for (int i = 0; i < size; i++) {
			map[input[i]]++;
		}
		
		int index = 0;
		for (int i = 0; i <= max; i++) {
			while(map[i] > 0) {
				input[index++] = i;
				map[i]--;
			}
		}
		
	}
	
}
