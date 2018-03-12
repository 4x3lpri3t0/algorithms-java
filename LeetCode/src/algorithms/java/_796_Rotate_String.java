import java.io.*;
import java.util.*;

public class _796_Rotate_String {
    public static boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }
}