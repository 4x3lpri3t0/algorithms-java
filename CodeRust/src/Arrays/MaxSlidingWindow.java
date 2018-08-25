package Arrays;

import java.util.ArrayDeque;

import static java.lang.System.*;

// https://www.educative.io/collection/page/5642554087309312/5679846214598656/210002
public class MaxSlidingWindow {
    public static void findMaxSlidingWindow(int[] array, int windowSize) {
        if (array.length < windowSize)
            return;

        ArrayDeque<Integer> window = new ArrayDeque<>();

        // Find out max for the first window
        for (int i = 0; i < windowSize; i++) {
            while (!window.isEmpty() && array[i] >= array[window.peekLast()]) {
                window.removeLast();
            }

            window.addLast(i);
        }

        out.print(array[window.peekFirst()] + ", ");

        for (int i = windowSize; i < array.length; i++) {
            // Remove all numbers that are smaller than current number from tail of q
            while (!window.isEmpty() && array[i] >= array[window.peekLast()]) {
                window.removeLast();
            }

            // Remove first number if it doesn't fall in the window anymore
            if (!window.isEmpty() && window.peekFirst() <= i - windowSize) {
                window.removeFirst();
            }

            window.addLast(i);

            out.print(array[window.peekFirst()] + ", ");
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 3, 2, 1, 2, 5};
        out.println("Window Size 4");
        findMaxSlidingWindow(array, 4);

        out.println("\nWindow Size 3");
        findMaxSlidingWindow(array, 3);

        out.println("\nWindow Size 5");
        findMaxSlidingWindow(array, 5);
    }
}