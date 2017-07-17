package foundation.chap2;

/**
 * Recursive binary search to search for an element. Created by ritesh on 6/20/17.
 */
public class RecursiveBinarySearch
{

    public static void main(String args[])
    {

        final int[] input = new int[] {1, 2, 3, 5, 49, 51};

        int index = recursiveBinarySearch(input, 0, input.length - 1, 2);

        System.out.println(index);
    }

    /**
     * Complexity is the number of sub-problems it is divided into T(n) = aT(n/b) + O(1) [combine] = O(logn)
     */
    public static int recursiveBinarySearch(final int[] in, int p, int r, int key)
    {

        if (p > r)
        {
            return -1;
        }

        int q = (p + r) / 2;

        int element = in[q];

        if (key < element)
        {

            return recursiveBinarySearch(in, p, q, key);
        }

        if (key > element)
        {
            return recursiveBinarySearch(in, q + 1, r, key);
        }

        if (key == element)
        {
            return q;
        }

        return -1;
    }
}
