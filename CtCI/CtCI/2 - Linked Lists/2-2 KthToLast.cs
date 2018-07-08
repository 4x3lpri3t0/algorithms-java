using System.Diagnostics;

namespace CtCI._2___Linked_Lists
{
    class _2_2_KthToLast
    {
        public static void Main()
        {
            var node = new Node(1);
            node.Next = new Node(2);
            node.Next.Next = new Node(3);

            // Recursive
            var result = NthToLastRecursive(node, 1, new IntWrapper());
            Debug.Assert(result.Data == 3);

            result = NthToLastRecursive(node, 3, new IntWrapper());
            Debug.Assert(result.Data == 1);

            // Iterative
            result = NthToLastIterative(node, 1);
            Debug.Assert(result.Data == 3);

            result = NthToLastIterative(node, 3);
            Debug.Assert(result.Data == 1);
        }

        private class IntWrapper
        {
            public int value = 0;
        }

        private static Node NthToLastRecursive(Node head, int k, IntWrapper i)
        {
            if (head == null)
                return null;

            Node node = NthToLastRecursive(head.Next, k, i);
            i.value = i.value + 1;
            if (i.value == k) // We've found the kth element
            {
                return head;
            }

            return node;
        }

        private static Node NthToLastIterative(Node head, int k)
        {
            if (k <= 0) return null;

            Node p1 = head;
            Node p2 = head;

            // Move p2 forward k nodes into the list.
            for (int i = 0; i < k - 1; i++)
            {
                if (p2 == null) return null; // Error check
                p2 = p2.Next;
            }

            if (p2 == null) return null;

            // Now, move p1 and p2 at the same speed. When p2 hits the end
            // p1 will be at the right element.
            while (p2.Next != null)
            {
                p1 = p1.Next;
                p2 = p2.Next;
            }

            return p1;
        }
    }
}