
import java.util.EmptyStackException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author asus
 */
public class Stack {

    private Node first;
    private int size;

    public Stack() {
        first = null;
        size = 0;
    }

    //size method in stack called count, but there are same
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

    public int push(String value) {
        Node newNode = new Node(value);

        if (first == null) {
            first = newNode;
        } else {
            newNode.next = first;
            first = newNode;
        }

        size++;

        return size;
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
