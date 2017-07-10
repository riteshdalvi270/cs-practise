package foundation.chap1;

/**
 * Best time to buy and sell stocks.
 * Created by ritesh on 7/9/17.
 */
public class MaximumArraySubproblem {

    public static void main(String args[]) {

        int prices[] = {13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};

        int maxStock = maximumArraySubProblem(prices,0,prices.length-1);

        System.out.println(maxStock);
    }

    private static int maximumArraySubProblem(int[] prices, int low, int high) {

        if(low==high) {
            return prices[low];
        }

        int mid = (low+high)/2;

        int leftSum = maximumArraySubProblem(prices,low,mid);

        int rightSum = maximumArraySubProblem(prices,mid+1,high);

        int crossOverSum = maximumCrossOverSubProblem(prices,low,mid,high);

        return Math.max(crossOverSum,Math.max(leftSum,rightSum));
    }

    private static int maximumCrossOverSubProblem(int[] prices, int low, int mid, int high) {

        int left = -1;

        int sum = 0;

        int maxSumSoFarLeft = 0;

        for(int i=mid; i>=low;i--) {

            sum = sum + prices[i];

            if(sum >maxSumSoFarLeft) {
                maxSumSoFarLeft = sum;
                left = i;
            }
        }

        int right = -1;
        sum = 0;
        int maxSumSoFarRight = 0;

        for(int j=mid+1;j<=high;j++) {

            sum = sum + prices[j];

            if(sum > maxSumSoFarRight) {
                maxSumSoFarRight = sum;
                right = j;
            }
        }

        return maxSumSoFarLeft + maxSumSoFarRight;
    }
}
