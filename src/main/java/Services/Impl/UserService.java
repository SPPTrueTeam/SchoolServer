package Services.Impl;

import DAO.Interfacies.IUnitOfWork;
import Entities.Pupil;
import Entities.Teacher;
import Entities.User;
import Services.Interfacies.IUserService;

import java.util.List;

/**
 * Created by Артем on 02.05.2016.
 */
public class UserService implements IUserService {

    private IUnitOfWork uof;
    public UserService(IUnitOfWork uof)
    {
        this.uof = uof;
    }

    public User Login(String login, String password) {
        return null;
    }

    public List<User> GetUserList() {
        return null;
    }

    public void AddUser(User user) {

    }

    public void RemoveUser(User user) {

    }

    public List<Pupil> GetPupilList() {
        return null;
    }

    public void AddPupil(Pupil pupil) {

    }

    public void RemovePupil(Pupil pupil) {

    }

    public List<Teacher> GetTeacherList() {
        return null;
    }

    public void AddTeacher(Teacher teacher) {

    }

    public void RemoveTeacher(Teacher teacher) {

    }

    public List<Class> getClassList() {
        return null;
    }

    public void AddClass() {

    }

    public void RemoveClass() {

    }

    public void AddClassPupil(Class cl, Pupil pupil) {

    }

    public void RemoveClassPupil(Pupil pupil) {

    }

    public void UpdatePupilUser(Pupil pupil, User user) {

    }

    public void UpdateTeacherUser(Teacher teacher, User user) {

    }
}
