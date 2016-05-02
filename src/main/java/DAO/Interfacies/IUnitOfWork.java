package DAO.Interfacies;

import DAO.MySqlConnection;

/**
 * Created by Артем on 02.05.2016.
 */
public interface IUnitOfWork {

    ILessonDao getLessonDao();
    ISubjectDao getSubjectDao();
    IUserDao getUserDao();
    void closeConnection();
}
