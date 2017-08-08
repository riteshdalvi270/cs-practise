package foundation.chap15;

/**
 * Determine max revenue of rod cut with a fixed amount incurred for each cut.
 * Created by ritesh on 7/30/17.
 */
public class CuttingRodWithCutCost {

    public static void main(String args[]) {

        int[] prices = new int[] {1,5,8,9,10,17,17,20,24,30};

        int fixedCost = 12;

        int n = 7;

        int[] rv = new int[n];

        System.out.println(memorizedCut(prices, rv, fixedCost,n));
    }

    private static int memorizedCut(int[] prices, int[] rv, int fixedCost, int n) {

        if(rv[n-1] > 0) {
            return rv[n-1];
        }

        if(n == 0) {
            return 0;
        }

        int q = -1;
        for(int i=0; i<n; i++) {

            q = Math.max(q, prices[i]+memorizedCut(prices,rv,fixedCost,n-i)) - fixedCost;
        }

        rv[n-1] = q;
        return q;
    }
}
