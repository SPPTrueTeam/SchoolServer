package DAO.Interfacies;

import Entities.Lesson;
import Entities.Mark;
import Entities.Subject;

import java.util.List;

/**
 * Created by Артем on 01.05.2016.
 */
public interface ILessonDao extends IDao<Lesson> {
    List<Lesson> GetSubjectLessons(int subjectID);
    List<Mark> GetLessonMarks(int lessonID);
}
