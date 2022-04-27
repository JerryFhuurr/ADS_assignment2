public class BinaryTreeNode<E> {
    private E element;
    private BinaryTreeNode leftChild;
    private BinaryTreeNode rightChild;

    public BinaryTreeNode(E element) {
        this.element = element;
        this.leftChild = null;
        this.rightChild = null;
    }

    public void addLeftChild(BinaryTreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public void addRightChild(BinaryTreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public BinaryTreeNode getLeftChild() {
        return leftChild;
    }

    public BinaryTreeNode getRightChild() {
        return rightChild;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public int balanceValue() {
        int leftMinHeight = 0;
        int leftMaxHeight = 0;
        int rightMinHeight = 0;
        int rightMaxHeight = 0;
        if (leftChild != null) {
            leftMinHeight = leftChild.minHeight();
            leftMaxHeight = leftChild.height();
        }
        if (rightChild != null) {
            rightMinHeight = rightChild.minHeight();
            rightMaxHeight = rightChild.height();
        }
        if (leftMaxHeight - rightMinHeight > rightMaxHeight - leftMinHeight) {
            return rightMinHeight - leftMaxHeight;
        }
        return rightMaxHeight - leftMinHeight;
    }

    private int minHeight() {
        int height = 1;
        int leftHeight = 0;
        int rightHeight = 0;
        if (leftChild != null) {
            leftHeight = leftChild.minHeight();
        }
        if (rightChild != null) {
            rightHeight = rightChild.minHeight();
        }
        if (leftHeight > 0 && rightHeight > 0) {
            height += Integer.min(leftHeight, rightHeight);
        } else {
            height += Integer.max(leftHeight, rightHeight);
        }
        return height;
    }

    public int height() {
        int height = 1;
        int leftHeight = 0;
        int rightHeight = 0;
        if (leftChild != null) {
            leftHeight = leftChild.height();
        }
        if (rightChild != null) {
            rightHeight = rightChild.height();
        }
        height += Integer.max(leftHeight, rightHeight);
        return height;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}
