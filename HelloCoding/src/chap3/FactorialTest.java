package chap3;

public class FactorialTest {
	private static int fact(int n) {
		if(n < 1) {
			return -1;
		} // 이 부분은 n이 0 이하의 수가 들어왔을때 반환하는 값.
		
		if(n == 1) {
			return 1; // 기본단계(무한으로 빠지지 않게 하기 위한 단계)
		} else {
			return n * fact(n-1); // 재귀단계
		}
	}
	
	public static void main(String[] args) {
		System.out.println(fact(10));
	}
}
