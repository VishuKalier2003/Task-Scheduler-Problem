/* You are given a 0-indexed array of positive integers tasks, representing tasks that need to be completed in order, where tasks[i] represents the type of the ith task... You are also given a positive integer space, which represents the minimum number of days that must pass after the completion of a task before another task of the same type can be performed... Each day, until all tasks have been completed, you must either:
* Complete the next task from tasks, or
* Take a break...
Return the minimum number of days needed to complete all tasks...
  * Eg 1: Tasks = [5,8,8,5]        spaces = 2     days = 6
  * Eg 2: Tasks = [1,2,1,2,3,1]    spaces = 3     days = 9  
  * Explanation of above case -> {One way to complete all tasks in 9 days is as follows: Day 1: Complete the 0th task. Day 2: Complete the 1st task. Day 3: Take a break. Day 4: Take a break. Day 5: Complete the 2nd task. Day 6: Complete the 3rd task. Day 7: Take a break. Day 8: Complete the 4th task. Day 9: Complete the 5th task. It can be shown that the tasks cannot be completed in less than 9 days.}  */
import java.util.*;
public class TaskScheduler
{
    public long MinimumDays(int tasks[], int spaces)
    {
        Map<Integer, Long> map = new HashMap<Integer, Long>();   // Using Map Data Structure...
        long result = 0;
        for(int i: tasks)    // For loop...
        {
            if(map.containsKey(i))    // If the task is already completed once...
                map.put(i, result = Math.max(result, map.get(i)+spaces) + 1);  // Update the task completion day...
            else
                map.put(i, ++result);    // Otherwise add it to the Map...
        }
        return result;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int x;
        System.out.print("Enter the number of tasks : ");
        x = sc.nextInt();
        int tasks[] = new int[x];
        for(int a: tasks)
        {
            System.out.print("Enter the "+(a+1)+" th task : ");
            tasks[a] = sc.nextInt();
        }
        System.out.print("Enter the value of spaces : ");
        x = sc.nextInt();
        TaskScheduler taskscheduler = new TaskScheduler();    // Object creation...
        System.out.println("The Minimum Days required to complete a task : "+taskscheduler.MinimumDays(tasks, x));
        sc.close();
    }
}

// Time Complexity  - O(n) time...
// Space Complexity - O(n) space...

/* DEDUCTIONS :- 
 * 1. A task once completed must wait for certain days to be finished up again...
 * 2. We can use Map to map the day on which that specific task is completed...
*/