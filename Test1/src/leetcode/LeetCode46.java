package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/permutations/
 * @author minibig
 */
public class LeetCode46 {
	
	public List<List<Integer>> permute(int[] nums) {
		
		List<List<Integer>> answer = new ArrayList<>();
		
		Set<Integer> remainNums = Arrays.stream(nums).boxed().collect(Collectors.toSet());
		for(int n : nums) {
			getPermuteList(answer, new ArrayList<>(), new HashSet<>(remainNums), n);
		}
		
		return answer;
	}
	
	public void getPermuteList(List<List<Integer>> answer, List<Integer> subList, Set<Integer> remainNums, int popNum) {
		
		subList.add(popNum);
		remainNums.remove(popNum);
		
		if(remainNums.size() == 0) {
			answer.add(subList);
			return;
		}
		
		for(int n : remainNums) {
			getPermuteList(answer, new ArrayList<Integer>(subList), new HashSet<>(remainNums), n);
		}
		
	}
}
