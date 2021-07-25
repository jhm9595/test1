package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/
 * @author minibig
 *
 */
public class LeetCode118 {
	
	public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> pascalTriangle = new ArrayList<List<Integer>>();
        List<Integer> currentRow = null;
        List<Integer> previousRow = null;
        for(int i = 0; i < numRows; i++){
            currentRow = new ArrayList<Integer>();
            
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    currentRow.add(1);
                }else{
                    previousRow = pascalTriangle.get(i-1);
                    currentRow.add(previousRow.get(j-1) + previousRow.get(j));
                }
            }
            
            pascalTriangle.add(currentRow);
        }
        
        return pascalTriangle;
    }
}
