package lesson1;

public class Wall implements Barrier{
    private int height;
    private int id;
    public Wall(int id,int height){
        this.height = height;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Wall{" +
                "height=" + height +
                ", id=" + id +
                '}';
    }
}
