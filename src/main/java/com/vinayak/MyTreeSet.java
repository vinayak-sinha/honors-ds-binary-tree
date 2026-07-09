package com.vinayak;

/**
 * Keeps track of a binary search tree with ways to add to it, remove from it, and 
 * check if it contains certain values.
 * 
 * @param   <E>     the type of the Objects to be held in the tree
 * 
 * @author  Vinayak Sinha
 * @version November 21, 2025
 */
public class MyTreeSet<E> {
    private TreeNode root;
    private int size;
    private static final TreeDisplay DISPLAY = new TreeDisplay();

    /**
     * Constructs a new binary tree of size 0 and initializes its display timing.
     */
    public MyTreeSet() {
        root = null;
        size = 0;

        //wait 1 millisecond when visiting a node
        DISPLAY.setDelay(1);
    }

    /**
     * Provides the number of entries in the tree.
     * 
     * @return  the number of entries in the tree
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the tree contains the given Object.
     * 
     * @param   obj     the object to be checked
     * 
     * @return  true, if the object is in the tree; otherwise,
     *          false
     */
    public boolean contains(Object obj) {
        return BinaryTreeUtil.contains(root, (Comparable) obj, DISPLAY);
    }

    /**
     * If the given Object is not in the tree, it will add the object.
     * 
     * @param   obj     the object to be added
     * 
     * @return  true, if the Object was successfully added; otherwise,
     *          false
     */
    public boolean add(E obj) {
        if(contains(obj)) {
            return false;
        }
        size++;
        root = BinaryTreeUtil.insert(root, (Comparable) obj, DISPLAY);
        return true;

    }

    /**
     * If the given Object is in the tree, it removes the Object.
     * 
     * @param   obj     the Object to be removed
     * 
     * @return  true, if the Object was successfully removed; otherwise,
     *          false
     */
    public boolean remove(Object obj) {
        if(!contains(obj)) {
            return false;
        }
        size--;
        root = BinaryTreeUtil.delete(root, (Comparable) obj, DISPLAY);
        return true;
    }

    /**
     * Converts the tree into a string from left to right
     * 
     * @return  a string containing the values in the tree
     */
    @Override
    public String toString() {
        return toString(root);
    }

    /**
     * Helper method for toString that goes one by one through the tree's elements.
     * 
     * @param   t   the TreeNode to convert to a String
     * 
     * @return  the value of the Treenode in between its children's values
     */
    private String toString(TreeNode t) {
        if (t == null)
            return " ";
        return toString(t.getLeft()) + t.getValue() + toString(t.getRight());
    }
}