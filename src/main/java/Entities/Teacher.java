package Entities;

import jdk.nashorn.internal.runtime.regexp.joni.constants.StringType;

/**
 * Created by Артем on 01.05.2016.
 */
public class Teacher implements IEntity {
    private int ID;
    private int userID;
    private User user;
    private String type;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
