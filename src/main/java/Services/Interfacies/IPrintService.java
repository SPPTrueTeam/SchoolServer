package Services.Interfacies;

import DAO.DAOException;
import Entities.*;
import Services.ServiceException;

import javax.sql.rowset.serial.SerialException;
import java.io.InputStream;
import java.util.Date;

/**
 * Created by Артем on 02.05.2016.
 */
public interface IPrintService {

    //Лист статистики ученика(средние баллы по предметам.)
    InputStream PrintPDFAchivementStatistics(Pupil pupil) throws ServiceException;
    InputStream PrintXLSAchivementStatistics(Pupil pupil)throws ServiceException;
    InputStream PrintCSVAchivementStatistics(Pupil pupil)throws ServiceException;

    //Печать листа благодраности
    InputStream PrintPDFThanksLetter(Pupil pupil, Teacher teacher)throws ServiceException;
    InputStream PrintXLSThanksLetter(Pupil pupil, Teacher teacher)throws ServiceException;
    InputStream PrintCSVThanksLetter(Pupil pupil, Teacher teacher)throws ServiceException;

    //Лист журнала с одним предметом
    InputStream PrintPDFSubjectList(Subject subject)throws ServiceException;
    InputStream PrintXLSSubjectList(Subject subject)throws ServiceException;
    InputStream PrintCSVSubjectList(Subject subject)throws ServiceException;

    //Расписание недели учителя
    InputStream PrintPDFTeacherWeekSchedule(Teacher teacher)throws ServiceException;
    InputStream PrintXLSTeacherWeekSchedule(Teacher teacher)throws ServiceException;
    InputStream PrintCSVTeacherWeekSchedule(Teacher teacher)throws ServiceException;

    //Расписание недели ученика
    InputStream PrintPDFPupilWeekSchedule(Pupil pupil)throws ServiceException;
    InputStream PrintXLSPupilWeekSchedule(Pupil pupil)throws ServiceException;
    InputStream PrintCSVPupilWeekSchedule(Pupil pupil)throws ServiceException;
}
