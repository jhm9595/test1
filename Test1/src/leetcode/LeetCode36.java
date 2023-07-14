package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/valid-sudoku/
 * 
 * @author minibig
 */
public class LeetCode36 {

	public boolean isValidSudoku(char[][] board) {
		
		Set<Character> rowSet = new HashSet<>();
		Set<Character> colSet = new HashSet<>();
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				// row Checks
				if(!isValid(board, i, j, rowSet)) {
					return false;
				}
				// col Checks
				if(!isValid(board, j, i, colSet)) {
					return false;
				}
			}
			rowSet.clear();
			colSet.clear();
		}
		
		Set<Character> boxSet = new HashSet<>();
		
		final int boxSize = (int) Math.pow(board.length, 0.5);
		
		for(int row = 0; row < boxSize; row++) {
			for(int col = 0; col < boxSize; col++) {
				for(int i = row * boxSize; i < (row+1) * boxSize; i++) {
					for(int j = col * boxSize; j < (col+1) * boxSize; j++) {
						if(!isValid(board, i, j, boxSet)) {
							return false;
						}
					}
				}
				boxSet.clear();
			}
		}
		
		return true;
	}

	private boolean isValid(char[][] board, int i, int j, Set<Character> set) {
		char c = board[i][j];
		if(c != '.') {
			if(!set.contains(c)) {
				set.add(board[i][j]);
			}else {
				return false;
			}
		}
		return true;
	}
}
