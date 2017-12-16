package hr.implementation; // Delete in HR

import java.util.Scanner;

public class OrganizingContainersOfBalls {
    public static void main() {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int[][] M = new int[n][n];
            for(int M_i=0; M_i < n; M_i++){
                for(int M_j=0; M_j < n; M_j++){
                    M[M_i][M_j] = in.nextInt();
                }
            }

            // TODO!
            
            System.out.println();
        }
    }
}