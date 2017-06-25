package foundation.chap6;

import java.util.Scanner;

/**
 * Implement first in first out queue with priority queue.
 * Created by ritesh on 6/25/17.
 */
public class FirstInFirstOutQueueWithPriorityQueue {

    public static void main(String args[]) {

        final Queue[] queue = new Queue[10];
        final MinHeap minHeap = new MinHeap(10);

        firstInFirstOutQueue(queue,minHeap);

    }


    public static void firstInFirstOutQueue(final Queue[] queues, final MinHeap minHeap) {

        final Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Enter the operation to be performed");

            System.out.println("1 - PUSH");
            System.out.println("2 - POP");
            System.out.println("3- PEEk");

            final int userWish = scanner.nextInt();

            switch (userWish) {

                case 1:
                        System.out.println("Enter element to be pushed");
                        final int element = scanner.nextInt();

                        push(element,queues,minHeap);

                        break;
                case  2:
                        System.out.println("Popping element with low priority...");
                        int poppedElement = pop(queues,minHeap);

                        System.out.println("Popped element"+poppedElement);
                        break;
                case 3:
                        System.out.println("Peeking element...");
                        int peekedElement = peek(queues);

                        System.out.println("Peeked element"+peekedElement);
                        break;
                 default:
                        throw new RuntimeException("Wrong case");

            }
        }
    }

    static class Queue {
        int value;
        int heapIndex;

        public Queue(final int element) {
            value = element;
        }
    }
    static class MinHeap {

        Priority[] priority;
        int heapSize;
        int size;

        public MinHeap(int size) {
            priority = new Priority[size];
            this.size = size;
            heapSize = 0;
        }
    }

    static class Priority {
        int priority;
        int index;

        public Priority(int priority, int index) {
            this.priority = priority;
            this.index = index;
        }
    }


    private static void push(final int element, final Queue[] queues, final MinHeap minHeap) {

        if(minHeap.heapSize == 10) {

            System.out.println("Pop element first");
            return;
        }

        final Queue queue = new Queue(element);

        int index = insertIntoQueue(queues,queue);

        int heapIndex = heapInsert(minHeap,index);

        queues[index].heapIndex = heapIndex;
    }

    private static int insertIntoQueue(final Queue[] queues, Queue queue) {

        for(int i=0;i<queues.length;i++) {

            if(queues[i] == null) {
                queues[i] = queue;
                return i;
            }
        }

        return -1;
    }

    private static int heapInsert(final MinHeap minHeap, int index) {

        if(minHeap.heapSize == 10) {

            throw new RuntimeException("Pop elements first");
        }

        if(minHeap.heapSize == 0) {
            final Priority priority = new Priority(0,index);

            minHeap.priority[0] = priority;
            minHeap.heapSize = minHeap.heapSize + 1;

            return minHeap.heapSize;
        }

        minHeap.priority[minHeap.heapSize] = new Priority(-100, -100);
        minHeap.heapSize = minHeap.heapSize+1;

        return increaseHeapKey(minHeap,minHeap.heapSize,new Priority(minHeap.priority.length+1,index));
    }

    private static int increaseHeapKey(final MinHeap minHeap, int indexToInsertInHeap, final Priority element) {

        if(element.priority < minHeap.priority[indexToInsertInHeap].priority) {
            throw new RuntimeException("Priority is less than current elemnt");
        }

        minHeap.priority[indexToInsertInHeap] = element;

        while(indexToInsertInHeap > 0 && minHeap.priority[indexToInsertInHeap].priority > minHeap.priority[PARENT(indexToInsertInHeap)].priority) {

            Priority temp = minHeap.priority[indexToInsertInHeap];
            minHeap.priority[indexToInsertInHeap] = minHeap.priority[PARENT(indexToInsertInHeap)];
            minHeap.priority[PARENT(indexToInsertInHeap)] = temp;

            indexToInsertInHeap = PARENT(indexToInsertInHeap);
        }

        return indexToInsertInHeap;
    }

    private static int PARENT(int index) {
        return index/2;
    }

    private static int LEFT(int index) {
        return 2*index;
    }

    private static int RIGHT(int index) {
        return 2*index+1;
    }

    private static int pop(final Queue[] queues, final MinHeap minHeap) {

        // TODO
        return 0;
    }

    private static int peek(final Queue[] queues) {

        //TODO:
        return 0;
    }
}
