package lguplus;

public class LGUPlus2 {

	public static void main(String[] args) {
		
//		String s = "2(2(hi)2(co))x2(bo)";
		String s = "3(2(hi)2(co)ab)";

		System.out.println(getOriginWord(s));
	}
	
	public static String getOriginWord(String s) {
		
		int firstL = s.indexOf('(');
		
		if(firstL == -1) {
			return s;
		}
		
		int oppositeR = 1;
		
		for(int i = firstL + 1; i < s.length(); i++) {
			if(s.charAt(i) == '(') {
				oppositeR++;
			}else if(s.charAt(i) == ')') {
				oppositeR--;
			}
			if(oppositeR == 0) {
				oppositeR = i;
			}
		}
		
		String str = getOriginWord(s.substring(firstL + 1, oppositeR));
		System.out.println("str : " + str);
		
		StringBuilder sb = new StringBuilder();
		
		String loopNstr = "";
		for(int i = 0; i < firstL; i++) {
			if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				loopNstr += s.charAt(i);
			}else {
				sb.append(s.charAt(i));
			}
		}
		
		for(int i = 0; i < Integer.valueOf(loopNstr); i++) {
			sb.append(str);
		}
		
		System.out.println("Assemble one : " + sb.toString());
		
		System.out.println("str2 : " + s.substring(oppositeR+1));
		
		sb.append(getOriginWord(s.substring(oppositeR+1)));
		
		return getOriginWord(sb.toString());
	}
	
	
}
