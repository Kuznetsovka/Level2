package lesson1;

public class Bot implements Players {
    private String name;
    int maxRun;
    int maxJump;
    private int limitRun;
    boolean isPower = true;

    public Bot(String name,int maxRun, int maxJump){
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
        this.limitRun = maxRun;
    }

    public Bot(String name){
        this.name = name;
    }

    public void run (Track track){
        if (isRunnable(track.getLength())) {
            limitRun=decreaseLimitRun(track.getLength());
            System.out.println("Робот " + name + " пробежал дорожку №" + track.getId() + "!");
        } else {
            System.out.println("Робот " + name + " не смог пробежать дорожку №" + track.getId() + "!");
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
            System.out.println("Робот " + name + " перепрыгнул стену №"+ wall.getId() + "!");
        } else {
            System.out.println("Робот " + name + " не смог перепрыгнуть стену №"+ wall.getId() + "!");
            isPower = false;
        }
    }

   public void run(){
        System.out.println("Робот " + name + " побежал!");
    }
    public void jump(){
        System.out.println("Робот " + name + " прыгнул!");
    }

    @Override
    public String toString() {
        return "Bot{" +
                "name='" + name + '\'' +
                ", maxRun=" + maxRun +
                ", maxJump=" + maxJump +
                ", limitRun=" + limitRun +
                ", isPower=" + isPower +
                '}';
    }
}
