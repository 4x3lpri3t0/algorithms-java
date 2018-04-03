/*
# Award Budget Cuts

The awards committee had planned to give n research grants this year,
out of a its total yearly budget.
However, the budget was reduced to b dollars.

The committee members has decided to affect the minimal number of highest grants,
by applying a maximum cap c on all grants: every grant that was planned to be higher than c
will now be c dollars.

Help the committee to choose the right value of c that would make the total sum of grants
equal to the new budget.

Given an array of grants g and a new budget b, explain and code an efficient method to find the cap c.
Assume that each grant is unique.
*/

import java.util.Arrays;

public class Budget_Cuts {
    private static int getOptimalCap(int[] grants, int b) {
        // Sort ascending
        Arrays.sort(grants);

        int curB = 0;
        int prevCap = b < grants[0] ? b : grants[0];
        int accum = 0;

        // Start from smallest
        for (int i = 0; i < grants.length; i++) {
            int curG = grants[i];

            // Apply current grant amount to the biggest ones
            int biggerGrants = grants.length - i;
            curB = accum + curG * biggerGrants;

            if (curB > b)
                return prevCap;

            // Distribute leftover among bigger grants
            int leftover = b - curB;
            // Substract 1 to not include current one
            prevCap = curG + (leftover / (biggerGrants - 1));
            accum += curG;
        }

        return prevCap;
    }

    public static void main() {
        int[] grants = {1, 2, 3};
        int b = 5; // 2?
        System.out.println(getOptimalCap(grants, b));

        grants = new int[]{1, 10};
        b = 4; // 3?
        System.out.println(getOptimalCap(grants, b));

        grants = new int[]{10};
        b = 9; // 9?
        System.out.println(getOptimalCap(grants, b));

        grants = new int[]{10, 11, 12};
        b = 32; // 11?
        System.out.println(getOptimalCap(grants, b));
    }
}