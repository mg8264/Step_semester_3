package string.class_problems;

public class Program5 {

    static class Student {

        String name;
        double attendance;

        static String collegeName = "SRM University";
        static int studentCount = 0;

        Student(String name, double attendance) {

            this.name = name;
            this.attendance = attendance;

            studentCount++;
        }

        static void printCollegeInfo() {

            System.out.println("College: " + collegeName);
            System.out.println("Student Count: " + studentCount);
        }
    }

    public static void main(String[] args) {

        Student student1 =
                new Student("Ravi", 85.5);

        Student student2 =
                new Student("Anitha", 90.0);

        Student.printCollegeInfo();
    }
}