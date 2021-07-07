package MakeMyTrip;

import java.util.*;

//A company is having a number is cyber cafe. Many customer visit cyber cafe and number if computers are limited. 
//If customer don't find available computer then he leave. 
//You have given a function with 2 arguments : 1 number of computers, 1 : a string with pairs. 
//1st occurrence of alphabet indicate start of customer and second occurrence indicate end. Only 1 person can use a computer at a time.
//Return count of customers who left cafe without using computer so that company can improve process.
//
//example :
//process(1, ABAB) : should return 1 as only 1 computer is there that is occupied by A when B comes.
//process(2,ABACBCDD) : should return 0 as all customer A,B,C, D are able to use Cafe.
//process(3, ABCDCDEFEFA) : should return 2 as D and F could use computer.

public class CyberCafeSimulation {

	public static void main(String[] args) {
		System.out.println(countUnservedRequests(1, "ABAB"));
		  System.out.println(countUnservedRequests(2, "ABACBCDD") );
		  System.out.println(countUnservedRequests(3, "ABCDCDEFEFA") );

	}

	private static int countUnservedRequests(int limit, String requests) {

		Set<Character> serving = new HashSet<>();
		Set<Character> unserved = new HashSet<>();

		if (limit == 0 || null == requests)
			return 0;

		int unservedCounts = 0;

		for (int i = 0; i < requests.length(); i++) {
			char currentChar = requests.charAt(i);

			if (unserved.contains(currentChar)) {
				unserved.remove(currentChar);
				continue;
			}

			if (serving.contains(currentChar))
				serving.remove(currentChar);
			else {
				if (serving.size() == limit) {
					unservedCounts++;
					unserved.add(currentChar);
				} else
					serving.add(currentChar);
			}
//			System.out.println(serving);
		}
		return unservedCounts;
	}

}
