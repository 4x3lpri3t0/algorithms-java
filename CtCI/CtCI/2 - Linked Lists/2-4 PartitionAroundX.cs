using System.Diagnostics;

namespace CtCI._2___Linked_Lists
{
    class _2_4_PartitionAroundX
    {
        public static void Main()
        {
            var node = new Node(4);
            node.Next = new Node(3);
            node.Next.Next = new Node(1);

            var result = Partition(node, 2);
            Debug.Assert(result.Data == 1);
            Debug.Assert(result.Next.Data == 4);
            Debug.Assert(result.Next.Next.Data == 3);
        }

        // Pass in the head of the LL and the value to partition around
        private static Node Partition(Node node, int x)
        {
            Node beforeStart = null;
            Node beforeEnd = null;
            Node afterStart = null;
            Node afterEnd = null;

            // Partition list
            while (node != null)
            {
                Node next = node.Next;
                node.Next = null;
                if (node.Data < x)
                {
                    // Insert into before list
                    if (beforeStart == null)
                    {
                        beforeStart = node;
                        beforeEnd = beforeStart;
                    }
                    else
                    {
                        beforeEnd.Next = node;
                        beforeEnd = node;
                    }
                }
                else
                {
                    // Insert into after list
                    if (afterStart == null)
                    {
                        afterStart = node;
                        afterEnd = afterStart;
                    }
                    else
                    {
                        afterEnd.Next = node;
                        afterEnd = node;
                    }
                }

                node = next;
            }

            if (beforeStart == null)
            {
                return afterStart;
            }

            // Merge before list and after list
            beforeEnd.Next = afterStart;

            return beforeStart;
        }

        // ALTERNATIVE METHOD: Insert nodes in front
        private static Node Partition2(Node node, int x)
        {
            Node beforeStart = null;
            Node afterStart = null;

            /* Partition list */
            PartitionList(ref node, x, ref beforeStart, ref afterStart);

            /* Merge before list and after list */
            if (beforeStart == null)
            {
                return afterStart;
            }

            var head = beforeStart;

            while (beforeStart.Next != null)
            {
                beforeStart = beforeStart.Next;
            }

            beforeStart.Next = afterStart;

            return head;
        }

        private static void PartitionList(ref Node node, int x, ref Node beforeStart, ref Node afterStart)
        {
            while (node != null)
            {
                var next = node.Next;

                if (node.Data < x)
                {
                    /* Insert node into start of before list */
                    node.Next = beforeStart;
                    beforeStart = node;
                }
                else
                {
                    /* Insert node into front of after list */
                    node.Next = afterStart;
                    afterStart = node;
                }
                node = next;
            }
        }
    }
}
