using System.Diagnostics;
using System.Linq;

namespace CtCI._1___Arrays_and_Strings
{
    class _1_3_IsPermutation
    {
        public static void Main()
        {
            // True
            Debug.Assert(IsPermutation("a", "a"));
            Debug.Assert(IsPermutation("aab", "baa"));
            Debug.Assert(IsPermutation("acb", "bac"));
            Debug.Assert(IsPermutation("az", "za"));
            Debug.Assert(IsPermutation("az", "az"));

            // False
            Debug.Assert(!IsPermutation("a", "b"));
            Debug.Assert(!IsPermutation("aa", "bb1"));
            Debug.Assert(!IsPermutation("1", "2"));
        }

        private static bool IsPermutation(string str1, string str2)
        {
            if (str1.Length != str2.Length)
            {
                return false;
            }

            string orderedStr1 = string.Join("", str1.OrderBy(x => x));
            string orderedStr2 = string.Join("", str2.OrderBy(x => x));

            return orderedStr1 == orderedStr2;
        }
    }
}
