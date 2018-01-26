package com.codecool;

public class App 
{

    public static LinkedList linkedList;

    public static void main(String[] args) {

        linkedList = new LinkedList();

        linkedList.add("pies");
        linkedList.add("kot");
        linkedList.add("mysz");
        linkedList.add("kon");
        linkedList.add("swiniak");

        System.out.println(linkedList);
        System.out.println(".size(): " + linkedList.getSize());
        System.out.println(".get(3): " + linkedList.get(3));
        System.out.println(".size(): " + linkedList.getSize());
        linkedList.remove();
        linkedList.remove(3);
        System.out.println("Print again: " + linkedList);
    }
}