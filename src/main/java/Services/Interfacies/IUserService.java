package Services.Interfacies;

import Entities.Pupil;
import Entities.Teacher;
import Entities.User;

import java.util.List;

/**
 * Created by Артем on 02.05.2016.
 */
public interface IUserService {
    User Login(String login, String password);
    List<User> GetUserList();
    void AddUser(User user);
    void RemoveUser(User user);
    List<Pupil> GetPupilList();
    void AddPupil(Pupil pupil);
    void RemovePupil(Pupil pupil);
    List<Teacher> GetTeacherList();
    void AddTeacher(Teacher teacher);
    void RemoveTeacher(Teacher teacher);

    List<Class> getClassList();
    void AddClass();
    void RemoveClass();
    void AddClassPupil(Class cl, Pupil pupil);
    void RemoveClassPupil(Pupil pupil);

    void UpdatePupilUser(Pupil pupil, User user);
    void UpdateTeacherUser(Teacher teacher, User user);
}
