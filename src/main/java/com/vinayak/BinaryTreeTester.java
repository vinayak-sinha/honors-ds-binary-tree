package com.vinayak;

/**
 * Tests the logic of the methods of the TreeUtil class.
 * 
 * @author  Vinayak Sinha
 * @version November 12, 2025
 */
public class BinaryTreeTester {
    /**
     * Tests the preOrder method for a BinaryTree.
     */
    public void test() {
        TreeDisplay display = new TreeDisplay();
        // to get the display to send back the values when it visits a node:
        display.setTester(this);
        // test to see that the call back works
        TreeNode t = TreeUtil.createRandom(2 * 2 + 2);
        display.displayTree(t);
        TreeUtil.preOrder(t, display);
    }

    /**
     * Sends back the node value when a node is visited.
     * 
     * @param   value   the value to be sent back
     */
    public void sendValue(Object value) {
        System.out.print(value);
    }


    /**
     * Creates a BinaryTreeTester object and runs the tests.
     * 
     * @param   args    command line arguments
     */
    public static void main (String [] args) {
        BinaryTreeTester tester = new BinaryTreeTester();
        tester.test();
        System.out.println();
    }
}
