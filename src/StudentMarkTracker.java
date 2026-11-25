import java.util.Arrays;

public class StudentMarkTracker {

    // Constants used to validate marks.
    private static final int MIN_MARK = 0;
    private static final int MAX_MARK = 10;
    // Constants used to classify average results
    private static final double EXCELLENT_SCORE = 8.0;
    private static final double GOOD_SCORE = 6.0;
    private static final double SATISFACTORY_SCORE = 4.0;

    //The only public method. It prints the results for each student
    // while keeping the implementation details hidden in private methods.
    public static void printStudentResults(int[][] studentMarks){
        for (int i = 0; i < studentMarks.length; i++) {
            System.out.printf("Student #%d average mark: ", i + 1);
            if (validateMarks(studentMarks[i])){
                System.out.println(classifyAverageMark(calculateStudentAverageMark(studentMarks[i])));
            } else {
                System.out.println("cannot be calculated (Invalid data)");
            }
        }
    }

    // Calculates the average mark for a student.
    private static double calculateStudentAverageMark(int[] studentMarks){
        return Arrays.stream(studentMarks).average().orElse(0.0);
    }

    // Classifies the average mark and returns a message describing the student's result.
    private static String classifyAverageMark(double averageMark){
        if (averageMark >= EXCELLENT_SCORE) {
            return String.format("%.2f - They did an excellent job!", averageMark);
        } else if (averageMark >= GOOD_SCORE) {
            return String.format("%.2f - They handled the work well!", averageMark);
        } else if (averageMark >= SATISFACTORY_SCORE) {
            return String.format("%.2f - They partially succeeded.", averageMark);
        } else {
            return String.format("%.2f - They failed.", averageMark);
        }
    }

    // Checks whether the marks are within the valid range
    // and whether the student has any marks at all.
    private static boolean validateMarks(int[] studentMarks){
        if (studentMarks.length == 0) return false;
        for (int mark : studentMarks){
            if (mark < MIN_MARK || mark > MAX_MARK){
                return false;
            }
        }
        return true;
    }
}