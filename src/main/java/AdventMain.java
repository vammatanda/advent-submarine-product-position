import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AdventMain {

    public static void main(final String[] args) throws IOException {
        AdventMain adventMain = new AdventMain();
        adventMain.run();
    }

    public final void run() throws IOException {
        System.out.println("Input: \n");

        List<String> inputString = new ArrayList<>();

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = stdin.readLine()) != null && line.length()!= 0) {
            inputString.add(line);
        }

        calculateProductOfPosition2(inputString);
//        calculateProductOfPosition1(inputString);
    }

    private void calculateProductOfPosition2(List<String> inputString) {
        int tempPosition;
        int horizontalPosition = 0;
        int depthPosition = 0;
        int aim = 0;

        for (String s : inputString) {
            if (s.contains("forward")) {
                tempPosition = Integer.parseInt((s.substring(8)));
                horizontalPosition += tempPosition;
                depthPosition += (aim * tempPosition);
            }
            if (s.contains("up")) {
                tempPosition = Integer.parseInt((s.substring(3)));
//                depthPosition +=tempPosition;
                aim -= tempPosition;
            }
            if (s.contains("down")) {
                tempPosition = Integer.parseInt((s.substring(5)));
//                depthPosition -=tempPosition;
                aim += tempPosition;
            }
        }
        System.out.println("horizontal : "+horizontalPosition);
        System.out.println("depth : "+depthPosition);
        System.out.println("Result: "+Math.abs(horizontalPosition * depthPosition));
    }

    private void calculateProductOfPosition1(List<String> inputString) {
        int tempPosition;
        int horizontalPosition = 0;
        int depthPosition = 0;

        for (String s : inputString) {
            if (s.contains("forward")) {
                tempPosition = Integer.parseInt((s.substring(8)));
                horizontalPosition += tempPosition;
            }
            if (s.contains("up")) {
                tempPosition = Integer.parseInt((s.substring(3)));
                depthPosition += tempPosition;
            }
            if (s.contains("down")) {
                tempPosition = Integer.parseInt((s.substring(5)));
                depthPosition -= tempPosition;
            }
        }
        System.out.println("Result: "+Math.abs(horizontalPosition * depthPosition));
    }
}
