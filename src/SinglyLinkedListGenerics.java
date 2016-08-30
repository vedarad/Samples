/*
 * Created by sreenathkodedala on 8/2/16.
 */
public class SinglyLinkedListGenerics<T> {

    public static void main(String[] args){
        SinglyLinkedListGenerics sl = new SinglyLinkedListGenerics();
        System.out.println("List is empty: "+sl.isEmpty());
        sl.append("First");sl.append(" Second");sl.append("Last ");sl.append("Last-1 ");sl.append("First+1");sl.append("None");
        System.out.println("List is empty: "+sl.isEmpty());
        System.out.println("Lenght of list: "+sl.length());
        System.out.println("Last element of list: "+sl.tail().toString());
        System.out.println("First element of list: "+sl.head.toString());
        System.out.println("Length using recursion: "+sl.len(sl.head));
        //System.out.println("isCyclic: "+sl.isCyclic());
    }

    private static class Node<T>{
        private Node<T> next;
        private T data;

        public Node(T val){
            this.data = val;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    private Node head;

    public boolean isCyclic(){
        Node fast, slow;
        fast = slow = head;

        while(fast!=null && slow!=null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow)
                return true;
        }
        return false;
    }

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
        while(current!=null){
            length++;
            current = current.next;
        }
        return length;
    }

    public void append(T val){
        if(head == null){
            head = new Node(val);
            return;
        }
        tail().next = new Node(val);
    }

    public Node tail(){
        Node tail = head;
        while(tail.next!=null){
            tail = tail.next;
        }
        return tail;
    }
}
