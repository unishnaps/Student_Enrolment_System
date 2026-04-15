import java.util.ArrayList;
import java.util.List;

public class Course {
    // Private fields for course information
    private String courseCode;
    private String courseName;
    private int maximumCapacity;

    // List to store enrolled students
    private List<Student> enrolledStudents;

    // List to store prerequisite course codes
    private List<String> prerequisites;

    // Constructor to initialize course object
    public Course(String courseCode, String courseName, int maximumCapacity) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.maximumCapacity = maximumCapacity;
        this.enrolledStudents = new ArrayList<>();
        this.prerequisites = new ArrayList<>();
    }

    // Getter methods
    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getMaximumCapacity() {
        return maximumCapacity;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public List<String> getPrerequisites() {
        return prerequisites;
    }

    // Setter methods
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setMaximumCapacity(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    // Add one prerequisite course code
    public void addPrerequisite(String prerequisiteCode) {
        prerequisites.add(prerequisiteCode);
    }

    // Check whether course is already at full capacity
    public boolean isFull() {
        return enrolledStudents.size() >= maximumCapacity;
    }

    // Check whether a student is already enrolled
    public boolean isStudentAlreadyEnrolled(Student student) {
        for (Student s : enrolledStudents) {
            if (s.getStudentId().equals(student.getStudentId())) {
                return true;
            }
        }
        return false;
    }

    // Enrol a student after all checks are done
    public boolean addStudent(Student student) {
        if (isStudentAlreadyEnrolled(student)) {
            System.out.println(student.getName() + " is already enrolled in " + courseCode + ".");
            return false;
        }

        if (isFull()) {
            System.out.println("Enrolment failed: " + courseCode + " has reached maximum capacity.");
            return false;
        }

        enrolledStudents.add(student);
        System.out.println(student.getName() + " has been enrolled in " + courseCode + ".");
        return true;
    }

    // Display course information
    public void displayCourseDetails() {
        System.out.println("Course Record");
        System.out.println("  Code       : " + courseCode);
        System.out.println("  Name       : " + courseName);
        System.out.println("  Capacity   : " + maximumCapacity);
        System.out.println("  Enrolled   : " + enrolledStudents.size());

        if (prerequisites.isEmpty()) {
            System.out.println("  Prereq.    : None");
        } else {
            System.out.println("  Prereq.    : " + String.join(", ", prerequisites));
        }
    }

    // Display all enrolled students
    public void displayEnrolledStudents() {
        System.out.println("Students enrolled in " + courseCode + ":");
        if (enrolledStudents.isEmpty()) {
            System.out.println("  No students enrolled.");
        } else {
            for (Student student : enrolledStudents) {
                System.out.println("  - " + student.getStudentId() + " | " + student.getName());
            }
        }
    }
}