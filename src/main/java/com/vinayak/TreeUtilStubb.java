package com.vinayak;

import java.util.*;
/**
 * TreeUtil contains the following methods for manipulating binary trees:
 * < put in your list of methods here>
 * @author Vinayak Sinha
 * @version November 12, 2025
 */ 
public class TreeUtilStubb  //method stubs /Skeleton code
{
    //used to prompt for command line input
    private static final Scanner in = new Scanner(System.in);
    //private static final boolean debug = false;


    /**
     * Provides the value in the leftmost node of the tree. It is 
     * implemented iteratively.
     * 
     * @precondition    t is non-empty
     * 
     * @param   t   is the tree whose leftmost node is to be found
     * 
     * @return  the value in the leftmost node of t.
     */
    public static Object leftmost(TreeNode t) {
        TreeNode current = t;
        while (current.getLeft() != null)
        {
            current = current.getLeft();
        }
        return current.getValue();
    }

    /**
     * Provides the value in the rightmost node of the tree. It is 
     * implemented recursively.
     * 
     * @precondition    t is non-empty
     * 
     * @param   t   is the tree whose rightmost node is to be found
     * 
     * @return  the value in the rightmost node of t.
     */
    public static Object rightmost(TreeNode t) {
        if(t.getRight() == null) {
            return t.getValue();
        }
        else {
            return rightmost(t.getRight());
        }
    }

    /**
     * Calculates the maximum depth of a binary tree. An empty tree has 
     * depth of 0 and a tree with one node has a depth of 1.
     * 
     * @param   t   a pointer to the root of a tree whose depth is to be calculated
     *
     * @return  the depth of the tree rooted at t
     */
    public static int maxDepth(TreeNode t) {
        if(t == null) {
            return 0;
        }
        else {
            int leftDepth = maxDepth(t.getLeft());
            int rightDepth = maxDepth(t.getRight());
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

    /**
     * Creates a random tree of the specified depth. No attempt to balance the tree
     * is provided.
     * 
     * @param   depth   the number of levels in the tree
     * 
     * @return  a TreeNode object that points to the generated tree
     */
    public static TreeNode createRandom(int depth) {
        if (Math.random() * Math.pow(2, depth) < 1)
            return null;
        return new TreeNode(((int)(Math.random() * (2 * 2 * 2 + 2))),
            createRandom(depth - 1),
            createRandom(depth - 1));
    }

    /**
     * Counts the number of nodes (including leaves) that are in the tree rooted at t.
     * 
     * @param   t   the root of the tree
     * 
     * @return  the number of nodes in the tree rooted at t
     */
    public static int countNodes(TreeNode t) {
        if(t == null) {
            return 0;
        }
        else {
            return 1 + countNodes(t.getLeft()) + countNodes(t.getRight());
        }
    }
    
    /**
     * Counts the number of leaves in the tree rooted at t.
     * 
     * @param   t   the root of the binary tree
     * 
     * @return  the number of leaves in the tree
     */
    public static int countLeaves(TreeNode t) {
        if(t == null) {
            return 0;
        }
        else if(t.getLeft() == null && t.getRight() == null) {
            return 1;
        }
        else {
            return countLeaves(t.getLeft()) + countLeaves(t.getRight());
        }
    }

    /**
     * Performs a pre-order traversal of the binary tree rooted at t, lighting
     * up the nodes on the display as the traversal takes place.
     * 
     * @postcondition   each node in t has been lit up on display
     * 
     * @param   t       the root of the tree to traverse
     * @param   display the display that will show the traversal
     */
    public static void preOrder(TreeNode t, TreeDisplay display) {
        if(t == null) {
            return;
        }
        display.visit(t);
        preOrder(t.getLeft(), display);
        preOrder(t.getRight(), display);
    }

    /**
     * Performs an in-order traversal of the binary tree rooted at t, lighting
     * up the nodes on the display as the traversal takes place.
     * 
     * @postcondition   each node in t has been lit up on display
     * 
     * @param   t       the root of the tree to traverse
     * @param   display the display that will show the traversal
     */
    public static void inOrder(TreeNode t, TreeDisplay display) {
        if(t == null) {
            return;
        }
        inOrder(t.getLeft(), display);
        display.visit(t);
        inOrder(t.getRight(), display);
    }

    /**
     * Performs a post-order traversal of the binary tree rooted at t, lighting
     * up the nodes on the display as the traversal takes place.
     * 
     * @postcondition   each node in t has been lit up on display
     * 
     * @param   t       the root of the tree to traverse
     * @param   display the display that will show the traversal
     */
    public static void postOrder(TreeNode t, TreeDisplay display) {
        if(t == null) {
            return;
        }
        postOrder(t.getLeft(), display);
        postOrder(t.getRight(), display);
        display.visit(t);
    }

    /**
     * Fills a list with the values of a binary tree rooted at t using a 
     * pre-order traversal with '$' values added to the list whenever
     * a null pointer is encountered.
     * 
     * @param   t       the root of the tree
     * @param   list    the returned list of values in the tree
     */
    public static void fillList(TreeNode t, List<String> list) {
        if(t == null) {
            list.add("$");
            return;
        }
        list.add(t.getValue().toString());
        fillList(t.getLeft(), list);
        fillList(t.getRight(), list);
    }

    /**
     * Uses the FileUtil utility class to save the tree rooted at t
     * as a file with the given file name.
     * 
     * @param   fileName    the name of the file to create which will hold the data
     *                      values in the tree
     * @param   t           is the root of the tree to save
     */
    public static void saveTree(String fileName, TreeNode t) {
        List<String> list = new ArrayList<>();
        fillList(t, list);
        Iterator<String> it = list.iterator();
        FileUtil.saveFile(fileName, it);
    }

    /**
     * Takes in an iterator which will iterate through a valid description of
     * a binary tree with String values. Null nodes are indicated by "$" markers.
     * 
     * @param   it  the iterator which will iterate over the tree description
     * 
     * @return  a pointer to the root of the tree built by the iteration
     */
    public static TreeNode buildTree(Iterator<String> it) {
        String value = it.next();
        if(value.equals("$")) {
            return null;
        }
        TreeNode left = buildTree(it);
        TreeNode right = buildTree(it);
        return new TreeNode(value, left, right);
    }

    /**
     * Reads a file description of a tree and then builds the tree.
     * 
     * @param   fileName    a valid file name for a file that describes a binary tree
     * 
     * @return  a pointer to the root of the tree
     */
    public static TreeNode loadTree(String fileName) {
        return buildTree(FileUtil.loadFile(fileName));
    }

    /**
     * Waits for a user to type text into Std Input and then press enter.
     * 
     * @return  the string entered by the user
     */
    private static String getUserInput() {
        return in.nextLine();
    }

    /**
     * Plays a single round of 20 questions.
     * 
     * @postcondition   plays a round of twenty questions, asking the user questions as it
     *                  walks down the given knowledge tree, lighting up the display as it goes;
     *                  modifies the tree to include information learned.
     * 
     * @param   t       a pointer to the root of the game tree
     * @param   display which will show the progress of the game
     */
    private static void twentyQuestionsRound(TreeNode t, TreeDisplay display) {
        display.visit(t);
        System.out.println("Is the thing you're thinking of " + t.getValue() + " (y/n)");
        String ans = getUserInput();

        if (t.getLeft() == null && t.getRight() == null) {
            if(ans.equals("y")) {
                System.out.println("Nice, I got it!");
                return;
            }

            System.out.println("Okay, I give up. What were you thinking of?");
            String newThing = getUserInput();

            System.out.println("What is different between \"" 
                                + newThing + "\" and \"" + t.getValue() + "\"?");
            String newQuestion = getUserInput();

            System.out.println("For \"" + newThing +
                                "\", is the answer to that question yes or no? (y/n)");
            String newQuestionAns = getUserInput();

            String oldThing = t.getValue().toString();
            t.setValue(newQuestion);

            if (newQuestionAns.equals("y")) {
                t.setLeft(new TreeNode(newThing));   // yes-branch → new thing
                t.setRight(new TreeNode(oldThing));  // no-branch  → old thing
            }
            else {
                t.setLeft(new TreeNode(oldThing));   // yes-branch → old thing
                t.setRight(new TreeNode(newThing));  // no-branch  → new thing
            }

            System.out.println("Thanks! I've learned something new.");
        }

        if (ans.startsWith("y")) {
            twentyQuestionsRound(t.getLeft(), display);
        }
        else {
            twentyQuestionsRound(t.getRight(), display);
        }
    }

    /** 
     * Plays a game of 20 questions. Begins by reading in a starting file
     * and then plays multiple rounds until the user enters "quit".
     * Then the final tree is saved.
     */
    public static void twentyQuestions() {
        TreeNode root = loadTree("/Users/Vinayak/Desktop/School_Files/Classes/binarytree/" +
                                    "src/main/java/com/vinayak/KnowledgeTree.txt");

        TreeDisplay display = new TreeDisplay("Twenty Questions");
        display.displayTree(root);

        while (true) {
            System.out.println();
            System.out.print("Press Enter to play, or type \"quit\" to stop: ");
            String input = getUserInput();

            if (input.equals("quit")) {
                break;
            }

            twentyQuestionsRound(root, display);
        }
        
        saveTree("/Users/Vinayak/Desktop/School_Files/Classes/binarytree/" +
                    "src/main/java/com/vinayak/KnowledgeTree.txt", root);
    }

    /**
     * Copies a binary tree.
     * 
     * @param   t   the root of the tree to copy
     * 
     * @return  a new tree, which is a complete copy of t with all new TreeNode objects
     *          pointing to the same values as t (in the same order, shape, etc)
     */
    public static TreeNode copy(TreeNode t) {
        if(t == null) {
            return null;
        }
        return new TreeNode(t.getValue(), copy(t.getLeft()), copy(t.getRight()));
    }
    
    /**
     * Tests to see if two trees have the same shape, but not necessarily the
     * same values. Two trees have the same shape if they have TreeNode objects
     * in the same locations relative to the root.
     * 
     * @param   t1  pointer to the root of the first tree
     * @param   t2  pointer to the root of the second tree
     * 
     * @return  true if t1 and t2 describe trees having the same shape; otherwise,
     *          false
     */
    public static boolean sameShape(TreeNode t1, TreeNode t2)
    {
        if(t1 == null && t2 == null) {
            return true;
        }
        if(t1 == null || t2 == null) {
            return false;
        }
        return sameShape(t1.getLeft(), t2.getLeft()) && sameShape(t1.getRight(), t2.getRight());
    }

    /**
     * Generates a tree for decoding Morse code.
     * 
     * @param   display     the display that will show the decoding tree
     * 
     * @return  the decoding tree
     */
    public static TreeNode createDecodingTree(TreeDisplay display)
    {
        TreeNode tree = new TreeNode("Morse Tree");
        display.displayTree(tree);
        insertMorse(tree, "a", ".-", display);
        insertMorse(tree, "b", "-...", display);
        insertMorse(tree, "c", "-.-.", display);
        insertMorse(tree, "d", "-..", display);
        insertMorse(tree, "e", ".", display);
        insertMorse(tree, "f", "..-.", display);
        insertMorse(tree, "g", "--.", display);
        insertMorse(tree, "h", "....", display);
        insertMorse(tree, "i", "..", display);
        insertMorse(tree, "j", ".---", display);
        insertMorse(tree, "k", "-.-", display);
        insertMorse(tree, "l", ".-..", display);
        insertMorse(tree, "m", "--", display);
        insertMorse(tree, "n", "-.", display);
        insertMorse(tree, "o", "---", display);
        insertMorse(tree, "p", ".--.", display);
        insertMorse(tree, "q", "--.-", display);
        insertMorse(tree, "r", ".-.", display);
        insertMorse(tree, "s", "...", display);
        insertMorse(tree, "t", "-", display);
        insertMorse(tree, "u", "..-", display);
        insertMorse(tree, "v", "...-", display);
        insertMorse(tree, "w", ".--", display);
        insertMorse(tree, "x", "-..-", display);
        insertMorse(tree, "y", "-.--", display);
        insertMorse(tree, "z", "--..", display);
        return tree;
    }

    /**
     * Helper method for building a Morse code decoding tree.
     * 
     * @postcondition   inserts the given letter into the decodingTree, in the appropriate position,
     *                  as determined by the given Morse code sequence; lights up the display as
     *                  it walks down the tree
     * 
     * @param   decodingTree    the partial decoding tree
     * @param   letter          the letter to add
     * @param   code            the Morse code for letter
     * @param   display         the display that will show progress as the method walks 
     *                          down the tree
     */
    private static void insertMorse(TreeNode decodingTree, String letter,
                                    String code, TreeDisplay display) {
        TreeNode currentNode = decodingTree;
        String [] codeArr = code.split("");

        for (String s : codeArr) {
            if (s.equals(".")) {
                if (currentNode.getLeft() == null) {
                    currentNode.setLeft(new TreeNode(letter));
                }
                currentNode = currentNode.getLeft();
            }
            else {
                if (currentNode.getRight() == null) {
                    currentNode.setRight(new TreeNode(letter));
                }
                currentNode = currentNode.getRight();
            }

            display.visit(currentNode);
        }
        currentNode.setValue(letter);
        //display.visit(currentNode);
    }

    /**
     * Decodes Morse code by walking the decoding tree according to the input code.
     * 
     * @param   decodingTree    the Morse code decoding tree
     * @param   cipherText      Morse code consisting of dots, dashes, and spaces
     * @param   display         the display object that will show the decoding progress
     * 
     * @return  the string represented by cipherText
     */
    public static String decodeMorse(TreeNode decodingTree, String cipherText, TreeDisplay display)
    {
        String decoded = "";
        for(String s: cipherText.split(" +")) {
            TreeNode currentNode = decodingTree;
            for(String d: s.split("")) {
                if(d.equals(".")) {
                    currentNode = currentNode.getLeft();
                }
                else{
                    currentNode = currentNode.getRight();
                }
                display.visit(currentNode);
            }
            decoded += (String) currentNode.getValue();
        }
        return decoded;
    }

    // /**
    // * optional work
    // */
    // public static Number eval(TreeNode expTree, TreeDisplay display) {
    //     throw new RuntimeException("Write ME!");
    // }

    // /**
    // * optional work
    // */
    // public static TreeNode createExpressionTree(String exp) {
    //     throw new RuntimeException("Write ME!");
    // }

    ///**
    // * Prints out for debug.
    // * 
    // * @postcondition   out is printed to System.out
    // * 
    // * @param   out     the string to send to System.out
    // */
    //private static void debugPrint(String out) {
    //    if(debug) {
    //        System.out.println("debug: " + out);
    //   }
    //}
}
    