/**********
 * Christian Duncan
 * Pancake Stack
 * Fall 2024 (CSC215) for P2 skill makeup
 * 
 * This class represents a stack of pancakes. Can you sort them using only the flip operation
 * in 2n flips?
 **********/
import java.util.ArrayList;
import java.util.Collections;

public class PancakeStack {
    private ArrayList<Integer> pancakes;
    private int numFlips = 0;

    // Create a stack of n pancakes in a random order
    public PancakeStack(int n) {
        pancakes = new ArrayList<>(n);
        for (int i = 0; i < n; i++) pancakes.add(i+1);
        Collections.shuffle(pancakes);
    }

    // Flip the first f pancakes
    // E.g. Pancakes = 1, 3, 2, 4, 6, 5, 9, 10 and we flip at 5, then the result is now:
    // Pancakes = 6, 4, 2, 3, 1, 5, 9, 10
    public void flip(int f) {
        numFlips++;  // One more flip was initiated
        int i = 0, j = f-1;
        while (i < j) {
            // Swap i and j
            Integer a = pancakes.get(i);
            Integer b = pancakes.get(j);
            pancakes.set(i, b);
            pancakes.set(j, a);
            i++; j--;  // Next two pancakes
        }
    }

    // Returns if the pancakes are sorted from smallest up to largest
    // E.g. 1, 2, 3, 4, ..., n
    public boolean isSorted() {
        Integer previous = 0;
        for (Integer curr: pancakes) {
            if (previous > curr) return false;
            previous = curr;
        }
        return true;
    }

    // Get pancake i
    public Integer getPancake(int i) {
        return pancakes.get(i);
    }

    // Get number of flips
    public int getNumberOfFlips() {
        return numFlips;
    }

    // Get how many pancakes are in the stack
    public int getSize() { return pancakes.size(); }

    // Print the stack - for debugging purposes really
    public void printStack() {
        System.out.print("Stack:");
        for (Integer p: pancakes) System.out.print(" " + p);
        System.out.println();
    }
}
