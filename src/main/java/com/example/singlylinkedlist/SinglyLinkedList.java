package com.example.singlylinkedlist;

import java.util.StringJoiner;

public class SinglyLinkedList<E> implements LinkedList<E> {

    private Node head;
    private Node tail;

    public SinglyLinkedList(){
        head = null;
        tail = null;
    }

    @Override
    public void addFirst(E element) {

        Node node = new Node(element, head);//creates node and points to current head of linkedlist

        if(head == null){
            head = node;//moves head to new node
            tail = head;
        }else{
            head = node;
        }
    }

    @Override
    public void addLast(E element) {
        Node node = new Node(element, null);//creates node and points to null of linkedlist

        if (tail == null){
            tail = node;
            head = tail;
        }else {
            tail.next = node;
            tail = node;
        }
    }

    @Override
    public E pollFirst() {
       E element;
       if (head == null){
           element = null;
       }else{
           element = head.element;
           Node next = head.next;
           head.next = null;//getting rid of the first newly added node
           head = next;//puts the "head" title to the next node
       }
       return element;
    }

    @Override
    public E pollLast() {
        E element;
        if(tail == null){
            element = null;
        }else {
            element= tail.element;

            if (head == tail){
                head = null;
                tail = null;
            }else{
                Node current = head;
                Node previous = head;
                while (current.next != null){
                    previous = current;
                    current = current.next;
                }
                tail = previous;
                tail.next = null;
            }
        }
        return element;
    }

    @Override
    public E peekFirst() {
        return head.element;
    }

    @Override
    public E peekLast() {
        return tail.element;
    }

    @Override
    public void clear() {
        Node current = head;
        while (current.next != null){
            Node next = current.next;
            current.next = null;
            current = next; //moves to the next node while the above erases the previous node
        }
        head = null;
        tail = null;
    }

    @Override
    public boolean contains(E element) {
        boolean contains = false;
        Node current = head;
        while (current != null){
            Node next = current.next;
            if(current.element == element){
                contains = true;
                break;
            }
                current = next;
        }
        return contains;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder("[");
        StringJoiner Joiner = new StringJoiner(", ");
        Node current = head;

            while (current != null){
                Joiner.add(current.element.toString());
                current = current.next;
            }

        builder.append(Joiner);
        builder.append("]");
        return builder.toString();


    }

    private class Node {

        Node next;
        E element;

        public Node(E element, Node next){
            this.element = element;
            this.next = next;
        }
    }
}
