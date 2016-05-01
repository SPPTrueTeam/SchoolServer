package DAO.Impl;

import DAO.DAOException;
import DAO.Interfacies.ISubjectDao;
import DAO.MySqlConnection;
import Entities.Pupil;
import Entities.Subject;
import Entities.Teacher;
import Entities.User;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 * Created by Артем on 01.05.2016.
 */
public class SubjectDao implements ISubjectDao {

    private final String SELECT_PUPILS_BY_SUBJECT ="SELECT * FROM subjects " +
            "JOIN classes ON subjects.subject_id=classes.class_id " +
            "JOIN pupils ON pupils.class_id=classes.class_id "+
            "WHERE subject_id = ?";
    private final String SELECT_TEACHER_BY_SUBJECT ="SELECT * FROM subjects " +
            "JOIN teachers ON subjects.teacher_id=teachers.teacher_id " +
            "WHERE subject_id = ?";
    private final String SELECT_SUBJECTS_BY_TEACHER="SELECT * FROM teachers " +
            "JOIN subjects ON teachers.teacher_id=subjects.teacher_id " +
            "WHERE teachers.teacher_id = ?";
    private final String SELECT_SUBJECTS_BY_PUPIL = "SELECT * FROM pupils " +
            "JOIN classes ON pupils.class_id=classes.class_id " +
            "JOIN subjects ON subjects.class_id=classes.class_id " +
            "WHERE pupils.pupil_id=?";
    private final String SELECT_SUBJECT_BY_ID = "SELECT * FROM subjects WHERE subject_id = ?";
    private final String INSERT_SUBJECT = "INSERT INTO subjects (name, lesson_count, class_id, teacher_id) VALUES (?, ?, ?, ?);";
    private final String DELETE_SUBJECT = "DELETE FROM subjects WHERE `subject_id`= ?";
    private final String UPDATE_SUBJECT = "UPDATE `subjects`" +
            "SET `name`= ? , `lesson_count`= ?, `class_id`= ?, `teacher_id`= ? WHERE `subject_id`= ?";;


    private MySqlConnection connection;
    public SubjectDao(MySqlConnection connection){
        this.connection = connection;
    }

    public List<Subject> GetPupilSubjects(int pupilID) throws DAOException {
        Connection cn = null;
        try{
            cn = connection.getConnection();
            PreparedStatement st = cn.prepareStatement(SELECT_SUBJECTS_BY_PUPIL);
            st.setInt(1, pupilID);
            ResultSet set = st.executeQuery();
            ArrayList<Subject> result = new ArrayList<Subject>();
            while (set.next()){
                Subject subject = new Subject();
                subject.setID(set.getInt("subject_id"));
                subject.setName(set.getString("name"));
                subject.setLessonCount(set.getInt("lesson_count"));
                subject.setClassID(set.getInt("class_id"));
                subject.setTeacherID(set.getInt("teacher_id"));
                result.add(subject);
            }
            return result;
        }
        catch (SQLException ex) {
            throw new DAOException(ex);
        }
        finally {
            if (cn!=null)
                connection.closeConnection();
        }
    }

    public List<Subject> GetTeacherSubjects(int teacherID) throws DAOException {
        Connection cn = null;
        try{
            cn = connection.getConnection();
            PreparedStatement st = cn.prepareStatement(SELECT_SUBJECTS_BY_TEACHER);
            st.setInt(1,teacherID);
            ResultSet set = st.executeQuery();
            ArrayList<Subject> result = new ArrayList<Subject>();
            while (set.next()){
                Subject subject = new Subject();
                subject.setID(set.getInt("subject_id"));
                subject.setName(set.getString("name"));
                subject.setLessonCount(set.getInt("lesson_count"));
                subject.setClassID(set.getInt("class_id"));
                subject.setTeacherID(set.getInt("teacher_id"));
                result.add(subject);
            }
            return result;
        }
        catch (SQLException ex) {
            throw new DAOException(ex);
        }
        finally {
            if (cn!=null)
                connection.closeConnection();
        }
    }

    public Teacher GetSubjectTeacher(int subjectID) throws DAOException {
        Connection cn = null;
        try{
            cn = connection.getConnection();
            PreparedStatement st = cn.prepareStatement(SELECT_TEACHER_BY_SUBJECT);
            st.setInt(1,subjectID);
            ResultSet set = st.executeQuery();
            if (set.next()) {
                Teacher teacher = new Teacher();
                teacher.setUserID(set.getInt("user_id"));
                teacher.setID(set.getInt("teacher_id"));
                teacher.setType(set.getString("type"));
                return teacher;
            }
        }
        catch (SQLException ex) {
            throw new DAOException(ex);
        }
        finally {
            if (cn!=null)
                connection.closeConnection();
        }
        return null;
    }

    public List<Pupil> GetSubjectPupils(int subjectID) throws DAOException {
        Connection cn = null;
        try{
            cn = connection.getConnection();
            PreparedStatement st = cn.prepareStatement(SELECT_PUPILS_BY_SUBJECT);
            st.setInt(1, subjectID);
            ResultSet set = st.executeQuery();
            ArrayList<Pupil> result = new ArrayList<Pupil>();
            while (set.next()){
                Pupil pupil = new Pupil();
                pupil.setID(set.getInt("pupil_id"));
                pupil.setClassID(set.getInt("class_id"));
                pupil.setUserID(set.getInt("user_id"));
                result.add(pupil);
            }
            return result;
        }
        catch (SQLException ex) {
            throw new DAOException(ex);
        }
        finally {
            if (cn!=null)
                connection.closeConnection();
        }
    }

    public int Insert(Subject item) throws DAOException {
        Connection cn = null;
        try{
            cn = connection.getConnection();
            PreparedStatement st = cn.prepareStatement(INSERT_SUBJECT,PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(1,item.getName());
            st.setInt(2,item.getLessonCount());
            st.setInt(3,item.getClassID());
            st.setInt(4,item.getTeacherID());
            st.executeUpdate();
            ResultSet set = st.getGeneratedKeys();
            if (set.next()){
                return set.getInt(1);
            }
        }
        catch (SQLException ex) {
            throw new DAOException(ex);
        }
        finally {
            if (cn!=null)
                connection.closeConnection();
        }
        return -1;
    }

    public Subject Select(int id) throws DAOException {
        Connection cn = null;
        try{
            cn = connection.getConnection();
            PreparedStatement st = cn.prepareStatement(SELECT_SUBJECT_BY_ID);
            st.setInt(1,id);
            ResultSet set = st.executeQuery();
            if (set.next()){
                Subject subject = new Subject();
                subject.setID(set.getInt("subject_id"));
                subject.setName(set.getString("name"));
                subject.setLessonCount(set.getInt("lesson_count"));
                subject.setClassID(set.getInt("class_id"));
                subject.setTeacherID(set.getInt("teacher_id"));
                return subject;
            }
        }
        catch (SQLException ex) {
            throw new DAOException(ex);
        }
        finally {
            if (cn!=null)
                connection.closeConnection();
        }
        return null;
    }

    public void Update(Subject item) throws DAOException {
        Connection cn = null;
        try {
            cn = connection.getConnection();
            PreparedStatement st = cn.prepareStatement(UPDATE_SUBJECT);
            st.setString(1,item.getName());
            st.setInt(2,item.getLessonCount());
            st.setInt(3,item.getClassID());
            st.setInt(4,item.getTeacherID());
            st.setInt(5,item.getID());
            st.executeUpdate();
        }
        catch (SQLException ex) {
            throw new DAOException(ex);
        }
        finally {
            if (cn!=null)
                connection.closeConnection();
        }

    }

    public void Delete(int id) throws DAOException {
        Connection cn = null;
        try {
            cn = connection.getConnection();
            PreparedStatement st = cn.prepareStatement(DELETE_SUBJECT);
            st.setInt(1,id);
            st.executeQuery();
        }
        catch (SQLException ex) {
            throw new DAOException(ex);
        }
        finally {
            if (cn!=null)
                connection.closeConnection();
        }
    }
}
