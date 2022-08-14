package leetcode;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * @author minibig
 *
 */
public class LeetCode5_try {

	public static String longestPalindrome(String s) {
		
		if(s.length() <= 1) {return s;}
		
		String result = null;
		
		// 모든 글자 사이사이에 '|' 를 추가
		String str = s.replaceAll("", "|"); 
		
		// 추가된 | 를 포함한 전체 길이를 구한다.
		int strLen = str.length(); 
		
		// 각 위치에서 회문을 만들어주는 가장 큰 반지름을 저장하기 위한 배열 생성
		int strArr[] = new int[strLen];  
		
		int center = 0;
		
		while(center < strLen) { // 0부터 길이가 되기전까지 루프 돌리기 
			
			// 이미 입력된 반지름이 있으면 거기부터 시작 
			int radius = strArr[center];
			
			while(center >= radius + 1 && 			// 왼쪽으로 중심에서 반지름까지가 0보다 크거나 같을 때
				  center + radius + 1 < strLen && 	// 오른쪽으로 중심에서 반지름까지가 총 길이보다 작을 때  
				  str.charAt(center - (radius +1)) == str.charAt(center + radius + 1)) { // 두개의 값이 같을 때
				radius++; // 반지름의 값을 하나 증가 
			}
			
			strArr[center] = radius; // 값이 같았던 최대의 반지름을 저장 
			
			// 기존에 구해진 값을 이용해서 다음 값을 채우기.
			int newCenter = center + 1;
			while(newCenter <= center + radius) { // 중심을 기준으로 오른쪽 배열을 왼쪽걸 이용해서 다 채울때까지
				
				// 왼쪽 센터를 조회
				int mirrorCenter = center - (newCenter - center);
				// 왼쪽 센터의 반지름 구하기
				int mirrorRadius = strArr[mirrorCenter];
				// 현재 가능한 가장 큰 반지름 구하기 
				int maxRadius = center + radius - newCenter;
				
				if(mirrorRadius > maxRadius) { // 왼쪽 반지름이 최대 반지름보다 큰 경우에는 최대 반지름 저장 
					strArr[newCenter] = maxRadius;
				}else if(mirrorRadius < maxRadius) { // 왼쪽 반지름보다 최대 반지름이 큰 경우에는 왼쪽 반지름 저장
					strArr[newCenter] = mirrorRadius;
				}
				newCenter++;
			}
			
			center++; // 다음 글자에서 다시 측정 ( 뒤에 추가로 오는 글자를 포함하여 또 회문일수 있으므로 재측정 )
		}
		
		// 가장 반지름이 컸던 위치를 찾아내고 해당 글자를 알아낸 후 | 제거하기 
		int max = 0;
		for(int i = 0; i < strArr.length; i++) {
			if(strArr[i] >= max) {
				max = strArr[i];
				result = str.substring(i - max, i + max + 1).replace("|", "");
			}
		}
		
		return result;
	}
}

