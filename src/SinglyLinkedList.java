import java.util.HashSet;
import java.util.Set;

/**
 * Implements a singly linked list of integers.
 * Each node stores data and a reference to the next node.
 */
public class SinglyLinkedList {
    private static class Node {
        private int data;
        private Node next;

        private Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public boolean isEmpty() {
        return head == null;
    }

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        System.out.println("Node inserted at the beginning.");
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            head = newNode;
            System.out.println("Node inserted at the end.");
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
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
        for (int i = 1; current != null && i < position - 1; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Invalid position.");
            return;
        }

        Node newNode = new Node(data);
        newNode.next = current.next;
        current.next = newNode;
        System.out.println("Node inserted at position " + position + ".");
    }

    public void insertAfterValue(int target, int data) {
        Node current = findNode(target);
        if (current == null) {
            System.out.println("Value " + target + " was not found.");
            return;
        }

        Node newNode = new Node(data);
        newNode.next = current.next;
        current.next = newNode;
        System.out.println("Node inserted after " + target + ".");
    }

    public void insertBeforeValue(int target, int data) {
        if (isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }
        if (head.data == target) {
            insertAtBeginning(data);
            return;
        }

        Node previous = head;
        Node current = head.next;
        while (current != null && current.data != target) {
            previous = current;
            current = current.next;
        }
        if (current == null) {
            System.out.println("Value " + target + " was not found.");
            return;
        }

        Node newNode = new Node(data);
        previous.next = newNode;
        newNode.next = current;
        System.out.println("Node inserted before " + target + ".");
    }

    public void deleteFromBeginning() {
        if (isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }
        System.out.println("Deleted node: " + head.data);
        head = head.next;
    }

    public void deleteFromEnd() {
        if (isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }
        if (head.next == null) {
            System.out.println("Deleted node: " + head.data);
            head = null;
            return;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        System.out.println("Deleted node: " + current.next.data);
        current.next = null;
    }

    public void deleteAtPosition(int position) {
        if (position < 1 || isEmpty()) {
            System.out.println(isEmpty() ? "The list is empty." : "Invalid position.");
            return;
        }
        if (position == 1) {
            deleteFromBeginning();
            return;
        }

        Node current = head;
        for (int i = 1; current.next != null && i < position - 1; i++) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Invalid position.");
            return;
        }

        System.out.println("Deleted node: " + current.next.data);
        current.next = current.next.next;
    }

    public void deleteByValue(int target) {
        if (isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }
        if (head.data == target) {
            deleteFromBeginning();
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != target) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Value " + target + " was not found.");
            return;
        }

        current.next = current.next.next;
        System.out.println("Deleted the first occurrence of " + target + ".");
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

    public void display() {
        if (isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }

        Node current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
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
        Node previous = null;
        Node current = head;

        while (current != null) {
            Node nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }
        head = previous;
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
        Node previous = null;

        while (current != null) {
            if (seenValues.contains(current.data)) {
                previous.next = current.next;
            } else {
                seenValues.add(current.data);
                previous = current;
            }
            current = current.next;
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
}
