package lesson1;

public class Track implements Barrier{
    private int length;
    private int id;

    public int getLength() {
        return length;
    }

    public int getId() {
        return id;
    }

    public Track(int id, int length){
        this.length = length;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Track{" +
                "length=" + length +
                ", id=" + id +
                '}';
    }
}
