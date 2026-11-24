public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {10, 9, 8},
                {6, 5, 7},
                {2, 3, 9}
        };

        StudentMarkTracker studentMarkTracker = new StudentMarkTracker();

        studentMarkTracker.printStudentResults(matrix);
    }
}