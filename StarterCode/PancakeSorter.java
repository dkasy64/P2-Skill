/**********
 * Christian Duncan
 * Pancake Sorter
 * Fall 2024 (CSC215) for P2 skill makeup
 * 
 * This class tests the Pancake Sorter to see if it works (and works efficiently enough) - 
 * in terms of the number of flips. It should be able to sort the stack in less than 2n flips.
 * 
 * Jermey Wiening, Dawit Kasy, Jason Handrahan, Paul Zegarek, Elle Berry
 **********/
public class PancakeSorter {
    // Tracking the effectiveness of the sorter
    static int incorrect = 0;
    static int inefficient = 0;
    static int correct = 0;

    public static void main(String[] args) {
        for (int size = 10; size <= 10; size += 10) {
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
           
        int counter = 0;
        
        for(int size = m; size > 1; size--){ // go through the unsorted portion of the stack
            int max = 0;
            for (int i = 1; i < size; i++) {
                 if (stack.getPancake(i) > stack.getPancake(max)) {
                     max = i;
                 }
        }
    }
       
}  
        //  stack.printStack();  // If you wish to see the stack at the end (is it sorted?) 




    
    
}