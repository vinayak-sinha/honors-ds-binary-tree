package com.vinayak;

/**
 * A TreeNode Object holds a value with references to additional left
 * and right branches.
 * 
 * @author  Vinayak Sinha
 * @version November 11, 2025
 */
public class TreeNode {
    private Object value;
    private TreeNode left;
    private TreeNode right;

    /**
     * Construct a tree node with given value and no children.
     * 
     * @param   initValue   the value to store in this node
     */
    public TreeNode(Object initValue) { 
        this(initValue, null, null);
    }

    /**
     * Construct a tree node with given value, left subtree, and right subtree.
     * 
     * @param   initValue   the initial value of this node
     * @param   initLeft    the left child of this node
     * @param   initRight   the right child of this node
     */
    public TreeNode(Object initValue, TreeNode initLeft, TreeNode initRight) { 
        value = initValue; 
        left = initLeft; 
        right = initRight; 
    }

    /**
     * Provides the value stored in the TreeNode.
     * 
     * @return  the value stored in the TreeNode
     */
    public Object getValue() {
        return value;
    }

    /**
     * Provides the left branch of the TreeNode.
     * 
     * @return  the left branch of the TreeNode
     */
    public TreeNode getLeft() {
        return left;
    }

    /**
     * Provides the right branch of the TreeNode.
     * 
     * @return  the right branch of the TreeNode
     */
    public TreeNode getRight() {
        return right;
    }

    /**
     * Changes the value stored in the TreeNode to the given value.
     * 
     * @param   theNewValue     the new value to be set
     */
    public void setValue(Object theNewValue) {
        value = theNewValue;
    }

    /**
     * Changes the left branch of the TreeNode to the given branch.
     * 
     * @param   theNewLeft      the new branch to be set
     */
    public void setLeft(TreeNode theNewLeft) {
        left = theNewLeft;
    }

    /**
     * Changes the right branch of the TreeNode to the given branch.
     * 
     * @param   theNewRight     the new branch to be set
     */
    public void setRight(TreeNode theNewRight) {
        right = theNewRight;
    }
}