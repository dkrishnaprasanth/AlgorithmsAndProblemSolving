
public class HeapSort {
	static void upHeapify(int[] input, int n) {
        int childIndex = n;
        int parentIndex = (n - 1)/2;
        
        while (childIndex > 0) {
              
              if (input[childIndex] < input[parentIndex]) {
                  int tmp = input[childIndex];
                  input[childIndex] = input[parentIndex];
                  input[parentIndex] = tmp;
              }
              childIndex = parentIndex;
              parentIndex = (childIndex - 1)/2;
        }
    }
    
    static void downHeapify(int[] input, int n) {
         int parentIndex = 0;
         int childIndex1 = 2*parentIndex + 1, childIndex2 = 2*parentIndex + 2;
         
         while (childIndex1 < n) {
               int minIndex = parentIndex;
               
               if (input[minIndex] > input[childIndex1]) {
                  minIndex = childIndex1;
               }
               
               if (childIndex2 < n && input[minIndex] > input[childIndex2]) {
                  minIndex = childIndex2;
               }
               
               if (minIndex == parentIndex) {
                  break;
               }
               
               int tmp = input[minIndex];
               input[minIndex] = input[parentIndex];
               input[parentIndex] = tmp;
               
               parentIndex = minIndex;
               childIndex1 = 2*parentIndex + 1;
               childIndex2 = 2*parentIndex + 2;
         }
    }
    
	public static void sort(int input[]) {
        for (int i = 1; i < input.length; i++) {
             upHeapify(input, i);
        }
        
        for (int i = input.length - 1; i >= 0; i--) {
            int tmp = input[0];
            input[0] = input[i];
            downHeapify(input, i);
            input[i] = tmp;
        }
	}
}
