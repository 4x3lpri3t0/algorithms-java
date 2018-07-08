using System;
using System.Diagnostics;

namespace CtCI._1___Arrays_and_Strings
{
    class _1_1_UniqueCharacters
    {
        public static void Main()
        {
            string alphabet = "abcdefghijklmnopqrstuvwxyz";

            // True
            Debug.Assert(StringHasUniqueChars("abc"));
            Debug.Assert(StringHasUniqueChars("yxz"));
            Debug.Assert(StringHasUniqueChars(alphabet));

            // False
            Debug.Assert(!StringHasUniqueChars("abbba"));
            Debug.Assert(!StringHasUniqueChars("aba"));
            Debug.Assert(!StringHasUniqueChars(alphabet + "a"));
        }

        private static bool StringHasUniqueChars(string str)
        {
            // str.Length > 26 -> there MUST be a repetition
            if (str.Length > 26)
            {
                return false;
            }

            for (int i = 0; i < str.Length - 1; i++)
            {
                char c = str[i];
                int futureOccurrence = str.IndexOf(c, i + 1);

                if (futureOccurrence != -1)
                {
                    return false;
                }
            }

            return true;
        }
    }
}