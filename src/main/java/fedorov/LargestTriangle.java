package fedorov;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class LargestTriangle {

    private double maxValue;
    private String stringValue;

    private final String inputFileName;
    private final String outputFileName;

    public LargestTriangle(String inputFileName, String outputFileName) {
        this.inputFileName = inputFileName;
        this.outputFileName = outputFileName;
    }

    public void perform() {
        System.out.println(String.format("Start perform. Time: %s", LocalDateTime.now()));
        readFile(inputFileName);
        writeFile(outputFileName);
        System.out.println(String.format("Completed! Time: %s", LocalDateTime.now()));
    }

    private void readFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            System.out.println("File is reading...");
            String str = null;
            while ((str = reader.readLine()) != null) {
                TriangleCoordinates triangleCoordinates = getTriangleCoordinates(str);
                double area = area(triangleCoordinates);
                if (area != 0) {
                    maxCoordinateChooser(area, str);
                }
            }
            System.out.println("File reading completed!");
        } catch (IOException e) {
            System.out.println("File reading error!");
        }
    }

    private void maxCoordinateChooser(double area, String coordinates) {
        if (area > this.maxValue) {
            this.maxValue = area;
            this.stringValue = coordinates;
        }
    }

    private void writeFile(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(this.stringValue == null ? "" : this.stringValue);
        } catch (IOException e) {
            System.out.println("Write result error!");
        }
    }

    private TriangleCoordinates getTriangleCoordinates(String string) {
        int x1, y1, x2, y2, x3, y3;
        String[] numbers = string.split(" ");
        try {
            x1 = Integer.valueOf(numbers[0]);
            y1 = Integer.valueOf(numbers[1]);
            x2 = Integer.valueOf(numbers[2]);
            y2 = Integer.valueOf(numbers[3]);
            x3 = Integer.valueOf(numbers[4]);
            y3 = Integer.valueOf(numbers[5]);
            return new TriangleCoordinates(x1, y1, x2, y2, x3, y3);
        } catch (IndexOutOfBoundsException | NumberFormatException ex) {
            return null;
        }
    }

    private double area(TriangleCoordinates triangleCoordinates) {
        double area = 0;

        if (triangleCoordinates != null) {
            double a = Math.sqrt((triangleCoordinates.x1 - triangleCoordinates.x2) * (triangleCoordinates.x1 - triangleCoordinates.x2) +
                    (triangleCoordinates.y1 - triangleCoordinates.y2) * (triangleCoordinates.y1 - triangleCoordinates.y2));
            double b = Math.sqrt((triangleCoordinates.x2 - triangleCoordinates.x3) * (triangleCoordinates.x2 - triangleCoordinates.x3) +
                    (triangleCoordinates.y2 - triangleCoordinates.y3) * (triangleCoordinates.y2 - triangleCoordinates.y3));
            double c = Math.sqrt((triangleCoordinates.x1 - triangleCoordinates.x3) * (triangleCoordinates.x1 - triangleCoordinates.x3) +
                    (triangleCoordinates.y1 - triangleCoordinates.y3) * (triangleCoordinates.y1 - triangleCoordinates.y3));

            if ((a == b) || (a == c) || (b == c)) {
                double p = (a + b + c) / 2.0;
                return Math.sqrt(p * (p - a) * (p - b) * (p - c));
            }
        }
        return area;
    }

    private static class TriangleCoordinates {
        private final int x1;
        private final int y1;
        private final int x2;
        private final int y2;
        private final int x3;
        private final int y3;

        public TriangleCoordinates(int x1, int y1, int x2, int y2, int x3, int y3) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.x3 = x3;
            this.y3 = y3;
        }
    }
}