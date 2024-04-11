package util;

import com.kazusa.algorithm.common.tree.domain.TreeNode;

/**
 * @Description 二叉搜索树删除节点工具类
 * @Author Kazusa
 * @Date 2024-04-10 上午11:27
 */
public class TreeDeleteUtil {

    public static <T extends Comparable<T>> TreeNode<T> deleteNode(TreeNode<T> root, T key) {
        if (root == null) {
            return null;
        }
        TreeNode<T> cur = root, pre = null;
        while (cur != null) {
            if (cur.val.compareTo(key) < 0) {
                pre = cur;
                cur = cur.right;
            } else if (cur.val.compareTo(key) > 0) {
                pre = cur;
                cur = cur.left;
            } else {
                break;
            }
        }
        if (pre == null)
            return deleteOneNode(cur);
        if (pre.left != null && pre.left.val == key)
            pre.left = deleteOneNode(cur);
        if (pre.right != null && pre.right.val == key)
            pre.right = deleteOneNode(cur);
        return root;
    }

    public static <T> TreeNode<T> deleteOneNode(TreeNode<T> node) {
        if (node == null)
            return null;
        if (node.right == null)
            return node.left;
        TreeNode<T> cur = node.right;
        while (cur.left != null) {
            cur = cur.left;
        }
        cur.left = node.left;
        return node.right;
    }

}
