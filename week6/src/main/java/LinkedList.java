
import java.lang.reflect.Array;

/**
 *
 * @author Mercy Soh Xi En
 */
public class LinkedList {

    protected Node first;
    protected Node last;
    protected int size;

    public LinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     *Get the size of Linked list.
     *
     * @return size or elements in Linked list
     */
    public int size() {
        return size;
    }

    /**
     * Get the value or element from the specified position of Linked list.
     *
     * @param pos is use for the specified position
     * @return value or element of the specified position from Linked list
     * @throws IndexOutOfBoundsException when the position is invalid
     */
    public Task get(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Illegal position supplied.");
        }
        Node current = first;
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
    }

    /**
     *Adds a task to the end of the Linked list.
     *
     * @param value is use for the specified value(Task)
     * @return true when added else return false
     */
    public boolean add(Task value) {
        Node newNode = new Node(value);

        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
        return true;
    }

    /**
     * Adds a task to a specified position in the Linked list.
     *
     * @param value is use for the specified value(Task)
     * @param pos is use for the specified position
     * @return true when added else return false
     * @throws IndexOutOfBoundsException when position invalid
     */
    public boolean add(Task value, int pos) {

        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Invalid position provided.");
        }

        if (pos == 0) {
            Node newNode = new Node(value);
            newNode.next = first;
            first = newNode;
        }
        Node current = first;

        for (int i = 0; i < pos - 1; i++) {
            current = current.next;
        }

        Node newNode = new Node(value);
        newNode.next = current.next;
        current.next = newNode;
        size++;
        return true;
    }

    /**
     * Check the Linked list is empty or not.
     *
     * @return true when Linked list is empty else return false
     */
    public boolean isEmpty() {
        return first == null;

    }

    /**
     * Return the last value in Linked list.
     *
     * @return last value in the Linked list
     */
    public Task tail() {
        return last.data;
    }

    /**
     * Removed the task from Linked list.
     *
     * @param value is use for the specified value(task)
     * @return true when specified value removed else return false
     */
    public boolean remove(Task value) {

        Node temp = first, prev = null;

        // If first node itself holds the value to be deleted
        if (temp.data == value) {
            first = temp.next; // Changed first
            size--;
            return true;
        }

        // Search for the value to be deleted, keep track of
        // the previous node as we need to change temp.next       
        //Using toString in here to compare the value else it keep return false
        while (temp != null && !temp.data.toString().equals(value.toString())) {
            prev = temp;
            temp = temp.next;
        }

        // If value was not present in linked list
        if (temp == null) {
            return false;
        }

        // Unlink the node from linked list
        prev.next = temp.next;
        size--;
        return true;
    }

    /**
     * Returns an array contained all of the task in the Linked list.
     *
     * @return an array of all the value in Linked list
     */
    public Task[] toArray() {

        Task[] taskArray = new Task[size];
        Node current = first;
        for (int i = 0; i < size; i++) {
            taskArray[i] = current.data;
            current = current.next;
        }

        return taskArray;
    }

    /**
     * Returns task of position in the Linked list.
     *
     * @param value is use for the specified value
     * @return position of specified value in Linked list
     */
    public int indexOf(Task value) {

        if (first == null) {
            return -1;
        }

        Node current = first;

        for (int i = 0; i < size; i++) {
            if (current.data.toString().equals(value.toString())) {
                return i;
            }
            current = current.next;
        }
        return -1;

    }

    protected static class Node {

        protected Task data;
        protected Node next;

        public Node(Task value) {
            this.data = value;
            this.next = null;
        }

    }
}
