/*
#H-Tree Construction

Construct an H-tree, given its center (x and y coordinates), starting_length and depth.
You can assume that you have a drawLine method.

Example of H-tree:
https://en.wikipedia.org/wiki/H_tree#/media/File:H_tree.svg

 |----|     |-----|
   |           |
   |-----------|
   |           |
 |----|     |-----|

How to construct an H-tree?

An H-tree can be constructed by starting with a line segment of arbitrary length,
drawing two segments of the same length at right angles to the first through its endpoints,
and continuing in the same vein, reducing (dividing) the length of the line segments drawn
at each stage by √2.
*/

public class H_Tree {
    private void drawLine(int x1, int x2, int y1, int y2) {
        // ...
    }

    private void hTreeVertical(int x, int y, int length, int depth) {
        int topY = y - (length / 2);
        int bottomY = y + (length / 2);
        drawLine(x, x, topY, bottomY);

        length = (int)Math.sqrt(length);
        hTreeHorizontal(x, topY, length, depth - 1);
        hTreeHorizontal(x, bottomY, length, depth - 1);
    }

    private void hTreeHorizontal(int x, int y, int length, int depth) {
        if (depth == 0)
            return;

        int leftX = x - (length / 2);
        int rightX = x + (length / 2);
        drawLine(leftX, rightX, y, y);

        hTreeVertical(leftX, y, length, depth);
        hTreeVertical(rightX, y, length, depth);
    }

    public void hTree(int x, int y, int length, int depth) {
        hTreeHorizontal(x, y, length, depth);
    }
}