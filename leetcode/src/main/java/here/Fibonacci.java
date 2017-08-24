package here;

/**
 * Created by ritesh on 8/22/17.
 */
public class Fibonacci {

    public static void main(String args[]) {

        int n = 5;

        fibonacciIterative(n);

        System.out.println("------End Of Iterative------");

        for(int i =1; i < 6; i++)
        System.out.println(fibonacciRecursive(i));
    }

    // 1,1,2,3,5
    private static void fibonacciIterative(int n) {

        if(n == 1) {
            System.out.println(1);
            return;
        }

        int i = 1;
        int j = 0;
        int sum = 0;

        System.out.println(i);
        while(n>1) {

            sum = i + j;
            System.out.println(sum);

            j = i;
            i = sum;

            n--;
        }
    }

    private static int fibonacciRecursive(int n) {

       if(n <= 0) {
           return 0;
       }

       if(n == 1) {
           return 1;
       }

       return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
    }
}
