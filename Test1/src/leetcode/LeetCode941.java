package leetcode;

/**
 * https://leetcode.com/problems/valid-mountain-array/
 * @author minibig
 *
 */
public class LeetCode941 {
	
	public static void main(String[] args) {
		int arr[] = {0,3,2,1};
		System.out.println(validMountainArray(arr));
	}

	public static boolean validMountainArray(int[] arr) {

		// 길이가 3 이상인지 체크
		if(arr.length <= 2) {
			return false;
		}
		
		// 첫 방향이 올라가는 방향인지 체크
 		if(arr[0] >= arr[1]) {
 			System.out.println("Not Increasing");
 			return false;
 		}
 		
 		boolean isInc = true;
 		int dirChngCnt = 0;
 		
 		for(int i = 1; i < arr.length-1; i++) {
 			if(arr[i+1] == arr[i]) {
 				System.out.println("same");
 				return false;
 			}else if(isInc && arr[i] > arr[i+1]) {
 				System.out.println("direction change");
 				isInc = false;
 				dirChngCnt++;
 			}else if(!isInc && arr[i] < arr[i+1]) {
 				System.out.println("increase again");
 				return false;
 			}
 			System.out.println("dirChngCnt : " + dirChngCnt);
 			
 			if(dirChngCnt > 1) {
 				return false;
 			}
 		}
 		
 		if(dirChngCnt != 1) {
 			return false;
 		}
		
		return true;
	}
}
