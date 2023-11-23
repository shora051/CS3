import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class QueueProbs
{
    public static Queue<Integer> evenFirst(Queue<Integer> nums)
    {
        Queue<Integer> oddList = new LinkedList<>();
        Queue<Integer> evenList = new LinkedList<>();
        int size = nums.size();
        for (int i = 0; i < size; i++)
        {
            if (nums.peek()%2 == 0)
            {
                evenList.offer(nums.poll());
            }
            else 
            {
                oddList.offer(nums.poll());
            }
        }
        size = oddList.size();
        for (int i = 0; i < size; i++){
            evenList.offer(oddList.poll());
        }
        return evenList;
    }
    public static boolean numPalindrome(Queue<Integer> nums)
    {
        int x = nums.size();
        int[] reverse = new int[x];
        Stack<Integer> check = new Stack<Integer>();
        for (int i = 0; i < x; i++){
            int z = nums.poll();
            reverse[i] = z;
            check.push(z);
        }
        for (int i = 0; i < x; i++){
            if (reverse[i] != check.pop()){
                return false;
            }
        }
        return true;
    }
    public static Stack<Integer> sieveOfErathonstenes(int n)
    {
        Queue<Integer> nums = new LinkedList<>();
        Stack<Integer> primes = new Stack<>();
        for(int i = 2; i <= n; ++i) 
        {
            nums.offer(i);
        }
        while(nums.size() > 0) 
        {
            primes.push(nums.poll());
            int num = primes.peek();
            Queue<Integer> temp = new LinkedList<>();
            while(nums.size() > 0) 
            {
                int x = nums.poll();
                if(x % num == 0) 
                {
                    temp.offer(x);
                }
            }
        }
        return primes;
    }
}
