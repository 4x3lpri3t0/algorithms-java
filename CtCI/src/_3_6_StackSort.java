import java.util.Stack;

import static java.lang.System.out;

public class _3_6_StackSort {
    static int c = 0;

    public static Stack<Integer> mergesort(Stack<Integer> inStack) {
        if (inStack.size() <= 1) {
            return inStack;
        }

        Stack<Integer> left = new Stack<>();
        Stack<Integer> right = new Stack<>();
        int count = 0;
        while (inStack.size() != 0) {
            count++;
            c++;
            if (count % 2 == 0) {
                left.push(inStack.pop());
            } else {
                right.push(inStack.pop());
            }
        }

        left = mergesort(left);
        right = mergesort(right);
        while (left.size() > 0 || right.size() > 0) {
            if (left.size() == 0) {
                inStack.push(right.pop());
            } else if (right.size() == 0) {
                inStack.push(left.pop());
            } else if (right.peek().compareTo(left.peek()) <= 0) {
                inStack.push(left.pop());
            } else {
                inStack.push(right.pop());
            }
        }

        Stack<Integer> reverseStack = new Stack<>();
        while (inStack.size() > 0) {
            c++;
            reverseStack.push(inStack.pop());
        }

        return reverseStack;
    }

    public void main() {
        for (int k = 1; k < 100; k++) {
            c = 0;
            Stack<Integer> s = new Stack<>();
            for (int i = 0; i < 10 * k; i++) {
                int r = AssortedMethods.randomIntInRange(0, 1000);
                s.push(r);
            }

            s = mergesort(s);
            int last = Integer.MAX_VALUE;
            while (!s.isEmpty()) {
                int cur = s.pop();
                if (cur > last) {
                    out.println("Error: " + last + " " + cur);
                }
                last = cur;
            }
            out.println(c);
        }

    }
}

// TC: O(n^2)
// SC: O(N)