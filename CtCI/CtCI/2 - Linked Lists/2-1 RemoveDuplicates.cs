using System;
using System.Collections.Generic;
using System.Diagnostics;

namespace CtCI._2___Linked_Lists
{
    class _2_1_RemoveDuplicates
    {
        public static void Main()
        {
            var head1 = CreateLL();
            Action<Node> RemoveDupsAction = RemoveDups;
            Test(RemoveDupsAction, head1);

            var head2 = CreateLL();
            Action<Node> RemoveDupsNoBufferAction = RemoveDupsNoBuffer;
            Test(RemoveDupsNoBufferAction, head2);
        }

        private static Node CreateLL()
        {
            var head = new Node(1);
            head.Next = new Node(2);
            head.Next.Next = new Node(2);
            head.Next.Next.Next = new Node(3);

            return head;
        }

        private static void Test(Action<Node> action, Node head)
        {
            action.Invoke(head);

            Debug.Assert(head.Data == 1);
            Debug.Assert(head.Next.Data == 2);
            Debug.Assert(head.Next.Next.Data == 3);
            Debug.Assert(head.Next.Next.Next == null);
        }

        private static void RemoveDups(Node n)
        {
            var table = new HashSet<int>();

            Node previous = null;
            while (n != null)
            {
                if (table.Contains(n.Data))
                {
                    previous.Next = n.Next;
                }
                else
                {
                    table.Add(n.Data);
                    previous = n;
                }

                n = n.Next;
            }
        }

        private static void RemoveDupsNoBuffer(Node head)
        {
            if (head == null) return;

            Node current = head;
            while (current != null)
            {
                // Remove all future nodes that have the same value
                Node runner = current;
                while (runner.Next != null)
                {
                    if (runner.Next.Data == current.Data)
                    {
                        runner.Next = runner.Next.Next;
                    }
                    else
                    {
                        runner = runner.Next;
                    }
                }

                current = current.Next;
            }
        }
    }
}
