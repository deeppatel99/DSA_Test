import  java.util.*;



public class LinkedList {
    public static Node head;
    public static void main(String[] args) {

        printLL(head);

        System.out.println("Inserting at beginning");
        // Inserting data at the beginning

        insertAtBeginning(5);
        insertAtBeginning(1);
        insertAtBeginning(17);
        insertAtBeginning(4);
        printLL(head);
        System.out.println();
        System.out.println();

        // Inserting data at the end

        System.out.println("Inserting at end");
        insertAtEnd(10);
        insertAtEnd(12);
        printLL(head);
        System.out.println();
        System.out.println();

        // Inserting data in between
        System.out.println("Inserting data in between");
        insertDataInBetween(5,20);
        printLL(head);
        System.out.println();
        System.out.println();

        // Deleting a Node
        System.out.println("Deleting a Node");
        deleteNode(17);
        deleteNode(20);
        printLL(head);
        System.out.println();
        System.out.println();

        // Reverse a Linked list
        System.out.println("Reverse a Linked list");
        reverseLL();
        printLL(head);
        System.out.println();
        System.out.println();

        // Find Middle of the Linked list
        System.out.println("Find Middle of Linked list");
        insertAtBeginning(7);
        printLL(head);
        System.out.println();
        findMiddle();

        // Find Loop, Remove Loop , Find Length of Loop

        Node lastNode = findExistingNode(4);
        Node middleNode = findExistingNode(10);

        initiateLoop(lastNode, middleNode);
        detectLoop();


    }

    private static void detectLoop() {

    }

    private static void initiateLoop(Node lastNode, Node middleNode) {
        lastNode.nextNode = middleNode;
    }


    public static class Node{
        public int data;
        public Node nextNode;
    }


    public static void printLL(Node newNode){

        if(newNode == null){
            System.out.println("Linked List is empty");
            return;
        }


        while(newNode != null){
            System.out.print(newNode.data + " ");
            newNode = newNode.nextNode;
        }
    }

    public static void insertAtBeginning(int data1){
        Node newNode = new Node();

        if(head == null){
            newNode.data = data1;
            head = newNode;
            return;
        }

        newNode.data = data1;
        newNode.nextNode = head;
        head = newNode;
    }

    public static void insertAtEnd(int data1){
        Node newNode = new Node();
        newNode.data = data1;

        Node lastNode = head;

        while(lastNode != null && lastNode.nextNode != null){
            lastNode = lastNode.nextNode;
        }

        lastNode.nextNode = newNode;

    }

    public static void insertDataInBetween(int existingData, int insertingData){
        Node existingNode = findExistingNode(existingData);

        if(existingNode == null){
            System.out.println("No such data exists!");
            return;
        }

        Node newNode = new Node();
        newNode.data = insertingData;

        newNode.nextNode = existingNode.nextNode;
        existingNode.nextNode = newNode;
    }

    private static Node findExistingNode(int data1){
        Node currentNode = head;

        while(currentNode!= null && currentNode.data != data1){
            currentNode = currentNode.nextNode;
        }

        return currentNode;
    }


    public static void deleteNode(int data1){
        Node currentNode = head;
        Node previousNode = new Node();

        if(currentNode != null && currentNode.data == data1){
            head = currentNode.nextNode;
            return;
        }

        while(currentNode != null && currentNode.data != data1){
            previousNode = currentNode;
            currentNode = currentNode.nextNode;
        }

        if(currentNode == null){
            System.out.println("No such data exists!");
            return;
        }
        previousNode.nextNode = currentNode.nextNode;

    }

    public static void reverseLL(){
        Node current = head;
        Node prev =null;
        Node nextOfCurrentNode;

        while(current != null){
            nextOfCurrentNode = current.nextNode;
            current.nextNode = prev;
            prev = current;
            current = nextOfCurrentNode;
        }

        head = prev;
    }

    public static void findMiddle(){
        Node slow = head;
        Node fast = head.nextNode;

        while(slow != null && fast != null && fast.nextNode != null){
            slow =  slow.nextNode;
            fast = fast.nextNode.nextNode;
        }

        System.out.println("Middle Element is : " + slow.data);
    }

}
