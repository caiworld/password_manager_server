package com.caihao.password_manager.algorithm.recursive;

/**
 * 反转二叉树 将左边的二叉树反转成右边的二叉树
 *        1                 1
 *     2     3          3       2
 *   4   5  6  7     7    6   5   4
 *
 * @author caihao
 * @date 2020/3/2 22:31
 */
public class InvertBinaryTreeTest {

  public static void main(String[] args) {
    BinaryTree root = new BinaryTree(1,
        new BinaryTree(2,
            new BinaryTree(4, null, null),
            new BinaryTree(5, null, null)),
        new BinaryTree(3,
            new BinaryTree(6, null, null),
            new BinaryTree(7, null, null)));
    invert(root);
    System.out.println("abc");
  }

  static BinaryTree invert(BinaryTree root) {
    if (root == null){
      return null;
    }
    BinaryTree left = invert(root.left);
    BinaryTree right = invert(root.right);
    root.left = right;
    root.right = left;
    return root;
  }

  private static class BinaryTree {
int val;
    BinaryTree left;
    BinaryTree right;

    public BinaryTree(
        int val,
        BinaryTree left,
        BinaryTree right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
