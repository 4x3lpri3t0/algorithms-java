using System;
using System.Linq;

namespace Algorithms._1_Fundamentals._1_1_BasicProgModel
{
    public class Ex_1_1_18
    {
        private static int Mystery1(int a, int b)
        {
            if (b == 0) return 0;
            if (b % 2 == 0) return Mystery1(a + a, b / 2);

            return Mystery1(a + a, b / 2) + a;
        }

        private static int Mystery2(int a, int b)
        {
            if (b == 0) return 1;
            if (b % 2 == 0) return Mystery2(a * a, b / 2);

            return Mystery2(a * a, b / 2) * a;
        }

        public static void Main()
        {
            Console.WriteLine("Result: " + Mystery1(2, 25));
            Console.WriteLine("Result: " + Mystery1(3, 11));
            Console.WriteLine();
            Console.WriteLine("Result: " + Mystery1(5, 7));
            Console.WriteLine();
            Console.WriteLine("Result: " + Mystery2(5, 7));
        }
    }
}