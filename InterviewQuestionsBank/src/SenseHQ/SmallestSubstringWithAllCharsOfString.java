package SenseHQ;

//6th July 2021

import java.util.HashMap;
import java.util.HashSet;

//Input: ppqrqrsqqrp  (p,q,r,s)
//Output: 

public class SmallestSubstringWithAllCharsOfString {

	public static void main(String args[]) {
		String input = "ppqrqrsqqrp";
		System.out.println(findSmallestSubstring(input));

	}

	private static String findSmallestSubstring(String input) {
//		logic to get all distinct characters
		HashSet<Character> distinctChars = new HashSet<>();
		for (int i = 0; i < input.length(); i++) {
			distinctChars.add(input.charAt(i));
		}
		int distinctLength = distinctChars.size();

//		below logic to check the subsets which are a possible solution

		int start = 0; 						// start index of current window
		int resultIndex = -1;				// index for the window which is actually the ans
		int minLength = Integer.MAX_VALUE;	// the length of smallest window
		int count = 0; 						// counter to maintain the distinctCharacters visited in current subset
		HashMap<Character, Integer> charMap = new HashMap<>();

		for (int i = 0; i < input.length(); i++) {
			char check = input.charAt(i);
			if (charMap.containsKey(check))
				charMap.put(check, charMap.get(check) + 1);
			else {
				charMap.put(check, 1);
				count++;
			}

			if (count == distinctLength) {// we have found a possible solution
//				below lines could be moved to a utility method also
				while (charMap.get(input.charAt(start)) > 1) {
					if (charMap.get(input.charAt(start)) > 1) {
						charMap.put(input.charAt(start), charMap.get(input.charAt(start) - 1));
					}
					start++;
				}

//				At this point we will be at correct position of Start, 
//				beyond which any removal of //character, will not be a possible solution. 
//				So now we need to check for the //length to be minimum.
				int lengthofCurrentWindow = i - start + 1;
				if (minLength > lengthofCurrentWindow)
					minLength = lengthofCurrentWindow;
				resultIndex = start;
			}
		}
		return input.substring(resultIndex, resultIndex + minLength);
	}
}

//Basically we have 2 loops- to get all distinct characters 
//And the other to actually get the minLength window.
//So the solution is O(2n) => O(n)
