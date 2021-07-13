package JPMorgan;

import java.util.*;
public class FlattenOverlappingPairs {

	public static void main(String[] args) {
		List<Pair> pairs = new ArrayList<>();
		pairs.add(new Pair(3, 7));
		pairs.add(new Pair(2, 5));
		pairs.add(new Pair(8, 10));
		System.out.println(pairs);
		System.out.println("flattened pairs are : \n" + flattenOverlappingPairs(pairs));
	}

	private static List<Pair> flattenOverlappingPairs(List<Pair> pairs) {
		
		if(pairs == null || pairs.size() == 0) 	return null;
		
		Collections.sort(pairs, (Pair pair1, Pair pair2)-> pair1.getStart() - pair2.getStart());	
		
		Stack<Pair> result = new Stack<>();
		result.push(pairs.get(0));
		
		for(int i = 1; i<pairs.size(); i++) {		
//get current pair from list and check for overlapping, by checking for the start of current pair with the end of previous pair
//if its overlapping then get the previous pair, merge it with current pair, by increasing its end with current's end. Else just add the current element in result, as it cannot be flattened.
			Pair current = pairs.get(i);
			Pair previous = result.peek();
			if(current.getStart() < previous.getEnd()) {
				previous.setEnd(current.getEnd());
				result.pop();
				result.push(previous);
			} else {
				result.push(current);
			}
		}
		return result;
	}
}

class Pair{	
	private Integer start;
	private Integer end;	
	
	Pair(Integer x, Integer y) {
		start = x;
		end = y;
	}
	
	@Override
	public String toString() {
		return "[" + this.start + " " + this.end + "]";
	}
	
	Integer getStart() {
		return this.start;
	}
	
	Integer getEnd() {
		return this.end;
	}
	
	void setStart(Integer x) {
		this.start = x;
	}
	
	void setEnd(Integer x) {
		this.end = x;
	}
}