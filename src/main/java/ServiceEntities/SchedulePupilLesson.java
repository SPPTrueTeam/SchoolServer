package ServiceEntities;

import Entities.*;

/**
 * Created by Артем on 05.05.2016.
 */
public class SchedulePupilLesson {

    private Lesson lesson;
    private Subject subject;
    private Teacher teacher;

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
