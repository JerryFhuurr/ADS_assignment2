import java.util.ArrayList;

public class BinarySearchTree<E> extends BinaryTree {
    private BinarySearchTreeNode root;
    private final ArrayList<E> nodes;

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

    public boolean insertNode(E element) {
        BinarySearchTreeNode newNode = (BinarySearchTreeNode) element;
        if (contains(element)) {
            return false;
        } else {
            if (nodes.isEmpty()) {
                root = newNode;
                nodes.add(element);
                size++;
                return true;
            } else {
                BinarySearchTreeNode current = root;
                BinarySearchTreeNode parentNode;
                while (current != null) {
                    parentNode = current;
                    if (current.compareTo(element) > 0) {
                        current = (BinarySearchTreeNode) current.getLeftChild();
                        if (current == null) {
                            parentNode.addLeftChild(newNode);
                            nodes.add((E) newNode);
                            size++;
                            return true;
                        }
                    } else {
                        current = (BinarySearchTreeNode) current.getRightChild();
                        if (current == null) {
                            parentNode.addRightChild(newNode);
                            nodes.add((E) newNode);
                            size++;
                            return true;
                        }
                    }
                }
            }

        }
        return false;
    }

    public boolean deleteNode(E element) {
        BinarySearchTreeNode parent = null;
        BinarySearchTreeNode current = root;
        BinarySearchTreeNode nodeRemove = (BinarySearchTreeNode) element;
        //1.find the location of node need to delete
        while (current != null) {
            if (nodeRemove.compareTo(current) < 0) {
                parent = current;
                current = (BinarySearchTreeNode) current.getLeftChild();
            } else if (nodeRemove.compareTo(current) > 0) {
                parent = current;
                current = (BinarySearchTreeNode) current.getRightChild();
            } else break;
        }

        //current is pointing the node to be removed
        if(current == null){
            return false;
        }

        //a.no left child (include no left but has right and neither left nor right)
        if (current.getLeftChild() == null){
            if (parent == null){
                root = (BinarySearchTreeNode) current.getRightChild();
            }else {
                if (nodeRemove.compareTo(parent) < 0){
                    parent.addLeftChild(current.getRightChild());
                }else {
                    parent.addRightChild(current.getRightChild());
                }
            }
        }
        //b.has left but no right
        else if (current.getRightChild() == null){
            if (parent == null){
                root = (BinarySearchTreeNode) current.getLeftChild();
            }else {
                if (nodeRemove.compareTo(parent) < 0){
                    parent.addLeftChild(current.getLeftChild());
                }else {
                    parent.addRightChild(current.getLeftChild());
                }
            }
        }
        //c.both left and right
        else {
            BinarySearchTreeNode parentRightMost = current;
            BinarySearchTreeNode rightMost = (BinarySearchTreeNode) current.getLeftChild();

            //find the max value in left child
            while (rightMost.getRightChild() != null){
                parentRightMost = rightMost;
                rightMost = (BinarySearchTreeNode) rightMost.getRightChild();
            }

            current = rightMost;
            if (parentRightMost.getRightChild() == rightMost){
                parentRightMost.addRightChild(rightMost.getLeftChild());
            }else {
                parentRightMost.addLeftChild(rightMost.getLeftChild());
            }
        }
        nodes.remove(element);
        size--;
        return true;
    }

    public void reBalance() {
        if (nodes != null && !nodes.isEmpty()) {
            while (root.balanceValue() >1 || root.balanceValue() < -1) {
                BinaryTreeNode superNode = root;
                BinaryTreeNode node = null;
                if (superNode.balanceValue() < -1) {
                    node = superNode.getLeftChild();
                } else if (superNode.balanceValue() > 1) {
                    node = superNode.getRightChild();
                }

                if (node != null) {
                    BinaryTreeNode superSuperNode = null;
                    while (true) {
                        if (node.balanceValue() < -1 && node.getLeftChild().balanceValue() != 0) {
                            superSuperNode = superNode;
                            superNode = node;
                            node = node.getLeftChild();
                        } else if (node.balanceValue() > 1 && node.getRightChild().balanceValue() != 0) {
                            superSuperNode = superNode;
                            superNode = node;
                            node = node.getRightChild();
                        } else {
                            break;
                        }
                    }
                    //balance
                    if (superNode.getLeftChild()==node) {
                        if (node.balanceValue() > 0) {
                            BinaryTreeNode subNode = node.getRightChild();
                            node.addRightChild(subNode.getLeftChild());
                            subNode.addLeftChild(node);
                            superNode.addLeftChild(subNode);
                        } else {
                            superNode.addLeftChild(node.getRightChild());
                            node.addRightChild(superNode);
                            if (superSuperNode != null) {
                                if (superSuperNode.getLeftChild()==superNode) {
                                    superSuperNode.addLeftChild(node);
                                } else {
                                    superSuperNode.addRightChild(node);
                                }
                            } else {
                                root = (BinarySearchTreeNode) node;
                                nodes.remove(node);
                                nodes.add(0, (E) node);
                            }
                        }
                    } else {
                        if (superNode.getRightChild()==node) {
                            if (node.balanceValue() < 0) {
                                BinaryTreeNode subNode = node.getLeftChild();
                                node.addLeftChild(subNode.getRightChild());
                                subNode.addRightChild(node);
                                superNode.addRightChild(subNode);
                            } else {
                                superNode.addRightChild(node.getLeftChild());
                                node.addLeftChild(superNode);
                                if (superSuperNode != null) {
                                    if (superSuperNode.getRightChild()==superNode) {
                                        superSuperNode.addRightChild(node);
                                    } else {
                                        superSuperNode.addLeftChild(node);
                                    }
                                } else {
                                    root = (BinarySearchTreeNode) node;
                                    nodes.remove(node);
                                    nodes.add(0, (E) node);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
