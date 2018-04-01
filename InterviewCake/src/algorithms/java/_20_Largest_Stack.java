import java.util.Stack;

/*
Notice how in the solution we're spending time on push() and pop()
so we can save time on getMax().
That's because we chose to optimize for the time cost of calls to getMax().

But we could've chosen to optimize for something else.
For example, if we expected we'd be running push() and pop()
frequently and running getMax() rarely, we could have optimized
for faster push() and pop() methods.

First step in algorithm design is deciding what we're optimizing for.
Consider the expected characteristics of the input.
*/

class _20_Largest_Stack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> maxStack = new Stack<>();

    // Add a new item to the top of our stack. If the item is greater
    // than or equal to the last item in maxStack, it's
    // the new max! So we'll add it to maxStack.
    public void push(int item) {
        stack.push(item);
        if (maxStack.empty() || item >= maxStack.peek()) {
            maxStack.push(item);
        }
    }

    // Remove and return the top item from our stack. If it equals
    // the top item in maxStack, they must have been pushed in together.
    // So we'll pop it out of maxStack too.
    public int pop() {
        int item = stack.pop();
        if (item == maxStack.peek()) {
            maxStack.pop();
        }

        return item;
    }

    // The last item in maxStack is the max item in our stack.
    public int getMax() {
        return maxStack.peek();
    }
}
// O(1) time for push(), pop(), and getMax().
// O(m) additional space, where m is the number of
// operations performed on the stack.