import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {

    static ArrayList<Student> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: viewStudents(); break;
                case 3: searchStudent(); break;
                case 4: updateStudent(); break;
                case 5: deleteStudent(); break;
                case 6: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 6);
    }

    // Add Student
    public static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        list.add(new Student(id, name, age, course));
        System.out.println("Student added successfully!");
    }

    // View Students
    public static void viewStudents() {
        if (list.isEmpty()) {
            System.out.println("No students found!");
            return;
        }
        System.out.println("\n--- Student List ---");
        for (Student s : list) {
            System.out.println(s);
        }
    }

    // Search Student by ID
    public static void searchStudent() {
        System.out.print("Enter Student ID to search: ");
        int id = sc.nextInt();

        for (Student s : list) {
            if (s.getId() == id) {
                System.out.println("Student Found: " + s);
                return;
            }
        }
        System.out.println("Student Not Found!");
    }

    // Update Student
    public static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Student s : list) {
            if (s.getId() == id) {
                System.out.print("Enter new name: ");
                s.setName(sc.nextLine());

                System.out.print("Enter new age: ");
                s.setAge(sc.nextInt());
                sc.nextLine();

                System.out.print("Enter new course: ");
                s.setCourse(sc.nextLine());

                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("Student Not Found!");
    }

    // Delete Student
    public static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();

        for (Student s : list) {
            if (s.getId() == id) {
                list.remove(s);
                System.out.println("Student deleted successfully!");
                return;
            }
        }
        System.out.println("Student Not Found!");
    }
}
