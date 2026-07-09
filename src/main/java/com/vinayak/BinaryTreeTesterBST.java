package com.vinayak;

import java.util.Scanner;

/**
 * Tests the Binary Tree.
 *
 * @author Sorjo Banerjee
 * @version 1/14/15
 * 
 * @author Marina Peregrino 
 * @version Dec 2022 
 * changed name and made as a subclass of BinaryTreeTester
 * other minor edits, e.g. allow last node to be deleted.  
 */
public class BinaryTreeTesterBST extends BinaryTreeTester {
    /**
     * Creates a new BinaryTreeTesterBST to test MyTreeSet.
     * 
     * @param   args    command line arguments
     */
    public static void main(String [] args) {
        BinaryTreeTesterBST newtester = new BinaryTreeTesterBST();
        System.out.println(newtester);
    }

    /**
     * Constructs a BinaryTreeTesterBST Object that tests the contains, add, and remove
     * methods in MyTreeSet.
     */
    public BinaryTreeTesterBST() {
        System.out.println("In the code");
        TreeDisplay display = new TreeDisplay();
        //display.setTester(this); // to get values back from display.visit

        Comparable x = (2 * 2 * 2);
        TreeNode t = null;
        t = BinaryTreeUtil.insert(t, x, display);
        display.displayTree(t);
        x = 2 * 2 * 2 + 2;
        t = BinaryTreeUtil.insert(t, x, display);
        x = 2;
        t = BinaryTreeUtil.insert(t, x, display);
        x = 2 + 2;
        t = BinaryTreeUtil.insert(t, x, display);
        x = 2 * 2 * 2 * 2 - 2;
        t = BinaryTreeUtil.insert(t, x, display);
        x = 2 * 2 * 2 - 1;
        t = BinaryTreeUtil.insert(t, x, display);
        
        //display.displayTree(t);
        
        //System.out.println("The tree is a BST ? " + BinaryTreeUtil.checkBST(t, display));
        try (Scanner sc = new Scanner(System.in);) {
            System.out.println("Continue?[Y/N]");
            while (sc.hasNext() && (sc.nextLine().equalsIgnoreCase("y"))) {
                System.out.println("Enter Number to add - ");
                if (sc.hasNext()) {
                    int newNum = Integer.parseInt(sc.nextLine());
                    System.out.println("Input was " + newNum);
                    x = newNum;
                    BinaryTreeUtil.insert(t, x, display);
                    display.displayTree(t);
                }   
                
                System.out.println("Continue?[Y/N]");            
            }
    
            System.out.println("Now commencing delete nodes ");
            System.out.println("Continue?[Y/N]");
            while (sc.hasNext() && (sc.nextLine().equalsIgnoreCase("y"))) {
                System.out.println("Enter Number to delete - ");
                if (sc.hasNext()) {
                    int newNum = Integer.parseInt(sc.nextLine());
                    System.out.println("Input was " + newNum);
                    x = newNum;
                    t = BinaryTreeUtil.delete(t, x, display);
                    display.displayTree(t);
                }   
                
                System.out.println("Continue?[Y/N]");            
            }
    
            System.out.println("Done");
        }
    }

    /**
    * Sends back the node value when a node is visited.
    * 
    * @param    value   the value to be sent back
    */
    @Override
    public void sendValue(Object value) {
        System.out.println(value);
    }
}