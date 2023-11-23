import java.util.Stack;

public class RecursionProbs {


    public double sumReciprocals(int n){

        if (n == 0){

            return 0;

        }
        else {
            return (1.0/n) + sumReciprocals(n-1);
        }


    }

    public int productOfEvens(int n){
        if (n == 0){
            return 1;
        }
        else{
            return (2*n) * productOfEvens(n-1);
        }
    }

    public String conversion(int num, int base){

        if (num == 0){
            return "";
        }
        else {
            return conversion(num/base, base) + String.valueOf(num%base);
        }

    }

    public int matchingDigits(int a, int b){

        if (String.valueOf(a).length() == 0 || String.valueOf(b).length() == 0){
            return 0;
        }

        else {
                if (a%10 == b%10){
                    return 1 + matchingDigits(a/10, b/10);
                }                                  
                else {
                    return matchingDigits(a/10, b/10);
                }
        }



    }

    public static void doubleUp(Stack<Integer> nums){

        if (nums.size() == 0){
            
        }
        else {
            int x = nums.pop();
            doubleUp(nums);
            nums.push(x);
            nums.push(x);   
        }
        
        

    }

    public static void printThis(int n){
        if (n <= 0){

        }
        else {
            int thing = 0;
            if (n%2==0){
                thing = (n/2)-1;
            }
            else {
                thing = n/2;
            }
            for (int i = 0; i < thing; i++){
                System.out.print("<");
            }
            if (n %2 == 0){
                System.out.print("**");
            }
            else {
                System.out.print("*");
            }
            for (int i = 0; i < thing; i++){
                System.out.print(">");
            }
            System.out.println();
        }
    }

    public static void printThis2(int n){
        if (n <= 0){

        }
        else {
            int len = 0;
            int start = 0;
            if (n%2==0){
                len = (n/2)-1;
                start = n/2;
            }
            else {
                len = n/2;
                start = n/2+1;
            }
            for (int i = start; i > 1; i--){
                System.out.print(i + " ");
            }
            if (n %2 == 0){
                System.out.print("1 1 ");
            }
            else {
                System.out.print("1 ");
            }
            for (int i = 2; i < start+1; i++){
                System.out.print(i + " ");
            }
            System.out.println();
        }





    }



    public static void main(String[] args) {
        printThis2(1);
        printThis2(2);
        printThis2(3);
        printThis2(4);
        printThis2(5);
        printThis2(6);
        printThis2(7);
        printThis2(8);
        printThis2(9);
        printThis2(10);
    }

    
}
