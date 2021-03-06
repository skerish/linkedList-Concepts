package linkedList;

public class DoublyLinkedList {

    private static class Node{

        private int data;
        private Node prev;
        private Node next;

        public Node(int data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private int size = 0;                                     // Initial state
    private Node head = null;
    private Node tail = null;

    @Override
    public String toString() {
        StringBuilder response = new StringBuilder();
        response.append("[ ");
        Node temp = this.head;
        while (temp != null){
            response.append(temp.data);
            if (temp.next != null){
                response.append(" <==> ");
            }
            temp = temp.next;
        }
        response.append(" ]");
        return response.toString();
    }

    private void insertHead(int data){                         // (ctrl + fn + f6) => to change the function name safely.
//        Node newNode = new Node(data, null, this.head);
//        this.head = newNode;

        this.head = new Node(data, null, this.head);
        size++;
    }

    private void insertAfter(int data, Node node){
        Node newNode = new Node(data, node, node.next);
        node.next = newNode;
        node.next.prev = newNode;
        size++;
    }

    public void insert(int data){
        if(head == null){
            insertHead(data);
        }
        else{
            Node temp = this.head;
            while (temp.next != null){
                temp = temp.next;
            }
            insertAfter(data, temp);
        }
    }

    public int deleteHead(){
        int response = -1;
        Node temp = this.head;
        if(temp.next != null){
            response = temp.data;
            this.head = temp.next;
            size--;
        }
        return response;
    }

    public int deleteAfter(Node preNode){
        int response = preNode.next.data;
        Node temp = preNode.next;
        preNode.next = temp.next;
        temp.next.prev = preNode;
        return response;
    }

    public int delete(int data){
        int response = -1;
        if(this.head == null){
            System.out.println("List is empty!");
        }
        else{
            Node temp = this.head;
            while (temp.next != null){
                   if(temp.next.data == data){
                       response = deleteAfter(temp);
                       break;
                   }
                temp = temp.next;
            }
        }
        return response;
    }

    public static void main(String[] args) {                   // (fn + shift + f10) => to run the main method
        DoublyLinkedList linkedList = new DoublyLinkedList();
        for (int i = 0; i < 5; i++) {
            linkedList.insert(i+1);
        }
        System.out.println(linkedList);
        int val1 = linkedList.deleteHead();
        System.out.println(linkedList);
        linkedList.delete(4);
        System.out.println(linkedList);
    }
}
