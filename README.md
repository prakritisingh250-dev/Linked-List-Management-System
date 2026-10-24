# Linked List Management System

## Objective
A menu-driven Java console application that demonstrates common operations on singly and doubly linked lists.

## Language Used
Java (no external libraries required).

## Project Structure
```text
Linked-List-Management-System/
├── src/
│   ├── Main.java
│   ├── SinglyLinkedList.java
│   └── DoublyLinkedList.java
├── sample-output/
│   └── output.txt
├── docs/
│   └── (place your project report here, if required)
├── .gitignore
└── README.md
```

## Features

### Singly Linked List
- Insert at beginning, end, position, before a value, or after a value
- Delete from beginning, end, position, or by value
- Search, update, and display
- Count nodes, find minimum/maximum, and find middle
- Reverse, sort in ascending order, and remove duplicates

### Doubly Linked List
- All insertion and deletion operations listed above
- Search, update, display forward and backward
- Count nodes, find minimum/maximum, and find middle
- Reverse, sort in ascending order, and remove duplicates

### Additional Feature
- Comparison table for singly and doubly linked lists

## Requirements
- Java Development Kit (JDK 8 or newer)
- IntelliJ IDEA, Eclipse, VS Code with Java support, or a terminal

## How to Run

### Option 1: IntelliJ IDEA
1. Extract the project ZIP.
2. Open IntelliJ IDEA and select **Open**.
3. Select the `Linked-List-Management-System` folder.
4. Open `src/Main.java`.
5. Click the green Run icon beside `main`.

### Option 2: Terminal
From the project root directory, compile:
```bash
javac src/Main.java src/SinglyLinkedList.java src/DoublyLinkedList.java
```
Then run:
```bash
java -cp src Main
```

## Position Rule
Positions are 1-based. Position 1 refers to the first node. For an even number of nodes, the middle operation reports the second of the two middle nodes.

## Sorting and Duplicate Removal
- Sorting uses Bubble Sort by swapping node data.
- Duplicate removal keeps the first occurrence of each value.
- A `HashSet` is used to track values during duplicate removal; the linked list itself is implemented using custom nodes, not an array or built-in list collection.

## Time Complexity (Typical)
| Operation | Singly Linked List | Doubly Linked List |
|---|---:|---:|
| Insert at beginning | O(1) | O(1) |
| Insert at end | O(n) | O(1) using tail |
| Insert/delete at position | O(n) | O(n) |
| Search / display / count | O(n) | O(n) |
| Find minimum / maximum | O(n) | O(n) |
| Find middle | O(n) | O(n) |
| Reverse | O(n) | O(n) |
| Bubble sort | O(n²) | O(n²) |
| Remove duplicates | O(n) average with HashSet | O(n) average with HashSet |

## Sample Output
See `sample-output/output.txt`.

## Author
Add your name, roll number, course, and section here before submitting.
