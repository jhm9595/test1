package commonclass;

public class Elements implements Comparable<Elements> {
	
	public int val;
	public int index;
	
	public Elements(int val, int index) {
		this.val = val;
		this.index = index;
	}

	@Override
	public int compareTo(Elements o) {
		return this.val < o.val ? -1 : 1;
	}
}
