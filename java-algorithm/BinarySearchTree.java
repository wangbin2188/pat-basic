package algorithm;

/**
 * Created by wangbin10 on 2018/9/12.
 * 二叉查找树又叫二叉排序树：
 * 若左子树不空，则左子树所有节点均小于根节点；
 * 若右子树不空，则右子树所有节点均大于根节点；
 * 左右子树也分别为二叉排序树
 */
public class BinarySearchTree<T extends Comparable<? super T>> {
    public static class BinaryNode<T> {
        T data;
        BinaryNode<T> left;
        BinaryNode<T> right;

        public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public BinaryNode(T data) {
            this(data, null, null);
        }
    }

    private BinaryNode<T> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void makeEmpty() {
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public boolean contains(T t) {
        return contains(t, root);
    }

    public T findMin() {
        return findMin(root).data;
    }

    /**
     * 非递归方式实现二叉树查找最小值
     */
    private BinaryNode<T> findMin(BinaryNode<T> root) {
        if (root != null) {
            while (root.left != null) {
                root = root.left;
            }
        }
        return root;
    }

    public T findMax() {
        return findMax(root).data;
    }

    public void insert(T t) {
        root = insert(root, t);
    }

    /**
     * 二叉排序树的插入比较简单，只需要将待插入节点插到满足条件的位置即可
     */
    private BinaryNode<T> insert(BinaryNode<T> root, T t) {
        if (root == null) {
            return new BinaryNode<T>(t);
        }
        int compareResult = t.compareTo(root.data);
        if (compareResult < 0) {
            root.left = insert(root.left, t);
        } else if (compareResult > 0) {
            root.right = insert(root.right, t);
        }
        return root;
    }

    public void remove(T t) {
        root = remove(root, t);
    }

    /**
     * 二叉查找树的删除，分为以下几种情况：
     * 1.删除叶子节点，简单，不会破坏二叉查找树的顺序，直接删除即可；
     * 2.删除只有一个叶子节点的节点，也比较简单，将叶子节点直接赋给当前节点即可；
     * 3.如果要删除有两个子节点的节点，一般要找到当前节点右子树的最小节点（因为这个节点保证比左子树所有节点大，比右子树所有节点小）
     * 4.将这个节点赋给当前节点，并递归删除右子树最小节点
     */
    private BinaryNode<T> remove(BinaryNode<T> root, T t) {
        if (root == null) {
            return null;
        }
        int compareResult = t.compareTo(root.data);
        if (compareResult < 0) {
            root.left = remove(root.left, t);
        } else if (compareResult > 0) {
            root.right = remove(root.right, t);
        } else if (root.left != null && root.right != null) {//待删除节点有两个子节点,寻找右子树的最小节点，将之复制给当前节点，进而递归删除它
            root.data = findMax(root.right).data;
            root.right = remove(root.right, root.data);
        } else {//有一个或零个子节点
            root = (root.left != null) ? root.left : root.right;
        }
        return root;
    }

    /**
     * 递归方式实现二叉树查找最大值
     */
    private BinaryNode<T> findMax(BinaryNode<T> root) {
        if (root == null) {
            return null;
        } else if (root.right == null) {
            return root;
        }
        return findMax(root.right);
    }

    private boolean contains(T t, BinaryNode<T> root) {
        if (root == null) {
            return false;
        }
        int compareResult = t.compareTo(root.data);
        if (compareResult < 0) {
            return contains(t, root.left);
        } else if (compareResult > 0) {
            return contains(t, root.right);
        } else {
            return true;
        }
    }
}


