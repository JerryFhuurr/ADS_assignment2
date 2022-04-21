import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode("G");
        BinaryTreeNode n1 = new BinaryTreeNode("D");
        BinaryTreeNode n2 = new BinaryTreeNode("M");
        BinaryTreeNode n3 = new BinaryTreeNode("A");
        BinaryTreeNode n4 = new BinaryTreeNode("F");
        BinaryTreeNode n5 = new BinaryTreeNode("H");
        BinaryTreeNode n6 = new BinaryTreeNode("Z");
        BinaryTreeNode n7 = new BinaryTreeNode("E");

        root.addLeftChild(n1);
        root.addRightChild(n2);
        n1.addLeftChild(n3);
        n1.addRightChild(n4);
        n4.addLeftChild(n7);
        n2.addLeftChild(n5);
        n2.addRightChild(n6);
        ArrayList<BinaryTreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        nodes.add(n1);
        nodes.add(n2);
        nodes.add(n3);
        nodes.add(n4);
        nodes.add(n5);
        nodes.add(n6);
        nodes.add(n7);

        BinaryTree tree = new BinaryTree(nodes);
        for (int i = 0; i < tree.getSize(); i++) {
            System.out.print(tree.preOrder().get(i));
        }

        System.out.println(" ");

        for (int i = 0; i < tree.getSize(); i++) {
            System.out.print(tree.inOrder().get(i));
        }

        System.out.println(" ");

    }
}
