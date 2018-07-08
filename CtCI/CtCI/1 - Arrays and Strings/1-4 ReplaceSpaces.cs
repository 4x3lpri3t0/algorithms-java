using System.Diagnostics;
using System.Linq;

namespace CtCI._1___Arrays_and_Strings
{
    class _1_4_ReplaceSpaces
    {
        public static void Main()
        {
            // True
            Debug.Assert(Replace("a b") == "a%20b");
            Debug.Assert(Replace("a b ") == "a%20b");
            Debug.Assert(Replace("a    b ") == "a%20b");
            Debug.Assert(Replace("Mr John Smith      ") == "Mr%20John%20Smith");

            // False
            Debug.Assert(Replace("a b") != "ab");
            Debug.Assert(Replace("a b") != "a b");
        }

        private static string Replace(string str)
        {
            var tokens = str.Trim()
                            .Split(' ')
                            .Where(x => x != "");

            return string.Join("%20", tokens);
        }
    }
}
