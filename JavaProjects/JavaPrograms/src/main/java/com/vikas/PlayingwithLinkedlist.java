package com.vikas;

import java.util.LinkedList;

public class PlayingwithLinkedlist {
    public static void main(String[] args) {
        LinkedList<Integer> ll=new LinkedList<>();
        ll.add(1);
        ll.add(0,2);
        ll.remove(0);
        ll.addFirst(3);
        System.out.println(ll);
        for (int i = 0; i < ll.size(); i++) {
            System.out.print(ll.get(i) + " ");
        }
    }
}
