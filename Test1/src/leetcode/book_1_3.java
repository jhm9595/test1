package leetcode;

public class book_1_3 {

	public static void main(String[] args) {
		
		String temp = "Mr John Smith    ";
		
		System.out.println(_replaceSpaces(temp.toCharArray(), 13));
		
		
	}

	private static String _replaceSpaces(char[] str, int truelength) {
		
		int spaceCount = 0, index, i=0;
		for(i = 0; i < truelength; i++) {
			if(str[i] == ' ') {
				spaceCount++;
			}
		}
		
		index = truelength + spaceCount * 2 - 1;
		System.out.println("spaceCount : " + spaceCount);
		System.out.println("index0 : " + index);
		if(truelength < str.length) str[truelength] = '\0';  // End Array
		for( i = truelength -1 ; i >= 0; i--) {
			System.out.println("str :" + str[i]);
			_print(str);
			if(str[i] ==  ' ') {
				System.out.println("index1 : " + index);
				_print(str);
				str[index--] = '0';
				str[index--] = '2';
				str[index--]  = '%';
				System.out.println("index2 : " + index);
				_print(str);
			}else {
				System.out.println("index3 : " + index);
				_print(str);
				str[index--]  = str[i];
				System.out.println("index4 : " + index);
				_print(str);
			}
		}
		
		
		
		
		
		return _print(str);
	}

	private static String _print(char[] str) {
		String strr = "";
		for(int j = 0; j < str.length; j++) {
			strr += str[j];
		}
		System.out.println("Strr : " + strr);
		return strr;
	}
}
