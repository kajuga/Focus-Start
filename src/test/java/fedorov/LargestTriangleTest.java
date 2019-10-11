package fedorov;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.junit.Test;


public class LargestTriangleTest {

    private String inputFileSmall = "inputSmall.txt";
    private static final String outputFile = getPathToResources("") + "/" + "out.txt";

    @Test
    public void whenDifferentDateInput() throws IOException {
        LargestTriangle tester = new LargestTriangle(getPathToResources(inputFileSmall), outputFile);
        String expect = "0 25 25 0 0 0";
        tester.perform();
        String result = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(outputFile)))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result = line;
            }
        }
        assertThat(result, is(expect));
    }

    private static String getPathToResources(String resource) {
        return LargestTriangleTest.class.getClassLoader().getResource(resource).getPath();
    }
}