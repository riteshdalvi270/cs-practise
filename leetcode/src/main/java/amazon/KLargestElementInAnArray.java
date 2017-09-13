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

        System.out.println(kLargestElement(input, 2));
    }

    private static int kLargestElement(int[] input, int k)
    {

        final Heap heap = new Heap(input.length);

        for (int i = 0; i < input.length; i++)
        {
            heap.array[i] = input[i];
        }

        heap.heapSize = input.length;

        heapSort(heap);

        for(int i=input.length-1;i>=0;i--) {

            if(i==k) {
                return heap.array[i];
            }
        }

        return 0;
    }

    private static void buildMaxHeap(Heap heap)
    {

        for (int i = (heap.heapSize / 2)-1; i >= 0; i--)
        {
            maxHeapify(heap, i);
        }
    }

    private static void maxHeapify(Heap heap, int index)
    {

        int left = 2 * index + 1;
        int right = 2 * index + 2;

        int largest = index;

        if (left < heap.heapSize && heap.array[left] > heap.array[largest])
        {
            largest = left;
        }

        if (right < heap.heapSize && heap.array[right] > heap.array[largest])
        {
            largest = right;
        }

        if (largest != index)
        {
            exhange(heap.array, largest, index);
            maxHeapify(heap, largest);
        }
    }

    private static void heapSort(final Heap heap)
    {

        buildMaxHeap(heap);

        for (int i = heap.size - 1; i >= 2; i--)
        {
            exhange(heap.array, 1, i);
            heap.heapSize = heap.heapSize - 1;
            maxHeapify(heap, 1);
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
