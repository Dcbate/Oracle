# Java Priority Queue

In computer science, a **priority queue** is an abstract data type which is like a regular queue, but where additionally each element has a "priority" associated with it. In a priority queue, an element with high priority is served before an element with low priority.

In this problem, we will test your knowledge on Java Priority Queue.

## Problem Statement

There are a number of students in a school who wait to be served. Two types of events, `ENTER` and `SERVED`, can take place, which are described below:

- **ENTER**: A student with some priority enters the queue to be served.
- **SERVED**: The student with the highest priority is served (removed) from the queue.

A unique ID is assigned to each student entering the queue. The queue serves the students based on the following criteria (priority criteria):

1. The student having the highest **Cumulative Grade Point Average (CGPA)** is served first.
2. Any students having the same CGPA will be served by name in ascending case-sensitive alphabetical order.
3. Any students having the same CGPA and name will be served in ascending order of the ID.

### Classes to Implement

Create the following two classes:

1. **Student Class**
    - The Student class should implement:
        - A constructor: `Student(int id, String name, double cgpa)`
        - Method `int getID()` to return the ID of the student.
        - Method `String getName()` to return the name of the student.
        - Method `double getCGPA()` to return the CGPA of the student.

2. **Priorities Class**
    - The Priorities class should implement:
        - Method `List<Student> getStudents(List<String> events)` to process all the given events and return all the students yet to be served in the priority order.

### Input Format

- The first line contains an integer, **n**, describing the total number of events.
- Each of the next **n** lines will be of the following two forms:
    - **ENTER name CGPA id**: The student to be added has name, CGPA, and ID.
    - **SERVED**: The highest priority student is removed from the queue.

### Constraints

- \( 2 \leq n \leq 1000 \)
- \( 0 \leq CGPA \leq 4.00 \)
- \( 1 \leq |name| \leq 30 \)
- \( 1 \leq id \leq 10^5 \)

### Output Format

- For each case, print each remaining student's name on a new line.
- If there are no students yet to be served, print `EMPTY`.

### Sample Input

12

ENTER John 3.75 50

ENTER Mark 3.8 24

ENTER Shafaet 3.7 35

SERVED

SERVED

ENTER Samiha 3.85 36

SERVED

ENTER Ashley 3.9 42

ENTER Maria 3.6 46

ENTER Anik 3.95 49

ENTER Dan 3.95 50

SERVED

### Sample Output
Dan

Ashley

Shafaet

Maria

### Explanation

In this case, the number of events is 12. Let the name of the queue be `Q`.

- **Event 1**: John is added to Q. So, it contains (John, 3.75, 50).

- **Event 2**: Mark is added to Q. So, it contains (John, 3.75, 50) and (Mark, 3.8, 24).

- **Event 3**: Shafaet is added to Q. So, it contains (John, 3.75, 50), (Mark, 3.8, 24), and (Shafaet, 3.7, 35).

- **Event 4**: Mark is served as he has the highest CGPA. So, Q contains (John, 3.75, 50) and (Shafaet, 3.7, 35).

- **Event 5**: John is served next as he has the highest CGPA. So, Q contains (Shafaet, 3.7, 35).

- **Event 6**: Samiha is added to Q. So, it contains (Shafaet, 3.7, 35) and (Samiha, 3.85, 36).

- **Event 7**: Samiha is served as she has the highest CGPA. So, Q contains (Shafaet, 3.7, 35).

- **Event 8**: Four more students are added to Q.

Following all events, the remaining students are printed based on the priority order: `Dan`, `Ashley`, `Shafaet`, `Maria`.
