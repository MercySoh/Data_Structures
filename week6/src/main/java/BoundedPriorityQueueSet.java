
import java.util.NoSuchElementException;

/**
 *
 * @author Mercy
 */
public class BoundedPriorityQueueSet extends LinkedList{

    private static final int INITIAL_CAPACITY = 10;
    private int capacity;

    public BoundedPriorityQueueSet(int capacity) {
        this.capacity = capacity;
    }
    
    /**
     *Get the size of Queue.
     *
     * @return size in Queue
     */
    @Override
    public int size() {
        return super.size(); 
    }

    /**
     * Check the Queue is empty or not.
     *
     * @return true when Queue is empty else return false
     */
    @Override
    public boolean isEmpty() {
        return super.isEmpty(); 
    }
    
    public boolean isFull() {
        return size >= capacity;
    }

    /**
     *Adds a task to the Queue.
     *
     * @param value is use for the specified value(Task)
     * @return position where task added
     * @throws IllegalStateException when queue is full
     * @throws DuplicateElementException when task is duplicate
     */
    @Override
    public boolean add(Task value) {
         Node newNode = new Node(value);
        if(isEmpty()){
            first = newNode;
            last = newNode;
        }else if(isFull()){
            throw new IllegalStateException("Task is full.");
        }else if(value.equals(this.first.data)){
           throw new DuplicateElementException("The task is duplicate.");
        }else{
            Node current = first.next;
            Node previous = first;
            
            while(!current.data.equals(value)){
                previous = current;
                current = current.next;
            }
            
            previous.next = newNode;
            newNode.next = current;
        }
        
        size++;
        
//        for (int i = 0; i < size; i++)
//                return i;
//            }
     
        return super.add(value); 
    }

    /**
     *Peeks first task from the Queue.
     *
     * @return first task when the Queue not empty
     * @throws NoSuchElementException when queue is empty
     */
    public Task peek() {
        if (isEmpty() == true) {
            throw new NoSuchElementException();
        }
        return first.data;
    }
    
     /**
     *Remove first task from the Queue.
     *
     * @return first task when removed
     * @throws NoSuchElementException when queue is empty
     */
    public Task remove() {
        if (isEmpty() == true) {
            throw new NoSuchElementException();
        }
        Task original = first.data;
        
        size--;
        return original;
    }
}
