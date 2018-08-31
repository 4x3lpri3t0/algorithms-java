package Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static java.lang.System.*;

class Boggle {
    // Assumption: Both dimensions of grid are equal
    char[][] grid;
    Set<String> dict;
    boolean[][] state;

    Boggle(char[][] g, HashSet<String> d) {
        grid = g;
        dict = d;
        state = new boolean[g.length][g.length];
        for (int i = 0; i < g.length; ++i) {
            for (int j = 0; j < g.length; ++j) {
                state[i][j] = false;
            }
        }
    }

    ArrayList<IntPair> findAllNumbers(int x, int y) {
        ArrayList<IntPair> numbers = new ArrayList<>();

        int startX = Math.max(0, x - 1);
        int startY = Math.max(0, y - 1);
        int endX = Math.min(grid.length - 1, x + 1);
        int endY = Math.min(grid.length - 1, y + 1);

        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                if (state[i][j]) {
                    continue;
                }
                numbers.add(new IntPair(i, j));
            }
        }

        return numbers;
    }

    void findWordsRec(int i, int j,
                      StringBuilder current,
                      HashSet<String> words) {

        if (current.length() > 0 &&
                dict.contains(current.toString())) {
            words.add(current.toString());
        }

        // we can speed up our algorithm if we have prefix method
        // available for our dict by using code like below
        /*
        if (!dict.is_prefix(current)) {
          // if current word is not prefix of any word in dict
          // we don't need to continue with search
          return;
        }
        */

        ArrayList<IntPair> nbrs = findAllNumbers(i, j);
        for (IntPair pair : nbrs) {
            current.append(grid[pair.first][pair.second]);
            state[pair.first][pair.second] = true;
            findWordsRec(pair.first, pair.second, current, words);
            current.setLength(current.length() - 1);
            state[pair.first][pair.second] = false;
        }
    }

    public HashSet<String> findAllWords() {
        HashSet<String> words = new HashSet<>();
        StringBuilder currentWord = new StringBuilder();
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid.length; ++j) {
                findWordsRec(i, j, currentWord, words);
            }
        }

        return words;
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'c', 'a', 't'},
                {'r', 'r', 'e'},
                {'t', 'o', 'n'}
        };

        HashSet<String> dictionary = new HashSet<>();
        dictionary.add("art");
        dictionary.add("cat");
        dictionary.add("cater");
        dictionary.add("cartoon");
        dictionary.add("toon");
        dictionary.add("moon");
        dictionary.add("not");
        dictionary.add("apple");
        dictionary.add("ton");

        Boggle b = new Boggle(grid, dictionary);
        HashSet<String> words = b.findAllWords();
        for (String s : words) {
            out.println(s);
        }
    }
};