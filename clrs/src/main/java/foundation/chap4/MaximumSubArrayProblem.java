package foundation.chap4;

/**
 * Brute force and recursive approach Created by ritesh on 6/21/17.
 */
public class MaximumSubArrayProblem
{

    public static void main(String[] args)
    {

        int[] stocks = new int[] {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};

        final MaxStock maxStock = bruteForceMaximuSubarrayProblem(stocks);

        System.out.println(maxStock.leftIndex + " , " + maxStock.rightIndex + " , " + maxStock.maxSum);

        final MaxStock maxStockRecursive = recursiveMaximumSubarrayProblem(stocks, 0, stocks.length - 1);

        System.out.println(maxStockRecursive.leftIndex + " , " + maxStockRecursive.rightIndex + " , " + maxStockRecursive.maxSum);
    }

    public static MaxStock bruteForceMaximuSubarrayProblem(final int[] stocks)
    {

        int max_so_far_index = 0;
        int maxSum = 0;
        int startIndex = 0;
        int sum = 0;

        for (int i = 0; i < stocks.length; i++)
        {

            int stockPrice = stocks[i];
            sum = sum + stockPrice;
            max_so_far_index = i;

            if (sum > maxSum)
            {
                maxSum = sum;
                startIndex = i;
            }
            else if (sum < 0)
            {
                max_so_far_index = 0;
                maxSum = 0;
                startIndex = i;
                sum = 0;
            }
        }

        return new MaxStock(startIndex, max_so_far_index, maxSum);
    }

    public static MaxStock recursiveMaximumSubarrayProblem(int[] stock, int low, int high)
    {

        if (low == high)
        {
            return new MaxStock(low, high, stock[low]);
        }

        int mid = (low + high) / 2;

        final MaxStock leftMaxStock = recursiveMaximumSubarrayProblem(stock, low, mid);
        final MaxStock rightMaxStock = recursiveMaximumSubarrayProblem(stock, mid + 1, high);
        final MaxStock crossOverStock = findMaxSubarrayCrossingMid(stock, low, mid, high);

        if (leftMaxStock.maxSum > rightMaxStock.maxSum && leftMaxStock.maxSum > crossOverStock.maxSum)
        {
            return leftMaxStock;
        }

        if (rightMaxStock.maxSum > leftMaxStock.maxSum && rightMaxStock.maxSum > crossOverStock.maxSum)
        {
            return rightMaxStock;
        }

        return crossOverStock;
    }

    public static MaxStock findMaxSubarrayCrossingMid(int[] stock, int low, int mid, int high)
    {

        int leftMaxSum = -10000;
        int sum = 0;
        int maxLeft = 0;

        for (int i = mid; i >= low; i--)
        {

            sum = sum + stock[i];

            if (sum > leftMaxSum)
            {
                leftMaxSum = sum;
                maxLeft = i;
            }
        }

        sum = 0;
        int rightMaxSum = -10000;
        int maxRight = 0;

        for (int j = mid + 1; j <= high; j++)
        {

            sum = sum + stock[j];

            if (sum > rightMaxSum)
            {
                rightMaxSum = sum;
                maxRight = j;
            }
        }

        return new MaxStock(maxLeft, maxRight, leftMaxSum + rightMaxSum);
    }

    static class MaxStock
    {

        int leftIndex;
        int rightIndex;
        int maxSum;

        public MaxStock(int leftIndex, int rightIndex, int maxSum)
        {
            this.leftIndex = leftIndex;
            this.rightIndex = rightIndex;
            this.maxSum = maxSum;
        }
    }
}
