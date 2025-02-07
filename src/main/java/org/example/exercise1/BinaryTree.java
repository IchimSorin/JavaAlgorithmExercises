package org.example.exercise1;

public class BinaryTree {
    TreeNode root;

    BinaryTree(int value) {
        root = new TreeNode(value);
    }


    int findMax(TreeNode node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }

        int max = node.value;
        int leftMax = findMax(node.left);
        int rightMax = findMax(node.right);

        if (leftMax > max) {
            max = leftMax;
        }

        if (rightMax > max) {
            max = rightMax;
        }

        return max;
    }


    int calculateDepth(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            int leftDepth = calculateDepth(node.left);
            int rightDepth = calculateDepth(node.right);

            if (leftDepth > rightDepth) {
                return leftDepth + 1;
            } else {
                return rightDepth + 1;
            }
        }
    }

}
