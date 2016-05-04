package Services.Impl;

import DAO.DAOException;
import DAO.Interfacies.IUnitOfWork;
import Entities.*;
import Entities.Class;
import Services.Interfacies.IScheduleService;
import Services.ServiceException;

import java.util.*;

/**
 * Created by Артем on 02.05.2016.
 */
public class ScheduleService implements IScheduleService {

    private IUnitOfWork uof;

    public ScheduleService(IUnitOfWork uof) {
        this.uof = uof;
    }

    public Subject AddSubject(Subject subject) throws ServiceException {
        try{
            int subject_id = uof.getSubjectDao().Insert(subject);
            subject.setID(subject_id);
            return subject;
        }
        catch (DAOException ex) {
            throw new ServiceException(ex);
        }
    }

    public Subject UpdateSubject(Subject subject) throws ServiceException {
        try {
            uof.getSubjectDao().Update(subject);
            return subject;
        }
        catch (DAOException ex)
        {
            throw new ServiceException(ex);
        }
    }

    public void RemoveSubject(Subject subject) throws ServiceException {
        try{
            uof.getSubjectDao().Delete(subject.getID());
        }
        catch (DAOException ex)
        {
            throw new ServiceException(ex);
        }
    }

    public List<Subject> GetSubjectListForClass(Class cls) throws ServiceException {
        try {
            return uof.getClassDao().GetClassSubjects(cls.getID());
        } catch (DAOException ex) {
            throw new ServiceException(ex);
        }
    }

    public List<Subject> GetSubjectListForTeacher(Teacher teacher) throws ServiceException {
        try {
            return uof.getTeacherDao().GetTeacherSubjects(teacher.getID());
        } catch (DAOException ex) {
            throw new ServiceException(ex);
        }
    }

    public void CreateScheduleForDay(List<Lesson> lessonList, int dayOfWeek) throws ServiceException {
        try {
            Calendar startDate = new GregorianCalendar(2015, 9, 1);
            while (startDate.get(Calendar.DAY_OF_WEEK) != dayOfWeek + 1)
                startDate.add(Calendar.DAY_OF_MONTH, 1);
            Calendar endDate = new GregorianCalendar(2016, 6, 1);
            while (startDate.before(endDate)) {
                for (Lesson l : lessonList) {
                    l.setDate(startDate.getTime());
                    l.setHomework("");
                    uof.getLessonDao().Insert(l);
                }
                startDate.add(Calendar.WEEK_OF_YEAR, 1);
            }
        }
        catch (DAOException ex) {
            throw new ServiceException(ex);
        }
    }

    public List<Lesson> GetPupilDayLessons(Pupil pupil, Date date) throws ServiceException {
        try {
            return uof.getLessonDao().GetPupilDayLessons(pupil.getID(),date);
        } catch (DAOException ex) {
            throw new ServiceException(ex);
        }
    }

    public List<Lesson> GetTeacherDayLessons(Teacher teacher, Date date) throws ServiceException {
        try {
            return uof.getLessonDao().GetTeacherDayLesson(teacher.getID(),date);
        } catch (DAOException ex) {
            throw new ServiceException(ex);
        }
    }

    public List<Lesson> GetClassDayLessons(Class cls, Date date) throws ServiceException {
        try {
            return uof.getLessonDao().GetClassDayLessons(cls.getID(),date);
        } catch (DAOException ex) {
            throw new ServiceException(ex);
        }
    }

    public List<Lesson> GetNextLessons(Lesson currentLesson, int count) throws ServiceException {
        try {
            List<Lesson> lessonList = uof.getLessonDao().GetSubjectLessons(currentLesson.getSubjectID());
            int index = lessonList.indexOf(currentLesson);
            List<Lesson> result = new ArrayList<Lesson>();
            for (int i = index + 1; i < lessonList.size(); i++) {
                result.add(lessonList.get(i));
            }
            return result;
        } catch (DAOException ex) {
            throw new ServiceException(ex);
        }
    }
}
