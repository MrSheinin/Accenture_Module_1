import java.util.Arrays;

public class StudentMarkTracker {

    private static final int MIN_MARK = 0;
    private static final int MAX_MARK = 10;
    private static final double EXCELLENT_SCORE = 8.0;
    private static final double GOOD_SCORE = 6.0;
    private static final double SATISFACTORY_SCORE = 4.0;

    public void printStudentResults(int [][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            System.out.printf("Student #%d average mark: ", i+1);
            System.out.println(classifyAverageMark(calculateStudentAverageMark(matrix[i])));
        }
    }

    private double calculateStudentAverageMark(int[] studentMarks){
        return Arrays.stream(studentMarks).average().orElse(0.0);
    }

    private String classifyAverageMark(double averageMark){
        if (averageMark > MAX_MARK || averageMark < MIN_MARK) {
            return String.format("%.2f - Invalid mark", averageMark);
        } else if (averageMark >= EXCELLENT_SCORE) {
            return String.format("%.2f - They did an excellent job!", averageMark);
        } else if (averageMark >= GOOD_SCORE) {
            return String.format("%.2f - They handled the work well!", averageMark);
        } else if (averageMark >= SATISFACTORY_SCORE) {
            return String.format("%.2f - They partially succeeded.", averageMark);
        } else {
            return String.format("%.2f - They failed.", averageMark);
        }
    }
}