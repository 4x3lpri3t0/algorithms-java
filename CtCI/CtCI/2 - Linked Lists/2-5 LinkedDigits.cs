using System.Diagnostics;

namespace CtCI._2___Linked_Lists
{
    class _2_5_LinkedDigits
    {
        public static void Main()
        {
            var node1 = new Node(7);
            node1.Next = new Node(1);
            node1.Next.Next = new Node(6);

            var node2 = new Node(5);
            node2.Next = new Node(9);
            node2.Next.Next = new Node(2);

            var result = AddLists(node1, node2, 0);
            Debug.Assert(result.Data == 2);
            Debug.Assert(result.Next.Data == 1);
            Debug.Assert(result.Next.Next.Data == 9);
        }

        private static Node AddLists(Node list1, Node list2, int carry)
        {
            if (list1 == null && list2 == null && carry == 0)
            {
                return null;
            }

            var value = carry;

            if (list1 != null)
            {
                value += list1.Data;
            }
            if (list2 != null)
            {
                value += list2.Data;
            }

            var result = new Node(value % 10);

            if (list1 != null || list2 != null)
            {
                var more = AddLists(list1 == null ? null : list1.Next,
                                    list2 == null ? null : list2.Next,
                                    value >= 10 ? 1 : 0);
                result.Next = more;
            }

            return result;
        }
    }
}
