import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagement management = new StudentManagement();

        int choice;
        do {
            // Display student list whenever an action is taken
            System.out.println("\n---- Current Student List ----");
            management.displayStudents();

            // Menu choices
            System.out.println("\n---- Student Management Menu ----");
            System.out.println("1. Add Students");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student");
            System.out.println("5. Sort Students by Marks");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add multiple students
                    System.out.print("Enter the number of students you want to add: ");
                    int numberOfStudents = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    for (int i = 1; i <= numberOfStudents; i++) {
                        System.out.println("Enter details for student " + i + ":");
                        System.out.print("Enter student ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter student name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter student marks: ");
                        double marks = scanner.nextDouble();
                        management.addStudent(new Student(id, name, marks));
                    }
                    break;

                case 2:
                    // Edit student details
                    System.out.print("Enter student ID to edit: ");
                    int editId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new student name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new student marks: ");
                    double newMarks = scanner.nextDouble();
                    management.editStudent(editId, newName, newMarks);
                    break;

                case 3:
                    // Delete a student
                    System.out.print("Enter student ID to delete: ");
                    int deleteId = scanner.nextInt();
                    management.deleteStudent(deleteId);
                    break;

                case 4:
                    // Search for a student by ID
                    System.out.print("Enter student ID to search: ");
                    int searchId = scanner.nextInt();
                    Student foundStudent = management.searchStudentById(searchId);
                    if (foundStudent != null) {
                        System.out.println("Student found: " + foundStudent);
                    } else {
                        System.out.println("Student with ID " + searchId + " not found.");
                    }
                    break;

                case 5:
                    // Sort students by marks
                    management.sortStudentsByMarks();
                    System.out.println("Students sorted by marks.");
                    break;

                case 0:
                    // Exit program
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
