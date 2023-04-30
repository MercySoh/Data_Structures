/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures;

import ApplicationData.Appointments;

/**
 *
 * @author asus
 */
public class PriorityQueue extends LinkedList {

    private int capacity;

    public PriorityQueue() {

    }

    public PriorityQueue(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Get the size of Queue.
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

    /**
     * Check the Queue is full or not.
     *
     * @return true when Queue size is over than capacity else return false
     */
    public boolean isFull() {
        return size >= capacity;
    }
}
