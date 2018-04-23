package chap4;

import java.util.stream.Stream;

public class QuickSortTest {
	/**
	   * <B>History</B>
	   * <ul>
	   * <li>Date : 2018. 4. 23.
	   * <li>Developer : joonkim
	   * <li>퀵 소팅으로 정수 배열을 소팅.
	   * </ul>
	   * <li>배열을 기준원소를 기준으로 작은 원소의 배열과 큰 원소의 배열, 두 개의 하위 배열로 분할. 하위 배열들에 재귀적으로 퀵 소팅.
	   *  
	   * @param arr
	   * @return
	   */
	public static Integer[] quickSort(Integer[] arr) {
		if(arr.length < 2) {
			return arr;
		} else {
			int pivot = arr[arr.length-1];
			Integer[] left = Stream.of(arr).limit(arr.length-1).filter(t -> t <= pivot).toArray(Integer[]::new); // pivot보다 작은 원소들
			Integer[] right = Stream.of(arr).limit(arr.length-1).filter(t -> t > pivot).toArray(Integer[]::new); // pivot보다 큰 원소들
			
			return Stream.concat(Stream.concat(Stream.of(quickSort(left)), Stream.of(pivot)),Stream.of(quickSort(right))).toArray(Integer[]::new);
		}
	}
	
	public static void main(String[] args) {
		Integer[] ll = quickSort(new Integer[]{17,2,31,5,4,5,7,8,19,20});
		System.out.println("");
	}

}
