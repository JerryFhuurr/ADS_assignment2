import java.util.ArrayList;
import java.util.Stack;

public class BinaryTree<E> {
    private BinaryTreeNode root;
    private int size;
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

    public void setNodes(ArrayList<E> nodes) {
        this.nodes = nodes;
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
}
