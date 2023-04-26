package DataStructures;

import ApplicationData.Appointments;
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
     *Get the size of appointments list.
     *
     * @return size in appointments list
     */
    public int size() {
        return size;
    }

    /**
     * Get the value from the specified position of appointments list.
     *
     * @param pos is use for the specified position
     * @return value of the specified position from appointments list
     * @throws IndexOutOfBoundsException when the position is less than 0 or greater than size 
     */
    public Appointments get(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Illegal position supplied.");
        }
        Node current = first;
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
    }

  

    protected static class Node {

        protected Appointments data;
        protected Node next;

        public Node(Appointments value) {
            this.data = value;
            this.next = null;
        }

    }
}
