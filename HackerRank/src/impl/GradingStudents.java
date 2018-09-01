package impl;

import java.util.Scanner;

public class GradingStudents {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for(int a = 0; a < n; a++){
            int grade = in.nextInt();
            if (grade >= 38) {
                if (grade % 5 >= 3) {
                    grade += 5 - (grade % 5);
                }
            }

            System.out.println(grade);
        }
    }
}
