package util;

import com.kazusa.algorithm.common.tree.domain.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 前序+中序构建二叉树工具类
 * @Author kazusa
 * @Date 2024-04-03 11:09
 */
public class PreAndInOrderBuildTreeUtil {

    // 前序+中序 递归 确定唯一二叉树
    public static <T> TreeNode<T> buildTreeRecursion(T[] preorder, T[] inorder) {
        int length = inorder.length;
        Map<T, Integer> map = new HashMap<>(length);
        for (int i = 0; i < length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, 0, length, map);
    }

    /**
     * 指定范围内查找元素
     *
     * @param start 起始index 包含
     * @param end   结束index 包含
     */
    private static <T> int find(T val, int start, int end, Map<T, Integer> map) {
        Integer result = map.get(val);
        if (result != null && result >= start && result <= end)
            return result;
        return -1;
    }

    /**
     * @param preStart index
     * @param inStart  index
     * @param length   长度
     */
    private static <T> TreeNode<T> buildTree(T[] preorder, T[] inorder, int preStart, int inStart, int length, Map<T, Integer> map) {
        T rootVal = preorder[preStart];
        TreeNode<T> root = new TreeNode<>(rootVal);
        if (length == 1)
            return root;
        int inoIdx = find(rootVal, inStart, inStart + length - 1, map);
        int leftLength = inoIdx - inStart;
        int rightLength = length + inStart - inoIdx - 1;
        if (leftLength > 0) {
            root.left = buildTree(preorder, inorder, preStart + 1, inStart, leftLength, map);
        }
        if (rightLength > 0) {
            root.right = buildTree(preorder, inorder, preStart + 1 + leftLength, inoIdx + 1, rightLength, map);
        }
        return root;
    }

}
