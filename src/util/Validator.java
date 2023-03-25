package util;

public class Validator {
    public static boolean lineIsValid(String line) {
        try {
            if (!isOnlyNumber(line)) {
                throw new IllegalArgumentException("Строка должна содержать только числа от 1 до 10 и операции к ним");
            }
            if (!startWithNumber(line)) {
                throw new IllegalArgumentException("Некорректное расположение математических операций. \n" +
                        "Учтите что строка не может начинаться или заканчиваться математической операцией. \n" +
                        "А так же две или более математических операций не могут идти подряд");
            }
            if (!containCorrectNumbers(line)) {
                throw new IllegalArgumentException("Строка должна содержать от 2 до 3 чисел в диапазоне от 1 до 10 и операции между ними");
            }
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private static boolean isOnlyNumber(String line) {
        return line.matches("^[\\d\\s()+\\-*/]+$");
    }

    private static boolean startWithNumber(String line) {
            return line.matches("^[0-9]+([-+*/][0-9]+)*$");
    }

    private static boolean containCorrectNumbers(String line) {
        return line.matches("^(?:[1-9]|10)(?:\\s*[+\\-*/]\\s*(?:[1-9]|10)){1,2}$");
    }
}
