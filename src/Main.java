import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BinarySearchTreeNode root = new BinarySearchTreeNode("G");
        BinarySearchTreeNode n1 = new BinarySearchTreeNode("D");
        BinarySearchTreeNode n2 = new BinarySearchTreeNode("M");
        BinarySearchTreeNode n3 = new BinarySearchTreeNode("A");
        BinarySearchTreeNode n4 = new BinarySearchTreeNode("F");
        BinarySearchTreeNode n5 = new BinarySearchTreeNode("H");
        BinarySearchTreeNode n6 = new BinarySearchTreeNode("Z");
        BinarySearchTreeNode n7 = new BinarySearchTreeNode("E");

        BinarySearchTreeNode n8 = new BinarySearchTreeNode("Y");

        root.addLeftChild(n1);
        root.addRightChild(n2);
        n1.addLeftChild(n3);
        n1.addRightChild(n4);
        n4.addLeftChild(n7);
        n2.addLeftChild(n5);
        n2.addRightChild(n6);
        ArrayList<BinarySearchTreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        nodes.add(n1);
        nodes.add(n2);
        nodes.add(n3);
        nodes.add(n4);
        nodes.add(n5);
        nodes.add(n6);
        nodes.add(n7);

        BinarySearchTree tree = new BinarySearchTree(nodes);
        //tree.findMin();

        //System.out.println(tree.insertHandler(n8));
        tree.insertHandler(n8);
        for (int i = 0; i < tree.getSize(); i++) {
            System.out.print(tree.preOrder().get(i));
        }

        /*
        BinaryTree tree = new BinaryTree(nodes);
        for (int i = 0; i < tree.getSize(); i++) {
            System.out.print(tree.preOrder().get(i));
        }

        System.out.println(" ");
        System.out.println("left " + nodes.get(0).getLeftChild());
        for (int i = 0; i < tree.getSize(); i++) {
            System.out.print(tree.inOrder().get(i));
        }

        System.out.println(" ");
        for (int i = 0; i < tree.getSize(); i++) {
            System.out.print(tree.postOrder().get(i));
        }

        System.out.println(" ");
        for (int i = 0; i < tree.getSize(); i++) {
            System.out.print(tree.levelOrder().get(i));
        }

        System.out.println(" ");
        System.out.println(tree.height());

         */
    }
}
