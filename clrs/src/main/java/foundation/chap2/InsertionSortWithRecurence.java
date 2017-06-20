package foundation.chap2;

/**
 * @author Ritesh Dalvi (rd026600).
 */
public class InsertionSortWithRecurence
{
    public static void main(String args[])
    {
        final int[] input = new int[] {3, 41, 52, 26, 38, 57, 9, 49};

        insertionSort(input, 0, input.length);

        System.out.println(input.toString());
    }

    public static void insertionSort(final int in[], int p, int r)
    {

        if (p >= r)
        {
            return;
        }

        r = r - 1;

        insertionSort(in, p, r);

        insert(in, p, r);
    }

    private static void insert(int[] in, int p, int q)
    {

        int i = q;

        int j = i - 1;

        int key = in[i];

        while (i > p && in[j] > key)
        {

            in[j + 1] = in[j];
            j = j - 1;

            in[i - 1] = key;
            i = i - 1;
        }

    }
}
