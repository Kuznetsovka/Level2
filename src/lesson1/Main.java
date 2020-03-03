package lesson1;

import java.util.Random;

public class Main {
    private static final int CAT_COUNT = 3;
    private static final int MAN_COUNT = 2;
    private static final int BOT_COUNT = 4;
    private static final int WALL_COUNT = 3;
    private static final int TRACK_COUNT = 2;
    private static Random powerRandomize = new Random();
    public static void main(String[] args) {
/*
Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса.
Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).
-----
Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники должны выполнять соответствующие действия (бежать или прыгать), результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
-----
Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
-----
* У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки. Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.
 */
        Man man1 = new Man("man1");
        Bot bot1 = new Bot("bot1");
        Cat cat1 = new Cat("cat1");
        man1.jump();
        man1.run();
        bot1.jump();
        bot1.run();
        cat1.jump();
        cat1.run();
        System.out.println("-----------");
        Players[] players = new Players[countPlayers()];
        Barrier[] barriers = new Barrier[countBarriers()];
        createPlayers(players);
        System.out.println("-----------");
        createBarrier(barriers);
        System.out.println("-----------");
        runBarriers(players, barriers);
    }

    private static void runBarriers(Players[] players, Barrier[] barriers) {
        for (int i = 0; i < countPlayers(); i++) {
            for (int j = 0; j < countBarriers(); j++) {
                if (players[i].isPower())
                    if (barriers[j] instanceof Wall) {
                        players[i].jump((Wall) barriers[j]);
                    } else {
                        players[i].run((Track) barriers[j]);
                    }

            }
            System.out.println("-----------");
        }
    }

    private static void createBarrier(Object[] barriers) {
        int i=0;
        while (i<WALL_COUNT) {
            barriers[i] = createWalls(i);
            infoCreate(barriers[i]);
            i++;
        }
        while (i<WALL_COUNT+TRACK_COUNT) {
            barriers[i] = createTracks(i-WALL_COUNT);
            infoCreate(barriers[i]);
            i++;
        }
    }

    private static int countBarriers() {
        return WALL_COUNT+TRACK_COUNT;
    }

    private static void createPlayers(Object[] players ) {
        int i=0;
        while (i<CAT_COUNT) {
            players[i] = createCats(i);
            infoCreate(players[i]);
            i++;
        }
        while (i<CAT_COUNT+MAN_COUNT) {
            players[i] = createMans(i-CAT_COUNT);
            infoCreate(players[i]);
            i++;
        }
        while (i<countPlayers()) {
            players[i] = createBots(i-CAT_COUNT-MAN_COUNT);
            infoCreate(players[i]);
            i++;
        }
    }


    private static int countPlayers() {
        return CAT_COUNT+MAN_COUNT+BOT_COUNT;
    }

    private static void infoCreate(Object obj) {
        System.out.println(obj);
    }

    private static Man createMans(int i) {
        return new Man("Человек" + (i+1),
                powerRandomize.nextInt(BOT_COUNT  * 50)+1,
                powerRandomize.nextInt(BOT_COUNT  * 5)+1);
    }

    private static Bot createBots(int i) {
        return new Bot("Робот" + (i+1),
                powerRandomize.nextInt(BOT_COUNT  * 100)+1,
                powerRandomize.nextInt(BOT_COUNT  * 10)+1);
    }

    private static Cat createCats(int i) {
        return new Cat("Кот" + (i+1),
                powerRandomize.nextInt(BOT_COUNT  * 20)+1,
                powerRandomize.nextInt(BOT_COUNT  * 3)+1);
    }

    private static Wall createWalls(int i) {
        return new Wall( (i+1),
                powerRandomize.nextInt(10)+1);
    }

    private static Track createTracks(int i) {
        return new Track( (i+1),
                powerRandomize.nextInt(100)+1);
    }

}
