package linkedlist;

import java.util.Stack;

public class LinkedList_DSA_Sheet {
    public static class Node{
        public int data;
        public String dataString;
        public Node nextNode;
    }

    public static Node head;

    public static void main(String[] args) {

       {
//            insertAtBeginning(9);
//            insertAtBeginning(8);
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

//        findMiddle();


        // 5.  Detect and Remove Loop in a Linked List

//        System.out.println("Node: " + findExistingNode(5).data);
        /*
        System.out.println();
        initiateLoop(findExistingNode(5), findExistingNode(8));
        detectLoop();
        */


        // 6. Program for n’th node from the end of a Linked List

//        System.out.println("Program for n’th node from the end of a Linked List: \n");
//        nthNodeFromEndOfList(4);


        // 7. Pairwise swap elements of a given linked list

        /*
        System.out.println("Pairwise swap elements of a given linked list: \n");
        pairwiseSwapLL();
        printLL(head);
        System.out.println();
        */


        // 8. Rotate a Linked List

//        For example, if the given linked list is 10->20->30->40->50->60 and k is 4, the list should be modified to 50->60->10->20->30->40.

        /*
        System.out.println("Rotate a Linked List: \n");
        rotateLL(2);
        */


        // 9. Function to check if a singly linked list is palindrome.   Ex: R -> A -> D -> A -> R

        /*
        {
            insertAtBeginningString("R");
            insertAtBeginningString("A");
            insertAtBeginningString("D");
            insertAtBeginningString("A");
            insertAtBeginningString("R");

            printLLString(head);
            System.out.println();
        }

        checkIfLLIsPalindrome();
        */



        // 10. Write a function to get the intersection point of two Linked Lists

//         look in geeksForGeeks as its simple to implement just look at the approach


        // 11. Find intersection of two sorted Linked List

//        geeksForGeeks for solution


        // 12. Delete alternate nodes of LL

//        . For example, if the given linked list is 1->2->3->4->5 then your function should convert it to 1->3->5, and if the given linked list is 1->2->3->4 then convert it to 1->3.

        deleteAlternateNodes();
        printLL(head);

    }

    // 12. Delete alternate nodes of LL
    private static void deleteAlternateNodes() {
        if(head == null){
            return ;
        }

        Node current = head;

        while (current != null && current.nextNode != null){
            current.nextNode = current.nextNode.nextNode;
            current  = current.nextNode;
//            System.out.println(current.data);
        }

//        printLL(head);




    }

    // 9. Function to check if a singly linked list is palindrome.
    private static void checkIfLLIsPalindrome() {
        Stack<String> stack = new Stack<String>();
        Node current = head;

        while (current != null){
            stack.push(current.dataString);
            current = current.nextNode;
        }

        current = head;
        boolean flag = false;
        while (current != null){
            if(current.dataString == stack.pop()){
                flag = true;
            }else {
                flag = false;
                break;
            }
            current = current.nextNode;
        }

        if(flag){
            System.out.println("Linked list is a Palindrome !");
        }else {
            System.out.println("Not a Palindrome !");
        }
    }

    // 8. Rotate a Linked List
    private static void rotateLL(int k) {
        Node current = head;
        int count = 1;

        while(current != null && count != k){
            current = current.nextNode;
            count++;
        }

        Node nextOfCurrent = current.nextNode;
        Node newHead = nextOfCurrent;
        current.nextNode = null;

        while (nextOfCurrent.nextNode != null){
            nextOfCurrent = nextOfCurrent.nextNode;
        }

        nextOfCurrent.nextNode = head;
        head = newHead;

        printLL(head);
        System.out.println();
    }

    // 7.  Pairwise swap elements of a given linked list
    private static void pairwiseSwapLL() {
        Node current = head;

        while(current != null && current.nextNode != null ){
            int k = current.data;
            current.data = current.nextNode.data;
            current.nextNode.data = k;
            current = current.nextNode.nextNode;
        }
    }

    // 6. Program for n’th node from the end of a Linked List
    private static void nthNodeFromEndOfList(int k) {
       Node current = head;
       int count = 1;

       while (current != null){
           current = current.nextNode;
           count++;
       }

       int nthNodeFromEnd = count - k;
       current = head;
       for(int i = 1; i < nthNodeFromEnd; i++){
           current = current.nextNode;
       }

        System.out.println("nth Node from End of List : " + current.data);

    }

    private static void initiateLoop(Node existingNode, Node lastNode) {
        lastNode.nextNode = existingNode;
    }

    // 5.  Detect and Remove Loop in a Linked List
    private static Node detectLoop() {
        Node slow = head;
        Node fast = head.nextNode;

        while(slow != null && fast != null && fast.nextNode != null && slow != fast){
            slow = slow.nextNode;
            fast = fast.nextNode.nextNode;
        }

        if(slow == fast){
            System.out.println("Loop Detected!");
            detectLoopAndDelete(slow);
        }else {
            System.out.println("Loop not Detected!");
        }

        return null;
    }

    private static void detectLoopAndDelete(Node loop) {
        Node ptr1 = loop;
        Node ptr2 = loop;

        // Count the number of nodes in loop
        int count = 1,i;
        while(ptr1.nextNode != ptr2){
            ptr1 = ptr1.nextNode;
            count++;
        }

        // Fix one pointer to head
        ptr1 = head;

        // And the other pointer to k nodes after head
        ptr2 = head;
        for(i = 0; i < count; i++){
            ptr2 = ptr2.nextNode;
        }

        /*  Move both pointers at the same pace,
         they will meet at loop starting node */
        while (ptr2 != ptr1){
            ptr1 = ptr1.nextNode;
            ptr2 = ptr2.nextNode;
        }


        // Get pointer to the last node
        while (ptr2.nextNode != ptr1){
            ptr2 = ptr2.nextNode;
        }

        ptr2.nextNode = null;

        System.out.println("Loop Removed !");
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

    private static void insertAtBeginningString(String data1) {
        Node newNode = new Node();

        if(head == null){
            newNode.dataString = data1;
            head = newNode;
            return;
        }

        newNode.dataString = data1;
        newNode.nextNode = head;
        head = newNode;

    }

    private static Node findExistingNode(int data1){
        Node current = head;

        while(current != null && current.data != data1){
            current = current.nextNode;
        }

        return current;
    }
    private static void printLL(Node head1){
        Node current = head1;

        while(current != null){
            System.out.print( current.data+"  ");
            current = current.nextNode;
        }
    }

    private static void printLLString(Node head1){
        Node current = head1;

        while(current != null){
            System.out.print( current.dataString+"  ");
            current = current.nextNode;
        }
    }

}
