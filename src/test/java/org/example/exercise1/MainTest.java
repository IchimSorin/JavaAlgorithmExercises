package org.example.exercise1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    public void testFindMax() {
        BinaryTree tree = new BinaryTree(5);
        tree.root.left = new TreeNode(3);
        tree.root.right = new TreeNode(2);
        tree.root.left.left = new TreeNode(10);
        tree.root.left.right = new TreeNode(11);

        // Correct case test
        assertEquals(11, tree.findMax(tree.root));

        // Test case bare tree
        assertEquals(Integer.MIN_VALUE, tree.findMax(null));

        // Test case single-node tree
        BinaryTree singleNodeTree = new BinaryTree(42);
        assertEquals(42, singleNodeTree.findMax(singleNodeTree.root));

    }

    @Test
    public void testCalculateDepth() {
        BinaryTree tree = new BinaryTree(5);
        tree.root.left = new TreeNode(3);
        tree.root.right = new TreeNode(2);
        tree.root.left.left = new TreeNode(10);
        tree.root.left.right = new TreeNode(11);

        // Correct case test
        assertEquals(3, tree.calculateDepth(tree.root));

        // Test case bare tree
        assertEquals(0, tree.calculateDepth(null));

        // Test case single-node tree
        BinaryTree singleNodeTree = new BinaryTree(42);
        assertEquals(1, singleNodeTree.calculateDepth(singleNodeTree.root));

    }

    @Test
    public void testFindMaxWithException() {
        BinaryTree tree = null;
        assertThrows(NullPointerException.class, () -> {
            tree.findMax(tree.root); // We expect it to throw NullPointerException
        });
    }

    @Test
    public void testCalculateDepthWithException() {
        BinaryTree tree = null;
        assertThrows(NullPointerException.class, () -> {
            tree.calculateDepth(tree.root); // We expect it to throw NullPointerException
        });
    }

}