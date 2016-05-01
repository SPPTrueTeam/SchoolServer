package Entities;

/**
 * Created by Артем on 01.05.2016.
 */
public class Pupil implements IEntity {
    private  int ID;
    private User user;
    private int userID;
    private int classID;

    public int getID() {
        return ID;
    }

    public void setID(int value) {
        ID = value;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
