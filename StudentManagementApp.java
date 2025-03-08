import java.io.*;
import java.util.*;
class Student implements Serializable {
    private String name;
    private int rollNumber;
    private String grade;
    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }
    public String getName() {
        return name;
    }
    public int getRollNumber() {
        return rollNumber;
    }
    public String getGrade() {
        return grade;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    @Override
    public String toString() {
        return "Roll No: " + rollNumber + ", Name: " + name + ", Grade: " + grade;
    }
}
class StudentManagementSystem {
    private List<Student> students;
    private static final String FILE_NAME = "students.dat";
    public StudentManagementSystem() {
        students = new ArrayList<>();
        loadStudents();
    }
    public void addStudent(Student student) {
        students.add(student);
        saveStudents();
        System.out.println("Student added successfully!");
    }
    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
        saveStudents();
        System.out.println("Student removed successfully!");
    }
    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found!");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
    private void saveStudents() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(students);
        } catch (IOException e) {
            System.out.println("Error saving student data.");
        }
    }
    private void loadStudents() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            students = (List<Student>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            students = new ArrayList<>();
        }
    }
}
public class StudentManagementApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();
        while (true) {
            System.out.println("\nSTUDENT MANAGEMENT SYSTEM");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Roll number: ");
                    int rollNumber = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter grade: ");
                    String grade = sc.nextLine();
                    sms.addStudent(new Student(name, rollNumber, grade));
                    break;
                case 2:
                    System.out.print("Enter roll number to remove: ");
                    int rollToRemove = sc.nextInt();
                    sms.removeStudent(rollToRemove);
                    break;
                case 3:
                    System.out.print("Enter roll number to search: ");
                    int rollToSearch = sc.nextInt();
                    Student student = sms.searchStudent(rollToSearch);
                    if (student != null) {
                        System.out.println("Student Found: " + student);
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;
                case 4:
                    sms.displayStudents();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
