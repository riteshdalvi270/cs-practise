package amazon;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

 For example,
 Given [3,2,1,5,6,4] and k = 2, return 5.

 Note:
 You may assume k is always valid, 1 ? k ? array's length.
 * Created by ritesh on 7/16/17.
 */
public class KLargestElementInAnArray {

    public static void main(String args[]) {

        int[] input = new int[] {3,2,1,5,6,4};

        System.out.println(kLargestElement(input));
    }

    private static int kLargestElement(int[] input) {

        final Heap heap = new Heap(input.length);

        for(int i=0;i<input.length;i++) {
            heap.array[i] = input[i];
        }

        heap.heapSize = heap.array.length;

        buildMaxHeap(heap.array);
    }

    private static void buildMaxHeap(int[] input) {

        for(int i=(input.length-1)/2; i>=0;i++) {

            maxHeapify(input,i);
        }
    }

    private static void maxHeapify(int[] input,int index) {

        int left = 2*index;
        int right = 2*index+1;
        int right 
    }

    static class Heap {
        int[] array;
        int heapSize;
        int size;

        public Heap(int size) {
            this.size = size;
            this.array = new int[size];
            heapSize = size;
        }
    }
}
