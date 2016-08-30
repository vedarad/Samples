/**
 * Created by sreenathkodedala on 8/2/16.
 */
public class DoublyLinkedList<T> {

    public static void main(String[] args){
        DoublyLinkedList dl = new DoublyLinkedList();
        System.out.println("List is empty: "+dl.isEmpty());
        dl.insertFirst("First");dl.insertLast("Last");
        System.out.println("List is empty: "+dl.isEmpty());
        System.out.println("List size: "+dl.getSize());
    }

    private static class Node<T>{
        T data;
        Node next, prev;

        public Node(T data){
            this.data = data;
        }

        public String toString(){
            return data.toString();
        }
    }

    Node first, last;
    int size = 0;

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void insertFirst(T data){
        Node newNode = new Node(data);
        if(first==null){
            first = newNode;
            last = first;
        }else{
            first.prev = newNode;
            newNode.next = first;
        }
        size++;
    }

    public void insertLast(T data){
        Node newNode = new Node(data);
        if(first==null){
            first = newNode;
            last = first;
        }else{
            newNode.prev = last;
            last.next = newNode;
            last = newNode;
        }
        size++;
    }
}
