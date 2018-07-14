import java.io.*;
import java.util.*;

// https://leetcode.com/problems/number-complement

public class _476_Number_Complement {
    public int findComplement(int num) {
        int n = 0;
        while (n < num) {
            n = (n << 1) | 1;
        }

        return n - num;
    }
}