import java.io.*;
import java.util.ArrayList;

public class GradeAnalyzer {
    private static int invalidLinesSkipped = 0;

    public static void main(String[] args) {
        ArrayList<Integer> scores = readScores("scores.txt");
        double average = calculateAverage(scores);

        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;

        for (int score : scores) {
            if (score > highest) {
                highest = score;
            }
            if (score < lowest) {
                lowest = score;
            }
        }

        writeReport(scores, average, highest, lowest, "report.txt");
    }

    // Returns a list of valid scores read from the file.
    public static ArrayList<Integer> readScores(String filename) {
        ArrayList<Integer> scores = new ArrayList<>();
        invalidLinesSkipped = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                String trimmedLine = line.trim();

                if (trimmedLine.isEmpty()) {
                    continue;
                }

                try {
                    int score = Integer.parseInt(trimmedLine);

                    if (score < 0 || score > 100) {
                        System.out.printf(
                                "Warning: skipped out-of-range score on line %d: %s%n",
                                lineNumber, trimmedLine);
                        invalidLinesSkipped++;
                    } else {
                        scores.add(score);
                    }
                } catch (NumberFormatException e) {
                    System.out.printf(
                            "Warning: skipped invalid entry on line %d: %s%n",
                            lineNumber, trimmedLine);
                    invalidLinesSkipped++;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading " + filename + ": " + e.getMessage());
        }

        return scores;
    }

    // Returns the average of a list of scores, or 0.0 if the list is empty.
    public static double calculateAverage(ArrayList<Integer> scores) {
        if (scores.isEmpty()) {
            return 0.0;
        }

        double total = 0.0;
        for (int score : scores) {
            total += score;
        }

        return total / scores.size();
    }

    // Writes the report to a file and prints the same report to the terminal.
    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low,
                                   String outputFile) {
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        int countF = 0;

        for (int score : scores) {
            if (score >= 90) {
                countA++;
            } else if (score >= 80) {
                countB++;
            } else if (score >= 70) {
                countC++;
            } else if (score >= 60) {
                countD++;
            } else {
                countF++;
            }
        }

        StringBuilder report = new StringBuilder();
        report.append("=== Grade Analysis Report ===\n\n");
        report.append(String.format("Total scores processed: %d%n", scores.size()));
        report.append(String.format("Invalid lines skipped:  %d%n%n", invalidLinesSkipped));
        report.append(String.format("Average score: %.2f%n", avg));

        if (scores.isEmpty()) {
            report.append("Highest score: N/A\n");
            report.append("Lowest score:  N/A\n\n");
        } else {
            report.append(String.format("Highest score: %d%n", high));
            report.append(String.format("Lowest score:  %d%n%n", low));
        }

        report.append("Grade distribution:\n");
        report.append(String.format("  A (90-100):   %d%n", countA));
        report.append(String.format("  B (80-89):    %d%n", countB));
        report.append(String.format("  C (70-79):    %d%n", countC));
        report.append(String.format("  D (60-69):    %d%n", countD));
        report.append(String.format("  F (below 60): %d%n", countF));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(report.toString());
            System.out.print(report);
        } catch (IOException e) {
            System.out.println("Error writing " + outputFile + ": " + e.getMessage());
        }
    }
}
