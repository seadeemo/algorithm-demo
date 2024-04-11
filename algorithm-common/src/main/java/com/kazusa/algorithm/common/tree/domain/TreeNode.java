package com.kazusa.algorithm.common.tree.domain;

/**
 * @Description 二叉树公共定义
 * @Author kazusa
 * @Date 2024-04-03 10:30
 */
public class TreeNode<T> {

    public T val;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode() {
    }

    public TreeNode(T val) {
        this.val = val;
    }

    public TreeNode(T val, TreeNode<T> left, TreeNode<T> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return toStringHelper(this, "", true);
    }

    private String toStringHelper(TreeNode<T> node, String prefix, boolean isTail) {
        StringBuilder sb = new StringBuilder();
        if (node.right != null) {
            sb.append(toStringHelper(node.right, prefix + (isTail ? "│   " : "    "), false));
        }
        sb.append(prefix).append(isTail ? "└── " : "┌── ").append(node.val).append("\n");
        if (node.left != null) {
            sb.append(toStringHelper(node.left, prefix + (isTail ? "    " : "│   "), true));
        }
        return sb.toString();
    }
}
