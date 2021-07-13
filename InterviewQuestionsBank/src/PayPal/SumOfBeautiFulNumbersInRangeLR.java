package PayPal;

import java.util.HashMap;
import java.util.Map;

//https://www.hackerearth.com/problem/algorithm/beautiful-numbers-05de0f51-101121ca/

public class SumOfBeautiFulNumbersInRangeLR {
	
	static Map<Integer, Boolean> beautifullMap = new HashMap<>();
//	static long[] sumOfBeautiFul = new long[1000005];
	
    public static void main(String[] args) {
    	
//    	preCompute();
        int l = 1, r = 1000000;
        long result = solve(l, r);
        System.out.println(result);
    }
	
//    private static void preCompute() {
//        for(int i = 1 ; i <= 1000000 ; i++){
//            if(isBeautiful(i))
//            {
//            	sumOfBeautiFul[i] = i;
//            }
//        }
//
//        for(int i = 1 ; i <= 1000000 ; i++){
//        	sumOfBeautiFul[i] += sumOfBeautiFul[i-1];
//        }
//	}

	private static long solve(int l, int r) {
		long sum = 0;
		for (int i = l; i <= r; i++) {
			if (beautifullMap.containsKey(i) && beautifullMap.get(i) == true) {
				sum += i;
			}
			else if (!beautifullMap.containsKey(i) && isBeautiful(i))
			{
				sum += i;
			}
		}
		return sum;
//		return (sumOfBeautiFul[r] - sumOfBeautiFul[l-1]);
	}

	private static Boolean isBeautiful(int i) {

		int cur = i;
		if (beautifullMap.containsKey(i)) {
			return beautifullMap.get(i);
		}
		
		beautifullMap.put(i, false);
		int temp = 0;
		while (i > 0) {
			int rem = i % 10;
			temp += rem * rem;
			i /= 10;
		}
		
		if (temp == 1 || temp == 7) {
			beautifullMap.put(cur, true);
			return true;

		} else if(temp < 9) {
			beautifullMap.put(cur, false);
			return false;
		}
		
		Boolean flag = isBeautiful(temp);
		beautifullMap.put(cur, flag);
		return flag;
	}
}
