// You can always win a Nim game if the number of stones n
// in the pile is not divisible by 4.

public class _292_Nim_Game {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}

// Time complexity: O(1) since only one check is performed.
// Space complexity: also O(1) since no additional space is used.