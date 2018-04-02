import java.util.Random;

public class _38_Simulate_Seven_Sided_Die {

    private static int rand5() {
        int min = 1;
        int max = 5;
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    public static int rand7() {
        while (true) {
            // Do our die rolls
            int roll1 = rand5();
            int roll2 = rand5();

            int outcomeNumber = (roll1 - 1) * 5 + (roll2 - 1) + 1;

            // If we hit an extraneous outcome we just re-roll
            if (outcomeNumber > 21)
                continue;

            // Our outcome was fine. Return it!
            return outcomeNumber % 7 + 1;
        }
    }
}
