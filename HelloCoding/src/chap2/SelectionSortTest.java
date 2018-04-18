package chap2;


public class SelectionSortTest {
	
	/** 입력받은 배열의 인덱스를 지움.
	 * @param arr
	 * @param index
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private static Comparable[] removeElement(Comparable[] arr, int index) {
		Comparable[] result = new Comparable[arr.length-1];
		
		for(int i=0; i< result.length; i++) {
			if(i<index) {
				result[i] = arr[i];
			} else if(i>=index) {
				result[i] = arr[i+1];
			}
		}
		return result;
	}
	/** 배열에서 가장 작은 Element를 찾아서 그 인덱스를 반환.
	 * @param arr
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static int findSmallest(Comparable[] arr) {
		Comparable smallest = arr[0];
		int smallest_index = 0;
		
		for(int i=1; i<arr.length; i++) {
			if(smallest.compareTo(arr[i])>0 ) {
				smallest = arr[i];
				smallest_index = i;
			}
		}
		return smallest_index;
	}
	/** 입력받은 배열을 선택정렬로 정렬함.(시간복잡도 O(n^2))
	 * @param arr
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Comparable[] selectionSort(Comparable[] arr) {
		Comparable[] result = new Comparable[arr.length];
		int result_index = 0;
		
		while(arr.length>0) {
			int smallest = findSmallest(arr);
			result[result_index++] = arr[smallest];
			arr = removeElement(arr, smallest);
		}
		
 		return result;
	}
	public static void main(String[] args) {
		selectionSort(new Integer[]{5,3,6,2,10});
		selectionSort(new Integer[]{9,2,6,2,10});
	}

}