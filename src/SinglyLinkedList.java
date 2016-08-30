/**
 * Created by sreenathkodedala on 8/2/16.
 */
public class SinglyLinkedList {

    public static void main(String[] args){
        SinglyLinkedList sl = new SinglyLinkedList();
        System.out.println("List is empty: "+sl.isEmpty());
        sl.append("First");sl.append(" Second");sl.append("Last ");sl.append("Last-1 ");sl.append("First+1");sl.append("None");
        System.out.println("List is empty: "+sl.isEmpty());
        System.out.println("Lenght of list: "+sl.length());
        System.out.println("Last element of list: "+sl.tail().toString());
        System.out.println("First element of list: "+sl.head.toString());
        System.out.println("Length using recursion: "+sl.len(sl.head));
    }

    private static class Node{
        String data;
        Node next;

        public Node(String val){
            this.data = val;
        }

        public String toString(){
            return this.data;
        }
    }

    Node head;

    public boolean isEmpty(){
        return length()==0;
    }

    public int len(Node current){
        int count = 0;
        if(current == null)
            return count;
        return 1+len(current.next);
    }

    public int length(){
        int length = 0;
        Node current = head;

        while(current!=null) {
            length++;
            current = current.next;
        }
        return length;
    }

    public void append(String data){
        if(head == null){
            head = new Node(data);
            return;
        }
        tail().next = new Node(data);
    }

    public Node tail(){
        Node tail = head;
        while(tail.next!=null){
            tail = tail.next;
        }
        return tail;
    }
}
