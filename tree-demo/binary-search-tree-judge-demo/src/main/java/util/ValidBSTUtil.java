package util;

import com.kazusa.algorithm.common.tree.domain.TreeNode;

import java.util.Stack;

/**
 * @Description
 * @Author Kazusa
 * @Date 2024-04-09 上午10:41
 */
public class ValidBSTUtil {

    public static <T extends Comparable<T>> boolean isValidBST(TreeNode<T> root) {
        Stack<TreeNode<T>> stack = new Stack<>();
        TreeNode<T> current = root, prev = null;
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                if (prev != null && prev.val.compareTo(current.val) > 0)
                    return false;
                prev = current;
                current = current.right;
            }
        }
        return true;
    }

}
