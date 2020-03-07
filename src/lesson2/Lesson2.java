package lesson2;

public class Lesson2 {
    public static final String STR = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
    public static String[][] arr;
    public static int COUNT;
    public static void main(String[] args){
        try {
            createMatrix(STR);
            int a = strToIntArr(arr,COUNT);
            System.out.println(a);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Массив не 4х4!");
        } catch (NumberFormatException e) {
            System.out.println("Элемент массива не число!");
        }
    }

    private static int getLengthRows(String str) {
        String []splitArray = str.split("\n");
        return splitArray.length;
        //Пришлось создать этот метод, потому что если задать длину сразу, при превышении количества строк ошибка не падает.
    }

    private static int strToIntArr(String[][] arr, int COUNT) throws ArrayIndexOutOfBoundsException {
        int[][] arrInt = new int[COUNT][COUNT];
        int sum =0;
        for (int i = 0; i < COUNT; i++) {
            for (int j = 0; j < COUNT; j++) {
                arrInt[i][j] = Integer.parseInt(String.valueOf(arr[i][j]));
                sum += arrInt[i][j];
            }
        }
        return sum/2;
    }
    private static void createMatrix(String str){
        COUNT  = getLengthRows(str);
        arr = new String[COUNT][COUNT];
        String[] arrColumn = str.split("\n");
        for (int i=0;i<COUNT;i++)
            arr[i] = arrColumn[i].split(" ");
    }

    /*
 5. * Написать собственные классы исключений для каждого из случаев
     */
}
