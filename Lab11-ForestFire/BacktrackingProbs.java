
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BacktrackingProbs
{

    public static void printBinary(int digits){


        printBinaryHelper(digits, "");






    }
    private static void printBinaryHelper(int digits, String soFar){

        if (soFar.length() == digits){
            System.out.print(soFar + " ");
        }
        else {
            printBinaryHelper(digits, soFar + "0");
            printBinaryHelper(digits, soFar + "1");
        }


    }

    public static void climbStairs(int steps){
        stairsHelp(steps, "");

    }
    public static void stairsHelp(int steps, String cur) {
        if (steps == 0){
            System.out.println(cur);
           
            
        }
        else if (steps == 1){
            System.out.println(cur + "1");
        }
        
        else {
            stairsHelp(steps-1, cur + "1, ");
            if (steps == 2){
                stairsHelp(steps-2, cur + "2");
            }
            else {
                stairsHelp(steps-2, cur + "2, ");
            }
        }

    }

    public static void campsite(int x, int y){

        helpCamp(x, y, "");

    }
    
    private static void helpCamp(int x, int y, String res){
        if (x == 0 && y == 0){
            System.out.println(res);
        }
        else {
            if (y != 0){
                helpCamp(x, y-1, res + "N ");
            }   
            
            if (x != 0){
                helpCamp(x-1, y, res + "E ");
            }
            
            if (x != 0 && y != 0){
                helpCamp(x-1, y-1, res + "NE ");
            }


        }
    }

    public static int getMax(List<Integer> nums, int limit){
        int[] maxs = {0};
        sumMax(nums, limit, 0, maxs);
        return maxs[0];

    }
    public static void sumMax(List<Integer> nums, int limit, int sum, int[] maxs){
        if (sum > maxs[0] && sum <= limit){
            maxs[0] = sum;
            
        }

        if (nums.size() != 0){
            int x = nums.remove(0);
            sumMax(nums, limit, sum + x, maxs);
            sumMax(nums, limit, sum, maxs);
            nums.add(x);

        }
        
    }


    public static int makeChange(int amount){
        
        
        ArrayList<Integer> coins = new ArrayList<Integer>();
        coins.add(25);
        coins.add(10);
        coins.add(5);
        coins.add(1);
        return makeChangeHelper(coins, 0, amount);


    }

    public static int makeChangeHelper(ArrayList<Integer> coins, int i, int amount){
        
        if (i >=4){
            return 0;
        }
        if (amount <= 0){
            if (amount < 0){
                return 0;
            }
            if (amount == 0){
                return 1;
            }
        }
        while (coins.get(i) > amount){
            i++;
        }
        return makeChangeHelper(coins, i, amount-coins.get(i)) + makeChangeHelper(coins, i+1, amount);

    }


    public static void makePrintChange(int amount, int[]amt){
        
        
        ArrayList<Integer> coins = new ArrayList<Integer>();
        coins.add(25);
        coins.add(10);
        coins.add(5);
        coins.add(1);
        
        makePrintChangeHelper(coins, 0, amount,amt );


    }

    public static int makePrintChangeHelper(ArrayList<Integer> coins, int i, int amount, int[]amt){
        
        if (i >=4){
            return 0;
        }
        if (amount <= 0){
            if (amount < 0){
                return 0;
            }
            if (amount == 0){
                for (int e = 0; e < amt.length; e++){
                    System.out.println(amt[e]);
                }
            }
        }
        while (coins.get(i) > amount){
            i++;
        }
        int []cloned = amt.clone();
        cloned[3-i] += 1;
        int[] n = new int[]{
            amt[0], amt[1], amt[2], amt[3]
        };
        return makePrintChangeHelper(coins, i, amount-coins.get(i), cloned) + makePrintChangeHelper(coins, i+1, amount, n);

    }


    public static String longestCommonSub(String first, String second, int len, String curstr){

        if (len == 0){
            int x = 0;
            for (int i = 0; i < second.length() && x < curstr.length(); i++){
                if (second.substring(i, i+1) == curstr.substring(i,i+1)){
                    x += 1;
                }
                if (x == curstr.length()){
                    return curstr;
                }

            }

        }
            String answer = longestCommonSub(first, second, len-1, first.substring(len-1,len) + curstr);

            String other_may = longestCommonSub(first, second, len-1, curstr);

            if (other_may.length() > answer.length()){
                return other_may;
            }
            return answer;
        




    }




public static void main(String[] args) 
{

    
}

}