package DAO.Interfacies;

import DAO.DAOException;
import Entities.Pupil;
import Entities.Teacher;
import Entities.User;

/**
 * Created by Артем on 01.05.2016.
 */
public interface IUserDao extends IDao<User> {
    User GetByLoginAndPassword(String login, String password) throws DAOException;
    Pupil GetPupilByUserId(int id) throws DAOException;
    Teacher GetTeacherByUserId(int id) throws DAOException;
}
