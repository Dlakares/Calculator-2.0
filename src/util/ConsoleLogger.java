package util;

import static util.InputUtil.*;

public class ConsoleLogger {
    public static void getResult(Double result){
        System.out.println("Результат: " + result);
    }

    public static boolean askToContinue(){
        String line;
        System.out.print("Хотите продолжить? (y\\n): ");
        line = getLine();
        while (!line.equalsIgnoreCase("y") && !line.equalsIgnoreCase("n")) {
            try {
                throw new IllegalArgumentException("Пожалуйста, введите 'y' или 'n': ");
            }catch (IllegalArgumentException e){
                System.out.print(e.getMessage());
            }
            line = getLine();
        }
        return line.equalsIgnoreCase("y");
    }
}
