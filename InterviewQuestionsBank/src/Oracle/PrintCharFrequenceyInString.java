package Oracle;

//https://www.geeksforgeeks.org/printing-frequency-of-each-character-just-after-its-consecutive-occurrences/
public class PrintCharFrequenceyInString {
	
	//Compress String 
	//Given aaabcbc as input, compress it to 3a1b1c1b1c
	
	public static void main(String[] args) {
		
		String input = "    ";
		StringBuilder result = new StringBuilder();
		
		
//		if(input == null) {
//			System.out.println(result);
//			return;
//		}		
		
		
		for(int i = 0 ; i< input.length(); ) {
			
			int count = 1;
			char currentChar = input.charAt(i);
			
			for(int j= i+1; j<input.length(); j++) {
				if(input.charAt(j) == currentChar) {
					count++;
				} 
				else
					break;			
			}
			
			result.append(count).append(currentChar);			
			i = i+count;			
		}
		
		System.out.println(result);
		
	}
}
