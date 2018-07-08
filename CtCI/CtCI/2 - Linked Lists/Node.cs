namespace CtCI._2___Linked_Lists
{
    public class Node
    {
        public Node Next = null;
        public int Data;

        public Node(int d)
        {
            Data = d;
        }

        void appendToTail(int d)
        {
            Node end = new Node(d);
            Node n = this;

            while (n.Next != null)
            {
                n = n.Next;
            }

            n.Next = end;
        }

        public static Node DeleteNode(Node head, int d)
        {
            Node n = head;

            if (n.Data == d)
            {
                return n.Next; // Move head
            }

            while (n.Next != null)
            {
                if (n.Next.Data == d)
                {
                    n.Next = n.Next.Next;
                    return head; // Head didn't change
                }

                n = n.Next;
            }

            return head;
        }
    }
}
