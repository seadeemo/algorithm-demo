package util;

import com.kazusa.algorithm.common.tree.domain.TreeNode;

/**
 * @Description 二叉搜索树插入值工具类
 * @Author Kazusa
 * @Date 2024-04-09 下午5:41
 */
public class TreeInsertUtil {

    public static <T extends Comparable<T>> TreeNode<T> insert(TreeNode<T> root, T value) {
        if (root == null) return new TreeNode<>(value);
        TreeNode<T> current = root;
        TreeNode<T> pre = root;
        while (current != null) {
            pre = current;
            if (current.val.compareTo(value) > 0) {
                current = current.left;
            } else if (current.val.compareTo(value) < 0) {
                current = current.right;
            }
        }
        if (pre.val.compareTo(value) > 0) {
            pre.left = new TreeNode<>(value);
        } else {
            pre.right = new TreeNode<>(value);
        }
        return root;
    }

}
