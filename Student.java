public class Student {
    // Private fields to follow encapsulation
    private String studentId;
    private String name;
    private String email;

    // Constructor to initialize student object
    public Student(String studentId, String name, String email) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
    }

    // Getter methods
    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // Setter methods
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Method to display student details
    public void displayStudentInfo() {
        System.out.println("Student Record");
        System.out.println("  ID    : " + studentId);
        System.out.println("  Name  : " + name);
        System.out.println("  Email : " + email);
    }
}