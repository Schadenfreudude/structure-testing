/**Class to provide a Stack which accepts a user's input of single
 * integers, then adds the integer to the Stack before sorting.
 * @author Christian Boor
 * @version 2.0.0
 * @since Week 5 of CSC6301
 */
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

/** Main driver class.
 * @since Week 5 of CSC6301
 */
public class Stack_Tester {
    /** Accepts user input for a series of integers, forming a Stack.
     * Then, continues to ask for new inputs until user exits or terminates program.
     * After each input value, stack resorts elements in ascending order by value.
     * @since Week 5 of CSC6301
     */
    public static void main(String[] args) {
        Stack<Integer> burger = new Stack<>();
        Boolean flag = true;

        System.out.println("\nThis module will accept input for a Stack.");
        System.out.println("Please enter integers to add them to the stack.");
        System.out.println("Or, enter '-9999' to finalize the elements.");

        System.out.println("\nStarting Stack: ");
        System.out.println(burger);

        Scanner reader = new Scanner(System.in);

        while (flag == true) {
            try {
                System.out.println("\nEnter an integer: ");
                int next = reader.nextInt();
                if (next == -9999) {
                    System.out.println("\nFinal Stack order:");
                    System.out.println(burger);
                    break;
                } else {
                    burger.add(next);
                    Collections.sort(burger);
                    System.out.println("\nCurrent Stack:");
                    System.out.println(burger);
                }
            } catch (RuntimeException rip) {
                    System.out.println("\nError: " + rip);
                    System.out.println("Input must be an integer.\n");
                    reader.next();
                }
            }
        reader.close();
    }
}

/* RESOURCES and NOTES

Appears to work fine on Windows 11 with:
    Run: java main.java
    Doc: javadoc main.java

In addition to last week's notes, used oracle docs on Stack and Vector.

https://docs.oracle.com/javase/8/docs/api/java/util/Stack.html

https://docs.oracle.com/javase/8/docs/api/java/util/Vector.html#sort-java.util.Comparator-

-Christian
*/

/* CHANGES notes
 * Line 5, 12, 17 : Week 4 > Week 5
 * Line 9: "import java.util.LinkedList;" replaced by "import java.util.Stack;"
 * Line 21: "LinkedList<Integer> LL = new LinkedList<Integer>();"
 *      replaced by "Stack<Integer> burger = new Stack<>();"
 * Each use of "Linked List" replaced replaced with "Stack".
 * Each use of LL replaced with "burger" - cause it's like a stack.
 *      Could have used "pancakes."
 * Extraneous comments from Week 4 removed for readability.
 */

// Considerations:
    // REMAKE OPTION 1:
        // take input
        // add to stack
        // dump array
        // convert stack to array using .toarray() from Vector
        // sort array into ascending order
        // dump stack
        // add each item of array to stack

    // REMAKE OPTION 2: Better
        // take input
        // add to stack
            // Stack inherits .sort() from Vector!
        // sort stack