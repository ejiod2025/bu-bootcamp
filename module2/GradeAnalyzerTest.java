import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class GradeAnalyzerTest {
    @Test
    void calculateAverageReturnsAverageOfMultipleScores() {
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(80, 90, 100));

        assertEquals(90.0, GradeAnalyzer.calculateAverage(scores), 0.001);
    }

    @Test
    void calculateAverageReturnsSingleScore() {
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(75));

        assertEquals(75.0, GradeAnalyzer.calculateAverage(scores), 0.001);
    }

    @Test
    void calculateAverageReturnsZeroForEmptyList() {
        ArrayList<Integer> scores = new ArrayList<>();

        assertEquals(0.0, GradeAnalyzer.calculateAverage(scores), 0.001);
    }

    @Test
    void calculateAverageHandlesDecimalResult() {
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(80, 81, 82, 84));

        assertEquals(81.75, GradeAnalyzer.calculateAverage(scores), 0.001);
    }

    @Test
    void calculateAverageHandlesZeroScores() {
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(0, 0, 0));

        assertEquals(0.0, GradeAnalyzer.calculateAverage(scores), 0.001);
    }

    @Test
    void calculateAverageReturnsExactAverageForTenScores() {
        ArrayList<Integer> scores = new ArrayList<>(
                Arrays.asList(50, 60, 70, 80, 90, 100, 55, 65, 75, 85));

        assertEquals(73.0, GradeAnalyzer.calculateAverage(scores), 0.001);
    }
}
