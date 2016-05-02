package Services.Interfacies;

import Entities.*;

import java.io.InputStream;
import java.util.Date;

/**
 * Created by Артем on 02.05.2016.
 */
public interface IPrintService {

    //Лист статистики ученика(средние балы по предметам.)
    InputStream PrintPDFAchivementStatistics(Pupil pupil);
    InputStream PrintXLSAchivementStatistics(Pupil pupil);
    InputStream PrintCSVAchivementStatistics(Pupil pupil);

    //Печать листа благодраности
    InputStream PrintPDFThanksLetter(Pupil pupil, Teacher teacher);
    InputStream PrintXLSThanksLetter(Pupil pupil, Teacher teacher);
    InputStream PrintCSVThanksLetter(Pupil pupil, Teacher teacher);

    //Лист журнала с одним предметом
    InputStream PrintPDFSubjecList(Subject subject);
    InputStream PrintXLSSubjectList(Subject subject);
    InputStream PrintCSVSubjectList(Subject subject);

    //Расписание дня учителя
    InputStream PrintPDFTeacheDaySchedule(Teacher teacher, Date date);
    InputStream PrintXLSTeacherDaySchedule(Teacher teacher, Date date);
    InputStream PrintCSVTeacherDaySchedule(Teacher teacher, Date date);

    //Расписание дня ученика
    InputStream PrintPDFPupilDaySchedule(Pupil pupil, Date date);
    InputStream PrintXLSPupilDaySchedule(Pupil pupil, Date date);
    InputStream PrintCSVPupilDaySchedule(Pupil pupil, Date date);
}
