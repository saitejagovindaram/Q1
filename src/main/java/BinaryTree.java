import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BinaryTree {
    private Node root;
    private ArrayList<Node> nodes;

    public BinaryTree() {
        this.root = null;
        nodes=new ArrayList<>();
    }
    public BinaryTree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void connect(Node root) {
        while(root != null){
            Node tempChild = new Node(0);
            Node currentChild = tempChild;
            while(root!=null){
                if(root.getLeft() != null) {
                    currentChild.setNext( root.getLeft());
                    currentChild = currentChild.getNext();
                }
                if(root.getRight() != null) {
                    currentChild.setNext( root.getRight());
                    currentChild = currentChild.getNext();
                }
                root = root.getNext();
            }
            root = tempChild.getNext();

        }
    }

    public void insert(Node newNode) {
        if (this.root == null) {
            this.root = newNode;
            nodes.add(this.root);
        } else if (this.root.getLeft() == null) {
            this.root.setLeft(newNode);
            nodes.add(root.getLeft());
        } else if (this.root.getRight() == null) {
            this.root.setRight(newNode);
            nodes.add(this.root.getRight());
        } else {
            List<Node> siblingNodes = new LinkedList<Node>();
            siblingNodes.add(this.root.getLeft());
            siblingNodes.add(this.root.getRight());
            insert2(siblingNodes, newNode);
        }
    }
    private void insert2(List<Node> siblingNodes, Node newNode) {
        List<Node> nextSiblingNodes = new LinkedList<Node>();
        for (Node currentNode : siblingNodes) {
            if (currentNode.getLeft() == null) {
                currentNode.setLeft(newNode);
                nodes.add(currentNode.getLeft());
                return;
            } else if (currentNode.getRight() == null) {
                currentNode.setRight(newNode);
                nodes.add(currentNode.getRight());
                return;
            }
            nextSiblingNodes.add(currentNode.getLeft());
            nextSiblingNodes.add(currentNode.getRight());
        }
        insert2(nextSiblingNodes, newNode);
    }

    public void traverse(List<Node> nodes){
        for (Node n:nodes) {
            if(n.getNext()==null){
                System.out.print(n.getVal()+","+"#"+",");
            }
            else {
                System.out.print(n.getVal()+",");
            }
        }

    }



    public static void main(String[] args) {
        BinaryTree binaryTree=new BinaryTree();
        List<Integer> input = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,null,7));
        for (Integer i:input) {
            binaryTree.insert(new Node(i));
        }
        binaryTree.connect(binaryTree.getRoot());
//        System.out.println(binaryTree.getRoot());
//        binaryTree.printLevelOrder();
        binaryTree.traverse(binaryTree.nodes);
    }





//    void printLevelOrder()
//    {
//        int h = height(root);
//        int i;
//        for (i = 1; i <= h; i++)
//            printCurrentLevel(root, i);
//    }
//
//    int height(Node root)
//    {
//        if (root == null)
//            return 0;
//        else {
//            /* compute  height of each subtree */
//            int lheight = height(root.getLeft());
//            int rheight = height(root.getRight());
//
//            /* use the larger one */
//            if (lheight > rheight)
//                return (lheight + 1);
//            else
//                return (rheight + 1);
//        }
//    }
//
//    void printCurrentLevel(Node root, int level)
//    {
//        if (root == null)
//            return;
//        if (level == 1) {
//            System.out.print(root.getVal() + " ");
//        }
//        else if (level > 1) {
//            printCurrentLevel(root.getLeft(), level - 1);
//            printCurrentLevel(root.getRight(), level - 1);
//        }
//    }

}

