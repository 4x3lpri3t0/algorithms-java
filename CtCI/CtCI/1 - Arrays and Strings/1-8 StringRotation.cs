using System.Diagnostics;

namespace CtCI._1___Arrays_and_Strings
{
    class _1_8_StringRotation
    {
        public static void Main()
        {
            // True
            Debug.Assert(IsRotation("waterbottle", "erbottlewat"));
            Debug.Assert(IsRotation("chewbacca", "baccachew"));
            Debug.Assert(IsRotation("a", "a"));
            Debug.Assert(IsRotation("cba", "bac"));

            // False
            Debug.Assert(!IsRotation("sad", "asd"));
        }

        private static bool IsRotation(string s1, string s2)
        {
            int len = s1.Length;

            // Check that s1 and s2 are equal length and not empty
            if (len == s2.Length && len > 0)
            {
                // yx will always be a substring of xyxy
                string s1s1 = s1 + s1;
                return IsSubstring(s1s1, s2);
            }

            return false;
        }

        private static bool IsSubstring(string s1, string s2)
        {
            return s1.IndexOf(s2) != -1;
        }
    }
}
