package chap6;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class ShortestPathTest {

	
	static String searchMangoSeller(String name) {
		String result = null;
		Map<String, String[]> graph =  getGraph(); // 정점 간의 간선 관계를 나타내기 위해 hashtable 구조로 그래프를 구현.
		
		Queue<String> search_queue = new LinkedList<>(); // 망고 판매자인지 검색해야 할 queue
		List<String> searched_list = new LinkedList<>(); // 중복 검색을 하지 않기 위해 이미 검색한 이름은 리스트에 저장.
		Collections.addAll(search_queue, graph.get(name)); // 확인할 사람의 명단을 넣음.
		
		while(!search_queue.isEmpty()) {
			String test_subject = search_queue.poll(); // 망고 판매자인지 검색할 대상.
			
			if(!searched_list.contains(test_subject)) { // 검색한적이 없으면 검색.
				if(isMangoSeller(test_subject)) { 
					System.out.println(test_subject + " is a mango seller!");
					break;
				} else { // 망고 판매자가 아니면,
					Collections.addAll(search_queue, graph.get(test_subject)); // 검색할 대상과 간선으로 연결된 모든 정점들을 검색할 큐에 넣음.
					searched_list.add(test_subject); // 검색한 이름은 리스트에 저장.
				}
			}
		}
		
		return result;
		
	}
	
	/**
	   * <B>History</B>
	   * <ul>
	   * <li>Date : 2018. 4. 26.
	   * <li>Developer : joonkim
	   * <li>망고 판매자인지 검색하는 로직(임의로 맨 끝글자에 'm'으로 끝나면 망고 판매자라고 판단함)
	   * </ul>
	   *  
	   * @param test_subject
	   * @return
	   */
	static boolean isMangoSeller(String test_subject) {
		boolean result = false;
		if(test_subject.endsWith("m")) result = true;
		return result;
	}
	
	/**
	   * <B>History</B>
	   * <ul>
	   * <li>Date : 2018. 4. 26.
	   * <li>Developer : joonkim
	   * <li>검색할 테스트 데이터.
	   * </ul>
	   *  
	   * @return
	   */
	static Map<String, String[]> getGraph() {
		Map<String, String[]> graph =  new HashMap<String, String[]>();
		graph.put("you", new String[]{"alice", "bob", "claire"});
		graph.put("bob", new String[]{"anuj", "peggy"});
		graph.put("alice", new String[]{"peggy"});
		graph.put("claire", new String[]{"thom", "jonny"});
		graph.put("anuj", new String[]{});
		graph.put("peggy", new String[]{});
		graph.put("thom", new String[]{});
		graph.put("jonny", new String[]{});
		
		return graph;
	}
	
	public static void main(String[] args) {

		searchMangoSeller("you");
		
	}

}
