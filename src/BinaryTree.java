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

    public ArrayList<E> inOrder() {
        if (isEmpty()) {
            return null;
        }
        ArrayList<E> temp = new ArrayList<>();
        Stack<E> tmpStack = new Stack<>();
        BinaryTreeNode node = root;
        while ((node != null) || !tmpStack.empty()){
            if (node != null){
                temp.add((E) node);
                tmpStack.push((E) node);
                node = node.getLeftChild();
            }else {
                BinaryTreeNode nodeTmp = (BinaryTreeNode) tmpStack.pop();
                node = nodeTmp.getRightChild();
            }
        }
        return temp;
    }
}
