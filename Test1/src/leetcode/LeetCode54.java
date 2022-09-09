package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix/
 * @author minibig
 *
 */
public class LeetCode54 {

	public List<Integer> spiralOrder(int[][] matrix) {
		
		List<Integer> result = new ArrayList<Integer>();
		
		int row = matrix.length;
		int col = matrix[0].length;
		
		int[][] traceMap = new int[row][col];
		
		int loop = row * col;
		
		int r = 0;
		int c = 0;
		
		// 0 : right, 1: down, 2 : left, 3 : up
		int direction = 0;
		
		while(true) {
			if(direction == 0) { 		// right
				if(c + 1 >= col || traceMap[r][c+1] == 1) {
					direction = ++direction % 4;
				}else {
					result.add(matrix[r][c]);
					traceMap[r][c] = 1;
					c++;
				}
			}else if(direction == 1) {	// down
				if(r + 1 >= row || traceMap[r+1][c] == 1) {
					direction = ++direction % 4;
				}else {
					result.add(matrix[r][c]);
					traceMap[r][c] = 1;
					r++;
				}
			}else if(direction == 2) {	// left
				if(c - 1 < 0 || traceMap[r][c-1] == 1) {
					direction = ++direction % 4;
				}else {
					result.add(matrix[r][c]);
					traceMap[r][c] = 1;
					c--;
				}
			}else if(direction == 3) {	// up
				if(r - 1 < 0 || traceMap[r-1][c] == 1) {
					direction = ++direction % 4;
				}else {
					result.add(matrix[r][c]);
					traceMap[r][c] = 1;
					r--;
				}
			}
			
			if(result.size() == loop - 1) {
				result.add(matrix[r][c]);
				break;
			}
		}
			
		return result;
	}
}