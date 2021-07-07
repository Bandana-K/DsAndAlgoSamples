package PayPal;

import java.util.HashMap;
import java.util.Map;

//https://www.hackerearth.com/problem/algorithm/beautiful-numbers-05de0f51-101121ca/

public class SumOfBeautiFulNumbersInRangeLR {
	
	static Map<Integer, Boolean> beautifullMap = new HashMap<>();
	
//	static {
//		beautifullMap.put(1, true);
//		beautifullMap.put(2, false);
//		beautifullMap.put(3, false);
//		beautifullMap.put(4, false);
//		beautifullMap.put(5, false);
//		beautifullMap.put(6, false);
//		beautifullMap.put(7, false);
//		beautifullMap.put(8, false);
//		beautifullMap.put(9, false);
//	}
	
    public static void main(String[] args) {
    	//31, 32  	  	=> 63 		=> 63
    	//8508, 10000 	=>1865855	=> 1865855
    	//3, 2834		=> 596941   => 591386
        int l = 19;
        int r = 20;

        long result = solve(l, r);
        System.out.println(result);
    }
    
    static long solve(int l, int r){
       
    	if(l == r)
    		return l;
    	
    	poupulateBeautifullMap(l, r);
    	
    	int sum = 0;
    	while(l<=r) {
    		if(beautifullMap.get(l))
    			sum = sum+l;
    		l++;
    	}
    	
    	return sum;
    }

	private static void poupulateBeautifullMap(int l, int r) {

		for(int i = l ; i<=r; i++) {
			if(isBeautiFullNumber(i))
				beautifullMap.put(i, true);
			else 
				beautifullMap.put(i, false);	
		}
	}

	private static boolean isBeautiFullNumber(int check) {
		
		if(beautifullMap.containsKey(check))
			return beautifullMap.get(check);
		
		int digitSum = getDigitSquaresSum(check);
		if(digitSum == 1) {
			beautifullMap.put(check, true);
			return true;
		} else	if(digitSum < 9) {
			beautifullMap.put(check, false);
			return false;
		}
		return isBeautiFullNumber(digitSum);

	}

	private static int getDigitSquaresSum(int check) {
		int sum = 0;
		while(check > 0) {
			int digit = check%10;
			sum = sum + digit * digit;
			check = check /10;
		}
		return sum;
	}
}