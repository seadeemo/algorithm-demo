package test;

import com.kazusa.algorithm.common.tree.domain.TreeNode;
import com.kazusa.algorithm.common.tree.util.CommonTreeUtil;

/**
 * @Description 二叉搜索树查找指定元素
 * @Author Kazusa
 * @Date 2024-04-03 16:50
 */
public class TestMain {

    public static void main(String[] args) {
        Integer[] arr1 = {4, 2, 7, 1, 3};
        System.err.println(binarySearch(CommonTreeUtil.arrToTree(arr1), 2));
    }

    public static <T extends Comparable<T>> TreeNode<T> binarySearch(TreeNode<T> root, T val) {
        TreeNode<T> left, right;
        while (true) {
            if (root == null)
                return null;
            left = root.left;
            right = root.right;
            if (val.compareTo(root.val) < 0 && left == null) {
                return null;
            }
            if (val.compareTo(root.val) > 0 && right == null) {
                return null;
            }
            if (root.val.compareTo(val) == 0) {
                return root;
            } else if (val.compareTo(root.val) < 0) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
    }

}
