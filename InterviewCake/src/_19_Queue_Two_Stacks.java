import java.util.NoSuchElementException;
import java.util.Stack;

class _19_Queue_Two_Stacks {
    private Stack<Integer> inStack = new Stack<>();
    private Stack<Integer> outStack = new Stack<>();

    public void enqueue(int item) {
        inStack.push(item);
    }

    public int dequeue() {
        if (outStack.empty()) {
            while (!inStack.empty()) {
                int item = inStack.pop();
                outStack.push(item);
            }

            if (outStack.empty()) {
                throw new NoSuchElementException("Already empty queue");
            }
        }

        return outStack.pop();
    }
}
// Enqueue: O(1) time
// Dequeue: O(n) time