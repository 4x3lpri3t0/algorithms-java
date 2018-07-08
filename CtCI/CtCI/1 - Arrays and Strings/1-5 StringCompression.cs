using System.Diagnostics;
using System.Text;

namespace CtCI._1___Arrays_and_Strings
{
    class _1_5_StringCompression
    {
        public static void Main()
        {
            Debug.Assert(Compress("a") == "a");
            Debug.Assert(Compress("aa") == "aa");
            Debug.Assert(Compress("aaa") == "a3");
            Debug.Assert(Compress("ab") == "ab");
            Debug.Assert(Compress("aabb") == "aabb");
            Debug.Assert(Compress("aaabbb") == "a3b3");
            Debug.Assert(Compress("aabbbb") == "a2b4");
            Debug.Assert(Compress("1112") == "1112");
            Debug.Assert(Compress("11112") == "1421");
        }

        private static string Compress(string str)
        {
            // Check if compression would create a longer string
            int size = CountCompression(str);
            if (size >= str.Length)
            {
                return str;
            }

            var compStr = new StringBuilder();
            char last = str[0];
            int count = 1;
            for (int i = 1; i < str.Length; i++)
            {
                if (str[i] == last) // Found repeated char
                {
                    count++;
                }
                else // Insert char count, and update last char
                {
                    compStr.Append(last); // Insert char
                    compStr.Append(count); // Insert count
                    last = str[i];
                    count = 1;
                }
            }

            compStr.Append(last);
            compStr.Append(count);

            return compStr.ToString();
        }

        private static int CountCompression(string str)
        {
            char last = str[0];
            int size = 0;
            int count = 1;

            for (int i = 1; i < str.Length; i++)
            {
                if (str[i] == last)
                {
                    count++;
                }
                else
                {
                    last = str[i];
                    size += 1 + count.ToString().Length;
                    count = 1;
                }
            }

            size += 1 + count.ToString().Length;
            return size;
        }
    }
}
