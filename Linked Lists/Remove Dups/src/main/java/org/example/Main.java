package org.example;

import java.util.HashSet;

public class Main {
    class Node {
        Node next = null;
        int data;

        public Node(int d) {
            data = d;
        }

        void appendToTail(int d) {
            Node end = new Node(d);
            Node n = this;

            while(n.next != null) {
                n = n.next;
            }

            n.next = end;
        }

        Node deleteNode(Node head, int d) {
            Node n = head;

            if(n.data == d) {
                return head;
            }

            while(n.next != null) {
                if (n.next.data == d) {
                    n.next = n.next.next;
                    return head;
                }
                n = n.next;
            }
            return head;
        }
    }

    void deleteDups(Node n) {
        HashSet<Integer> set = new HashSet<Integer>();
        Node previous = null;
        while(n != null) {
            if(set.contains(n.data)) {
                previous.next = n.next;
            } else {
                set.add(n.data);
                previous = n;
            }
            n = n.next;
        }
    }

    void deleteDupsWithoutBuffer(Node head) {
        Node current = head;
        while(current != null) {
            Node runner = current;
            while(runner.next != null) {
                if(current.data == runner.next.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }
}