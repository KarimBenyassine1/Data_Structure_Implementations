public class Node{
    Node next;
    int val;
    public Node(int val){
        this.val = val;
    }

}

public class LinkedList{
    Node head;

    public void append(int val){
        if(head==null){
            head = new Node(val);
            return;
        }

        Node current = this;
        while(current.next!=null){
            current =current.next;
        }
        current.next = new Node(val);
    }

    public void prepend(int val){
        Node newHead = new Node(val);
        newHead.next =  head;
        head = newHead;
    }

    public void deleteValue(int val){
        if (head==null){
            return;
        }

        if (head.val ==val){
            head =head.next;
            return;
        }

        Node current = head;
        while(current.next!=null){
            if(current.next.val == val){
                current.next= current.next.next;
                return;
            }
            current = current.next;
        }

    }
}