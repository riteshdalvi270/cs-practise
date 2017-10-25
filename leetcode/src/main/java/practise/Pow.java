package practise;

/**
 * Implement pow(x, n).
 * @author Ritesh Dalvi
 **/
public class Pow {

    public static void main(String args[]) {

        int n = 3;
        int x = 2;

        boolean sign = false;

        if(n<0) {
            n = -n;
            sign = true;
        }

        int value = pow(x,n);

        if(sign) {
            value = -value;
        }

        System.out.println(value);
    }

    private static int pow(int x, int n) {

        if(n ==0) {
            return x;
        }

        if(n%2==0) {
            return pow(x,n-1);
        }else {
            return x * pow(x,n-1);
        }
    }
}
