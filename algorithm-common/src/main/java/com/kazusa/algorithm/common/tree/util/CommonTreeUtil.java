package com.kazusa.algorithm.common.tree.util;

import com.kazusa.algorithm.common.tree.domain.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description
 * @Author lihaichen
 * @Date 2024-04-03 16:51
 */
public class CommonTreeUtil {

    public static <T> TreeNode<T> arrToTree(T[] arr) {
        if (arr.length == 0) {
            return null;
        }
        TreeNode<T> root = new TreeNode<T>(arr[0]);
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        for (int i = 1; i < arr.length; i++) {
            TreeNode<T> father = queue.poll();
            if (arr[i] == null) {
                continue;
            }
            TreeNode<T> newNode = new TreeNode<T>(arr[i]);
            if (father == queue.peek())
                father.left = newNode;
            else
                father.right = newNode;
            queue.offer(newNode);
            queue.offer(newNode);
        }
        return root;
    }

}
