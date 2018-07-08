using System.Diagnostics;

namespace CtCI._2___Linked_Lists
{
    class _2_3_DeleteNode
    {
        public static void Main()
        {
            var node = new Node(1);
            var node2 = new Node(2);
            node.Next = node2;
            var node3 = new Node(3);
            node2.Next = node3;

            Debug.Assert(DeleteNode(node2) == true);
            Debug.Assert(node.Next.Data == node3.Data && node3.Data == 3);
        }

        // NOTE: This problem cannot be solved if the node to
        // be deleted is the last node in the linked list.
        private static bool DeleteNode(Node n)
        {
            if (n == null || n.Next == null)
            {
                return false; // Failure
            }

            Node next = n.Next;
            n.Data = next.Data;
            n.Next = next.Next;

            return true;
        }
    }
}
