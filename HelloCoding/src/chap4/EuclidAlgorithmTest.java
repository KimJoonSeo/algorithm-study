package chap4;

public class EuclidAlgorithmTest {
	
	/**
	   * <B>History</B>
	   * <ul>
	   * <li>Date : 2018. 4. 23.
	   * <li>Developer : joonkim
	   * <li>유클리드 호제법으로 최대공약수 구하기. 
	   * </ul>
	   * <li>a>=b일떼, gcd(a, b) = gcd(b, r)
	   *  
	   * @param a
	   * @param b
	   * @return
	   */
	public static int gcd(int a, int b) {
		if (a % b == 0) return b;
        else return gcd(b, a % b);
		
	}
	public static void main(String[] args) {
		System.out.println(gcd(1112,264));
	}

}
