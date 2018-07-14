
import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        // TODO's -> Needs review

        // numJewelsInStones
        // rotateString
        // judgeCircle
        // findComplement // TODO: BM
        // partitionLabels // TODO: Greedy

        // --- 2018-03-17 ---

        // reverseWords // TODO: StringBuilder.append, StringBuffer(word).reverse()
        // twoSum // TODO: Hash Table (HashMap in Java)
        // addTwoNumbers // TODO: LinkedList
        // romanToInt // TODO: Roman

        // canWinNim // TODO: Game Theory
        // singleNumber // TODO: BM
        // findMedianSortedArrays // TODO: BS-ish [HARD]
        // longestCommonPrefix // TODO: String [HARD] -> Transcribe multiple solutions
        // convert // [ZigZag] // TODO: String [HARD] -> Transcribe and DEBUG!
        // isPalindrome // TODO: Math
        // maxArea // TODO: 2 Pointers -> Read explanation, transcribe, debug
        // lengthOfLongestSubstring // TODO: Set, 2 Pointers (Sliding Window), String
        // intToRoman // TODO: Enum -> Transcribe!
        // isValid // (Parentheses) // TODO: Map + Stack
        // getSum // (Sum of 2 Integers) // TODO: BM (Read "BM Tips" before!)
        // https://leetcode.com/problems/sum-of-two-integers/discuss/84278/A-summary:-how-to-use-bit-manipulation-to-solve-problems-easily-and-efficiently
        // Also: https://leetcode.com/problems/sum-of-two-integers/discuss/84290/Java-simple-easy-understand-solution-with-explanation
        // reverse // TODO: Integer overlflow

        // --- 2018-03-18 ---

        // deleteNode // TODO: Delete node from singly-LL
        // mergeTwoLists // TODO: Merge LLs -> Transcribe + DEBUG!!!
        // maxDepth // TODO: Recursive / Iterative + Q
        // plusOne // TODO: Array, Math
        // preProcess // TODO: String, DP [HARD] -> [See "Solution" explanations]
        // LRUCache // TODO: Doubly LL + HashMap [HARD]
        // reverseList // TODO: Singly LL
        // _122_Best_Time_to_Buy_and_Sell_Stock_II.maxProfit // TODO: Simple One Pass
        // maxSubArray // TODO: DP!! -> DEBUG!!

        // --- 2018-03-19 ---

        // majorityElement // TODO: HashMap, Sorting, Boyer-Moore Voting Algorithm!!
        // _155_Min_Stack // TODO: MinStack implemented with LL
        // hammingWeight // TODO: BM
        // moveZeroes // TODO: Array, 2 Pointers
        // hasCycle // TODO: LL, HashSet, 2 Pointers

        // --- 2018-03-20 ---

        // mergeKLists // TODO: PriorityQueue / Recursion

        // --- 2018-03-22 ---

        // quickSort // TODO: Debug

        // --- 2018-03-23 ---

        // _121_Best_Time_to_Buy_and_Sell_Stock.maxProfit // TODO: Min, Max
        // climbStairs // TODO: DP

        // --- 2018-03-27 ---

        // matrixReshape // TODO

        // --- 2018-04-02 ---
        // --- Arrays ---

        // wiggleSort
        // isToeplitzMatrix
        // getModifiedArray // TODO, cool solution!

        // ---------------------------------------------------------------------
        // --- 2018-07-05 --- A new beginning...

        // --- Arrays ---
        // arrayPairSum
        // flipAndInvertImage
        // transpose
        // arrayPairSum
        // isToeplitzMatrix // TODO: Redo
        // matrixReshape
        // findLadders(); // TODO: Hardest. Good exercise for debugging and understanding.
        // findDuplicates // TODO: Review
        // findMaxConsecutiveOnes

        // --- String ---
        // isNumber // TODO: Hardest (Review)
        // longestValidParentheses

        // TODO: https://leetcode.com/tag/string/
    }

    private static void findLadders() {
        String start = "hit";
        String end = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        _126_Word_Ladder_II solver = new _126_Word_Ladder_II();
        List<List<String>> result = solver.findLadders(start, end, wordList);

        for (List<String> words : result) {
            for (String word : words) {
                out.print(word + " ");
            }

            out.println();
        }
    }
}