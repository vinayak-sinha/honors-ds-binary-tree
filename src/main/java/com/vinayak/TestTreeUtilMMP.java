package com.vinayak;

/**
 * Basic Tests for Tree util
 * 
 * @author -- .- .-. .. -. .-   .--. . .-. . --. .-. .. -. ---
 * @version 2013 
 * 
 * @version Nov 2019  consolidated changes 
 */
public class TestTreeUtilMMP extends Debug
{
    //static TreeDisplay display = new TreeDisplay();
    //TreeNode tree = TreeUtil.createRandom(3);

    //static boolean showVisitedNodeValue = false; 

    /**
     * Tests the TreeUtil functions' logic.
     * 
     * @param   args    command line arguments
     */
    public static void main(String[] args) {
        System.out.println ("Test display:");
        TreeNode tree = TreeUtil.createRandom((2 + 2 + 1));
        TreeDisplay display = new TreeDisplay();

        display.displayTree(tree);

        boolean twentyQuestionsTest = false;
        if(twentyQuestionsTest) {
            TreeUtil.twentyQuestions();
        }

        boolean testLeftMost = false;
        if (testLeftMost) {
            debugPause("test left and right most");
            for (int i = (2 + 1); i < (2 * 2 + 2); i ++) {
                tree = TreeUtil.createRandom(i);
                if (tree == null) continue;
                display.displayTree(tree);
                System.out.println ("LeftMost = "+ (TreeUtil.leftmost(tree)));
                System.out.println ("RightMost = "+ (TreeUtil.rightmost(tree)));
                System.out.println ("CountLeaves = " + TreeUtil.countLeaves(tree));
                System.out.println ("CountNodes = " + TreeUtil.countNodes(tree));
                System.out.println ("MaxDepth = " + TreeUtil.maxDepth(tree));
                getUserInput();
            }
        }

        boolean testCopyAndShape = false; 
        if (testCopyAndShape) {
            debugPause("test copy and sameShape, 3 displays");
            TreeDisplay displayCopy = new TreeDisplay("copy");
            TreeDisplay displayRandom = new TreeDisplay("random");

            int size = 2 + 2; 
            tree = TreeUtil.createRandom(size);
            display.displayTree(tree);
            TreeUtil.preOrder(tree, display);

            TreeNode copyCat = TreeUtil.copy(tree);
            displayCopy.displayTree(copyCat);
            TreeNode randomTree = TreeUtil.createRandom(size);
            displayRandom.displayTree(randomTree);

            System.out.println ("copy  is same shape?  " + TreeUtil.sameShape(tree, copyCat));
            System.out.println ("random  is same shape?  " + TreeUtil.sameShape(tree, randomTree));
            //TreeUtil.getUserInput();
        }

        boolean testSaveTree = false;
        if (testSaveTree) {
            System.out.println ("\ntest save and load trees");
            TreeUtil.saveTree("Lorax", tree);
            //ArrayList<String> ListFromTree = new ArrayList<String>();
            //TreeUtil.fillList(tree, ListFromTree);
            getUserInput("the tree was saved, hit enter");

            tree = TreeUtil.createRandom(0);
            display.displayTree(tree);
            getUserInput("hit enter to see the saved tree");
            tree = TreeUtil.loadTree("Lorax"); 
            display.displayTree(tree);
            getUserInput("hit enter to continue");
        }

        boolean testTreeTraversal = false; 
        if (testTreeTraversal) {
            System.out.println ("test tree traversal");

            //use BinaryTreeTester sendValue method to display the results of the visited nodes
            //for traversal.  
            BinaryTreeTester printer = new BinaryTreeTester();
            display.setTester (printer);

            display.displayTree(null);
            display.displayTree(tree);
            debugPause("In Order tree traversal:");
            TreeUtil.inOrder(tree, display);

            display.displayTree(null);
            display.displayTree(tree);
            debugPause("Post Order tree traversal:");
            TreeUtil.postOrder(tree, display);

            display.displayTree(tree);
            debugPause("Pre Order tree traversal:");
            TreeUtil.preOrder(tree, display);
            display.setTester (null);
        }

        boolean testMorse = true; 
        if (testMorse) {
            TreeNode decoder = TreeUtil.createDecodingTree(display);
            //System.out.println(TreeUtil.decodeMorse (decoder, ".-", display)); 
            System.out.println("\". .- -\" says \"" + 
                                TreeUtil.decodeMorse(decoder, ". .- -", display) + 
                                "\" in Morse code");
            String haveANiceDay = ".... .- ...- . .- -. .. -.-. . -.. .- -.--";
            System.out.println("\""+haveANiceDay+ "\"\n\t says \"" +
                                TreeUtil.decodeMorse (decoder, haveANiceDay, display) +
                                "\" in Morse code"); 

            String msg = Debug.getUserInput("Enter your Morse code message to be decoded:");
            System.out.println("\""+msg+ "\"\n\t says \"" +
                                TreeUtil.decodeMorse (decoder, msg, display) +
                                "\" in Morse code");

        }

        // boolean testExpressions = false;
        // if (testExpressions) {
        //     String [] expressions = 
        //         {"3.0 2.01 * 4 1 - +", "3.0 2 5 7 - + +", "1 2 + 3 4 + *", "5 5 - 2 2 + + 3 *"};
        //     //for students, just test Integer, not shift between int and double.  

        //     for(String s: expressions) {
        //         TreeNode xTree = TreeUtil.createExpressionTree(s);
        //         display.displayTree(xTree);

        //         System.out.print(s +" = ");
        //         Number eval = TreeUtil.eval(xTree, display); 
        //         System.out.println(eval);

        //         debugPause();
        //     }
        //     System.out.println ("Thanks for playing.");
        // }
        debugPrint("all tests done");
    }
}
