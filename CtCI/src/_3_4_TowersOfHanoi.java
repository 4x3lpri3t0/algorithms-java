import java.io.*;
import java.util.*;

public class _3_4_TowersOfHanoi {
    private class Tower {
        private Stack<Integer> disks;
        private int index;

        public Tower(int i) {
            disks = new Stack<Integer>();
            index = i;
        }

        int index() {
            return index;
        }

        void add(int d) {
            if (!disks.isEmpty() && disks.peek() <= d) {
                System.out.println("Error placing disk " + d);
            } else {
                disks.push(d);
            }
        }

        void moveTopTo(Tower t) {
            int top = disks.pop();
            t.add(top);
        }

        void print() {
            System.out.println("Contents of Tower " +
                    index() + ": " + disks.toString());
        }

        void moveDisks(int n, Tower destination, Tower buffer) {
            if (n > 0) {
                moveDisks(n - 1, buffer, destination);
                moveTopTo(destination);
                buffer.moveDisks(n - 1, destination, this);
            }
        }
    }

    public void main() {
        int n = 5;
        Tower[] towers = new Tower[3];
        for (int i = 0; i < 3; i++) {
            towers[i] = new Tower(i);
        }
        for (int i = n - 1; i >= 0; i--) {
            towers[0].add(i);
        }

        towers[0].print();
        towers[2].print();
        towers[0].moveDisks(n, towers[2], towers[1]);
        towers[0].print();
        towers[2].print();
    }
}