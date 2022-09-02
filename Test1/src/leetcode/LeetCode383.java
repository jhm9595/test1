package leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * https://leetcode.com/problems/ransom-note/
 * @author minibig
 *
 */
public class LeetCode383 {

	public boolean canConstruct(String ransomNote, String magazine) {
        
        Map<String, Integer> magazineMap = new HashMap<String,Integer>();
        Map<String, Integer> ransomNoteMap = new HashMap<String,Integer>();
        

        for(int i = 0; i < magazine.length(); i++){
            String str = String.valueOf(magazine.charAt(i));
            int value = magazineMap.get(str) == null ? 0 : magazineMap.get(str);
            magazineMap.put(str, value + 1);
        }
        
        for(int i = 0; i < ransomNote.length(); i++){
            String str = String.valueOf(ransomNote.charAt(i));
            int value = ransomNoteMap.get(str) == null ? 0 : ransomNoteMap.get(str);
            ransomNoteMap.put(str, value + 1);
        }
        
        
        Iterator<Entry<String, Integer>> itr = ransomNoteMap.entrySet().iterator();
        
        while(itr.hasNext()){
        	Entry<String, Integer> entry = itr.next();
        	
        	Integer cnt = magazineMap.get(entry.getKey());
        	if(cnt == null || entry.getValue() < cnt) {
        		return false;
        	}
        }
        
        return true;
    }

}
