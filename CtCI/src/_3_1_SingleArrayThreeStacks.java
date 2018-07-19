import java.io.*;
import java.util.*;

// Stack 1: [0, n/3]
// Stack 2: [n/3, 2n/3]
// Stack 3: [2n/3, n]
public class _3_1_SingleArrayThreeStacks {
    private int stackSize = 100;
    private int[] buffer = new int [stackSize * 3];
    private int[] stackPointer = {-1, -1, -1}; // Pointers to track top element

    void push(int stackNum, int value) throws Exception {
        // Check if we have space
        if (stackPointer[stackNum] + 1 >= stackSize) { // Last element
            throw new Exception("Out of space");
        }

        // Increment stack pointer and then update top value
        stackPointer[stackNum]++;
        buffer[absTopOfStack(stackNum)] = value;
    }

    int pop(int stackNum) throws Exception {
        if (stackPointer[stackNum] == -1) {
            throw new Exception("Trying to pop an empty stack");
        }

        int value = buffer[absTopOfStack(stackNum)] = 0; // Clear index
        stackPointer[stackNum]--; // Decrement pointer
        return value;
    }

    int peek(int stackNum) {
        int index = absTopOfStack(stackNum);
        return buffer[index];
    }

    boolean isEmpty(int stackNum) {
        return stackPointer[stackNum] == -1;
    }

    // Returns index of top of stack "stackNum", in absolute terms
    int absTopOfStack(int stackNum) {
        return stackNum * stackSize + stackPointer[stackNum];
    }
}