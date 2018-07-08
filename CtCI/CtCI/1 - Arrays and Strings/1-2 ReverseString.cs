using System.Collections.Generic;
using System.Diagnostics;
using System.Text;

namespace CtCI._1___Arrays_and_Strings
{
    class _1_2_ReverseString
    {
        public static void Main()
        {
            Debug.Assert(Reverse("a") == "a");
            Debug.Assert(Reverse("ab") == "ba");
            Debug.Assert(Reverse("") == "");
            Debug.Assert(Reverse("a1z") == "z1a");
        }

        private static string Reverse(string str)
        {
            var reversed = new StringBuilder(str.Length);
            var stack = new Stack<char>(str);

            while (stack.Count > 0)
            {
                char popped = stack.Pop();
                reversed.Append(popped);
            }

            return reversed.ToString();
        }
    }
}
