using System.Diagnostics;

namespace CtCI._1___Arrays_and_Strings
{
    class _1_6_RotateMatrix
    {
        public static void Main()
        {
            int[] row1 = { 1, 2 };
            int[] row2 = { 3, 4 };
            int[][] matrix = { row1, row2 };

            Rotate(matrix, matrix.Length);

            // Assert that the matrix has been rotated 90 degrees
            Debug.Assert(matrix[0][0] == 3);
            Debug.Assert(matrix[0][1] == 1);
            Debug.Assert(matrix[1][0] == 4);
            Debug.Assert(matrix[1][1] == 2);
        }

        private static void Rotate(int[][] matrix, int n)
        {
            for (int layer = 0; layer < n / 2; layer++)
            {
                int first = layer;
                int last = n - 1 - layer;
                for (int i = first; i < last; i++)
                {
                    int offset = i - first;

                    // save top
                    int top = matrix[first][i];

                    // left -> top
                    matrix[first][i] = matrix[last - offset][first];

                    // bottom -> left
                    matrix[last - offset][first] = matrix[last][last - offset];

                    // right -> bottom
                    matrix[last][last - offset] = matrix[i][last];

                    // top -> right
                    matrix[i][last] = top;
                }
            }
        }
    }
}
