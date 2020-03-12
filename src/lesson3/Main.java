package lesson3;

import java.util.*;

public class Main {
    public static ArrayList<String> result = new ArrayList<>();
    public static void main(String[] args) {
        String[] arrList = {"Теплопередача", "—", "физический", "процесс", "передачи", "тепловой", "энергии", "от", "более", "горячего", "тела", "к", "менее", "горячему,", "либо", "непосредственно", "(при", "контакте),", "или", "через", "разделяющую", "(тела", "или", "среды)", "перегородку", "из", "какого-либо", "материала.", "Когда", "физические", "тела", "одной", "системы", "находятся", "при", "разной", "температуре,", "то", "происходит", "передача", "тепловой", "энергии,", "или", "теплопередача", "от", "одного", "тела", "к", "другому", "до", "наступления", "термодинамического", "равновесия.", "Самопроизвольная", "передача", "тепла", "всегда", "происходит", "от", "более", "горячего", "тела", "к", "менее", "горячему,", "что", "является", "следствием", "второго", "закона", "термодинамики)",
        };
        LinkedHashSet<String> arrSetList;
        arrSetList = getNotDuplicatedList(arrList);
        for (String word : arrSetList) {
            System.out.print(word + " ");
        }
        int arrLength = arrLength(arrList);
        System.out.println("\n" + arrLength);
        System.out.println("-------------------------------");
        PhoneBook pb  = new PhoneBook();
        pb.add("Кузнецов","111-11-11","kuznetsov@gb.ru");
        pb.add("Иванов","222-22-22","ivanov@gb.ru");
        pb.add("Сидоров","333-33-33","sidorov@gb.ru");
        pb.add("Иванов","444-44-44","ivanov2@gb.ru");
        pb.add("Сидоров","555-55-55","sidorov2@gb.ru");
        pb.add("Кузнецов","666-66-66","kuznetsov2@gb.ru");
        result = pb.getEmailByName("Кузнецов");
        for (String res : result) {
            System.out.println(res);
        }
        result = pb.getPhoneByName("Сидоров");
        for (String res : result) {
            System.out.println(res);
        }


    }

    private static int arrLength(String[] arrList) {
        HashMap<Integer,String> arrHashMap = new HashMap<>();
        for (int i = 0; i < arrList.length; i++)
            arrHashMap.put(arrList[i].hashCode(),arrList[i]);
        return arrHashMap.size();

    }

    private static LinkedHashSet<String> getNotDuplicatedList(String[] arrList) {
        LinkedHashSet<String> arrSet= new LinkedHashSet<>();
        for (String word : arrList)
            arrSet.add(word);
        return arrSet;
    }
    /*
1. Создать массив с набором слов (20-30 слов, должны встречаться повторяющиеся):
   - Найти список слов, из которых состоит текст (дубликаты не считать);
   - Посчитать сколько раз встречается каждое слово (использовать HashMap);
 2. Написать простой класс PhoneBook(внутри использовать HashMap):
  - В качестве ключа использовать фамилию
  - В каждой записи всего два поля: phone, e-mail
  - Отдельный метод для поиска номера телефона по фамилии (ввели фамилию, получили ArrayList телефонов), и отдельный метод для поиска e-mail по фамилии.
   Следует учесть, что под одной фамилией может быть несколько записей. Итого должно получиться 3 класса Main, PhoneBook, Person.
*/
}
