package StacksAndQueues;

import java.util.Stack;

import static java.lang.System.out;

// https://www.educative.io/collection/page/5642554087309312/5679846214598656/220002
class QueuesUsingStacks {
    class QueueUsingStacks {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        void enqueue(int data) {
            stack1.push(data);
        }

        boolean isEmpty() {
            return stack1.size() + stack2.size() == 0;
        }

        int dequeue() throws Exception {
            if (isEmpty()) {
                throw new Exception("queue is empty");
            }

            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }

            return stack2.pop();
        }
    }

    public static void main(String[] args) {
        try {
            QueuesUsingStacks qsc = new QueuesUsingStacks();
            QueueUsingStacks qs = qsc.new QueueUsingStacks();

            out.println("qs.enqueue(1,2,4)");
            qs.enqueue(1);
            qs.enqueue(2);
            qs.enqueue(4);

            out.println("qs.dequeue()" + "= " + qs.dequeue());
            out.println("qs.enqueue(3)");
            qs.enqueue(3);
            out.println("qs.dequeue()" + "= " + qs.dequeue());
            out.println("qs.dequeue()" + "= " + qs.dequeue());
            out.println("qs.dequeue()" + "= " + qs.dequeue());
        } catch (Exception ex) {
            out.println("Exception");
        }
    }
}