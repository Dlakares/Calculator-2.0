import module.Calculator;

import static util.Config.*;
import static util.ConsoleLogger.*;

public class MainCalc {
    public static void main(String[] args) {
        onStart();
        do {
            getResult(Calculator.evaluate());
        } while (askToContinue());
        onEnd();
    }
}
