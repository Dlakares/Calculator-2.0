package util;
import java.util.Scanner;

public class InputUtil {
    public static String getMathExpression(){
        String line = inputLine();
        return line;
    }

    public static String getLine(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private static String inputLine(){
        printInput();
        String line = getLine().replaceAll("\\s", "");
        while (!Validator.lineIsValid(line)){
            printInput();
            line = getLine().replaceAll("\\s", "");
        }
        return line;
    }

    private static void printInput() {
        System.out.print("Ввод: ");
    }
}
