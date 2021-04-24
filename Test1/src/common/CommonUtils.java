package common;

public class CommonUtils {

	public static void printArray(int[] arr) {
		
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		for(int i = 0; i < arr.length; i++) {
			sb.append(arr[i]).append(',');
		}
		sb.deleteCharAt(sb.lastIndexOf(","));
		sb.append(']');
		System.out.println(sb.toString());
	}
}
