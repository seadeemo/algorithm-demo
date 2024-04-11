package test;

import com.kazusa.algorithm.common.tree.domain.TreeNode;
import com.kazusa.algorithm.common.tree.util.CommonTreeUtil;
import util.ValidBSTUtil;

/**
 * @Description
 * @Author Kazusa
 * @Date 2024-04-09 上午10:40
 */
public class TestMain {

    public static void main(String[] args) {
        TreeNode<Integer> arr1 = CommonTreeUtil.arrToTree(new Integer[]{2, 1, 3});
        TreeNode<Integer> arr2 = CommonTreeUtil.arrToTree(new Integer[]{5, 1, 4, null, null, 3, 6});
        System.err.println(ValidBSTUtil.isValidBST(arr1));
        System.err.println(ValidBSTUtil.isValidBST(arr2));
    }

}
