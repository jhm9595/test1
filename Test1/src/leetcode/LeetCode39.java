package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/description/
 * @author jhm95
 */
public class LeetCode39 {
	
	List<List<Integer>> answerList = new ArrayList<>();

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		
		findAnswer(candidates, new ArrayList<>(), target);

		return answerList;
	}

	public void findAnswer(int[] candidates, List<Integer> answerSub, int target) {
		if(target == 0) {
			answerList.add(answerSub);
			return;
		}
		List<Integer> answer;
		int factor;
		int rest;
		for (int i = 0; i < candidates.length; i++) {
			factor = candidates[i];
			rest = target - factor;
			if (rest >= 0 && !hasReverseOrder(answerSub, factor)) {
                answer = new ArrayList<>(answerSub);
				answer.add(factor);
				findAnswer(candidates, answer, rest);
			}
		}
	}

	private boolean hasReverseOrder(List<Integer> answer, int factor) {
		for(int a : answer) {
			if(a > factor) {
				return true;
			}
		}
		return false;
	}
}
