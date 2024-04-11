package test;

import com.kazusa.algorithm.common.tree.domain.TreeNode;
import util.InAndPostOrderBuildTreeUtil;
import util.PreAndInOrderBuildTreeUtil;

/**
 * @Description
 * @Author kazusa
 * @Date 2024-04-03 10:32
 */
public class TestMain {

    public static void main(String[] args) {
        // 中序+后序构造
        Integer[] inorder = {9, 3, 15, 20, 7};
        Integer[] preorder = {3, 9, 20, 15, 7};
        Integer[] postorder = {9, 15, 7, 20, 3};
        TreeNode<Integer> root = InAndPostOrderBuildTreeUtil.buildTreeRecursion(inorder, postorder);
        System.err.println("中序+后序构造-------------------------");
        System.err.println(root);
        // 前序+中序构造
        root = PreAndInOrderBuildTreeUtil.buildTreeRecursion(preorder, inorder);
        System.err.println("前序+中序构造-------------------------");
        System.err.println(root);
    }

}
