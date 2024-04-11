package domain;

import com.kazusa.algorithm.common.tree.domain.TreeNode;

import java.util.*;

/**
 * @Description
 * @Author kazusa
 * @Date 2024-03-13 9:30
 */
public class ChainedTree<T extends Comparable<T>> {

    private TreeNode<T> root;

    private int size;

    // 中序遍历--递归
    public List<T> inorderTraversalRecursion() {
        if (root == null) {
            return Collections.emptyList();
        }

        return inorderTraversalRecursion(root);
    }

    // 中序遍历--递归
    private List<T> inorderTraversalRecursion(TreeNode<T> currentRoot) {
        List<T> result = new ArrayList<>();
        if (currentRoot.left != null) {
            result.addAll(inorderTraversalRecursion(currentRoot.left));
        }
        result.add(currentRoot.val);
        if (currentRoot.right != null) {
            result.addAll(inorderTraversalRecursion(currentRoot.right));
        }
        return result;
    }

    // 前序遍历--递归
    public List<T> preorderTraversalRecursion() {
        if (root == null) {
            return Collections.emptyList();
        }

        return preorderTraversalRecursion(root);
    }

    // 前序遍历--递归
    private List<T> preorderTraversalRecursion(TreeNode<T> currentRoot) {
        List<T> result = new ArrayList<>();
        result.add(currentRoot.val);
        if (currentRoot.left != null) {
            result.addAll(preorderTraversalRecursion(currentRoot.left));
        }
        if (currentRoot.right != null) {
            result.addAll(preorderTraversalRecursion(currentRoot.right));
        }
        return result;
    }

    // 后序遍历--递归
    public List<T> postorderTraversalRecursion() {
        if (root == null) {
            return Collections.emptyList();
        }

        return postorderTraversalRecursion(root);
    }

    // 后序遍历--递归
    private List<T> postorderTraversalRecursion(TreeNode<T> currentRoot) {
        List<T> result = new ArrayList<>();
        if (currentRoot.left != null) {
            result.addAll(postorderTraversalRecursion(currentRoot.left));
        }
        if (currentRoot.right != null) {
            result.addAll(postorderTraversalRecursion(currentRoot.right));
        }
        result.add(currentRoot.val);
        return result;
    }

    // 前序遍历--迭代(根左右，栈先进后出，故先右后左，入栈顺序与遍历顺序对应)
    public List<T> preorderTraversalIteration() {
        if (root == null) {
            return Collections.emptyList();
        }
        Stack<TreeNode<T>> stack = new Stack<>();
        TreeNode<T> current;
        stack.push(root);
        List<T> result = new ArrayList<>(size);
        while (!stack.isEmpty()) {
            current = stack.pop();
            result.add(current.val);
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
        return result;
    }

    // 中序遍历--迭代(左根右，先找到最左边的，再找右边的，栈仅用作记录入栈关系)
    public List<T> inorderTraversalIteration() {
        if (root == null) {
            return Collections.emptyList();
        }
        Stack<TreeNode<T>> stack = new Stack<>();
        TreeNode<T> current = root;
        List<T> result = new ArrayList<>(size);
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                result.add(current.val);
                current = current.right;
            }
        }
        return result;
    }

    // 后序遍历--迭代(左右根，实际上是根右左的反向)
    public List<T> postorderTraversalIteration() {
        if (root == null) {
            return Collections.emptyList();
        }
        Stack<TreeNode<T>> stack = new Stack<>();
        stack.push(root);
        TreeNode<T> current;
        List<T> result = new ArrayList<>(size);
        while (!stack.isEmpty()) {
            current = stack.pop();
            result.add(current.val);
            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
        }
        Collections.reverse(result);
        return result;
    }

    // 中序遍历--迭代(统一写法)
    public List<T> inorderTraversal() {
        if (root == null) {
            return Collections.emptyList();
        }
        Stack<TreeNode<T>> stack = new Stack<>();
        List<T> result = new ArrayList<>(size);
        stack.push(root);
        TreeNode<T> current;
        while (!stack.isEmpty()) {
            current = stack.peek();
            stack.pop();
            if (current != null) {
                if (current.right != null) {
                    stack.push(current.right);
                }
                stack.push(current);
                stack.push(null);
                if (current.left != null) {
                    stack.push(current.left);
                }
            } else {
                current = stack.pop();
                result.add(current.val);
            }
        }
        return result;
    }

    // 前序遍历--迭代(统一写法)
    public List<T> preorderTraversal() {
        if (root == null) {
            return Collections.emptyList();
        }
        Stack<TreeNode<T>> stack = new Stack<>();
        List<T> result = new ArrayList<>(size);
        stack.push(root);
        TreeNode<T> current;
        while (!stack.isEmpty()) {
            current = stack.peek();
            stack.pop();
            if (current != null) {
                if (current.right != null) {
                    stack.push(current.right);
                }
                if (current.left != null) {
                    stack.push(current.left);
                }
                stack.push(current);
                stack.push(null);
            } else {
                current = stack.pop();
                result.add(current.val);
            }
        }
        return result;
    }

    // 后序遍历--迭代(统一写法)
    public List<T> postorderTraversal() {
        if (root == null) {
            return Collections.emptyList();
        }
        Stack<TreeNode<T>> stack = new Stack<>();
        List<T> result = new ArrayList<>(size);
        stack.push(root);
        TreeNode<T> current;
        while (!stack.isEmpty()) {
            current = stack.peek();
            stack.pop();
            if (current != null) {
                stack.push(current);
                stack.push(null);
                if (current.right != null) {
                    stack.push(current.right);
                }
                if (current.left != null) {
                    stack.push(current.left);
                }
            } else {
                current = stack.pop();
                result.add(current.val);
            }
        }
        return result;
    }

    // 层序遍历
    public List<List<T>> levelOrder() {
        if (root == null) {
            return Collections.emptyList();
        }

        Queue<TreeNode<T>> queue = new LinkedList<>();
        List<List<T>> result = new LinkedList<>();
        queue.offer(root);
        TreeNode<T> current;
        while (!queue.isEmpty()) {
            List<T> currentList = new LinkedList<>();
            int size = queue.size();
            while (size > 0) {
                current = queue.poll();
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
                currentList.add(current.val);
                size--;
            }
            result.add(currentList);
        }
        return result;
    }

    public void insert(T value) {
        size++;
        if (root == null) {
            root = new TreeNode<>();
            root.val = value;
            return;
        }
        TreeNode<T> current = root;
        while (true) {
            if (value.compareTo(current.val) < 0) {
                if (current.left != null) {
                    current = current.left;
                } else {
                    current.left = new TreeNode<>();
                    current.left.val = value;
                    break;
                }
            } else {
                if (current.right != null) {
                    current = current.right;
                } else {
                    current.right = new TreeNode<>();
                    current.right.val = value;
                    break;
                }
            }
        }
    }

}
