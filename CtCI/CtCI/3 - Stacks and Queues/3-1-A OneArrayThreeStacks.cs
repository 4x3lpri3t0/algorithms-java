using System;

namespace CtCI._3___Stacks_and_Queues
{
    public class OneArrayThreeStacksA
    {
        const int StackSize = 10;
        readonly int[] _buffer = new int[StackSize * 3];

        // 3 stack pointers to keep track of the index of the top element
        readonly int[] _stackPointer = { -1, -1, -1 };

        void Push(int stackNum, int value)
        {
            /* Check that we have space for the next element */
            if (_stackPointer[stackNum] + 1 >= StackSize)
            {
                throw new Exception("Out of space.");
            }

            /* Increment stack pointer */
            _stackPointer[stackNum]++;

            /* Update top value */
            int absTopOfStack = AbsTopOfStack(stackNum);
            _buffer[absTopOfStack] = value;
        }

        int Pop(int stackNum)
        {
            if (_stackPointer[stackNum] == -1)
            {
                throw new Exception("Trying to pop an empty stack.");
            }

            int absTopOfStack = AbsTopOfStack(stackNum);
            int value = _buffer[absTopOfStack]; // Get top
            _buffer[absTopOfStack] = 0; // Clear index
            _stackPointer[stackNum]--; // Decrement pointer

            return value;
        }

        int Peek(int stackNum)
        {
            int absTopOfStack = AbsTopOfStack(stackNum);

            return _buffer[absTopOfStack];
        }

        bool IsEmpty(int stackNum)
        {
            return _stackPointer[stackNum] == -1;
        }

        /* returns index of the top of the stack "stackNum", in absolute terms */
        int AbsTopOfStack(int stackNum)
        {
            return stackNum * StackSize + _stackPointer[stackNum];
        }

        public void Run()
        {
            Push(2, 4);
            Console.WriteLine("Peek 2: " + Peek(2));
            Push(0, 3);
            Push(0, 7);
            Push(0, 5);
            Console.WriteLine("Peek 0: " + Peek(0));
            Pop(0);
            Console.WriteLine("Peek 0: " + Peek(0));
            Pop(0);
            Console.WriteLine("Peek 0: " + Peek(0));
        }
    }
}