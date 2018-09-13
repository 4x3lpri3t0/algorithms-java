/*
The deletion distance of two strings is the minimum number of characters you need to
delete in the two strings in order to get the same string.

For instance, the deletion distance between "heat" and "hit" is 3:
By deleting 'e' and 'a' in "heat", and 'i' in "hit", we get the string "ht" in both cases.
We cannot get the same string from both strings by deleting 2 letters or fewer.

Given the strings str1 and str2, write an efficient function deletionDistance
that returns the deletion distance between them.

Examples:

input:  str1 = "dog", str2 = "frog"
output: 3

input:  str1 = "some", str2 = "some"
output: 0

input:  str1 = "some", str2 = "thing"
output: 9

input:  str1 = "", str2 = ""
output: 0
 */

public class Deletion_Distance {
    public static int deletionDistance(String one, String two) {
        if (one.isEmpty() || two.isEmpty()) {
            return Math.max(one.length(), two.length());
        }

        String oneSub = one.substring(1);
        String twoSub = two.substring(1);
        if (one.charAt(0) == two.charAt(0)) {
            return deletionDistance(oneSub, twoSub);
        } else {
            return 1 + Math.min(
                    deletionDistance(oneSub, two),
                    deletionDistance(one, twoSub));
        }
    }

    public static int deletionDistanceOptimized(String one, String two) {
        int[][] matrix = new int[one.length() + 1][two.length() + 1];
        for (int i = 0; i < one.length() + 1; i++) {
            for (int j = 0; j < two.length() + 1; j++) {
                if (j == 0) {
                    matrix[i][j] = i;
                } else if (i == 0) {
                    matrix[i][j] = j;
                } else if (one.charAt(i - 1) == two.charAt(j - 1)) {
                    matrix[i][j] = matrix[i - 1][j - 1];
                } else {
                    matrix[i][j] = 1 + Math.min(matrix[i - 1][j], matrix[i][j - 1]);
                }
            }
        }

        return matrix[one.length()][two.length()];
    }

    public static void main() {
        System.out.println(deletionDistance("dog", "")); // 3
        System.out.println(deletionDistance("", "frog")); // 4
        System.out.println(deletionDistance("dog", "frog")); // 3
        System.out.println(deletionDistance("some", "some")); // 0
        System.out.println(deletionDistance("some", "ome")); // 1
        System.out.println(deletionDistance("some", "thing")); // 9
        System.out.println(deletionDistance("soie", "thing")); // 7
        System.out.println(deletionDistance("car", "racer")); // 4

        System.out.println(deletionDistanceOptimized("dog", ""));
        System.out.println(deletionDistanceOptimized("", "frog"));
        System.out.println(deletionDistanceOptimized("dog", "frog"));
        System.out.println(deletionDistanceOptimized("some", "some"));
        System.out.println(deletionDistanceOptimized("some", "ome"));
        System.out.println(deletionDistanceOptimized("some", "thing"));
        System.out.println(deletionDistanceOptimized("soie", "thing"));
        System.out.println(deletionDistanceOptimized("car", "racer"));
    }
}