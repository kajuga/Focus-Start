package fedorov;

public class App {
    public static void main(String[] args) {
        String in = args[0];
        String out = args[1];
        LargestTriangle largestTriangle = new LargestTriangle(in, out);
        largestTriangle.perform();
    }
}
