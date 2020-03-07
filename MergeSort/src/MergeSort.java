
public class MergeSort {
	
	void mergeSort(int low, int high, int[] arr, int[] tempArr) {
		if(low < high) {
			int mid = (low+high)/2;
			mergeSort(low, mid, arr, tempArr);
			mergeSort(mid+1, high, arr, tempArr);
			merge(low, mid, high, arr, tempArr);
		}
	}
	
	private void merge(int low, int mid, int high, int[] arr, int[] tempArr) {		
		int l = low;
		int r = mid+1;
		int k = low;
		
		while(l <= mid && r<=high) {
			if(arr[l] <= arr[r]) {
				tempArr[k++] = arr[l++];
			}else {
				tempArr[k++] = arr[r++];
			}
		}
		
		while(l<=mid) {
			tempArr[k++] = arr[l++];
		}
		while(r<=high) {
			tempArr[k++] = arr[r++];
		}
		
		for(int i=low; i<=high; i++) {
			arr[i] = tempArr[i];
		}
	}

	public static void main(String[] args) {
		int arr[] = {1,2,34,9,11,43,98,0,111,45,90,677,-1,-8,-9,400};
		int tempArr[] = new int[arr.length];
		MergeSort mergeSort = new MergeSort();
		mergeSort.mergeSort(0, arr.length-1, arr, tempArr);
		
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
