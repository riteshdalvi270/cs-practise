package foundation.chap2;

/**
 * Rewrite merge procedure without sentinal. Created by ritesh on 6/19/17.
 */
public class RewriteMergeProcedureWithoutSentinal
{

    public static void main(String args[])
    {

        final int[] input = new int[] {3, 41, 52, 26, 38, 57, 9, 49};

        mergeSort(input, 0, input.length);

        System.out.println(input.toString());
    }

    public static void mergeSort(final int[] in, int p, int r)
    {

        if (p >= r)
        {
            return;
        }

        int q = (p + r) / 2;

        mergeSort(in, p, q);
        mergeSort(in, q + 1, r);

        merge(in, p, q, r);
    }

    public static void merge(final int[] in, int p, int q, int r)
    {
        int n1 = q - p + 1;
        int n2 = r - q;

        int[] leftIn = new int[n1];
        for (int i = 0; i < n1; i++)
        {
            leftIn[i] = in[p + i];
        }

        int[] rightIn = new int[n2];
        for (int j = 0; j < n2; j++)
        {
            rightIn[j] = in[q + j];
        }

        int i = 0;
        int j = 0;

        for (int k = p; k < r; k++)
        {

            if (i > n1 - 1 && j < n2 - 1)
            {

                in[k] = rightIn[j];
                j++;
                continue;
            }
            else if (j > n2 - 1 && i < n1 - 1)
            {

                in[k] = leftIn[i];
                i++;
                continue;
            }

            if (leftIn[i] <= rightIn[j])
            {
                in[k] = leftIn[i];
                i++;
            }
            else if (rightIn[j] < leftIn[i])
            {
                in[k] = rightIn[j];
                j++;
            }
        }
    }
}
