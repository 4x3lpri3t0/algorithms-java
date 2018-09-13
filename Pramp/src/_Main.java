import java.util.Arrays;

public class _Main {

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
        // Already asked:

        // Arr_IndexAndElement_Equal
        // Array_of_Array_Products
        // Quad_Combination
        // Matrix_Spiral
        // Flatten_Dictionary
        // Getting_Diff_Number
        // Merge_Packages
        // K_Messed_Array_Sort
        // Largest_Smaller_BST_Key
        // Sudoku_Solver
        // BST_Successor
        // Word_Count_Engine
        // BasicRegexParser // TODO: Review (when finished all others)
        // Number_Of_Paths

        // Not asked:

        // Budget_Cuts
        // Busiest_Time
        // Deletion_Distance // TODO: Review! Cool solution / Review Optimized
        // Drone_Flight_Planner
        // H_Tree
        // Island_Count
        // Isomorphic_Evaluator
        // Meeting_Planner // TODO: Review again
        // Pairs_With_Difference
        // Sentence_Reverse
        // Shift
        // ed_Array_Search
        // Min_Sub_String // Smallest_Substring
    }
}
