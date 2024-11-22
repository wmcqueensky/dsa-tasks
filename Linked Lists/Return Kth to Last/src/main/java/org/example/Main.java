package org.example;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    static LinkedList<Integer> kToLast(LinkedList<Integer> list, int k) {
        if (list.isEmpty() || k <= 0) {
            return null;
        }

        ListIterator<Integer> p1 = list.listIterator();
        ListIterator<Integer> p2 = list.listIterator();

        for (int i=0; i<k; i++) {
            if (!p1.hasNext()) {
                return null;
            }
            p1.next();
        }

        while (p1.hasNext()) {
            p1.next();
            p2.next();
        }

        LinkedList<Integer> newList = new LinkedList<Integer>();

        while (p2.hasNext()) {
            newList.add(p2.next());
        }

        return newList;
    }

    public static void main(String args[]) {
        LinkedList<Integer> mockList = new LinkedList<Integer>();
        mockList.add(3);
        mockList.add(1);
        mockList.add(7);
        mockList.add(4);
        mockList.add(9);

        mockList = kToLast(mockList, 3);
        System.out.println("New list from 3rd to last: " + mockList);
    }



}