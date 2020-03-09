package lesson1;

public class Man implements Players {
    private String name;
    int maxRun;
    int maxJump;
    private int limitRun;
    private boolean isPower = true;

    public Man(String name,int maxRun, int maxJump){
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
        this.limitRun = maxRun;
    }

    public Man(String name){
        this.name = name;

    }

    public void run (Track track){
        if (isRunnable(track.getLength())) {
            limitRun=decreaseLimitRun(track.getLength());
            System.out.println("Человек " + name + " пробежал дорожку №" + track.getId() + "!");
        } else {
            System.out.println("Человек " + name + " не смог пробежать дорожку №" + track.getId() + "!");
            isPower = false;
        }
    }

    private boolean isRunnable(int length) {
        return limitRun >= length;
    }

    public boolean isPower() {
        return isPower;
    }

    private int decreaseLimitRun(int length) {
        return maxRun-length;
    }

    public void jump(Wall wall){
        if (maxJump>wall.getHeight()) {
            System.out.println("Человек " + name + " перепрыгнул стену №"+ wall.getId() + "!");
        } else {
            System.out.println("Человек " + name + " не смог перепрыгнуть стену №"+ wall.getId() + "!");
            isPower = false;
        }
    }

    public void run(){
        System.out.println("Человек " + name + " побежал!");
    }
    public void jump(){
        System.out.println("Человек " + name + " прыгнул!");
    }

    @Override
    public String toString() {
        return "Man{" +
                "name='" + name + '\'' +
                ", maxRun=" + maxRun +
                ", maxJump=" + maxJump +
                ", limitRun=" + limitRun +
                ", isPower=" + isPower +
                '}';
    }
}
