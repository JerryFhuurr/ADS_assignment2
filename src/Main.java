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
        for (int i = 0; i < tree.getSize(); i++) {
            System.out.print(tree.postOrder().get(i));
        }
        System.out.println("  ");
        //tree.findMin();

        for (int i = 0; i < nodes.size(); i++){
            System.out.println(nodes.get(i) + " Left " + nodes.get(i).getLeftChild() + " Right " + nodes.get(i).getRightChild());
        }
        System.out.println("   ");
        tree.insertNode(n8);
        ArrayList<BinarySearchTreeNode> newNodes = tree.getNodes();

        for (int i = 0; i < newNodes.size(); i++){
            System.out.println(newNodes.get(i) + " Left " + newNodes.get(i).getLeftChild() + " Right " + newNodes.get(i).getRightChild());
        }

        BinarySearchTree tree2 = new BinarySearchTree(newNodes);

        /*
        for (int i = 0; i < tree2.getSize(); i++) {
            System.out.print(tree2.postOrder().get(i));
        }

         */

        for (int i = 0; i < tree.getSize(); i++) {
            System.out.print(tree.preOrder().get(i));
        }
        System.out.println("  ");
        for (int i = 0; i < tree.getSize(); i++) {
            System.out.print(tree.postOrder().get(i));
        }
        System.out.println("  ");
        for (int i = 0; i < tree.getSize(); i++) {
            System.out.print(tree.levelOrder().get(i));
        }

        System.out.println(" ");

        tree2.deleteNode(n8);
        ArrayList<BinarySearchTreeNode> newNodes2 = tree.getNodes();
        BinarySearchTree tree3 = new BinarySearchTree(newNodes2);

        for (int i = 0; i < tree3.getSize(); i++) {
            System.out.print(tree3.postOrder().get(i));
        }


        BinaryTreePrint print = new BinaryTreePrint();
        //print.printTree(root);

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
