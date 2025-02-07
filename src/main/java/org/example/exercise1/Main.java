//    Define and implement a class(es), representing binary tree with integer-values nodes, e.g.
//              5
//           /     \
//          3        2
//       /     \
//      10     11
//
//    Define and implement methods:
//      ~ find maximum value
//      ~ calculate tree depth

package org.example.exercise1;

public class Main {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(5);
        tree.root.left = new TreeNode(3);
        tree.root.right = new TreeNode(2);
        tree.root.left.left = new TreeNode(10);
        tree.root.left.right = new TreeNode(11);

        System.out.println("Maximum value in the binary tree: " + tree.findMax(tree.root));
        System.out.println("Depth of the binary tree: " + tree.calculateDepth(tree.root));

    }

}
