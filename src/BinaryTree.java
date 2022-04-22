import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<E> {
    private final BinaryTreeNode root;
    private final int size;
    private ArrayList<E> nodes;

    public BinaryTree(ArrayList<E> nodes) {
        this.nodes = nodes;
        if (nodes.isEmpty()) {
            this.root = null;
            this.size = 0;
        } else {
            this.root = (BinaryTreeNode) nodes.get(0);
            this.size = nodes.size();
        }
    }

    public BinaryTreeNode getRoot() {
        return root;
    }

    public boolean isEmpty() {
        return nodes.isEmpty();
    }

    public int getSize() {
        return size;
    }

    public boolean contains(E element) {
        return nodes.contains(element);
    }

    public ArrayList<E> preOrder() {
        if (isEmpty()) {
            return null;
        }
        ArrayList<E> temp = new ArrayList<>();
        Stack<E> tmpStack = new Stack<>();
        BinaryTreeNode node = root;
        while ((node != null) || !tmpStack.empty()) {
            if (node != null) {
                temp.add((E) node);
                tmpStack.push((E) node);
                node = node.getLeftChild();
            } else {
                BinaryTreeNode nodeTmp = (BinaryTreeNode) tmpStack.pop();
                node = nodeTmp.getRightChild();
            }
        }
        return temp;
    }

    public ArrayList<E> inOrder() {
        if (isEmpty()) {
            return null;
        }
        ArrayList<E> listTmp = new ArrayList<>();
        Stack<E> tmpStack = new Stack<>();
        BinaryTreeNode node = root;
        while ((node != null) || !tmpStack.empty()) {
            if (node != null) {
                tmpStack.push((E) node);
                node = node.getLeftChild();
            } else {
                BinaryTreeNode tmpNode = (BinaryTreeNode) tmpStack.pop();
                listTmp.add((E) tmpNode);
                node = tmpNode.getRightChild();
            }
        }
        return listTmp;
    }

    public ArrayList<E> postOrder() {
        if (isEmpty()) {
            return null;
        }
        ArrayList<E> listTmp = new ArrayList<>();
        BinaryTreeNode cur, pre = null;

        Stack<E> tmpStack = new Stack<>();
        tmpStack.push((E) root);

        while (!tmpStack.empty()) {
            cur = (BinaryTreeNode) tmpStack.peek();
            if ((cur.getLeftChild() == null && cur.getRightChild() == null) || (pre != null && (pre == cur.getLeftChild() || pre == cur.getRightChild()))) {
                listTmp.add((E) cur);
                tmpStack.pop();
                pre = cur;
            } else {
                if (cur.getRightChild() != null) {
                    tmpStack.push((E) cur.getRightChild());
                }
                if (cur.getLeftChild() != null) {
                    tmpStack.push((E) cur.getLeftChild());
                }
            }
        }
        return listTmp;
    }

    public ArrayList<E> levelOrder() {
        if (isEmpty()) {
            return null;
        }
        ArrayList<E> tmp = new ArrayList<>();
        Queue<E> queue = new LinkedList<E>();
        queue.add((E) root);

        while (!queue.isEmpty()) {
            BinaryTreeNode node = (BinaryTreeNode) queue.poll();
            tmp.add((E) node);

            if (node.getLeftChild() != null) {
                queue.add((E) node.getLeftChild());
            }
            if (node.getRightChild() != null) {
                queue.add((E) node.getRightChild());
            }
        }
        return tmp;
    }

    public int height() {
        if (nodes.isEmpty()) {
            return -1;
        }
        //↓notes for myself
        //使用count进行层级统计。
        //nextCount保存的是每层遍历后新增到队列中的元素数量。
        //如果count++ = nextCount 就说明将该层遍历完了 deep++ nextCount等于队列中保存的下一层的所有结点数目。
        //以此类推
        int deep = 0, count = 0, nextCount = 1;
        Queue<E> queue = new LinkedList<>();
        queue.add((E) root);
        while (!queue.isEmpty()) {
            BinaryTreeNode treeNode = (BinaryTreeNode) queue.poll();
            count++;
            if (treeNode.getLeftChild() != null) {
                queue.add((E) treeNode.getLeftChild());
            }
            if (treeNode.getRightChild() != null) {
                queue.add((E) treeNode.getRightChild());
            }
            if (count == nextCount) {
                nextCount = queue.size();
                count = 0;
                deep++;
            }
        }
        return deep;
    }
}
