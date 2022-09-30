package leetcode;

public class LeetCode6 {

	public String convert(String s, int numRows) {
		if(numRows <=1) {
			return s;
		}
		
		int length = s.length();
		
		int curRow = 0;
		int curCol = 0;
		int direction = 1;
		
		for(int i = 0 ; i < length; i++) {
			
			if(direction < 0) {
				curCol++;
			}
			
			if(curRow == numRows -1) {
				direction = direction * -1;
			}else if (i != 0 && curRow == 0){
				direction = direction * -1;
			}
			
			curRow = curRow + direction;
		}
		
		int arr[][] = new int[numRows][curCol + 1];
		
		curRow = 0;
		curCol = 0;
		direction = 1;
		
		for(int i = 0; i < length; i++) {
			if(direction < 0) {
				curCol++;
			}
			
			if(curRow == numRows -1) {
				direction = direction * -1;
			}else if(i != 0 && curRow == 0){
				direction = direction * -1;
			}
			
			arr[curRow][curCol] = s.charAt(i);
			
			curRow = curRow + direction;
		}
		
		StringBuffer result = new StringBuffer();
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				if(arr[i][j] != 0) {
					result.append((char) arr[i][j]);
				}
			}
		}
		
		return result.toString();
	}
}
