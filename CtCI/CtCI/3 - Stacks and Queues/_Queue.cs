namespace CtCI._3___Stacks_and_Queues
{
    class _Queue
    {
        Node first, last;

        void Enqueue(object item)
        {
            if (first == null)
            {
                last = new Node(item);
                first = last;
            }
            else
            {
                last.next = new Node(item);
                last = last.next;
            }
        }

        object Dequeue()
        {
            if (first != null)
            {
                object item = first;
                first = first.next;

                return item;
            }

            return null;
        }
    }
}
