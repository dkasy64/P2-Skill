/**********
 * Christian Duncan
 * Pancake Sorter
 * Fall 2024 (CSC215) for P2 skill makeup
 * 
 * This class tests the Pancake Sorter to see if it works (and works efficiently enough) - 
 * in terms of the number of flips. It should be able to sort the stack in less than 2n flips.
 * 
 * Jermey Wiening, Dawit Kasy, Jason Handrahan, Paul Zegarek, Ella Berry
 **********/
public class PancakeSorter {
    // Tracking the effectiveness of the sorter
    static int incorrect = 0;
    static int inefficient = 0;
    static int correct = 0;

    public static void main(String[] args) {
        for (int size = 10; size <= 100; size += 10) {
            // Test the sorter on pancake stacks of varying sizes
            runTest(size);
        }
        System.out.println("Correct: " + correct + " Inefficient: " + inefficient + " Incorrect: " + incorrect);
    }

    public static void runTest(int size) {
        PancakeStack stack = new PancakeStack(size);
        sort(stack);
        if (stack.isSorted()) {
            int flips = stack.getNumberOfFlips();
            if (flips <= 3*size) {   // I will let 3n slide as well but 2(n-1) is achievable!
                correct++;
                // Correct - nothing to print out (quiet mode) - uncomment to see the output
                // System.out.println("Size: " + size + " Flips: " + flips + " Correct and efficient.");
            } else {
                inefficient++;
                System.out.println("Size: " + size + " Flips: " + flips + " Correct but too many flips performed!");                
            }
        } else {
            incorrect++;
            System.out.println("Size: " + size + " Incorrectly sorted.");
        }
    }

    // Sort the given stack
    public static void sort(PancakeStack stack) {
        // Methods to help you:
         stack.printStack();  // If you wish to print the original stack
         int m = stack.getSize();  // To get the number of pancakes on the stack
         int p = stack.getPancake(0);  // Get "first" pancake in stack
         stack.flip(5);  // Flip over the first 5 pancakes
        // INSERT YOUR ALGORITHM HERE!  
        
        /*
         1.  keep track of current pancake value and set as max
         2. compare value to the next pancake
         3. if current  is less than next, then flip equal to the positions of that pancake
         4. if current is greater than next, then move on to the next
          */  
           
        int counter = 0;
        
        for(int size = m; size > 1; size--){ // go through the unsorted part of the stack
            int max = 0;
            for (int i = 1; i < size; i++) {         // Find the index of the largest pancake in the unsorted part
                if (stack.getPancake(i) > stack.getPancake(max)) { //if pancake at index 1 is greater than pancake at index 0 set new max to i
                    max = i;
                }
            }
            if (max != size - 1) {      // If the largest pancake is not already at the top
                if (max != 0) {             
                    stack.flip(max + 1);  // Flip up pancake to the position of the largest pancake
                }
                stack.flip(size);    // Flip the entire  stack with the largest pancake on the bottom  
            }
        }  
        stack.printStack();  // If you wish to see the stack at the end (is it sorted?) 

        // RUNNING TIME: Theta(n^2);
    }
}