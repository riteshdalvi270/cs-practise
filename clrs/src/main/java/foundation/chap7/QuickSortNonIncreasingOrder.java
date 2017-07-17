package foundation.chap7;

/**
 * Quick sort for decreasing order. Created by ritesh on 7/2/17.
 */
public class QuickSortNonIncreasingOrder
{

    public static void main(String args[])
    {

        int[] input = new int[] {13, 19, 9, 5, 12, 8, 7, 4, 21, 2, 6, 11};

        quickSortForDecreasingOrder(input, 0, input.length - 1);

        for (int i = 0; i < input.length; i++)
        {
            System.out.print(input[i] + " ");
        }
    }

    private static void quickSortForDecreasingOrder(final int[] input, int start, int end)
    {

        if (start < end)
        {

            int mid = partition(input, start, end);
            quickSortForDecreasingOrder(input, start, mid - 1);
            quickSortForDecreasingOrder(input, mid + 1, end);
        }
    }

    private static int partition(int[] input, int start, int end)
    {

        int x = input[end];

        int i = start - 1;
        int j = start;

        while (j < end)
        {

            if (input[j] >= x)
            {
                i = i + 1;
                exchange(input, i, j);
            }
            j = j + 1;
        }
        i = i + 1;
        exchange(input, i, end);

        return i;
    }

    private static void exchange(final int[] input, int i, int j)
    {

        int temp = input[j];
        input[j] = input[i];
        input[i] = temp;
    }
}
