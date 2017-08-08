package foundation.chap15;

import org.apache.commons.lang3.tuple.Pair;

/**
 * Rod cutting with minimum price and the cut.
 * Created by ritesh on 7/29/17.
 */
public class CuttingRod {

    public static void main(String args[]) {

        int[] prices = new int[] {1,5,8,9,10,17,17,20,24,30};

        printCost(prices, 7);
    }


    private static void printCost(int[] prices, int n) {

        Pair<int[], int[]> costByCut = memoized_cut_rod(prices, n);

        final int[] cost = costByCut.getLeft();
        final int[] cut = costByCut.getRight();

        while(n>0) {

            System.out.println(cost[n] + " " + cut[n]);
            n = n - cut[n];
        }
    }

    // botton-up approach. (should work), not getting the answer tho.
    private static Pair<int[], int[]> memoized_cut_rod(int[] prices, int n) {


        int[] r = new int[n];
        int[] s = new int[n];

        r[0] = 0;

        for(int i=0;i<n;i++) {
            int q = -1;

            for(int j=0; j<i; j++) {

                if(q<prices[j]+r[i-j]){
                    q = prices[j] + r[i-j];
                    s[i] = j;
                }
            }

            r[i] = q;
        }

        return Pair.of(r,s);
    }

    // figure this out.
    private static Pair<Integer,Integer> cut_rod(int[] prices, int n, int r[], int s[]) {

        if(r[n] > 0) {
            return Pair.of(r[n],s[n]);
        }

        if(n == 0) {
            return Pair.of(0,0);
        }

        int q = -1;

        for(int i=0; i<n; i++) {

            q = Math.max(q,prices[i]+cut_rod(prices,n-i,r,s).getLeft());
        }

        r[n] = q;
        s[n] = n;

        return Pair.of(r[n], s[n]);
    }
}
