package util;

public class Config {
    public static void onStart(){
        System.out.println("""
                Консольный калькулятор 2.0.\s
                Это тестовое приложение. Автор: Басимов Рустам\s
                E-mail: sombra1nf@yandex.ru, Telegram: @Dlakres, Git: https://github.com/Dlakares\s
                Для начала введите выражение. Оно должно состоять из чисел от 1 до 10 и операторов (+, -, *, /)""");
    }

    public static void onEnd(){
        System.out.println("Спасибо за использование!");
    }
}
