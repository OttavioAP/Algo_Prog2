import java.util.ArrayList;


public class heapTester {
    public static void main(String[] args) {
        // Create an ArrayList of students
        ArrayList<Student> students = new ArrayList<>();

        Student changeStudent = new Student(2,19);

        students.add(changeStudent);
        students.add(new Student(3,57));

        students.add(new Student(4,99));
        students.add(new Student(1,7));

        students.add(new Student(5,297));
        students.add(new Student(999));

        // Create a new heap and build it using the students ArrayList
        Heap heap = new Heap();
        heap.buildHeap(students);


        heap.insertNode(new Student(6,400));

        heap.insertNode(new Student(7,401));

        heap.changeKey(changeStudent, 500);

        // heap.delete(3);

        // heap.delete(5);

        // Student student = students.get(2);
        // heap.changeKey(student, 700);
        // student = students.get(5);
        // heap.changeKey(student, 600);


        Student extractedStudent = heap.extractMin();
        System.out.println("Extracted Student: " + extractedStudent.getName());

        extractedStudent = heap.extractMin();
        System.out.println("Extracted Student: " + extractedStudent.getName());

        extractedStudent = heap.extractMin();
        System.out.println("Extracted Student: " + extractedStudent.getName());

        extractedStudent = heap.extractMin();
        System.out.println("Extracted Student: " + extractedStudent.getName());

        extractedStudent = heap.extractMin();
        System.out.println("Extracted Student: " + extractedStudent.getName());

        extractedStudent = heap.extractMin();
        System.out.println("Extracted Student: " + extractedStudent.getName());


        extractedStudent = heap.extractMin();
        System.out.println("Extracted Student: " + extractedStudent.getName());

        extractedStudent = heap.extractMin();
        System.out.println("Extracted Student: " + extractedStudent.getName());




        // Test findMin
        // Student minStudent = heap.findMin();
        // System.out.println("Minimum Student: " + minStudent.getName());



        // // Test insertNode
        // heap.insertNode(new Student(6,400));
        // System.out.println("After inserting Student with name 5: " + heap);

        // // Test extractMin
        // Student extractedStudent = heap.extractMin();
        // System.out.println("Extracted Student: " + extractedStudent.getName());
        // System.out.println("After extracting minimum: " + heap);

        // // Test delete
        // heap.delete(1);
        // System.out.println("After deleting index 1: " + heap);

        // // Test changeKey
        // Student student = students.get(2);
        // heap.changeKey(student, 8);
        // System.out.println("After changing Student with name " + student.getName() + " key to 8: " + heap);
    }
}
