package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

/**
 * Created by wangbin10 on 2018/9/11.
 * AVL树又叫自平衡二叉查找树，在AVL树中任何节点的两个子树的高度最大差别为1；
 * 增加和删除节点可能需要通过一次或多次树旋转来重新平衡这个树
 */
public class AVLTree<T extends Comparable<? super T>> {
    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();
        AVLNode<Integer> root = null;
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            int num = rand.nextInt(100);
            root = tree.insert(root, num);
        }
        tree.postTravel(root);
        System.out.println("==========");
        tree.postOrder(root);
        System.out.println("==========");

    }

    public Integer getHeight(AVLNode<T> t) {
        return t == null ? -1 : t.getHeight();
    }

    /**
     * AVL树的插入和删除和二叉查找树逻辑相同，区别在于增加了一步自平衡
     */
    public AVLNode<T> insert(AVLNode<T> t, T x) {
        if (t == null) {
            t = new AVLNode<T>(x);
        }
        int compareResult = x.compareTo(t.data);
        if (compareResult < 0) {
            t.left = insert(t.left, x);
        } else if (compareResult > 0) {
            t.right = insert(t.right, x);
        } else {
            ;
        }
        return balance(t);
    }

    public AVLNode<T> remove(AVLNode<T> t, T x) {
        if (t == null) {
            return t;
        }
        int compareResult = x.compareTo(t.data);
        if (compareResult < 0) {
            t.left = remove(t.left, x);
        } else if (compareResult > 0) {
            t.right = remove(t.right, x);
        } else if (t.left != null && t.right != null) {
            t.data = findMin(t.right).data;
            t.right = remove(t.right, t.data);
        } else {
            t = (t.left != null) ? t.left : t.right;
        }
        return balance(t);
    }

    private AVLNode<T> findMin(AVLNode<T> t) {
        if (t != null) {
            while (t.left != null) {
                t = t.left;
            }
        }
        return t;
    }

    private AVLNode<T> findMax(AVLNode<T> t) {
        if (t != null) {
            while (t.right != null) {
                t = t.right;
            }
        }
        return t;
    }

    /**
     * 一、如果当前节点左子树的高度比右子树高大于1,分两种情况处理：
     * *1.左子树的左节点高于左子树的右节点，则对当前节点的左子树进行单旋转；
     * *2.左子树的左节点低于左子树的右节点，则对当前节点的左子树进行双旋转；
     * 二、如果当前节点左子树的高度比右子树高小于1,分两种情况处理：
     * * 1.右子树的右节点高于右子树的左节点，则对当前节点的右子树进行单旋转；
     * * 2.右子树的右节点低于右子树的左节点，则对当前节点的右子树进行双旋转；
     */
    private AVLNode<T> balance(AVLNode<T> t) {
        if (t == null) {
            return null;
        }
        if (getHeight(t.left) - getHeight(t.right) > 1) {
            if (getHeight(t.left.left) >= getHeight(t.left.right)) {
                t = rotateWithLeft(t);
            } else {
                t = doubleRotateWithLeft(t);
            }
        } else if (getHeight(t.right) - getHeight(t.left) > 1) {
            if (getHeight(t.right.right) >= getHeight(t.right.left)) {
                t = rotateWithRight(t);
            } else {
                t = doubleRotateWithRight(t);
            }
        }
        t.setHeight(Math.max(getHeight(t.left), getHeight(t.right)) + 1);
        return t;
    }

    private AVLNode<T> rotateWithLeft(AVLNode<T> k2) {
        AVLNode<T> k1;
        k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.setHeight(Math.max(getHeight(k2.left), getHeight(k2.right)) + 1);
        k1.setHeight(Math.max(getHeight(k1.left), k2.height) + 1);
        return k1;
    }

    private AVLNode<T> rotateWithRight(AVLNode<T> k2) {
        AVLNode<T> k1;
        k1 = k2.right;
        k2.right = k1.left;
        k1.left = k2;
        k2.setHeight(Math.max(getHeight(k2.left), getHeight(k2.right)) + 1);
        k1.setHeight(Math.max(getHeight(k1.right), k2.height) + 1);
        return k1;
    }

    private AVLNode<T> doubleRotateWithLeft(AVLNode<T> k3) {
        k3.left = rotateWithRight(k3.left);
        return rotateWithLeft(k3);
    }

    private AVLNode<T> doubleRotateWithRight(AVLNode<T> k4) {
        k4.right = rotateWithLeft(k4.right);
        return rotateWithRight(k4);
    }

    private static class AVLNode<T> {
        private T data;
        private AVLNode<T> left;
        private AVLNode<T> right;
        private Integer height;

        public AVLNode(T data, AVLNode<T> left, AVLNode<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
            this.height = 0;
        }

        public AVLNode(T data) {
            this(data, null, null);
        }


        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }
    }

    /**
     * 前序遍历——递归实现
     */
    public void preTravel(AVLNode<T> t) {
        if (t == null) {
            return;
        }
        System.out.format("%s,", t.data);
        preTravel(t.left);
        preTravel(t.right);
    }

    /**
     * 中序遍历——递归实现
     */
    public void midTravel(AVLNode<T> t) {
        if (t == null) {
            return;
        }
        midTravel(t.left);
        System.out.format("%s,", t.data);
        midTravel(t.right);
    }

    /**
     * 后序遍历——递归实现
     */
    public void postTravel(AVLNode<T> t) {
        if (t == null) {
            return;
        }
        postTravel(t.left);
        postTravel(t.right);
        System.out.format("%s,", t.data);
    }

    /**
     * 层次遍历
     */
    public void levelTravel(AVLNode<T> t) {
        Queue<AVLNode<T>> queue = new LinkedList<>();
        if (t == null) {
            return;
        }
        System.out.format("%s,", t.data);
        queue.offer(t);
        while (!queue.isEmpty()) {
            AVLNode<T> pop = queue.poll();
            if (pop.left != null) {
                System.out.format("%s,", pop.left.data);
                queue.offer(pop.left);
            }
            if (pop.right != null) {
                System.out.format("%s,", pop.right.data);
                queue.offer(pop.right);
            }
        }
        System.out.println();
    }

    /**
     * 前序遍历——非递归实现
     * 如果根节点及其左节点存在，则打印并入栈；
     * 待所有左子节点入栈后，对栈顶元素出栈，并返回其右子节点（假如有的话）
     * 同样道理，打印当前节点，并入栈其左子树
     */
    public void preOrder(AVLNode<T> t) {
        Stack<AVLNode<T>> stack = new Stack<>();
        while (t != null || !stack.isEmpty()) {
            while (t != null) {
                System.out.format("%s,", t.data);
                stack.push(t);
                t = t.left;
            }
            if (!stack.empty()) {
                t = stack.pop();
                t = t.right;
            }
        }
        System.out.println();
    }

    /**
     * 中序遍历——非递归实现
     * 如果根节点及其左节点存在，则入栈；
     * 如果栈不空，则对栈顶元素出栈，并打印；
     * 指针移到当前元素的右子节点，入栈；
     */
    public void midOrder(AVLNode<T> t) {
        Stack<AVLNode<T>> stack = new Stack<>();
        while (t != null || !stack.isEmpty()) {
            while (t != null) {
                stack.push(t);
                t = t.left;
            }
            if (!stack.isEmpty()) {
                t = stack.pop();
                System.out.printf("%s,", t.data);
                t = t.right;
            }
        }
        System.out.println();
    }

    /**
     * 后续遍历——非递归实现
     */
    public void postOrder(AVLNode<T> t) {
        Stack<AVLNode<T>> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int i = 1;
        while (t != null || !stack1.empty()) {
            while (t != null) {
                stack1.push(t);
                stack2.push(0);
                t = t.left;
            }

            while (!stack1.empty() && stack2.peek() == i) {
                stack2.pop();
                System.out.format("%s,", stack1.pop().data);
            }

            if (!stack1.empty()) {
                stack2.pop();
                stack2.push(1);
                t = stack1.peek();
                t = t.right;
            }
        }
        System.out.println();
    }

}


