package leetcode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/4sum/
 * @author minibig
 */
public class LeetCode18 {

	public List<List<Integer>> fourSum(int[] nums, int target) {
	        
        List<List<Integer>> answerList = new ArrayList<List<Integer>>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) +1);
        }
        
        List<Integer> numsList = new ArrayList<Integer>();
        for(Entry<Integer, Integer> entry : map.entrySet()){
            int loop = Math.min(entry.getValue(), 4);
            
            for(int i = 0; i < loop; i++){
                numsList.add(entry.getKey());
            }
        }
        
        int numLen = numsList.size();
        
        BigDecimal bigI = null;
        BigDecimal bigJ = null;
        BigDecimal bigK = null;
        BigDecimal bigL = null;
        final BigDecimal bigTarget = new BigDecimal(target);
        BigDecimal tempTarget = null;
        BigDecimal sum = null;
        Collections.sort(numsList);
        for(int i = 0; i < numLen-3; i++){
            bigI = new BigDecimal(numsList.get(i));
            for(int j=i+1; j < numLen-2; j++){
                bigJ = new BigDecimal(numsList.get(j));
                
                tempTarget = bigTarget.subtract(bigI).subtract(bigJ);
                
                int k = j+1;
                int l = numLen-1;
                
                while(k < l){
                    bigK = new BigDecimal(numsList.get(k));
                    if(bigK.multiply(new BigDecimal(2)).compareTo(tempTarget) > 0){
                        break;
                    }
                    bigL = new BigDecimal(numsList.get(l));
                    
                    sum = bigK.add(bigL);
                    
                    if(sum.compareTo(tempTarget) == 0){
                        answerList.add(new ArrayList<Integer>(Arrays.asList(numsList.get(i), numsList.get(j), numsList.get(k), numsList.get(l))));
                        k++;
                    }else if(sum.compareTo(tempTarget) > 0){
                        l--;
                    }else if(sum.compareTo(tempTarget) < 0){
                        k++;
                    }
                }
            }
        }
        return answerList.stream().distinct().collect(Collectors.toList());
	}
}
