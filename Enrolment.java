import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Enrolment {
    // References to student and course
    private Student student;
    private Course course;
    private LocalDate enrolmentDate;

    // Stores whether enrolment was successful
    private boolean enrolledSuccessfully;

    // Stores message explaining result
    private String statusMessage;

    // Constructor
    public Enrolment(Student student, Course course, LocalDate enrolmentDate) {
        this.student = student;
        this.course = course;
        this.enrolmentDate = enrolmentDate;
        this.enrolledSuccessfully = false;
        this.statusMessage = "Not processed yet";
    }

    // Getter methods
    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public LocalDate getEnrolmentDate() {
        return enrolmentDate;
    }

    public boolean isEnrolledSuccessfully() {
        return enrolledSuccessfully;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    // Setter methods
    public void setStudent(Student student) {
        this.student = student;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setEnrolmentDate(LocalDate enrolmentDate) {
        this.enrolmentDate = enrolmentDate;
    }

    // Create enrolment with prerequisite checking
    // completedCourses map stores:
    // key = student ID
    // value = list of course codes already completed by that student
    public void createEnrolment(Map<String, List<String>> completedCourses) {
        List<String> studentCompletedCourses = completedCourses.get(student.getStudentId());

        // Check prerequisite requirements first
        for (String prerequisite : course.getPrerequisites()) {
            if (studentCompletedCourses == null || !studentCompletedCourses.contains(prerequisite)) {
                enrolledSuccessfully = false;
                statusMessage = "Enrolment rejected - missing prerequisite: " + prerequisite;
                System.out.println("Could not enrol " + student.getName() + " in " + course.getCourseCode()
                        + " because prerequisite " + prerequisite + " has not been completed.");
                return;
            }
        }

        // If prerequisites are satisfied, attempt normal enrolment
        enrolledSuccessfully = course.addStudent(student);

        if (enrolledSuccessfully) {
            statusMessage = "Enrolled successfully";
        } else {
            statusMessage = "Enrolment rejected - capacity full or duplicate enrolment";
        }
    }

    // Display enrolment details
    public void displayEnrolmentDetails() {
        System.out.println("Enrolment Entry");
        System.out.println("  Student ID   : " + student.getStudentId());
        System.out.println("  Student Name : " + student.getName());
        System.out.println("  Course Code  : " + course.getCourseCode());
        System.out.println("  Course Name  : " + course.getCourseName());
        System.out.println("  Date         : " + enrolmentDate);
        System.out.println("  Result       : " + statusMessage);
    }
}