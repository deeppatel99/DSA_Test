public class LinkedList_DSA_Sheet {
    public static class Node{
        public int data;
        public Node nextNode;
    }

    public static Node head;

    public static void main(String[] args) {

        {
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

        System.out.println("Reverse a Linked List in group of given size K : \n");

        Node newHead = head;
        newHead = reverseLLOfSizeK(newHead,3);
        printLL(newHead);

        System.out.println();

    }

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
