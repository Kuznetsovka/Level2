package lesson2;

public class InfoExceptions extends Exception{
    public InfoExceptions(String message) {
        super(message);
    }

    protected static void infoArrayExceptions()
    {
        System.out.println("Массив не 4х4!");
    }

    protected static void infoNumberFormatExceptions(String message) {
        String errWord = errWord(message);
        System.out.println("Элемент массива " + errWord +" не число!");
    }

    private static String errWord(String message) {
        return message.substring(message.indexOf(':')+1);
    }
}
