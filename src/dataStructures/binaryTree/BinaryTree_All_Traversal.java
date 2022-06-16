package dataStructures.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree_All_Traversal {

    public static Node root = null;
    public static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

        Node sevenNode = new Node(7, null, null);
        Node sixNode = new Node(6, null, null);
        Node eightNode = new Node(8, null, null);
        Node tenNode = new Node(10, null, null);
        Node threeNode = new Node(3, sevenNode, sixNode);
        Node nineNode = new Node(9, eightNode, tenNode);
        Node root = new Node(5, threeNode, nineNode);

        System.out.print("  In-Order Traversal: ");
        printInOrder(root);    //  left -> data -> right
        System.out.println();

        System.out.print(" Pre-Order Traversal: ");
        printPreOrder(root);   //  data -> left -> right
        System.out.println();

        System.out.print("Post-Order Traversal: ");
        printPostOrder(root);  //  left  -> right -> data
        System.out.println();

        System.out.print("Level-Order Traversal: ");  // level wise traversal
        printLevelOrderTraversal(root);
        System.out.println();


        System.out.print("Zig-Zag Traversal: ");   // zig-zag traversal
        printZigZagTraversal(root);
        System.out.println();
    }

    // Zig-Zag Traversal
    private static void printZigZagTraversal(Node root) {
        if(root == null)
            return;

        Stack<Node> currentStack = new Stack<>();
        Stack<Node> nextStack = new Stack<>();

        boolean leftToRightFlag = true;

        currentStack.push(root);

        while (!currentStack.isEmpty()){
            Node node = currentStack.pop();
            System.out.print(node.data + " ");

            if (leftToRightFlag){
                if(node.left != null)
                    nextStack.push(node.left);
                if(node.right != null)
                    nextStack.push(node.right);
            }else {
                if(node.right != null)
                    nextStack.push(node.right);
                if(node.left != null)
                    nextStack.push(node.left);
            }

            if(currentStack.isEmpty()){
                leftToRightFlag = !leftToRightFlag;
                Stack<Node> temp = new Stack<>();
                currentStack = nextStack;
                nextStack =  temp;
            }
        }

    }

    // Level-Order Traversal
    private static void printLevelOrderTraversal(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            System.out.print(q.peek().data + " ");

            if (q.peek().left != null)
                q.add(q.peek().left);

            if (q.peek().right != null)
                q.add(q.peek().right);
            q.poll();
        }
    }

    // In-Order Traversal
    private static void printInOrder(Node root) {
        Node current = root;

        if(current == null) return;

        printInOrder(current.left);
        System.out.print( current.data + " ");
        printInOrder(current.right);

    }


    // Pre-Order Traversal
    private static void printPreOrder(Node root) {
        Node current = root;

        if(current == null) return;

        System.out.print( current.data + " ");
        printPreOrder(current.left);
        printPreOrder(current.right);

    }

    // Post-Order Traversal
    private static void printPostOrder(Node root) {
        Node current = root;

        if(current == null) return;

        printPostOrder(current.left);
        printPostOrder(current.right);
        System.out.print( current.data + " ");

    }
}
