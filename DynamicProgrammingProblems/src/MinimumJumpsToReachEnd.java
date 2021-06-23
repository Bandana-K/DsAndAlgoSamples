//https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/?ref=leftbar-rightbar

//Given an array of integers where each element represents the max number of steps that can be made forward from that element.
//Write a function to return the minimum number of jumps to reach the end of the array (starting from the first element). 
//If an element is 0, they cannot move through that element. If the end isn’t reachable, return -1.

//Examples: 
//Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
//Output: 3 (1-> 3 -> 8 -> 9)
//Explanation: Jump from 1st element 
//to 2nd element as there is only 1 step, 
//now there are three options 5, 8 or 9. 
//If 8 or 9 is chosen then the end node 9 
//can be reached. So 3 jumps are made.
//
//Input:  arr[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
//Output: 10
//Explanation: In every step a jump 
//is needed so the count of jumps is 10.

//Approach: 
//
//In this way, make a jumps[] array from left to right such that jumps[i] indicate the minimum number of jumps needed to reach arr[i] from arr[0].
//To fill the jumps array run a nested loop inner loop counter is j and outer loop count is i.
//Outer loop from 1 to n-1 and inner loop from 0 to n-1.
//if i is less than j + arr[j] then set jumps[i] to minimum of jumps[i] and jumps[j] + 1. initially set jump[i] to INT MAX
//Finally, return jumps[n-1].
		

// JAVA Code for Minimum number
// of jumps to reach end
class MinimumJumpsToReachEnd {

	private static int minJumps(int[] arr, int n)
	{
		// jumps[n-1] will hold the
		int jumps[] = new int[n];
		// result
		int i, j;

		// if first element is 0,
		if (n == 0 || arr[0] == 0)
			return Integer.MAX_VALUE;
		// end cannot be reached

		jumps[0] = 0;

		// Find the minimum number of jumps to reach arr[i]
		// from arr[0], and assign this value to jumps[i]
		for (i = 1; i < n; i++) {
			jumps[i] = Integer.MAX_VALUE;
			for (j = 0; j < i; j++) {
				if (i <= j + arr[j]
					&& jumps[j]
						!= Integer.MAX_VALUE) {
					jumps[i] = Math.min(jumps[i], jumps[j] + 1);
					break;
				}
			}
		}
		return jumps[n - 1];
	}

	// driver program to test above function
	public static void main(String[] args)
	{
		int arr[] = { 1, 3, 6, 1, 0, 9 };

		System.out.println("Minimum number of jumps to reach end is : "
						+ minJumps(arr, arr.length));
	}
}

//Time Complexity: O(n^2) 