package foundation.chap2;

/**
 * Search the element iteratively
 * Created by ritesh on 6/20/17.
 */
public class IterativeBinarySearch {

    public static void main(String args[]) {

        final int[] input = new int[] {1,2,3,5,49,51};

        int index = iterativeBinarySearch(input,4);

        System.out.println(index);
    }

    /**
     * Complexity is the number of sub-problems it is divided into
     * T(n) = aT(n/b) + O(1) [combine] =  O(logn)
     */
    private static int iterativeBinarySearch(final int[] in, int key) {

        int p = 0;
        int r = in.length - 1;

        while(p<=r) {

            int q = (p+r)/2;

            int element = in[q];

            if(key<element) {

                r = q;
                continue;
            }

            if(key>element) {
                p = q+1;
                continue;
            }

            if(key == element) {

                return q;
            }
        }

        return -1;
    }
}
