import java.util.HashSet;
import java.util.Set;

/**
 * Implements a doubly linked list of integers.
 * Each node stores data and references to both previous and next nodes.
 */
public class DoublyLinkedList {
    private static class Node {
        private int data;
        private Node previous;
        private Node next;

        private Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;

    public boolean isEmpty() {
        return head == null;
    }

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
        System.out.println("Node inserted at the beginning.");
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        System.out.println("Node inserted at the end.");
    }

    public void insertAtPosition(int data, int position) {
        if (position < 1) {
            System.out.println("Invalid position. Positions start from 1.");
            return;
        }
        if (position == 1) {
            insertAtBeginning(data);
            return;
        }

        Node current = head;
        for (int i = 1; current != null && i < position; i++) {
            current = current.next;
        }
        if (current == null) {
            if (position == countNodes() + 1) {
                insertAtEnd(data);
            } else {
                System.out.println("Invalid position.");
            }
            return;
        }

        Node newNode = new Node(data);
        Node previousNode = current.previous;
        newNode.previous = previousNode;
        newNode.next = current;
        previousNode.next = newNode;
        current.previous = newNode;
        System.out.println("Node inserted at position " + position + ".");
    }

    public void insertAfterValue(int target, int data) {
        Node current = findNode(target);
        if (current == null) {
            System.out.println("Value " + target + " was not found.");
            return;
        }
        if (current == tail) {
            insertAtEnd(data);
            return;
        }

        Node newNode = new Node(data);
        newNode.next = current.next;
        newNode.previous = current;
        current.next.previous = newNode;
        current.next = newNode;
        System.out.println("Node inserted after " + target + ".");
    }

    public void insertBeforeValue(int target, int data) {
        Node current = findNode(target);
        if (current == null) {
            System.out.println("Value " + target + " was not found.");
            return;
        }
        if (current == head) {
            insertAtBeginning(data);
            return;
        }

        Node newNode = new Node(data);
        newNode.previous = current.previous;
        newNode.next = current;
        current.previous.next = newNode;
        current.previous = newNode;
        System.out.println("Node inserted before " + target + ".");
    }

    public void deleteFromBeginning() {
        if (isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }
        System.out.println("Deleted node: " + head.data);
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.previous = null;
        }
    }

    public void deleteFromEnd() {
        if (isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }
        System.out.println("Deleted node: " + tail.data);
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.previous;
            tail.next = null;
        }
    }

    public void deleteAtPosition(int position) {
        if (position < 1 || position > countNodes()) {
            System.out.println(isEmpty() ? "The list is empty." : "Invalid position.");
            return;
        }
        if (position == 1) {
            deleteFromBeginning();
            return;
        }
        if (position == countNodes()) {
            deleteFromEnd();
            return;
        }

        Node current = nodeAtPosition(position);
        current.previous.next = current.next;
        current.next.previous = current.previous;
        System.out.println("Deleted node: " + current.data);
    }

    public void deleteByValue(int target) {
        Node current = findNode(target);
        if (current == null) {
            System.out.println("Value " + target + " was not found.");
            return;
        }
        if (current == head) {
            deleteFromBeginning();
        } else if (current == tail) {
            deleteFromEnd();
        } else {
            current.previous.next = current.next;
            current.next.previous = current.previous;
            System.out.println("Deleted the first occurrence of " + target + ".");
        }
    }

    public void search(int target) {
        Node current = head;
        int position = 1;
        while (current != null) {
            if (current.data == target) {
                System.out.println("Value found at position " + position + ".");
                return;
            }
            current = current.next;
            position++;
        }
        System.out.println("Value " + target + " was not found.");
    }

    public void update(int oldValue, int newValue) {
        Node current = findNode(oldValue);
        if (current == null) {
            System.out.println("Value " + oldValue + " was not found.");
            return;
        }
        current.data = newValue;
        System.out.println("First occurrence updated successfully.");
    }

    public void displayForward() {
        if (isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }
        Node current = head;
        System.out.print("NULL <-> ");
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("NULL");
    }

    public void displayBackward() {
        if (isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }
        Node current = tail;
        System.out.print("NULL <-> ");
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.previous;
        }
        System.out.println("NULL");
    }

    public int countNodes() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void findMaximum() {
        if (isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }
        int maximum = head.data;
        for (Node current = head.next; current != null; current = current.next) {
            if (current.data > maximum) {
                maximum = current.data;
            }
        }
        System.out.println("Maximum value: " + maximum);
    }

    public void findMinimum() {
        if (isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }
        int minimum = head.data;
        for (Node current = head.next; current != null; current = current.next) {
            if (current.data < minimum) {
                minimum = current.data;
            }
        }
        System.out.println("Minimum value: " + minimum);
    }

    public void findMiddle() {
        if (isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Middle element: " + slow.data
                + (countNodes() % 2 == 0 ? " (second middle for even-sized list)" : ""));
    }

    public void reverse() {
        Node current = head;
        while (current != null) {
            Node temporary = current.previous;
            current.previous = current.next;
            current.next = temporary;
            current = current.previous;
        }

        Node temporaryHead = head;
        head = tail;
        tail = temporaryHead;
        System.out.println("List reversed.");
    }

    public void sort() {
        if (head == null || head.next == null) {
            System.out.println("List sorted.");
            return;
        }

        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            while (current.next != null) {
                if (current.data > current.next.data) {
                    int temporary = current.data;
                    current.data = current.next.data;
                    current.next.data = temporary;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);

        System.out.println("List sorted in ascending order.");
    }

    public void removeDuplicates() {
        Set<Integer> seenValues = new HashSet<>();
        Node current = head;

        while (current != null) {
            if (seenValues.contains(current.data)) {
                Node duplicate = current;
                current = current.next;
                if (duplicate == tail) {
                    tail = duplicate.previous;
                    if (tail != null) {
                        tail.next = null;
                    }
                } else if (duplicate == head) {
                    head = duplicate.next;
                    if (head != null) {
                        head.previous = null;
                    }
                } else {
                    duplicate.previous.next = duplicate.next;
                    duplicate.next.previous = duplicate.previous;
                }
            } else {
                seenValues.add(current.data);
                current = current.next;
            }
        }

        if (head == null) {
            tail = null;
        }
        System.out.println("Duplicate values removed.");
    }

    private Node findNode(int value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    private Node nodeAtPosition(int position) {
        Node current = head;
        for (int i = 1; i < position; i++) {
            current = current.next;
        }
        return current;
    }
}
