import java.util.Arrays;

public class StudentMarkTracker {

    public void trackStudentMarks(int [][] matrix){
        Arrays.stream(matrix)
                .map(this::calculateStudentAvgMark)
                .flatMapToDouble(Arrays::stream)
                .forEach(this::classifyAvgMarks);
    }

    private double[] calculateStudentAvgMark(int[] matrix){
        return Arrays.stream(matrix).average().stream().toArray();
    }

    private void classifyAvgMarks(double avgMark){
        if (avgMark > 10 || avgMark < 0) {
            System.out.printf("%s - Invalid mark\n", avgMark);
        }
        if (avgMark >= 8){
            System.out.printf("%s - Did an excellent job!\n", avgMark);
        } else if (avgMark < 8 && avgMark >= 6) {
            System.out.printf("%s - Handled the work well!\n", avgMark);
        } else if (avgMark < 6 && avgMark >= 4) {
            System.out.printf("%s - Partially succeeded.\n", avgMark);
        } else {
            System.out.printf("%s - Failed.\n", avgMark);
        }
    }
}