public class Main {
    public static void main(String[] args) {
        int[][] studentMarks = {
                {10, 9, 8},
                {6, 5, 7},
                {2, 3, 9},
                {},
                {15, -5, 10}
        };

        StudentMarkTracker.printStudentResults(studentMarks);
    }
}