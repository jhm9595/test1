package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-ii/
 * @author minibig
 *
 */
public class LeetCode40 {
	
	int candidatesSize = 10;

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		
		List<List<Integer>> answerList = new ArrayList<>();
		
		int[] candidatesSort = new int[candidatesSize + 1];
		
		for(int num : candidates) {
			candidatesSort[num]++;
		}
		
		findAnswer(candidatesSort, new ArrayList<Integer>(), answerList, target, candidatesSize);
		
		return answerList;
	}

	private void findAnswer(int[] candidatesSort, List<Integer> answer, List<List<Integer>> answerList, int rest, int idx) {
		
		if(rest == 0) {
			answerList.add(answer);
			return;
		}
		
		for(int i = idx; i >= 0; i--) {
			if(candidatesSort[i] > 0 && rest - i >= 0) {
				List<Integer> answerSub = new ArrayList<>(answer);
				answerSub.add(i);
				candidatesSort[i]--;
				findAnswer(candidatesSort, new ArrayList<>(answerSub), answerList, rest - i, i);
				candidatesSort[i]++;
			}
		}
	}
}
