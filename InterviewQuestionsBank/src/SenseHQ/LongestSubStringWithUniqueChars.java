package SenseHQ;

//12th July 2021

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution. If you need more classes, simply define them inline.
 
 abcgdblkogdop
  abcgd
  cgdblko 		ans 7
  dblkog
  blkogd
 
 abcdbncma
 abcd
 cdbn
 dbncma			ans 6
 
 adcgddddddd 	ans 4
 
 */

public class LongestSubStringWithUniqueChars {
  public static void main(String[] args) {
    String  test = "abcgdblkogdop";
    String  test1 = "abcdbncma";
    String  test2 = "adcgddddddd";

    String nulltest = null;
    String emptyString = "     ";
    String sameChar = "aaaaa";
    
    System.out.println(getMaxLengthUniqueChar(test));
    System.out.println(getMaxLengthUniqueChar(test1));
    System.out.println(getMaxLengthUniqueChar(test2));

    System.out.println(getMaxLengthUniqueChar(nulltest));
    System.out.println(getMaxLengthUniqueChar(emptyString));
    System.out.println(getMaxLengthUniqueChar(sameChar));

  }
  
  private static int getMaxLengthUniqueChar(String check) {
    
    int maxlength = Integer.MIN_VALUE;

    if(check == null)
      return maxlength;
    
    String input = check.trim();
    if(input.equals(""))
      return maxlength;
    
    HashSet<Character> uniqueChars = new HashSet<>();
    
    int start = 0, i = 0;
    for(;i<input.length(); i++){
      
      char current = input.charAt(i);
      if(!uniqueChars.contains(current)){
        uniqueChars.add(current);
      } else {
        
        int currentLength = i-start;
        if(maxlength < currentLength)
          maxlength = currentLength;
        
        while(input.charAt(start) != current){
          uniqueChars.remove(input.charAt(start));
          start++;
        }
        start++;     
      } 
    }
    
    int currentLength = i-start;
    if(maxlength < currentLength)
          maxlength = currentLength;
    
    
    return maxlength;
  }
}
