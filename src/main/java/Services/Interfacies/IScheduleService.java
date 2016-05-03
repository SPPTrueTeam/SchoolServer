package Services.Interfacies;

import Entities.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Артем on 02.05.2016.
 */
public interface IScheduleService {
    void AddSubject(Subject subject);
    void UpdateSubject(Subject subject);
    void RemoveSubject(Subject subject);
    void CreateSchedule(List<Lesson> lessonList, int lessonsCount);

    void AddLesson(Lesson lesson, Subject subject);
    void UpdateLesson(Lesson lesson);
    void RemoveLesson(Lesson lesson);

    void AddMark(Lesson lesson, Mark mark);
    void UpdateMark(Mark mark);
    void RemoveMark(Mark mark);

    List<Lesson> GetPupilDaySubject(Pupil pupil, Date date);
    List<Lesson> GetTeacherDaySubject(Pupil pupil, Date date);

    void GetSubjectJournal(Subject subject);
}
