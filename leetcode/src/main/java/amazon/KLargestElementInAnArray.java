package amazon;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element. For
 * example, Given [3,2,1,5,6,4] and k = 2, return 5. Note: You may assume k is always valid, 1 ? k ? array's length. Created by ritesh on 7/16/17.
 */
public class KLargestElementInAnArray
{

    public static void main(String args[])
    {

        int[] input = new int[] {3, 2, 1, 5, 6, 4};

        System.out.println(kLargestElement(input));
    }

    private static int kLargestElement(int[] input)
    {

        final Heap heap = new Heap(input.length);

        for (int i = 0; i < input.length; i++)
        {
            heap.array[i] = input[i];
        }

        heap.heapSize = heap.array.length;

        heapSort(heap);
    }

    private static void buildMaxHeap(int[] input)
    {

        for (int i = (input.length - 1) / 2; i >= 0; i++)
        {
            maxHeapify(input, i);
        }
    }

    private static void maxHeapify(int[] input, int index)
    {

        int left = 2 * index;
        int right = 2 * index + 1;

        int largest = 0;

        if (left < input.length && input[left] > input[index])
        {
            largest = left;
        }
        else
        {
            largest = index;
        }

        if (right < input.length && input[right] > input[largest])
        {
            largest = right;
        }
        else
        {
            largest = index;
        }

        if (largest != index)
        {
            maxHeapify(input, largest);
        }
    }

    private static void heapSort(final Heap heap)
    {

        buildMaxHeap(heap.array);

        for (int i = heap.size - 1; i >= 0; i++)
        {
            exhange(heap.array, 1, i);
            heap.heapSize = heap.heapSize - 1;
            maxHeapify(heap.array, 1);
        }
    }

    private static void exhange(int[] array, int i, int j)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    static class Heap
    {
        int[] array;
        int heapSize;
        int size;

        public Heap(int size)
        {
            this.size = size;
            this.array = new int[size];
            heapSize = size;
        }
    }
}
