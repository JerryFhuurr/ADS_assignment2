public class BinarySearchTreeNode<E> extends BinaryTreeNode implements Comparable<E> {
    private E element;

    public BinarySearchTreeNode(E element){
        super(element);
        this.element = element;
    }

    @Override
    public String toString() {
        return element.toString();
    }

    @Override
    public int compareTo(E o) {
        return element.toString().compareTo(o.toString());
    }
}
