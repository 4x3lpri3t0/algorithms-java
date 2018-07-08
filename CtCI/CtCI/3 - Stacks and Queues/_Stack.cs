namespace CtCI._3___Stacks_and_Queues
{
    class Node
    {
        public object data;
        public Node next;

        public Node(object data)
        {
            this.data = data;
        }
    }

    class _Stack
    {
        Node top;

        object Pop()
        {
            if (top != null)
            {
                object item = top.data;
                top = top.next;

                return item;
            }

            return null;
        }

        void Push(object item)
        {
            Node t = new Node(item);
            t.next = top;
            top = t;
        }

        object Peek()
        {
            return top.data;
        }
    }
}
