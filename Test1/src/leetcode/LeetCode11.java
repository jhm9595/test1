package leetcode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/container-with-most-water/description/
 * @author minibig
 *
 */
public class LeetCode11 {

	public int maxArea(int[] height) {
		
        int maxHeight = Arrays.stream(height).max().getAsInt();

		int max = 0;
		int curArea = 0;
		int psblMaxArea = 0;
		
		// width : 현재 가로폭 ( 가장 큰 것부터 줄여가기 )
		for(int width = height.length - 1; width >= 1; width--) {
			
			// 현재 가로폭일 때 가능한 최대 넓이 
			psblMaxArea = maxHeight * width;
			
			// 가능한 최대 넓이가 내가 구한 max값보다 적으면 바로 max 리턴 
			if(psblMaxArea < max) {
				return max;
			}
			
			int leftIdx = 0; // 왼쪽인덱스
			while(leftIdx + width < height.length) { // 왼쪽인덱스와 가로폭의 합계가 총 길이보다 작을 때까지
				
 				int leftHeight = height[leftIdx];		// 왼쪽 높이
				int rightHeight = height[leftIdx+width];// 오른쪽 높이
				
				curArea = width * Math.min(leftHeight, rightHeight); // 현재 넓이
				
				// 현재 넓이가 max보다 크면 max를 갱신
				if(curArea > max) { 
					max = curArea;
				}
				leftIdx++;
			}
		}
		return max;
    }
}
