import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static java.lang.System.out;

public class _3_5_TwoStacksQ {
    private class MyQueue<T>  {
        Stack<T> stackNewest, stackOldest;

        MyQueue() {
            stackNewest = new Stack<>();
            stackOldest = new Stack<>();
        }

        public int size() {
            return stackNewest.size() + stackOldest.size();
        }

        public void add(T value) {
            // Push new incoming values
            stackNewest.push(value);
        }

        // Move elements from stackNewest into stackOldest.
        // This is usually done so that we can do operations
        // on stackOldest.
        private void shiftStacks() {
            if (stackOldest.isEmpty()) {
                while (!stackNewest.isEmpty()) {
                    stackOldest.push(stackNewest.pop());
                }
            }
        }

        public T peek() {
            shiftStacks();
            return stackOldest.peek(); // Retrieve oldest.
        }

        public T remove() {
            shiftStacks();
            return stackOldest.pop(); // Pop oldest.
        }
    }

    public void main() {
        MyQueue<Integer> myQueue = new MyQueue<>();

        // Test code against "real" queue
        Queue<Integer> testQueue = new LinkedList<>();

        for (int i = 0; i < 100; i++) {
            int choice = AssortedMethods.randomIntInRange(0, 10);
            if (choice <= 5) { // enqueue
                int element = AssortedMethods.randomIntInRange(1, 10);
                testQueue.add(element);
                myQueue.add(element);
                out.println("Enqueued " + element);
            } else if (testQueue.size() > 0) {
                int top1 = testQueue.remove();
                int top2 = myQueue.remove();
                if (top1 != top2) { // Check for error
                    out.println("******* FAILURE - DIFFERENT TOPS: " + top1 + ", " + top2);
                }
                out.println("Dequeued " + top1);
            }

            if (testQueue.size() == myQueue.size()) {
                if (testQueue.size() > 0 && testQueue.peek() != myQueue.peek()) {
                    out.println("******* FAILURE - DIFFERENT TOPS: " + testQueue.peek() + ", " + myQueue.peek() + " ******");
                }
            }  else {
                out.println("******* FAILURE - DIFFERENT SIZES ******");
            }
        }
    }
}