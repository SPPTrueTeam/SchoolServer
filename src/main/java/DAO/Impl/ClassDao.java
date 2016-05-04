package DAO.Impl;

import DAO.DAOException;
import DAO.Interfacies.IClassDao;
import DAO.MySqlConnection;
import Entities.Class;
import Entities.Mark;
import Entities.Pupil;
import Entities.Subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Артем on 03.05.2016.
 */
public class ClassDao implements IClassDao {
    private final String INSERT_CLASS="INSERT INTO `classes` (`grade`, `letter`) VALUES (?, ?);";
    private final String UPDATE_CLASS="UPDATE classes SET grade=?, letter=? WHERE class_id=?";
    private final String SELECT_CLASS="SELECT * FROM classes WHERE class_id=?";
    private final String SELECT_ALL_CLASSES = "SELECT * FROM classes";
    private final String DELETE_CLASS="DELETE FROM classes WHERE class_id=?";
    private final String SELECT_CLASS_SUBJECTS = "SELECT * FROM subjects WHERE class_id=?";

    private MySqlConnection connection;
    public ClassDao(MySqlConnection connection){
        this.connection = connection;
    }

    public int Insert(Class item) throws DAOException {
        Connection cn = null;
        try{
            cn = connection.getConnection();
            PreparedStatement st = cn.prepareStatement(INSERT_CLASS,PreparedStatement.RETURN_GENERATED_KEYS);
            st.setInt(1, item.getGrade());
            st.setString(2, item.getLetter());
            st.executeQuery();
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

    public Class Select(int id) throws DAOException {
        Connection cn = null;
        try{
            cn = connection.getConnection();
            PreparedStatement st = cn.prepareStatement(SELECT_CLASS);
            st.setInt(1,id);
            ResultSet set = st.executeQuery();
            if (set.next()){
                Class cl = new Class();
                cl.setID(set.getInt("class_id"));
                cl.setGrade(set.getInt("grade"));
                cl.setLetter(set.getString("letter"));
                return cl;
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

    public void Update(Class item) throws DAOException {
        Connection cn = null;
        try {
            cn = connection.getConnection();
            PreparedStatement st = cn.prepareStatement(UPDATE_CLASS);
            st.setInt(1, item.getGrade());
            st.setString(2, item.getLetter());
            st.setInt(3, item.getID());
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
            PreparedStatement st = cn.prepareStatement(DELETE_CLASS);
            st.setInt(1, id);
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

    public List<Class> GetClassList() throws DAOException {
        Connection cn = null;
        try{
            cn = connection.getConnection();
            PreparedStatement st = cn.prepareStatement(SELECT_ALL_CLASSES);
            ResultSet set = st.executeQuery();
            ArrayList<Class> result = new ArrayList<Class>();
            while (set.next()){
                Class cl = new Class();
                cl.setID(set.getInt("class_id"));
                cl.setGrade(set.getInt("grade"));
                cl.setLetter(set.getString("letter"));
                result.add(cl);
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

    public List<Subject> GetClassSubjects(int classID) throws DAOException {
        Connection cn = null;
        try{
            cn = connection.getConnection();
            PreparedStatement st = cn.prepareStatement(SELECT_CLASS_SUBJECTS);
            st.setInt(1, classID);
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
}
