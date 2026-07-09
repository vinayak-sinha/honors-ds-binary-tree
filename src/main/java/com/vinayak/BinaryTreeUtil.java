package com.vinayak;

/**
 * A collection of static methods for operating on binary search trees
 * 
 * @author  Vinayak Sinha
 * @version November 15, 2025
 */
public abstract class BinaryTreeUtil extends TreeUtil {
    /**
     * Checks if a given value is contained in a tree.
     * 
     * @precondition    t is a binary search tree in ascending order
     * 
     * @param   t       the Tree that is being searched
     * @param   x       the Object that is being checked
     * @param   display the visual display of the tree
     * 
     * @return  true if t contains the value x; otherwise,
     *          false
     */
    public static boolean contains(TreeNode t, Comparable x, TreeDisplay display) {
        if(t == null) {
            return false;
        }

        display.visit(t);
        int comp = x.compareTo(t.getValue());
        if(comp == 0) {
            return true;
        }
        else if(comp < 0) {
            return contains(t.getLeft(), x, display);
        }
        else {
            return contains(t.getRight(), x, display);
        }
    }

    /**
     * Inserts a given Object into a tree organized from least to greatest.
     * 
     * @precondition    t is a binary search tree in ascending order
     * @postcondition   if t is empty, returns a new tree containing x;
     *                  otherwise, returns t, with x having been inserted
     *                  at the appropriate position to maintain the binary
     *                  search tree property; x is ignored if it is a
     *                  duplicate of an element already in t; only one new
     *                  TreeNode is created in the course of the traversal
     * 
     * @param   t       the tree that will receive the Object
     * @param   x       the Object to be added
     * @param   display the visual display of the tree
     * 
     * @return  the new tree with the added Object
     */
    public static TreeNode insert(TreeNode t, Comparable x, TreeDisplay display) {
        if(t == null) {
            return new TreeNode(x);
        }

        display.visit(t);
        int comp = x.compareTo(t.getValue());
        if(comp == 0) {
            return t;
        }
        else if(comp < 0) {
            t.setLeft(insert(t.getLeft(), x, display));
        }
        else {
            t.setRight(insert(t.getRight(), x, display));
        }
        return t;
    }

    /**
     * Deletes the given node, replacing it with the highest value under it.
     * 
     * @precondition    t is a binary search tree in ascending order
     * @postcondition   returns a pointer to a binary search tree,
     *                  in which the value at node t has been deleted
     *                  (and no new TreeNodes have been created)
     * 
     * @param   t       the TreeNode to delete
     * @param   display the visual display of the tree
     * 
     * @return  the updated TreeNode
     */
    private static TreeNode deleteNode(TreeNode t, TreeDisplay display) {
        if(t.getRight() == null && t.getLeft() == null) {
            return null;
        }

        if(t.getRight() == null) {
            return t.getLeft();
        }
        else if(t.getLeft() == null) {
            return t.getRight();
        }
        else {
            Object newVal = rightmost(t.getLeft());
            delete(t, (Comparable) newVal, display);
            t.setValue(newVal);
            return t;
        }
    }

    /**
     * Deletes the given Object from a tree.
     * 
     * @precondition    t is a binary search tree in ascending order
     * @postcondition   returns a pointer to a binary search tree,
     *                  in which the value x has been deleted (if present)
     *                  (and no new TreeNodes have been created)
     * 
     * @param   t       the tree from which the Object is to be deleted from
     * @param   x       the Object to be deleted
     * @param   display the visual display of the tree
     *
     * @return  the new tree with the deleted node
     */
    public static TreeNode delete(TreeNode t, Comparable x, TreeDisplay display) {
        if(t == null) {
            return null;
        }

        display.visit(t);
        int comp = x.compareTo(t.getValue());
        if(comp == 0) {
            t = deleteNode(t, display);
        }
        else if(comp < 0) {
            t.setLeft(delete(t.getLeft(), x, display));
        }
        else {
            t.setRight(delete(t.getRight(), x, display));
        }
        return t;
    }
}