import java.util.ArrayList;
import java.util.Stack;

public class BinarySearchTree<E> extends BinaryTree {
    private BinarySearchTreeNode root;
    private ArrayList<E> nodes;

    public BinarySearchTree(ArrayList<E> nodes) {
        super(nodes);
        this.root = (BinarySearchTreeNode) getRoot();
        this.nodes = nodes;
    }

    public boolean containsSearchTree(E element) {
        return contains(element);
    }

    public E findMin() {
        BinarySearchTreeNode current = root;
        BinarySearchTreeNode minNode = current;
        while (current != null) {
            minNode = current;
            current = (BinarySearchTreeNode) current.getLeftChild();
        }
        return (E) minNode;
    }

    public E findMax() {
        BinarySearchTreeNode current = root;
        BinarySearchTreeNode maxNode = current;
        while (current != null) {
            maxNode = current;
            current = (BinarySearchTreeNode) current.getRightChild();
        }
        return (E) maxNode;
    }

    private boolean insertNode(E element) {
        BinarySearchTreeNode newNode = (BinarySearchTreeNode) element;
        if (contains(element)){
            return false;
        }else {
            if (nodes.isEmpty()) {
                root = newNode;
                nodes.add(element);
                return true;
            } else {
                BinarySearchTreeNode current = root;
                BinarySearchTreeNode parentNode = null;
                while (current != null) {
                    parentNode = current;
                    if (current.compareTo(element) > 0) {
                        current = (BinarySearchTreeNode) current.getLeftChild();
                        if (current == null) {
                            parentNode.addLeftChild(newNode);
                            nodes.add((E) newNode);
                            return true;
                        }
                    } else {
                        current = (BinarySearchTreeNode) current.getRightChild();
                        if (current == null) {
                            parentNode.addRightChild(newNode);
                            nodes.add((E) newNode);
                            return true;
                        }
                    }
                }
        }

        }
        return false;
    }

    public String insertHandler(E elementInsert) {
        if (insertNode(elementInsert)) {
            return "insert: success";
        } else {
            return "insert: failed";
        }
    }

}
