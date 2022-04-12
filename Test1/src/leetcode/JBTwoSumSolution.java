package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JBTwoSumSolution {
	
	
	public static void main(String[] args) {
		
		int arr[] = new int[] { 11, 7, 2, 15 };
		
		List<Elements> list = new ArrayList<Elements>();
		for(int i = 0; i < arr.length; i++) {
			list.add(new Elements(i, arr[i]));
		}
		
		int[] result = binarySearchByList(list, 18);
		
		System.out.println("result : [" + result[0] +","+ result[1] + "]" );
	}

	public static int[] binarySearchByList(List<Elements> list, int target) {
		
		int[] result = new int[2];
		
		int l = 0, r = list.size(), mid = 0, subtract_target;
		
		Collections.sort(list);
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println("list.get(i) : " + list.get(i).value);
		}
		
		for(int i = 0; i < list.size(); i++) {
			
			l = i + 1;
			r = list.size() - 1;
			
			subtract_target = target - list.get(i).value;
			
			System.out.println("i : " + i);
			System.out.println("l : " + l);
			System.out.println("r : " + r);
			System.out.println("list.get(i) : " + list.get(i).value);
			System.out.println("subtract_target : " + subtract_target);
		
			while(l < r) {
				System.out.println("mid : " + mid);
				
				mid = l + ((r - l) / 2);
				
				
				if(list.get(mid).value < subtract_target) {
					l = mid + 1;
				}else {
					r = mid;
				}
				
				System.out.println("list.get(mid).value : " + list.get(mid).value);
				
				
			}
			
			if(list.get(l).value == subtract_target) {
				
				return new int[] {list.get(i).index, list.get(l).index};
			}
		}
		
		return result;
	}
	
	
}


class Elements implements Comparable<Elements>{ 
	int value;
	int index;
	
	Elements(int index, int value){
		this.index = index;
		this.value = value;
	}

	@Override
	public int compareTo(Elements o) {
		// Test
		return this.value > o.value ? 1 : -1;
	}
}	
