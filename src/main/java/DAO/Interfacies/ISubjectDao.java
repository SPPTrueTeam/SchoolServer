package DAO.Interfacies;

import DAO.DAOException;
import Entities.Lesson;
import Entities.Pupil;
import Entities.Subject;
import Entities.Teacher;

import java.util.List;

/**
 * Created by Артем on 01.05.2016.
 */
public interface ISubjectDao extends IDao<Subject> {
    List<Subject> GetPupilSubjects(int pupilID) throws DAOException;
    List<Subject> GetTeacherSubjects(int teacherID)throws DAOException;
    Teacher GetSubjectTeacher(int subjectID) throws DAOException;
    List<Pupil> GetSubjectPupils(int subjectID) throws DAOException;
}
