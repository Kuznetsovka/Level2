package lesson2;

public class Lesson2 extends InfoExceptions {
    public static final String STR = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
    public static String[][] arr;
    public static int count;
    public static final int COUNT=4;

    public Lesson2(String message) {
        super(message);
    }

    public static void main(String[] args){
        try {
            createMatrix(STR);
            int a = strToIntArr(arr, count);
            System.out.println(a);
        } catch (ArrayIndexOutOfBoundsException e){
            infoArrayExceptions();
        } catch (NumberFormatException e){
            infoNumberFormatExceptions(e.getMessage());
        }
    }

    private static int getLengthRows(String str) {
        String []splitArray = str.split("\n");
        return splitArray.length;
        //Пришлось создать этот метод, потому что если задать длину сразу, при превышении количества строк ошибка не падает.
    }

    private static int strToIntArr(String[][] arr, int count) throws ArrayIndexOutOfBoundsException {
        int[][] arrInt = new int[count][count];
        int sum =0;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                arrInt[i][j] = Integer.parseInt(String.valueOf(arr[i][j]));
                sum += arrInt[i][j];
            }
        }
        return sum/2;
    }
    private static void createMatrix(String str) throws ArrayIndexOutOfBoundsException{
        count = getLengthRows(str);
        if (count !=COUNT) throw new ArrayIndexOutOfBoundsException();
        arr = new String[count][count];
        String[] arrColumn = str.split("\n");
        for (int i = 0; i< count; i++)
            arr[i] = arrColumn[i].split(" ");
    }
}
