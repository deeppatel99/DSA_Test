public class LinkedList_DSA_Sheet {
    public static class Node{
        public int data;
        public Node nextNode;
    }

    public static Node head;

    public static void main(String[] args) {

        {
//            insertAtBeginning(9);
            insertAtBeginning(8);
            insertAtBeginning(7);
            insertAtBeginning(6);
            insertAtBeginning(5);
            insertAtBeginning(4);
            insertAtBeginning(3);
            insertAtBeginning(2);
            insertAtBeginning(1);

            System.out.println();
            printLL(head);
            System.out.println("\n");
        }



        // 1. Reverse a Linked List in group of given size K

//        Inputs:   1->2->3->4->5->6->7->8->9->NULL and k = 3
//        Output:   3->2->1->6->5->4->9->8->7->NULL.

        /*
        System.out.println("Reverse a Linked List in group of given size K : \n");

        Node newHead = head;
        newHead = reverseLLOfSizeK(newHead,3);
        printLL(newHead);

        System.out.println();
        */


        // 2. Reverse alternate K nodes in a Singly Linked List

//        Inputs:   1->2->3->4->5->6->7->8->9->NULL and k = 3
//        Output:   3->2->1->4->5->6->9->8->7->NULL.

        /*
        System.out.println("Reverse alternate K nodes in a Singly Linked List : \n");

        Node newHead = head;
        newHead = reverseLLAlternateOfSizeK(newHead,3);
        printLL(newHead);
        */


        // 3. Print reverse of a Linked List without actually reversing


        /*
        System.out.println("Print reverse of a Linked List without actually reversing: \n");
        reverseLLWithoutReversing(head);
        */


        // 4. Find the middle of a given linked list

        findMiddle();

    }

    // 4. Find the middle of a given linked list
    private static void findMiddle() {
        Node current = head;

        Node slow = head;
        Node fast = head.nextNode;  // if list is even it'll return left side of middle element and if we want to return right side then do fast = head;

        while(slow != null && fast != null && fast.nextNode != null){
            slow = slow.nextNode;
            fast = fast.nextNode.nextNode;
        }

        System.out.println("Middle Element of Linked List: " + slow.data);
    }

    // 3. Print reverse of a Linked List without actually reversing
    private static void reverseLLWithoutReversing(Node head1) {
        Node current = head1;

        if(current == null){
            return;
        }

        reverseLLWithoutReversing(current.nextNode);

        System.out.print(current.data + "  ");
    }


    // 2. Reverse alternate K nodes in a Singly Linked List
    private static Node reverseLLAlternateOfSizeK(Node newHead, int k) {
        if(newHead == null){
            System.out.println("Linked List is Empty!");
        }

        Node current = newHead;
        Node prev = null;
        Node next = null;
        int count = 1;

        while (current != null && count <= k){
            next = current.nextNode;
            current.nextNode = prev;
            prev = current;
            current = next;
            count++;
        }

        if(newHead != null){
            newHead.nextNode = current;
        }

        count = 1;
        while (current != null && count < k) {
            current = current.nextNode;
            count++;
        }

        if (current != null){
            current.nextNode = reverseLLOfSizeK(current.nextNode, k);
        }

        return prev;
    }


    // 1. Reverse a Linked List in group of given size K
    private static Node reverseLLOfSizeK(Node head1, int k) {

        if(head1 == null){
            System.out.println("Linked List is Empty!");
        }

        Node current = head1;
        Node prev = null;
        Node next = null;
        int count = 1;


        while(current != null && count <= k){
            next = current.nextNode;
            current.nextNode = prev;
            prev = current;
            current = next;
            count++;
        }

        if(next != null){
            head1.nextNode = reverseLLOfSizeK(next, k);
        }


        return prev;

    }

    private static void insertAtBeginning(int data1) {
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

    private static void printLL(Node head1){
        Node current = head1;

        while(current != null){
            System.out.print( current.data+"  ");
            current = current.nextNode;
        }
    }

}
