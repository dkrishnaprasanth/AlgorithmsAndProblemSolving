
public class QuickSort {
	static int partation(int[] input, int start, int end){
        int pivot = input[start];
        int count = 0;
        for(int i=start + 1;i<=end;i++){
            if(input[i] <= pivot) {
                count++;
            }
        }
        int tmp = input[start];
        input[start] = input[start + count];
        input[count + start] = tmp;
        int i = start, j = end;
        while(i < j){
            if(input[i] <= pivot){
                i++;
            }else if(input[j] > pivot){
                j--;
            }
            else{
                tmp = input[i];
                input[i] = input[j];
                input[j] = tmp;
                i++;
                j--;
            }
            
        }
        return count + start;
    }
    
    static void quickSortHelper(int[] input, int start, int end) {
        if(start >= end){
            return;
        }
        
        int pi = partation(input, start, end);
        quickSortHelper(input, start, pi-1);
        quickSortHelper(input, pi+1, end);
    }
    
	public static void sort(int[] input) {
		
        quickSortHelper(input, 0 , input.length - 1);
		
	}
}
