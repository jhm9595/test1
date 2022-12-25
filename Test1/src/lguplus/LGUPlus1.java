package lguplus;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LGUPlus1 {

	public static void main(String[] args) {
	
		int[] num = {112, 211, 811, 1012, 569, 818, 118};
		
		System.out.println(classfy(num));
	}
	
	public static int classfy(int[] num) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		String[] arr;
		StringBuilder sb;
		String key;
		for(int n : num) {
			arr = String.valueOf(n).split("");
			
			Arrays.sort(arr);
			
			sb = new StringBuilder();
			for(String s : arr) {
				sb.append(s);
			}
			
			key = sb.toString();
			if(map.containsKey(key)) {
				map.put(key, map.get(key) + 1);
			}else {
				map.put(key, 1);
			}
		}
		

		for(Entry<String, Integer> entry : map.entrySet()) {
			System.out.println("key : " + entry.getKey());
			System.out.println("val : " + entry.getValue());
		}
		
		return map.size();
	}
	
	
}
