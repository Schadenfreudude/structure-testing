/**Class to provide a Linked List which accepts a user's input of single
 * integers, then adds the integer to the Linked List before sorting.
 * @author Christian Boor
 * @version 1.0.0
 * @since Week 4 of CSC6301
 */
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/** Main driver class.
 * @since Week 4 of CSC6301
 */
public class LinkedList_Tester {
    /** Accepts user input for a series of integers, forming a Linked List.
     * Then, continues to ask for new inputs until user exits or terminates program.
     * @since Week 4 of CSC6301
     */
    public static void main(String[] args) {
        LinkedList<Integer> LL = new LinkedList<>();
            // Built-in Linked List class from Collections enables
            // very, very easy pre-made linked list instead of reinventing
            // the wheel!
        Boolean flag = true;

        System.out.println("\nThis module will accept input for a Linked List.");
        System.out.println("Please enter integers to add them to the list.");
        System.out.println("Or, enter '-9999' to finalize the list.");

        System.out.println("\nStarting Linked List: ");
        System.out.println(LL);

        Scanner reader = new Scanner(System.in);
        // Scanner class used to accept input from user

        while (flag == true) {
            try {
                System.out.println("\nEnter an integer: ");
                int next = reader.nextInt();
                // Built-in method .nextInt() reused from Scanner class
                if (next == -9999) {
                    System.out.println("\nFinal Linked List:");
                    System.out.println(LL);
                    break;
                } else {
                    LL.add(next);
                    // Built-in method .add() reused from Linked List class
                    Collections.sort(LL);
                    // Built-in method .sort() reused from Collections class
                    // enables easy sorting of Linked List in ascending order
                    System.out.println("\nCurrent Linked List:");
                    System.out.println(LL);
                }
            } catch (RuntimeException rip) {
                    // Researching java.util.InputMismatchException
                    // helped identify RuntimeException as necessary superclass
                    System.out.println("\nError: " + rip);
                    System.out.println("Input must be an integer.\n");
                    reader.next();
                    // Meta AI used for debugging loop - reader.next() adoped
                    // instead of break or continue.
                }
            }
        reader.close();
        // .close() reused from Scanner class.
    }
}


/* RESOURCES and NOTES

Appears to work fine on Windows 11 with:
    Run: java main.java
    Doc: javadoc main.java

Several items were reused from previously released pre-made Java classes.
Collections and Linked Lists packages were used to implement a Linked List
and sort it. Scanner was used to implement user input.

https://www.w3schools.com/java/ref_scanner_next.asp

https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html

https://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html

https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html
    Specfically found the section in the Methods Summary where it clearly
    laid out that it sorts a given list in ascending order most helpful.

-Christian
*/