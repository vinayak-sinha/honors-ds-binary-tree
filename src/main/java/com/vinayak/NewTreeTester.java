package com.vinayak;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Tests the TreeUtil class.
 * 
 * @author Nathan Dalal
 * @version 11/13/13
 */
public class NewTreeTester extends BinaryTreeTester 
{
    /**
     * Tests the basic binary tree methods of TreeUtil.
     */
    private void basicTest() {
        System.out.print ("\f");
        
        int randomDepth = (int)(Math.random() * (2 + 2 + 1)) + (2 + 1);
        TreeNode t = TreeUtil.createRandom (randomDepth);
        
        TreeDisplay display = new TreeDisplay();
        
        display.setTester (this);
        display.displayTree (t);
        
        if (TreeUtil.maxDepth (t) == randomDepth) System.out.println ("maxDepth works");
        else System.out.println ("maxDepth no work");
        TreeNode copyTree = t;
        if (TreeUtil.sameShape (copyTree, t)) System.out.println ("SameShape works");
        else System.out.println ("SameShape no work");
        copyTree = TreeUtil.copy(t);
        if (TreeUtil.sameShape (copyTree, t)) System.out.println ("Copy works");
        else System.out.println ("Copy no work");
        System.out.println ("Leftmost node from root is " + TreeUtil.leftmost (t));
        System.out.println ("Rightmost node from root is " + TreeUtil.rightmost (t));
        System.out.println ("Total number of nodes is " + TreeUtil.countNodes (t));
        System.out.println ("Total number of leaves is " + TreeUtil.countLeaves (t));
        
        System.out.println ("\n\nDoing Pre Order");
        TreeUtil.preOrder(t, display);
        
        List <String> list = new ArrayList <> ();
        TreeUtil.fillList (t, list);
        System.out.println ("\n\nfillList works if below numbers match Pre Order");
        for (int i = 0; i < list.size(); i++) {
            System.out.print (list.get(i) + " ");
        }
        
        System.out.println ("\n\nDoing In Order");
        TreeUtil.inOrder (t, display);
        
        System.out.println ("\n\nDoing Post Order");
        TreeUtil.postOrder (t, display);
        
        System.out.println ("\n\nCheck with the tree to see that all of your methods work.");
    }
    
    /**
     * Tests the morse code methods of the TreeUtil class.
     */
    private void morseTest() {
        System.out.print ("\f");
        
        TreeDisplay display = new TreeDisplay();
        display.setTester (this);
        
        TreeNode decodingTree = TreeUtil.createDecodingTree (display);
        
        System.out.println ("\nLooks like we know our ABC's!\n");
        
        System.out.println ("Let's decode ... --- ...");
        String decoded1 = TreeUtil.decodeMorse(decodingTree, "... --- ...", display);
        System.out.println ("\nIt should have printed: " + decoded1 + "\n");
        
        System.out.println ("Let's decode .- -- . .-. .. -.- ..- ....");
        String decoded2 = TreeUtil.decodeMorse(decodingTree, ".- -- . .-. .. -.- ..- ....",
                                                display);
        System.out.println ("\nIt should have printed: " + decoded2 + "\n");

        System.out.println ("Let's decode -.-. .... .-. .. ... - -- .- ...");
        String decoded3 = TreeUtil.decodeMorse(decodingTree, "-.-. .... .-. .. ... - -- .- ...",
                                                display);
        System.out.println ("\nIt should have printed: " + decoded3 + "\n");

        System.out.println ("\nCheck with the tree to see that all of your methods work.\n");
        
        userMorse(decodingTree, display);
    }
    
    /**
     * Allows the user to test their own code with user-inputted morse code.
     * 
     * @param   decodingTree    the decoding tree in the display window
     * @param   display         the TreeDisplay object that needs to be passed
     */
    private void userMorse(TreeNode decodingTree, TreeDisplay display) {
        try(Scanner in = new Scanner(System.in)) {
            System.out.println("""
                Enter "y" to decode your own morse!
                Enter "n" to end the morse code test.
                """);
            String response = in.nextLine();
            
            while (response.equals("y")) {
                System.out.println("""
                    \fType valid morse code. The tester will break if code is not valid.
                    Also do not add spaces after the final morse code segment.

                    Let's try your own Morse Code!
                    Place your code below:
                    """);
                String code = in.nextLine();
                System.out.println ("Let's decode " + code);
                String userDecoded = TreeUtil.decodeMorse (decodingTree, code, display);
                System.out.println ("\nIt should have printed: " + userDecoded + "\n");
                
                System.out.println ("""
                    Enter "y" to enter a new morse code.
                    "Enter "n" to end the user-inputted morse code sequence.
                    """);
                response = in.nextLine();
            }
            
            System.out.println ("\n\nHope you had fun!\n");
        }
    }
    
    /**
     * Compiles all aspects of the tester in a menu-based system.
     */
    @Override
    public void test() {
        String initial;
        int response = 0;
        Scanner in = new Scanner(System.in);
        boolean notValidInput = true;
        boolean alreadyHappened = false;
        
        while (notValidInput) {
            try {
                if (!alreadyHappened) {
                    System.out.println ("""
                        \fWelcome to the Binary Tree Tester.
                        This tests the implementation of the TreeUtil class.


                        Enter 1 to test basic tree methods, 2 for morse code methods, 3 to quit.
                        """);
                }
                else {
                    System.out.println ("""
                        \fInvalid input, please try again.
                        
                        "Enter 1 to test basic tree methods, 2 for morse code methods, 3 to quit.
                        """);
                }
                
                initial = in.nextLine();
                response = Integer.parseInt (initial);
                notValidInput = false;
            }
            catch (IllegalArgumentException i) {
                notValidInput = true;
                alreadyHappened = true;
            }
        }
        
        while (true) {
            if (response == 1) {
                basicTest();
            }
            if (response == 2) {
                morseTest();
            }
            if (response == (2 + 1)) {
                System.out.print("\fYou win!");
                System.exit(1);
            }
            if (response != 1 && response != 2 && response != (2 + 1))
                System.out.print ("\fInvalid input, please try again.");
            //System.out.print("\n\nEnter 1 to test basic tree methods, " +
            //                     "2 for morse code methods, 3 to quit.\n");
            //response = Integer.parseInt (in.nextLine());
            notValidInput = true;
            alreadyHappened = false;
            while (notValidInput) {
                try {
                    if (!alreadyHappened)
                        System.out.println ("""
                            
                            Enter 1 to test basic tree methods, 2 for morse code methods, 3 to quit.
                            """);
                    else
                        System.out.println ("""
                            \fInvalid input, please try again.
                            
                            
                            Enter 1 to test basic tree methods, 2 for morse code methods, 3 to quit.
                            """);
                    initial = in.nextLine();
                    response = Integer.parseInt (initial);
                    in.close();
                    notValidInput = false;
                }
                catch (IllegalArgumentException i) {
                    notValidInput = true;
                    alreadyHappened = true;
                }
            }
        }
    }
    
    /**
    * Sends back the node value when a node is visited.
    * 
    * @param    value   the value passed that is printed out
    */
    @Override
    public void sendValue(Object value)
    {
        System.out.print(value + " ");
    }
    
    /**
     * Tests the logic behind the BinaryTree class.
     * 
     * @param   args    command line arguments
     */
    public static void main (String [] args)
    {
        NewTreeTester richard = new NewTreeTester();
        richard.test();
    }
}
