import java.util.Stack;
public class Runner {
    
    public static Stack<Integer> makeStack(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int num : nums){
            stack.push(num);
        }
        return stack;
    }
        //example call: makeStack(new int[] {1, 2, 3, 4})


    public static void main(String[] args) {
        
        Stack<Integer> test = makeStack(new int []{7, 23, 7, 0, 22, 8, 4, 5});
        System.out.println(test);
        
        Stack<Integer>testt = StackProbs.shiftByN(test, 3);
        System.out.println(testt);
        
        //boolean msg = StackProbs.bracketBalance("([()])))");
        //System.out.println(msg);
    }

}
