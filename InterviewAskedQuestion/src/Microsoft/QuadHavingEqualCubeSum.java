package Microsoft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QuadHavingEqualCubeSum {
	
	public static void main(String[] args) {
		List<Integer> input = new ArrayList<>();		
		int min = 1, max = 1000;
		for(int i=min; i<=max; i++)
			input.add(i+1);
		findQuads(input);		
	}	
	
	 static void findQuads(List<Integer> input)
	 {
	     HashMap<Integer,FirstPair> map = new HashMap<Integer,FirstPair>();
	     int n=input.size();

	     for (int i=0; i<n; ++i)
	     {
	         for (int j=i+1; j<n; ++j)
	         {
	        	 int a = input.get(i);
	        	 int b = input.get(j);
	             int sum = (a*a*a + b*b*b);
	             
	             if (!map.containsKey(sum))
	                 map.put(sum,new FirstPair(a, b));
	             else 
	             {
	            	 FirstPair p = map.get(sum);
	                 System.out.println("first pair : " + p.first + " " +p.second + " second pair : " +a + " " +b);
	             }
	         }
	     }
	 }
}
 class FirstPair
 {
     int first, second;
     FirstPair(int f,int s)
     {
         first = f; second = s;
     }
 }