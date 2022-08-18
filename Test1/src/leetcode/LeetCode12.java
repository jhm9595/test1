package leetcode;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * https://leetcode.com/problems/integer-to-roman/
 * @author minibig
 */
public class LeetCode12 {

	public static String intToRoman(int num) {
		
		Map<Integer, String> romanMap = new LinkedHashMap<Integer, String>();
		romanMap.put(1000, "M");
		romanMap.put(900, "CM");
		romanMap.put(500, "D");
		romanMap.put(400, "CD");
		romanMap.put(100, "C");
		romanMap.put(90, "XC");
		romanMap.put(50, "L");
		romanMap.put(40, "XL");
		romanMap.put(10, "X");
		romanMap.put(9, "IX");
		romanMap.put(5, "V");
		romanMap.put(4, "IV");
		romanMap.put(1, "I");
		
		String romanStr = "";
		
		Iterator<Entry<Integer, String>> itr = romanMap.entrySet().iterator();
		Entry<Integer, String> entry = null;
		
		while(num > 0 || itr.hasNext()) {
			if(entry == null) {
				entry = itr.next();
			}
			
			if(num / entry.getKey() > 0) {
				num -= entry.getKey();
				romanStr += entry.getValue();
			}else {
				entry = itr.next();
			}
		}
		
		return romanStr;
	}
}
