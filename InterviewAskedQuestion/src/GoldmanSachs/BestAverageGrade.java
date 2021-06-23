package GoldManSachs;

/* Problem Name is &&& Best Average Grade &&& PLEASE DO NOT REMOVE THIS LINE. */

import java.io.*;
import java.util.*;

/*
**  Instructions:
**
**  Given a list of student test scores, find the best average grade.
**  Each student may have more than one test score in the list.
**
**  Complete the bestAverageGrade function in the editor below.
**  It has one parameter, scores, which is an array of student test scores.
**  Each element in the array is a two-element array of the form [student name, test score]
**  e.g. [ "Bobby", "87" ].
**  Test scores may be positive or negative integers.
**
**  If you end up with an average grade that is not an integer, you should
**  use a floor function to return the largest integer less than or equal to the average.
**  Return 0 for an empty input.
**
**  Example:
**
**  Input:
**  [ [ "Bobby", "87" ],
**    [ "Charles", "100" ],
**    [ "Eric", "64" ],
**    [ "Charles", "22" ] ].
**
**  Expected output: 87
**  Explanation: The average scores are 87, 61, and 64 for Bobby, Charles, and Eric,
**  respectively. 87 is the highest.
*/

public class BestAverageGrade
{
  /*
  **  Find the best average grade.
  */
  public static Integer bestAverageGrade(String[][] scores)
  {
    
    double besAverageGrade = Integer.MIN_VALUE;
    int result = 0;
    

    if(scores == null )
      return result;
    

    Map<String, List<Integer>> studentScore = new HashMap<>();
    for(int i = 0; i<scores.length; i++){
      String name = scores[i][0];
      int value = Integer.valueOf(scores[i][1]);
      
      if(studentScore.containsKey(name))
        studentScore.get(name).add(value);
      else{
        List<Integer> currentScores =  new ArrayList<>();
        currentScores.add(value);
        studentScore.put(name, currentScores);
      }
    }
      
    for(Map.Entry<String,List<Integer>> entry: studentScore.entrySet()){
        
        DoubleSummaryStatistics statistic = entry.getValue().stream()
          .mapToDouble(num -> num)
          .summaryStatistics();
          
       double currentAvg = statistic.getAverage();
       if(currentAvg > besAverageGrade)
         besAverageGrade = currentAvg;
        
      } 
    
    
      result = (int)Math.floor(besAverageGrade);    
      return result;
  }
    

  /*
  **  Returns true if the tests pass. Otherwise, returns false;
  */
  public static boolean doTestsPass()
  {
    // TODO: implement more test cases
    String[][] tc1 = { { "Bobby", "87" },
               { "Charles", "100" },
               { "Eric", "64" },
               { "Charles", "22" } };
    
    String[][] tc2 = null;

    
    String[][] tc3 = {};
    
    String[][] tc4 = { { "Bobby", "-2" },
               { "Charles", "-3" },
               { "Eric", "-1" },
               { "Charles", "-4" } };
    
    
    return (bestAverageGrade(tc1) == 87 && bestAverageGrade(tc2) == 0 && 
           bestAverageGrade(tc3) == 0  && bestAverageGrade(tc4) == -1 );
  }
  
  /*
  **  Execution entry point.
  */
  public static void main(String[] args)
  {
    // Run the tests
    if(doTestsPass())
    {
      System.out.println("All tests pass");
    }
    else
    {
      System.out.println("Tests fail.");
    }
  }
}

