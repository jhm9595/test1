package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/check-if-n-and-its-double-exist/
 * @author minibig
 *
 */
public class LeetCode1346 {
	
	public static void main(String[] args) {
		int arr[] = {-2,0,10,-19,4,6,-8};
		
		System.out.println(checkIfExist(arr));
	}

	public static boolean checkIfExist(int[] arr) {
        
		Set<Integer> set = new HashSet<Integer>();
		
		for(int a : arr) {
			if(set.contains(a * 2) || (a % 2 == 0 && set.contains(a / 2))) {
				return true;
			}
			set.add(a);
		}
        return false;
    }
}
