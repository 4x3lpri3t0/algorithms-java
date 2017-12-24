import java.io.*;
import java.util.*;

// If during last move the opposite player put his chip to cell
// with coordinates (xl, yl) in some small field, the next move should
// be done in one of the cells of the small field with coordinates (xl, yl).
//
// For example, if in the first move a player puts his chip to lower left cell
// of CENTRAL field, then the second player on his next move should put his
// chip into some cell of LOWER LEFT field
// (pay attention to the first test case).
//
// If there are no free cells in the required field,
// the player can put his chip to any empty cell on any field.
//
// You are given current state of the game and coordinates of cell
// in which the last move was done.
// You should find all cells in which the current player can put his chip.
//
// A hare works as a postman in the forest, he likes to foul bears.
// Sometimes he changes the game field a bit, so the current state
// of the game could be unreachable.
// However, after his changes,
// the cell where the last move was done is not empty.
// You don't need to find if the state is unreachable or not,
// just output possible next moves according to the rules.

// Input
//
// First 11 lines contains descriptions of table with 9 rows and
// 9 columns which are divided into 9 small fields by spaces and empty lines.
//
// Each small field is described by 9 characters without spaces and empty lines. character "x" (ASCII-code 120) means that the cell is occupied with chip of the first player, character "o" (ASCII-code 111) denotes a field occupied with chip of the second player, character "." (ASCII-code 46) describes empty cell.
//
// The line after the table contains two integers x and y (1 ≤ x, y ≤ 9).
// They describe coordinates of the cell in table where the last move was done.
// Rows in the table are numbered from up to down and columns
// are numbered from left to right.
//
// It's guaranteed that cell where the last move was done is filled
// with "x" or "o".
// Also, it's guaranteed that there is at least one empty cell.
// It's not guaranteed that current state of game is reachable.
//
// Output
//
// Output the field in same format with characters "!"
// on positions where the current player can put his chip.
// All other cells should not be modified.

public class CF907B_TicTacToe {
    private void solve() {
        int n = readInt();

        // TODO

        out.println();
    }

    public static void main(String[] args) {
        new CF907B_TicTacToe().run();
    }

    private void run() {
        try {
            init();
            solve();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");

    private void init() throws IOException {
        String filename = "";
        if (filename.isEmpty()) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        } else {
            in = new BufferedReader(new FileReader(filename + ".in"));
            out = new PrintWriter(new FileWriter(filename + ".out"));
        }
    }

    private String readString() {
        while (!tok.hasMoreTokens()) {
            try {
                tok = new StringTokenizer(in.readLine());
            } catch (Exception e) {
                return null;
            }
        }

        return tok.nextToken();
    }

    private int readInt() {
        return Integer.parseInt(readString());
    }

    private long readLong() {
        return Long.parseLong(readString());
    }

    private double readDouble() {
        return Double.parseDouble(readString());
    }
}