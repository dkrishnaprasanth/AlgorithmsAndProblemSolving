import java.util.Arrays;
import java.util.Scanner;

public class Search {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int size = in.nextInt();
		int[] arr = new int[size];
		
		for (int i = 0; i < size; i++) {
			arr[i] = in.nextInt();
		}
		
		Arrays.sort(arr);
		int key = in.nextInt();
		
		System.out.println(BinarySearch.search(arr, key));
		System.out.println(TernarySearch.search(arr, key));
		System.out.println(JumpSearch.search(arr, key));
		System.out.println(ExponentialSearch.search(arr, key));
		
	}
}
