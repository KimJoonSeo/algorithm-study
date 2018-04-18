package chap1;

public class BinarySearchTest {
	
	/**
	   * <B>History</B>
	   * <ul>
	   * <li>Date : 2018. 4. 18.
	   * <li>Developer : joonkim
	   * <li>target이 배열에서 몇 번째 인덱스를 갖는지 반환하는 메서드. target이 배열에 없을 경우 -1을 리턴. 시간복잡도 O(log(1,n 
	   * </ul>
	   *  
	   * @param objArr
	   * @param target
	   * @return
	   */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static int BinarySearch(Comparable[] objArr, Comparable target) {
		int result = -1;
		int low = 0;
		int high = objArr.length - 1;
		
		while(low <= high) {
			int mid = (low + high) / 2;
			Comparable guess = objArr[mid];
			if(guess.compareTo(target) == 0) {
				result = mid;
				break;
			} else if(guess.compareTo(target) > 0){
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		
		return result;
	}
	public static void main(String[] args) {
		System.out.println(BinarySearch(new String[] {"1", "3", "5", "7", "9", "11"}, "9"));
		System.out.println(BinarySearch(new String[] {"1", "3", "5", "7", "9", "11"}, "10"));
		System.out.println(BinarySearch(new String[] {"1", "3", "5", "7", "9", "11"}, "-1"));
	}

}