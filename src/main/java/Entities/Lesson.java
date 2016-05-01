package Entities;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Артем on 01.05.2016.
 */
public class Lesson implements IEntity {
    private int ID;
    private Date date;
    private int scheduleNumber;
    private String homework;

    public int getID() {
        return 0;
    }

    public void setID(int value) {

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getScheduleNumber() {
        return scheduleNumber;
    }

    public void setScheduleNumber(int scheduleNumber) {
        this.scheduleNumber = scheduleNumber;
    }

    public String getHomework() {
        return homework;
    }

    public void setHomework(String homework) {
        this.homework = homework;
    }
}
