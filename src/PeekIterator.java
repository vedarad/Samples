import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by skoded001c on 8/8/16.
 */
public class PeekIterator<T> implements Iterator<T>{
    private Iterator<T> iterator;
    private T nextItem;

    public PeekIterator(Iterator iterator){
        this.iterator = iterator;
    }
    @Override
    public boolean hasNext() {
        if(nextItem!=null)
            return true;

        if(iterator.hasNext())
            nextItem = iterator.next();

        return nextItem!=null;
    }

    @Override
    public T next() {
        if(!hasNext())
            throw (new NoSuchElementException("Iterator has no elements left."));

        T toReturn = nextItem;
        nextItem = null;
        return toReturn;
    }

    public T peek(){

        if(!hasNext())
            throw (new NoSuchElementException("Iterator has no elements left."));

        return nextItem;
    }

    public T pop(){
        if(!hasNext())
            throw (new NoSuchElementException("Iterator has no elements left."));

        T temp = nextItem;
        iterator.remove();
        nextItem = null;
        return temp;
    }

    public static void main(String []args){
        ArrayList<Integer> li = new ArrayList();
        li.add(22);li.add(33);li.add(44);li.add(55);li.add(66);li.add(77);li.add(88);

        PeekIterator pi = new PeekIterator(li.iterator());
        //System.out.println(pi.next());
        System.out.println(pi.peek());
        //System.out.println(pi.next());
        System.out.println(pi.pop());
        System.out.println(pi.peek());
        System.out.println(pi.next());
    }
}


