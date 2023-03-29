
import java.util.EmptyStackException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author asus
 */
public class boundedStack {
    private static final int INITIAL_CAPACITY = 10;
    private int capacity;
    private Node first;
    private int size;
    
     public boundedStack() {
        first = null;
        size = 0;
        capacity = INITIAL_CAPACITY;
    }
     
      public boundedStack(int capacity) {
        first = null;
        size = 0;
        capacity = INITIAL_CAPACITY;
    }
      
       public int count() {
        return size;
    }

    public boolean isEmpty() {
        if (first == null) {
            return true;
        }
        return false;
    }

    public String peek() {
        if (isEmpty() == true) {
            throw new EmptyStackException();
        }
//        Node current = first;
//        while (current.next != null) {
//            current = current.next;
//        }
        return first.data;
    }

    public boolean push(String value) {
       
        if (isFull()) {
           throw new StackFullException("No space available in stack");
        } 
        Node newNode = new Node(value);
         if (first == null) {
            first = newNode;
        } else {
            newNode.next = first;
            first = newNode;
        }

        size++;
        return true;
    }

    public String pop() {
        if (isEmpty() == true) {
            throw new EmptyStackException();
        }
        String original = first.data;
        first = first.next;
        size--;
        return original;
    }
    
    public boolean isFull() {
        return size >= capacity;
    }
    
    private static class Node {

        private String data;
        private Node next;

        public Node(String value) {
            this.data = value;
            this.next = null;
        }

        public Node hasNext() {
            return this.next = null;
        }
    }
}

 
