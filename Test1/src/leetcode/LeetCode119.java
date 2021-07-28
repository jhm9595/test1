package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle-ii/
 * @author minibig
 *
 */
public class LeetCode119 {
	
	public static List<Integer> getRow(int rowIndex) {
		List<Integer> result = new ArrayList<Integer>();
        result.add(0, 1);
		for(int i = 1; i <= rowIndex; i++) {
			for(int j = result.size() -1; j >=1 ; j--) {
				result.set(j, result.get(j) + result.get(j-1));
			}
			result.add(1);
		}
		return result;
    }
}
