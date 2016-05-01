package Entities;

/**
 * Created by Артем on 01.05.2016.
 */
public class Mark implements IEntity {
    private int ID;
    private int mark;

    public int getID() {
        return ID;
    }

    public void setID(int value) {
        ID=value;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
