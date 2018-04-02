import java.util.Arrays;

public class Main {
    private static void print(Object obj) {
        if (obj instanceof int[]) {
            print(Arrays.toString((int[]) obj));
            return;
        }
        if (obj instanceof String[]) {
            print(Arrays.toString((String[]) obj));
            return;
        }

        System.out.println(obj.toString());
    }

    public static void main(String[] args) {
        // 1 - Stock Price
        // Greedy
//        int[] stockPrices = new int[]{10, 7, 5, 8, 11, 9};
//        print(_01_stock_price.getMaxProfit(stockPrices));

        // 2 - Product of Other Numbers
        // Greedy
//        int[] integers = new int[]{1, 7, 3, 4};
//        print(_02_product_of_other_numbers.getProductsOfAllIntsExceptAtIndex(integers));

        // 3 - Highest Product of 3
        // Greedy
//        integers = new int[]{-10, -10, 1, 3, 2};
//        print(_03_highest_product_of_3.highestProductOf3(integers));

        // 4 - Merging Ranges
        // Sort + Greedy

        // 5 - Making Change // TODO: Review!!
        // Greedy
//        int[] coins = new int[]{1, 2, 3};
//        print(_05_Making_Change.changePossibilitiesBottomUp(4, coins));

        // 6 - Rectangular Love
        // Decompose problem

        // 7 - Temperature Tracker
        // Ahead-of-time approach

        // 8 - Balanced Binary Tree // TODO: Review!!
        // DFS (depth-first)

        // 9 - BST Checker
        // BST / DFS

        // 10 - Second Largest Item in BST // TODO: Review!!
        // BST

        // 11 - Compress URL List // TODO: Review!!
        // Trie

        // 12 - Find in Ordered Set
        // Binary Search

        // 13 - Find Rotation Point // TODO: Review!!
        // Binary Search

        // 14 - Inflight Entertainment // TODO: Review!!
        // HashSet

        // 15 - Nth Fibonacci
        // Recursive + memo / Iterative (Bottom-up)

        // 16 - Cake Thief // TODO: Review!!
        // TODO

        // 19 - Queue Two Stacks

        // 20 - Largest Stack
        // Stacks

        // 21 - Find Unique int Among Duplicates
        // XOR

        // 22 - Delete Node
        // Linked List

        // 23 - Linked List Cycles
        // Linked List - Tortoise and hare (Cycle Detection)

        // 24 - Reverse Linked List
        // Linked List

        // 25 - Kth to Last Node // TODO: Review!!
        // Linked List

        // 26 - Reverse String in Place
        // Strings

        // 27 - Reverse Words // TODO: Review
        // Strings + Divide & Conquer

        // 28 - Parenthesis Matching
        // Stacks

        // 29 - Bracket Validator
        // HashMap, HashSet, Stack

        // 30 - Permutation Palindrome
        // HashMap

        // 31 - Recursive String Permutations // TODO: Review!!
        // Recursion, HashSet, substring

        // 32 - Top Scores // TODO: Review!!
        // Counting Sort

        // 33 - Which appears twice
        // Sum // TODO

        // 34 - Word Cloud
        // Character.isLetter, substring

        // 35 - Shuffle // TODO
        // Fisher-Yates shuffle / Knuth shuffle // TODO

        // 36 - Single Riffle Check
        // TODO

        // 38 - Simulate 7 Sided Die
        // Math
//        int[] freq = new int[8];
//        for (int i = 0; i < 10000000; i++) {
//            int rand = _38_Simulate_Seven_Sided_Die.rand7();
//            freq[rand]++;
//        }
//        for (int i = 1; i < freq.length; i++) {
//            print(i + " called " + freq[i] + " times");
//        }

        // 40 - Find Repeat Space Edition
        // Modified Binary Search - TODO: 1..n

        // 41 - Find Repeat Space Edition BEAST MODE
        // TODO: NUTS!! (Not in scope of interviews)

        // 45 - Graph Coloring
        // Greedy

        // 46 - Mesh Message // TODO: Review!! Transcribe
        // BFS
    }
}