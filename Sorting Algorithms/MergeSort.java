
public class MergeSort {
	 static void merge(int[] input, int start, int mid, int end){
	        int[] tmp = new int[end - start + 1];
	        int i = start, j = mid+1, k = 0;
	        while(i<=mid && j <= end){
	            if(input[i] > input[j]){
	                tmp[k++] = input[j++];
	            }
	            else {
	                tmp[k++] = input[i++];
	            }
	        }
	        
	        while(i <= mid){
	            tmp[k++] = input[i++];
	        }
	        while(j <= end){
	            tmp[k++] = input[j++];
	        }
	        for(i=start, k = 0;i<=end;i++,k++){
	            input[i] = tmp[k];
	        }
	    }
	    
	    static void mergeSortHelper(int[] input, int start, int end){
	        if(start >= end) {
	            return;
	        }
	        int mid = (start + end)/2;
	        
	        mergeSortHelper(input, start, mid);
	        mergeSortHelper(input, mid+1, end);
	        merge(input, start, mid, end);
	    }
	    
		public static void sort(int[] input){
			mergeSortHelper(input, 0, input.length - 1);
			
		}
}
