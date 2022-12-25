package lguplus;

import java.util.ArrayList;
import java.util.List;

public class LGUPlus3 {

	public static void main(String[] args) {
//		int[] match = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1};
//		int[] match = {0,0,0,0,0,0,0,1};
		int[] match = {1,1,1,1,1,0,0,1};
		
		System.out.println(getMaxProMatch(match));
	}
	
	public static int getMaxProMatch(int[] match) {
		
		int cnt = match.length;
		
		List<Match> matchList = new ArrayList<Match>();
		
		for(int m : match) {
			matchList.add(new Match(m==0?false:true));
		}
		
		for(int i = 0; i < cnt; i++) {
			System.out.print("isPro : " + matchList.get(i).isPro());
			System.out.print("\tNormal : " + matchList.get(i).getNormalMatch());
			System.out.println("\tPro : " + matchList.get(i).getProMatch());
		}
		System.out.println("================initialize================");
		
		int maxCnt = 0;
		while(cnt > 0) {
			
			for(int i = 0; i < cnt / 2; i++) {
				Match player1 = matchList.get(i*2);
				Match player2 = matchList.get(i*2+1);
				
				if(player1.isPro() || player2.isPro()) {
					Match player = player1.isPro() ? player1 : player2;
					if(cnt == match.length) {
						player.setProMatch(1);
					}else {
						player.setProMatch(player1.getProMatch() + player2.getProMatch()+1);
						player.setNormalMatch(player1.getNormalMatch() > player2.getNormalMatch() ? player1.getNormalMatch() : player2.getNormalMatch());
					}
					
					matchList.set(i, player);
				}else {
					Match player = player1.getNormalMatch() > player2.getNormalMatch() ? player1 : player2;
					if(cnt == match.length) {
						player.setNormalMatch(1);
						maxCnt = 1;
					}else {
						player.setNormalMatch(player.getNormalMatch() + 1);
						maxCnt = maxCnt > player.getNormalMatch() ? maxCnt : player.getNormalMatch();
					}
					matchList.set(i, player);
				}
				
			}
			
			cnt /= 2;
			
			for(int i = 0; i < cnt; i++) {
				System.out.print("isPro : " + matchList.get(i).isPro());
				System.out.print("\tNormal : " + matchList.get(i).getNormalMatch());
				System.out.println("\tPro : " + matchList.get(i).getProMatch());
			}
			System.out.println("maxCnt : " + maxCnt);
			System.out.println("================next=================");
		}
		
		return matchList.get(0).getProMatch() + maxCnt;
	}
	
	static class Match{
		
		private boolean isPro;
		private int proMatch;
		private int normalMatch;
		
		public Match(boolean isPro) {
			this.isPro = isPro;
			this.proMatch = 0;
			this.normalMatch = 0;
		}
		
		public int getProMatch() {
			return proMatch;
		}
		public void setProMatch(int proMatch) {
			this.proMatch = proMatch;
		}
		public int getNormalMatch() {
			return normalMatch;
		}
		public void setNormalMatch(int normalMatch) {
			this.normalMatch = normalMatch;
		}
		public boolean isPro() {
			return isPro;
		}
	}
}
