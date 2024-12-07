package org.example;

import java.util.LinkedList;

public class Main {
    public static void middleNode(LinkedList<Integer> list) {
        if (list.size() < 3) return;
        int index = list.size() / 2;
        list.remove(index);
    }
}