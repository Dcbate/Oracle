package leetcode.priorityQueue;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {


    public record Student(int id, String name,double cgpa) implements Comparable<Student> {

        // Override compareTo to define custom ordering based on priority.
        @Override
        public int compareTo(Student other) {
            // 1. Compare by CGPA in descending order
            if (this.cgpa != other.cgpa) {
                return Double.compare(other.cgpa, this.cgpa);
            }
            // 2. If CGPA is the same, compare by name in alphabetical order
            int nameComparison = this.name.compareTo(other.name);
            if (nameComparison != 0) {
                return nameComparison;
            }
            // 3. If both CGPA and name are the same, compare by id in ascending order
            return Integer.compare(this.id, other.id);
        }
    }

    static PriorityQueue<Student> getStudents(List<String> events){


        PriorityQueue<Student> priorityQueue = new PriorityQueue<>();

        events.forEach( s -> {
            if (s.startsWith("ENTER")){
                String[] s1 = s.split(" ");
                String name = s1[1];
                double cpda = Double.parseDouble(s1[2]);
                int id = Integer.parseInt(s1[3]);
                Student student = new Student(id,name,cpda);
                priorityQueue.add(student);
            }
            if (s.contains("SERVED")){
                priorityQueue.poll().name();
            }
        });
        return priorityQueue;
    }

    public static void main(String[] args) {
        // Sample events for testing
        List<String> events = Arrays.asList(
                "ENTER John 3.75 50",
                "ENTER Mark 3.8 24",
                "ENTER Shafaet 3.7 35",
                "SERVED",
                "SERVED",
                "ENTER Samiha 3.85 36",
                "SERVED",
                "ENTER Ashley 3.9 42",
                "ENTER Maria 3.6 46",
                "ENTER Anik 3.95 49",
                "ENTER Dan 3.95 50",
                "SERVED"
        );

        // Instantiate Priorities and process the events
        PriorityQueue<Student> students = getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            students.forEach(student -> System.out.println(student.name()));
        }

    }
}


