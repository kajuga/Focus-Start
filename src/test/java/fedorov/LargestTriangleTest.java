package fedorov;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import org.junit.Test;


public class LargestTriangleTest {
    String inputFileSmall = "/home/kajuga/projects/focusstart/src/main/resources/inputSmall.txt";
    String inputFileBig = "/home/kajuga/projects/focusstart/src/main/resources/inputOneGig.txt";
    String outputFile = "/home/kajuga/projects/focusstart/src/main/resources/out.txt";

    @Test
    public void whenDifferentDateInput() {
        LargestTriangle tester = new LargestTriangle(inputFileSmall, outputFile);
        String expect = "0 25 25 0 0 0";
        tester.perform();
        String result = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(outputFile)));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                result = line;
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Output file not found...");
        }
        assertThat(result, is(expect));
    }

    @Test
    public void whenBigMoreThanGigFileIncoming() {
        LargestTriangle tester = new LargestTriangle(inputFileBig, outputFile);
        String expect = "19 16 16 -2 -2 1";
        tester.perform();
        String result = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(outputFile)));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                result = line.trim();
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Output file not found...");
        }
        assertThat(result, is(expect));
    }
}




