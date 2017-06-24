package foundation.chap6;

/**
 * Implement max heapify iteratively.
 * Created by ritesh on 6/24/17.
 */
public class MaxHeapifyIterative {

    public static void main(String args[]) {

        Heap input = new Heap();

        maxHeapifyIterative(input, 3);
    }

    public static void maxHeapifyIterative(Heap heap, int i) {

        int largest = i;

        do {
            int left = 2*largest;
            int right = 2*largest + 1;

            if(left<heap.capacity && heap.input[left] > heap.input[largest]) {
                largest = i;
            }else {
                largest = i;
            }

            if(right<heap.capacity && heap.input[right] > heap.input[largest]) {
                largest = right;
            }else {
                largest = i;
            }

            if(largest!=i) {
                exchange(heap.input,i,largest);
            }
        }while (largest!=i);
    }

    private static void exchange(int[] input, int i, int j) {

        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    static class Heap {
        int[] input;
        int capacity;
        int size;
    }
}
