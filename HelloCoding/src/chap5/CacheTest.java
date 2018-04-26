package chap5;

import java.util.Hashtable;

/**
   * <B>Project Name : </B>HelloCoding<br/>
   * <B>Package Name : </B>chap5<br/>
   * <B>File Name : </B>CacheTest<br/>
   * <B>Description</B>
   * <ul> 
   * <li>Hashtable로 캐싱을 본따 만들어봄.
   * <li>시나리오: 특정 URI로 접근함 -> URI에 대한 데이터가 이미 캐싱되어 있으면 그 데이터를 리턴
   * <li>그렇지 않을 경우 서버에서 URI에 대한 데이터를 생성하고 캐시에 저장후 리턴.
   * </ul>
   * 
   * @author joonkim
   * @since 2018. 4. 25.
   */
public class CacheTest {
	private static Hashtable<String, Object> cache = new Hashtable<>(); //캐싱할 데이터
	
	private static Object getPage(String url){
		Object result;
		
		if(cache.get(url) == null) {
			result = getDataFromServer(url);
			cache.put(url, result);
		} else {
			result = cache.get(url);
		}
		
		return result;
	}
	
	private static Object getDataFromServer(String url){
		return "Data About "+ url + "From Server";
	}
	
	public static void main(String[] args) {
		cache.put("joon.com", "joonkim");
		cache.put("mi.com", "yumi");
		getPage("joon.com");
		getPage("sook.com");
		getPage("mi.com");
		getPage("joon.com");
	}

}
