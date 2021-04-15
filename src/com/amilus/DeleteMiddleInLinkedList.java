package com.amilus;

public class DeleteMiddleInLinkedList {
    /*
    * Delete middle element in given linkedlist
    * Time Complexity O(n)
    */

    public Node deleteMiddle(Node node) {
        if (node == null) {
            return null;
        }
        if (node.getLink() == null) {
            return null;
        }

        Node first = node, second = node, prev = null;
        while (second.getLink() != null && second.getLink().getLink() != null) {
            prev = first;
            first = first.getLink();
            second = second.getLink().getLink();
        }

        if (prev != null) {
            prev.setLink(first.getLink());
            first.setLink(null);
        }

        return node;
    }

    public void printLL(Node node) {
        if (node == null) {
            System.out.println("Linked list is empty");
        }
        while (node != null) {
            System.out.println(node.getValue());
            node = node.getLink();
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1, null);
        node.setLink(new Node(2, null));
        node.getLink().setLink(new Node(3, null));
        node.getLink().getLink().setLink(new Node(4, null));
        node.getLink().getLink().getLink().setLink(new Node(5, null));

        DeleteMiddleInLinkedList deleteMiddleLL = new DeleteMiddleInLinkedList();
        System.out.println("Original LinkedList : ");
        deleteMiddleLL.printLL(node);

        System.out.println("Deleted Middle LinkedList : ");
        node = deleteMiddleLL.deleteMiddle(node);
        deleteMiddleLL.printLL(node);

    }
}

class Node {
    int value;
    Node link;

    public Node(int value, Node link) {
        this.value = value;
        this.link = link;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLink() {
        return link;
    }

    public void setLink(Node link) {
        this.link = link;
    }
}

