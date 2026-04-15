import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Create student objects using sample names
        Student student1 = new Student("S2400450", "Unish Bhattarai", "unish@example.com");
        Student student2 = new Student("S2400451", "Student one", "student1@example.com");
        Student student3 = new Student("S2400452", "Student two", "student2@example.com");
        Student student4 = new Student("S2400453", "Student three", "student3@example.com");

        // Create course objects
        Course course1 = new Course("IT101", "Introduction to Computing", 2);
        Course course2 = new Course("IT201", "Object Oriented Programming", 2);

        // Add prerequisite to the second course
        // Students must complete IT101 before enrolling in IT201
        course2.addPrerequisite("IT101");

        // Store completed courses for each student
        Map<String, List<String>> completedCourses = new HashMap<>();
        completedCourses.put("S2400450", Arrays.asList("IT101"));
        completedCourses.put("S2400451", Arrays.asList("IT101"));
        completedCourses.put("S2400452", Arrays.asList("BUS100"));
        completedCourses.put("S2400453", new ArrayList<>());

        // Display student details
        System.out.println("Student information preview");
        System.out.println("--------------------------------");
        student1.displayStudentInfo();
        System.out.println();
        student2.displayStudentInfo();
        System.out.println();
        student3.displayStudentInfo();
        System.out.println();
        student4.displayStudentInfo();
        System.out.println();

        // Display course details
        System.out.println("Course information preview");
        System.out.println("--------------------------------");
        course1.displayCourseDetails();
        System.out.println();
        course2.displayCourseDetails();
        System.out.println();

        // Create enrolment records
        ArrayList<Enrolment> enrolments = new ArrayList<>();

        Enrolment e1 = new Enrolment(student1, course1, LocalDate.now());
        Enrolment e2 = new Enrolment(student2, course1, LocalDate.now());
        Enrolment e3 = new Enrolment(student3, course1, LocalDate.now()); // should fail because course becomes full
        Enrolment e4 = new Enrolment(student1, course2, LocalDate.now()); // should pass because prerequisite completed
        Enrolment e5 = new Enrolment(student3, course2, LocalDate.now()); // should fail prerequisite check
        Enrolment e6 = new Enrolment(student4, course2, LocalDate.now()); // should fail prerequisite check

        enrolments.add(e1);
        enrolments.add(e2);
        enrolments.add(e3);
        enrolments.add(e4);
        enrolments.add(e5);
        enrolments.add(e6);

        // Process enrolments
        System.out.println("Processing enrolments");
        System.out.println("--------------------------------");
        for (Enrolment enrolment : enrolments) {
            enrolment.createEnrolment(completedCourses);
            System.out.println();
        }

        // Display all enrolment results
        System.out.println("Detailed enrolment results");
        System.out.println("--------------------------------");
        for (Enrolment enrolment : enrolments) {
            enrolment.displayEnrolmentDetails();
            System.out.println();
        }

        // Show final course status
        System.out.println("Final status of courses");
        System.out.println("--------------------------------");
        course1.displayCourseDetails();
        course1.displayEnrolledStudents();
        System.out.println();

        course2.displayCourseDetails();
        course2.displayEnrolledStudents();
        System.out.println();

        // Show completed course records used for prerequisite checking
        System.out.println("Completed course records used in prerequisite validation");
        System.out.println("--------------------------------");
        for (Map.Entry<String, List<String>> entry : completedCourses.entrySet()) {
            System.out.println("Student ID: " + entry.getKey() + " | Completed: " + entry.getValue());
        }
    }
}