package test;

import domain.ChainedTree;

import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author kazusa
 * @Date 2024-03-13 10:29
 */
public class TestMain {

    public static void main(String[] args) {
        ChainedTree<Integer> tree = new ChainedTree<>();
//        List<Integer> list = Arrays.asList(8, 1, 3, 5, 7, 2, 4, 6, 10, 9, 11, 13, 22, 19);
        List<Integer> list = Arrays.asList(1);
        for (Integer integer : list) {
            tree.insert(integer);
        }

        List<Integer> resultList = tree.preorderTraversalRecursion();

        System.err.println("前序遍历---------------------------------------");
        resultList.forEach(i -> System.err.print(i + ","));
        System.err.println();

        resultList = tree.preorderTraversalIteration();
        resultList.forEach(i -> System.err.print(i + ","));
        System.err.println();

        resultList = tree.preorderTraversal();
        resultList.forEach(i -> System.err.print(i + ","));

        System.err.println();
        System.err.println("中序遍历----------------------------------------");
        resultList = tree.inorderTraversalRecursion();
        resultList.forEach(i -> System.err.print(i + ","));
        System.err.println();

        resultList = tree.inorderTraversalIteration();
        resultList.forEach(i -> System.err.print(i + ","));
        System.err.println();

        resultList = tree.inorderTraversal();
        resultList.forEach(i -> System.err.print(i + ","));

        System.err.println();
        System.err.println("后序遍历-----------------------------------------");
        resultList = tree.postorderTraversalRecursion();
        resultList.forEach(i -> System.err.print(i + ","));
        System.err.println();

        resultList = tree.postorderTraversalIteration();
        resultList.forEach(i -> System.err.print(i + ","));

        System.err.println();
        resultList = tree.postorderTraversal();
        resultList.forEach(i -> System.err.print(i + ","));
        System.err.println();

        System.err.println("层序遍历-----------------------------------------");
        List<List<Integer>> leveResultList;
        leveResultList = tree.levelOrder();
        System.err.println(leveResultList);
    }

}
