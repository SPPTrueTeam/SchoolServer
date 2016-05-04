package Services.Interfacies;

import Entities.*;

import java.io.InputStream;
import java.util.Date;

/**
 * Created by Артем on 02.05.2016.
 */
public interface IPrintService {

    //Лист статистики ученика(средние баллы по предметам.)
    InputStream PrintPDFAchivementStatistics(Pupil pupil);
    InputStream PrintXLSAchivementStatistics(Pupil pupil);
    InputStream PrintCSVAchivementStatistics(Pupil pupil);

    //Печать листа благодраности
    InputStream PrintPDFThanksLetter(Pupil pupil, Teacher teacher);
    InputStream PrintXLSThanksLetter(Pupil pupil, Teacher teacher);
    InputStream PrintCSVThanksLetter(Pupil pupil, Teacher teacher);

    //Лист журнала с одним предметом
    InputStream PrintPDFSubjectList(Subject subject);
    InputStream PrintXLSSubjectList(Subject subject);
    InputStream PrintCSVSubjectList(Subject subject);

    //Расписание недели учителя
    InputStream PrintPDFTeacherDaySchedule(Teacher teacher);
    InputStream PrintXLSTeacherDaySchedule(Teacher teacher);
    InputStream PrintCSVTeacherDaySchedule(Teacher teacher);

    //Расписание недели ученика
    InputStream PrintPDFPupilDaySchedule(Pupil pupil);
    InputStream PrintXLSPupilDaySchedule(Pupil pupil);
    InputStream PrintCSVPupilDaySchedule(Pupil pupil);
}
