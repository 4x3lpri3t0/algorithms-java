import java.io.*;
import java.util.*;

// https://leetcode.com/problems/rotate-string

public class _796_Rotate_String {
    public static boolean rotateString(String A, String B) {
        boolean sameLength = A.length() == B.length();
        boolean containedInA = (A + A).contains(B);
        return sameLength && containedInA;
    }
}