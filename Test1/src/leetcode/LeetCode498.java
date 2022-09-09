package leetcode;

/**
 * https://leetcode.com/problems/diagonal-traverse/submissions/
 * @author minibig
 *
 */
public class LeetCode498 {

	public int[] findDiagonalOrder(int[][] matrix) {
		
		int row = matrix.length;
		int col = matrix[0].length;
		
		int arr[] = new int[row * col];
		int idx = 0;
		
		for(int i = 0; i < row + col - 1; i++) {
			
			// moving down index
			int r = i < col ? 0 : i - col + 1;
			int c = i >= col ? col - 1 : i;
			
			// moving up index
			int c2 = i < row ? 0 : i - row + 1;
			int r2 = i >= row ? row - 1 : i;
			
			while(r < row && r >= 0 && c < col && c >= 0) {
				if(i % 2 == 0) {
					arr[idx++] = matrix[r2][c2];
				}else {
					arr[idx++] = matrix[r][c];
				}
				r++;
				c--;
				
				r2--;
				c2++;
			}
		}
		
		return arr;
	}
}
