package com.codecool;


public class LinkedList {

    private int size;
    private Node head;

    public int getSize() {
        return size;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void add(Object data) {

        if (head == null) {
            head = new Node(data);
        }

        Node currentNode = head;
        Node nodeToAdd = new Node(data);

        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }

        currentNode.setNext(nodeToAdd);
        size++;
    }

    public void add(Object data, int index) {

        if (head == null) {
            head = new Node(data);
        }

        Node nodeToAdd = new Node(data);
        Node currentNode = head;
        //i < index poniewaz przypisujesz juz kolejnego node'a, czyli wlasnie tego poszukiwanego!!!
        for (int i = 0; i < index && currentNode.getNext() != null; i++) {
            currentNode = currentNode.getNext();
        }
        //trzeba mu przypisac node'a ktory bedzie mial odniesienie do kolejnego node'a
        nodeToAdd.setNext(currentNode.getNext());
        currentNode.setNext(nodeToAdd);
        size++;
    }

    public Object get(int index) {
        Node currentNode = null;

        if (index < 0 || index >= getSize()) throw new IndexOutOfBoundsException();

        if (head != null) {
            currentNode = head;

            for (int i = 0; i <= index; i++) {
                currentNode = currentNode.getNext();
            }
        }
        return currentNode.getData();
    }

    public void remove() {

        if (head != null) {
            setHead(this.head.getNext());
        } else {
            throw new IllegalStateException();
        }
    }


    public void remove(int index) {

        if (index < 1 || index >= getSize()) throw new IndexOutOfBoundsException();
        if (head == null) throw new IllegalStateException();

        Node currentNode = head;

            for (int i = 0; i < index; i++) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(currentNode.getNext().getNext());
    }

    public String toString() {
        String output = "";

        if (head != null) {
            Node currentNode = head.getNext();
            while (currentNode != null) {
                output += currentNode.getData().toString() + " ";
                currentNode = currentNode.getNext();
            }

        }
        return output;
    }

    private class Node {

        Node nextNode;
        Object data;

        public Node(Object data) {
            this.nextNode = null;
            this.data = data;
        }

        public Object getData() {
            return data;
        }

        public Node getNext() {
            return nextNode;
        }

        public void setNext(Node nextValue) {
            nextNode = nextValue;
        }
    }
}