package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Queue;

import static java.lang.System.out;

// https://www.educative.io/collection/page/5642554087309312/5679846214598656/260001
public class StacksUsingQueues {
    class StackUsingQueue {
        Queue<Integer> queue1 = new ArrayDeque<>();
        Queue<Integer> queue2 = new ArrayDeque<>();

        void push(int data) {
            queue1.add(data);
        }

        boolean isEmpty() {
            return queue1.size() + queue2.size() == 0;
        }

        int pop() throws Exception {
            if (isEmpty()) {
                throw new Exception("stack is empty");
            }

            while (queue1.size() > 1) {
                queue2.add(queue1.poll());
            }

            int value = queue1.poll();

            swapQueues();

            return value;
        }

        private void swapQueues() {
            Queue<Integer> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
        }
    }

    public static void main(String[] args) {
        try {
            StacksUsingQueues sqc = new StacksUsingQueues();
            StackUsingQueue sq = sqc.new StackUsingQueue();

            out.println("sq.push(1), sq.push(2)");
            sq.push(1);
            sq.push(2);

            out.println("sq.pop() = " + (sq.pop()));

            out.println("sq.push(3)");

            sq.push(3);
            out.println("sq.pop() = " + (sq.pop()));
        } catch (Exception ex) {
        }
    }
}
