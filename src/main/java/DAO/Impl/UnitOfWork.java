package DAO.Impl;

import DAO.Interfacies.ILessonDao;
import DAO.Interfacies.ISubjectDao;
import DAO.Interfacies.IUnitOfWork;
import DAO.Interfacies.IUserDao;
import DAO.MySqlConnection;

/**
 * Created by Артем on 02.05.2016.
 */
public class UnitOfWork implements IUnitOfWork {

    MySqlConnection connection;
    ILessonDao lessonDao;
    ISubjectDao subjectDao;
    IUserDao userDao;

    public UnitOfWork(MySqlConnection connection)
    {
        this.connection = connection;
        lessonDao = new LessonDao(this.connection);
        subjectDao = new SubjectDao(this.connection);
        userDao = new UserDao(this.connection);
    }

    public ILessonDao getLessonDao()
    {
        return lessonDao;
    }

    public ISubjectDao getSubjectDao()
    {
        return subjectDao;
    }

    public IUserDao getUserDao(){
        return userDao;
    }

    public void closeConnection() {
        if (connection!=null)
            connection.closeConnection();
    }
}
