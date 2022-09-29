import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        RainData rainData = new RainData("rainfall_data.txt");
        rainData.compute();
        rainData.writeFile();

    }
}