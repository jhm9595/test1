package leetcode;
public class Palindrome_Permutation {
	
	static boolean isPermutationOfPalindrome(String phrase){
		int bitVector = createBitVector(phrase);
		return bitVector == 0 || checkExactlyOneBitSet(bitVector);
	}
	
	/* create a bit vector for the string. For each letter with value i, toggle the ith bit. */
	static int createBitVector(String phrase) {
		int bitVector = 0;
		for(char c : phrase.toCharArray()) {
			int x = getCharNumber(c);
			bitVector = toggle(bitVector, x);
		}
		return bitVector;
	}
	
	/* Toggle the ith bit in the integer. */
	static int toggle(int bitVector, int index) {
		if(index < 0) return bitVector;
		
		int mask = 1 << index;
		
		if((bitVector & mask) == 0) {
			bitVector |= mask;
		}else {
			bitVector &= ~mask;
		}
		return bitVector;
	}
	
	/* Check that exactly one bit is set by substracting one from the integer and ANDing it with the original integer. */
	static boolean checkExactlyOneBitSet(int bitVector) {
		return (bitVector & (bitVector - 1)) == 0;
	}
	
	/* Map each character to a numnber. a -> 0, b -> 1, c -> 2, etc.
	 * This is case insensitive. Non-letter characters map to -1.
	 */
	static int getCharNumber(Character c) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(c);
		if(a <= val && val <= z) {
			return val - a;
		}
		return -1;
	}
}
