package leetcode;

public class BinarySearch {

	public static void main(String[] args) {
		
		int arr[] = new int[] {1,2,3,5,7,8,9,13,15};
		
		System.out.println("test");
		System.out.println(_findPosition(arr, 8));
		
		System.out.println("=============================");
		
		System.out.println(_findPosition(arr, 2));
	}
	
	private static int _findPosition(int arr[], int k) {
		
		int l = 0, r = arr.length;
		
		while(l < r) {
		
//			int mid = (l + r) / 2;
			int mid = l + ((r - l) / 2); 
			
			System.out.println("l : " + l);
			System.out.println("r : " + r);
			System.out.println("mid : " + mid);
			
			System.out.println("arr[mid] : " + arr[mid] + "/ k : " + k);
			
			if(arr[mid] < k) {
				
				System.out.println(arr[mid] + " < " + k);
				
				l = mid + 1;
			}else { // arr[mid] >= k
				
				System.out.println( k + " <= " + arr[mid]);
				
				r = mid;
			}
		}
		
		System.out.println("=============================");
		
		return l; // when l == r 
	}
}
